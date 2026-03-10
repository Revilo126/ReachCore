package revilo.reach.tile.multiblock;

import java.util.List;

import net.minecraft.item.ItemStack;

import gregapi.data.LH;
import gregapi.data.LH.Chat;

public class MultiTileEntityFusionReactor2 extends MultiTileEntityFusionReactorBase {

    @Override
    public int setWall1() {
        return 18006;
    }

    @Override
    public int setWall2() {
        return 18005;
    }

    @Override
    public int setWall3() {
        return 180012;
    }

    @Override
    public int setCoil() {
        return 20000;
    }

    @Override
    public String getTileEntityName() {
        return "reach.multitileentity.fusionreactor.2";
    }

    static {
        LH.add(
            "reach.tooltip.multiblock.fusionreactor2.1",
            "For Assembly Instructions read the Manual in the GUI. Work In Progress.");
        LH.add(
            "reach.tooltip.multiblock.fusionreactor2.2",
            "144 Unbinillium Coils, 576 Regular Adamantium Walls, 50 Ventilation Units.");
        LH.add(
            "reach.tooltip.multiblock.fusionreactor2.3",
            "36 Regular Tantalum Hafnium Carbide Walls, 53 Titanium Walls.");
        LH.add(
            "reach.tooltip.multiblock.fusionreactor2.4",
            "3 Versatile, 12 Logic and 12 Control Quadcore Processing Units.");
        LH.add("reach.tooltip.multiblock.fusionreactor2.5", "Energy Output at the Electric Interfaces");
        LH.add("reach.tooltip.multiblock.fusionreactor2.6", "Laser Input at the 'Glass' Ring");
        LH.add("reach.tooltip.multiblock.fusionreactor2.7", "Items and Fluids are handeled at the normal Walls");
    }

    @Override
    public void addToolTips(List<String> aList, ItemStack aStack, boolean aF3_H) {
        aList.add(Chat.CYAN + LH.get(LH.STRUCTURE) + ":");
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor2.1"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor2.2"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor2.3"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor2.4"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor2.5"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor2.6"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor2.7"));
        super.addToolTips(aList, aStack, aF3_H);
    }

}
