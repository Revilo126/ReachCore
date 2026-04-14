package revilo.reach.mixins;

import net.minecraft.client.Minecraft;

import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraftTitle {

    @Inject(method = "startGame", at = @At("RETURN"))
    public void reach$changeTitleName(CallbackInfo ci) {
        // TODO: add system to check modpack version (or just change this everytime).
        Display.setTitle("Minecraft 1.7.10 - Reach 0.0.1");
    }

}
