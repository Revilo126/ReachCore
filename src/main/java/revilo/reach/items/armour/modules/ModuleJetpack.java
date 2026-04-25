package revilo.reach.items.armour.modules;

import static gregapi.data.CS.*;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import codechicken.lib.vec.Vector3;
import revilo.reach.items.armour.IItemArmourModule;
import revilo.reach.items.armour.ItemArmourModular;

public class ModuleJetpack implements IItemArmourModule {

    private int tier;

    private JetpackMode mode = JetpackMode.OFF;

    public enum JetpackMode {
        OFF,
        HOVER,
        BOOST
    }

    private static final long[] TIER_TO_VOLTAGE = { V[3], // MV
        V[4], // HV
        V[5], // EV
        V[6] // IV
    };

    private static final double HOVER_THRUST = 0.08;
    private static final double BOOST_THRUST = 0.18;

    private static final double BASE_DRAG = 0.90;
    private static final double BOOST_DRAG = 0.96;

    private static final double AIR_RESIST = 0.98;
    private static final double MAX_SPEED = 0.9;

    private double targetAltitude = -1;

    @Override
    public int getRequiredSlot() {
        return 0; // chestplate
    }

    @Override
    public long getRequiredEnergy() {
        if (tier < 1 || tier > 4) return V[3];
        return TIER_TO_VOLTAGE[tier - 1];
    }

    public void toggleMode() {
        switch (mode) {
            case OFF:
                mode = JetpackMode.HOVER;
                break;
            case HOVER:
                mode = JetpackMode.BOOST;
                break;
            case BOOST:
                mode = JetpackMode.OFF;
                break;
        }
    }

    public JetpackMode getMode() {
        return mode;
    }

    @Override
    public void onModuleTick(EntityPlayer player, ItemStack armour, ItemArmourModular container) {

        if (mode == JetpackMode.OFF) return;

        long cost = getRequiredEnergy();

        if (!consumeEnergy(armour, container, cost)) {
            mode = JetpackMode.OFF;
            return;
        }

        applyFlight(player);
    }

    private boolean consumeEnergy(ItemStack armour, ItemArmourModular container, long amount) {
        return container.removeEnergy(amount, tier);
    }

    private void applyFlight(EntityPlayer player) {

        Vector3 thrust = computeThrust(player);

        applyInertia(player);

        player.motionX += thrust.x;
        player.motionY += thrust.y;
        player.motionZ += thrust.z;

        if (mode == JetpackMode.HOVER) {
            stabilizeAltitude(player);
        }

        clampSpeed(player);

        player.fallDistance = 0;
    }

    private Vector3 computeThrust(EntityPlayer player) {

        double x = 0, y = 0, z = 0;

        float yawRad = (float) Math.toRadians(player.rotationYaw);

        double forwardX = -Math.sin(yawRad);
        double forwardZ = Math.cos(yawRad);

        double strafeX = Math.cos(yawRad);
        double strafeZ = Math.sin(yawRad);

        double thrustPower = (mode == JetpackMode.BOOST) ? BOOST_THRUST : HOVER_THRUST;

        // Forward / backward
        if (player.moveForward > 0) {
            x += forwardX * thrustPower;
            z += forwardZ * thrustPower;
        } else if (player.moveForward < 0) {
            x -= forwardX * thrustPower * 0.5;
            z -= forwardZ * thrustPower * 0.5;
        }

        // Strafing
        if (player.moveStrafing != 0) {
            x += strafeX * thrustPower * player.moveStrafing;
            z += strafeZ * thrustPower * player.moveStrafing;
        }

        // Vertical control
        if (mode == JetpackMode.HOVER) {

            if (Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed()) y += HOVER_THRUST;
            if (player.isSneaking()) y -= HOVER_THRUST;

        } else if (mode == JetpackMode.BOOST) {

            y += BOOST_THRUST;
        }

        return new Vector3(x, y, z);
    }

    private void applyInertia(EntityPlayer player) {

        double drag = (mode == JetpackMode.BOOST) ? BOOST_DRAG : BASE_DRAG;

        player.motionX *= drag;
        player.motionZ *= drag;

        player.motionY *= AIR_RESIST;

        if (Math.abs(player.motionX) < 0.01) player.motionX = 0;
        if (Math.abs(player.motionZ) < 0.01) player.motionZ = 0;
    }

    private void clampSpeed(EntityPlayer player) {

        double speedSq = player.motionX * player.motionX + player.motionZ * player.motionZ;

        if (speedSq > MAX_SPEED * MAX_SPEED) {

            double scale = MAX_SPEED / Math.sqrt(speedSq);

            player.motionX *= scale;
            player.motionZ *= scale;
        }
    }

    private void stabilizeAltitude(EntityPlayer player) {

        if (targetAltitude < 0) {
            targetAltitude = player.posY;
        }

        double error = targetAltitude - player.posY;

        player.motionY += error * 0.08;
        player.motionY *= 0.85;
    }
}
