package revilo.reach.tile.multiblock.fusion;

import java.util.List;

import net.minecraft.item.ItemStack;

import gregapi.data.LH;
import gregapi.data.LH.Chat;
import gregapi.tileentity.multiblocks.MultiTileEntityMultiBlockPart;
import revilo.multihelper.structure.Definition;
import revilo.multihelper.structure.StructureUtil;
import revilo.multihelper.structure.elements.StructureElementPart;
import revilo.reach.loaders.a.MultiTileEntityLoader;

public class MultiTileEntityFusionReactorTier2 extends MultiTileEntityFusionReactorBase {

    @Override
    public Definition<MultiTileEntityFusionReactorBase> getStructure() {
        return Definition.<MultiTileEntityFusionReactorBase>builder(STRUCTURE)
            .addElement(
                'W',
                new StructureElementPart<>(
                    MultiTileEntityLoader.iridiumWall,
                    getMultiTileEntityRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.ONLY_ITEM_FLUID))
            .addElement(
                'R',
                new StructureElementPart<>(
                    MultiTileEntityLoader.iridiumWall,
                    getMultiTileEntityRegistryID(),
                    mActive ? 6 : 5,
                    MultiTileEntityMultiBlockPart.ONLY_ENERGY_IN))
            .addElement(
                'P',
                new StructureElementPart<>(
                    MultiTileEntityLoader.iridiumWall,
                    getMultiTileEntityRegistryID(),
                    2,
                    MultiTileEntityMultiBlockPart.ONLY_ENERGY_OUT))
            .addElement(
                'C',
                new StructureElementPart<>(
                    MultiTileEntityLoader.naqCoils,
                    getMultiTileEntityRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING))
            .addElement(
                'S',
                new StructureElementPart<>(
                    18006,
                    StructureUtil.getGTRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING))
            .addElement(
                'G',
                new StructureElementPart<>(
                    MultiTileEntityLoader.osmiumWall,
                    getMultiTileEntityRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING))
            .addElement(
                'V',
                new StructureElementPart<>(
                    18299,
                    StructureUtil.getGTRegistryID(),
                    0,
                    MultiTileEntityMultiBlockPart.NOTHING))
            .addElement(
                'L',
                StructureUtil.counted(
                    "versatile",
                    3,
                    new StructureElementPart<>(
                        18200,
                        StructureUtil.getGTRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING),
                    "logic",
                    12,
                    new StructureElementPart<>(
                        18201,
                        StructureUtil.getGTRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING),
                    "control",
                    12,
                    new StructureElementPart<>(
                        18202,
                        StructureUtil.getGTRegistryID(),
                        0,
                        MultiTileEntityMultiBlockPart.NOTHING)))
            .build();
    }

    static {
        LH.add("reach.tooltip.multiblock.fusionreactor.2.1", "For Assembly Instructions read the Manual in the GUI.");
        LH.add(
            "reach.tooltip.multiblock.fusionreactor.2.2",
            "144 Naquadah Coils, 576 Regular Iridium Walls, 50 Ventilation Units.");
        LH.add("reach.tooltip.multiblock.fusionreactor.2.3", "36 Regular Titanium Walls, 53 Osmium Walls.");
        LH.add(
            "reach.tooltip.multiblock.fusionreactor.2.4",
            "3 Versatile, 12 Logic and 12 Control Quadcore Processing Units.");
        LH.add("reach.tooltip.multiblock.fusionreactor.2.5", "Energy Output at the Electric Interfaces");
        LH.add("reach.tooltip.multiblock.fusionreactor.2.6", "Laser Input at the 'Glass' Ring");
        LH.add("reach.tooltip.multiblock.fusionreactor.2.7", "Items and Fluids are handeled at the normal Walls");
    }

    @Override
    public void addToolTips(List<String> aList, ItemStack aStack, boolean aF3_H) {
        aList.add(Chat.CYAN + LH.get(LH.STRUCTURE) + ":");
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.2.1"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.2.2"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.2.3"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.2.4"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.2.5"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.2.6"));
        aList.add(Chat.WHITE + LH.get("reach.tooltip.multiblock.fusionreactor.2.7"));
        super.addToolTips(aList, aStack, aF3_H);
    }

    @Override
    public String getTileEntityName() {
        return "reach.multitileentity.multiblock.fusionreactor.2";
    }

}
