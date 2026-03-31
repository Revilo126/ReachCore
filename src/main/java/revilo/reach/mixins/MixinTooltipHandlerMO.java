package revilo.reach.mixins;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import matteroverdrive.handler.TooltipHandler;

@Mixin(TooltipHandler.class)
public class MixinTooltipHandlerMO {

    /*
     * I hate the matter tooltip, and since matter stuff is disabled its not needed!
     */
    @Inject(method = "onItemTooltip", at = @At("HEAD"), cancellable = true, remap = false)
    private void disableMatterTooltip(ItemTooltipEvent event, CallbackInfo ci) {
        ci.cancel();
    }

}
