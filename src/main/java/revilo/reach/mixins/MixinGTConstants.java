package revilo.reach.mixins;

import static gregapi.data.CS.*;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import gregapi.data.CS;

@Mixin(CS.class)
public class MixinGTConstants {

    @Final
    @Mutable
    @Shadow
    public static String[] OD_CIRCUITS;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void onCSInit(CallbackInfo ci) {
        OUT.println("Reach: Refactoring GT6's Constant Data");

        // Base GT only had capability to go up to T9 Circuit
        OD_CIRCUITS = new String[] { "gt:circuit0", "gt:circuit1", "gt:circuit2", "gt:circuit3", "gt:circuit4",
            "gt:circuit5", "gt:circuit6", "gt:circuit7", "gt:circuit8", "gt:circuit9", "gt:circuit10", "gt:circuit11",
            "gt:circuit12", "gt:circuit13" };
    }
}
