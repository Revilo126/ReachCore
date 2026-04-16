package revilo.reach.items.behaviours;

import static gregapi.data.CS.*;
import static gregapi.util.WD.*;

import java.util.ArrayList;

import com.cleanroommc.modularui.api.IGuiHolder;
import com.cleanroommc.modularui.api.drawable.IKey;
import com.cleanroommc.modularui.factory.PlayerInventoryGuiData;
import com.cleanroommc.modularui.screen.ModularPanel;
import com.cleanroommc.modularui.screen.ModularScreen;
import com.cleanroommc.modularui.screen.UISettings;
import com.cleanroommc.modularui.value.sync.PanelSyncManager;

import gregapi.block.multitileentity.IMultiTileEntity;
import gregapi.code.ArrayListNoNulls;
import gregapi.event.BlockScanningEvent;
import gregapi.util.UT.Code;
import gregapi.item.multiitem.MultiItem;
import gregapi.item.multiitem.behaviors.IBehavior.AbstractBehaviorDefault;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import revilo.reach.data.RCCS;

@SuppressWarnings("unused")
public class Behaviour_Laptop /*extends AbstractBehaviorDefault implements IGuiHolder<PlayerInventoryGuiData>*/ {

    /*public Behaviour_Laptop() {
    	
    }
    
    @Override
    public ModularScreen createScreen(PlayerInventoryGuiData data, ModularPanel mainPanel) {
        return new ModularScreen(RCCS.ModIds.REACH, mainPanel);
    }

    @Override
    public ModularPanel buildUI(PlayerInventoryGuiData guiData, PanelSyncManager guiSyncManager, UISettings settings) {
    	ModularPanel panel = ModularPanel.defaultPanel("laptopscan_gui").resizeableOnDrag(T);
    	
    	return panel;
    }
    
    @Override
	public boolean onItemUseFirst(MultiItem aItem, ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ, byte aSide, float hitX, float hitY, float hitZ) {
    	if (aPlayer instanceof EntityPlayerMP) {
			ArrayList<String> tList = new ArrayListNoNulls<>();
			if (aItem.useEnergy(TD.Energy.EU, aStack, LaptopGUI.scan(null, aPlayer, aWorld, aX, aY, aZ, aSide, hitX, hitY, hitZ), aPlayer, aPlayer.inventory, aWorld, aX, aY, aZ, T)) build;
			return T;
		}
    	
    	return aPlayer instanceof EntityPlayerMP;
    }
    
    /*
     * TODO add features:
     * Build full multiblocks (GT compatible)
     * Scanner (Full GUI)
     * Stop/Pause etc machines
     * Large battery (Usable for portable on the-fly energy storage)
     * Upgrade machines (Keep setting and if player has in inventory replace the block with next tier E.g LV-MV)
     * Ore/Fluid (Basic) prospecting
     * Maybe Tiers?
     * Build Schematics?
     */
    
	/*
    public static class LaptopGUI {
    	public static long scan(ModularPanel panel, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ, byte aSide, float aClickX, float aClickY, float aClickZ) {
    		if (panel == null) return 0;
    		
    		ArrayList<String> rList = new ArrayListNoNulls<>();
    		long rEUAmount = 0;
    		
    		Block aBlock = aWorld.getBlock(aX, aY, aZ);
    		byte aMeta = (byte)aWorld.getBlockMetadata(aX, aY, aZ);
    		TileEntity aTileEntity = te(aWorld, aX, aY, aZ, T);
    		
    		try {
    			panel.child(IKey.str("Laptop: Scanned " + (aTileEntity instanceof IInventory && Code.stringValid(((IInventory)aTileEntity).getInventoryName()) ? ((IInventory)aTileEntity).getInventoryName() : aBlock.getUnlocalizedName()) + "  MetaData: " + aMeta).asWidget());
    			
    		} catch(Throwable e) {e.printStackTrace(ERR);}
    		
    		BlockScanningEvent tEvent = new BlockScanningEvent(aWorld, aPlayer, aX, aY, aZ, aSide, 2, aBlock, aTileEntity, rList, aClickX, aClickY, aClickZ);
    		tEvent.mEUCost = rEUAmount;
    		MinecraftForge.EVENT_BUS.post(tEvent);
    		return tEvent.mEUCost;
    	}
    }
    */
    
}
