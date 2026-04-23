package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.data.RM.*;
import static gregapi.util.CR.*;
import static gregapi.util.ST.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregapi.data.FL;
import gregapi.data.MD;
import gregapi.data.MT;

@SuppressWarnings("unused")
public class ScriptAdvRocketry implements IScriptLoader {

    /*
     * Recipes for Advanced Rocketry are majority crafting table, however most parts should be welded or others.
     */

    // Blocks
    private ItemStack launchpad = make(MD.GC_ADV_ROCKETRY, "launchpad", 1),
        structureTower = make(MD.GC_ADV_ROCKETRY, "structureTower", 1),
        genericSeat = make(MD.GC_ADV_ROCKETRY, "seat", 1), engine = make(MD.GC_ADV_ROCKETRY, "rocketmotor", 1),
        advEngine = make(MD.GC_ADV_ROCKETRY, "tile.advRocket", 1), fuelTank = make(MD.GC_ADV_ROCKETRY, "fuelTank", 1),
        sawBlade = make(MD.GC_ADV_ROCKETRY, "sawBlade", 1), concrete = make(MD.GC_ADV_ROCKETRY, "concrete", 1),
        platePress = make(MD.GC_ADV_ROCKETRY, "blockHandPress", 1),
        airLock = make(MD.GC_ADV_ROCKETRY, "smallAirlockDoor", 1),
        landingPad = make(MD.GC_ADV_ROCKETRY, "dockingPad", 1),
        oxygenDetector = make(MD.GC_ADV_ROCKETRY, "atmosphereDetector", 1),
        oxygenScrubber = make(MD.GC_ADV_ROCKETRY, "scrubber", 1), lens = make(MD.GC_ADV_ROCKETRY, "lens", 1);

    // Items
    private ItemStack wafer = make(MD.GC_ADV_ROCKETRY, "wafer", 1),
        circuitPlate = make(MD.GC_ADV_ROCKETRY, "circuitplate", 1),
        circuitIC = make(MD.GC_ADV_ROCKETRY, "circuitIC", 1), miscPart = make(MD.GC_ADV_ROCKETRY, "miscpart", 1),
        sawBladeI = make(MD.GC_ADV_ROCKETRY, "sawBlade", 1),
        spaceStationChip = make(MD.GC_ADV_ROCKETRY, "stationChip", 1),
        elevatorChip = make(MD.GC_ADV_ROCKETRY, "elevatorChip", 1),
        asteroidChip = make(MD.GC_ADV_ROCKETRY, "asteroidChip", 1),
        stationPacked = make(MD.GC_ADV_ROCKETRY, "station", 1),
        smallAirlock = make(MD.GC_ADV_ROCKETRY, "smallAirlock", 1),
        carbonCartridge = make(MD.GC_ADV_ROCKETRY, "carbonScrubberCartridge", 1),
        lensI = make(MD.GC_ADV_ROCKETRY, "lens", 1),
        satellitePowerSource = make(MD.GC_ADV_ROCKETRY, "satellitePowerSource", 1),
        satellitePrimaryFunction = make(MD.GC_ADV_ROCKETRY, "satellitePrimaryFunction", 1);

    @Override
    public String getScriptName() {
        return "Advanced Rocketry Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIDs.GC_ADV_ROCKETRY, ModIDs.VULPES);
    }

    @Override
    public void loadRecipes() {
        delate(launchpad);
        delate(structureTower);
        delate(genericSeat);
        delate(engine);
        delate(advEngine);
        delate(fuelTank);
        delate(sawBlade);
        delate(concrete);
        delate(platePress);
        delate(airLock);
        delate(landingPad);
        delate(oxygenDetector);
        delate(oxygenScrubber);
        delate(lens);

        shapeless(landingPad, array(make(BlocksGT.Concrete, 1, 0)));

        shaped(
            oxygenDetector,
            DEF_REV_NCC,
            "wPs",
            "CMC",
            "SGS",
            'P',
            plate.dat(MT.StainlessSteel),
            'C',
            OD_CIRCUITS[3],
            'M',
            casingMachine.dat(MT.StainlessSteel),
            'S',
            screw.dat(MT.StainlessSteel),
            'G',
            carbonCartridge);
        shaped(
            oxygenDetector,
            DEF_REV_NCC,
            "wPs",
            "CRC",
            "GMG",
            'P',
            plate.dat(MT.StainlessSteel),
            'C',
            OD_CIRCUITS[3],
            'M',
            casingMachine.dat(MT.StainlessSteel),
            'G',
            carbonCartridge,
            'R',
            rotor.dat(MT.StainlessSteel));
    }

    @Override
    public void loadMachines() {
        Injector.addRecipe1(
            T,
            16,
            64,
            make(BlocksGT.Concrete, 1, 7),
            FL.array(DYE_FLUIDS_WATER[DYE_INDEX_Black], DYE_FLUIDS_WATER[DYE_INDEX_Yellow]),
            NF,
            launchpad);
        Injector.addRecipe1(
            T,
            16,
            64,
            make(BlocksGT.Concrete, 1, 7),
            FL.array(DYE_FLUIDS_FLOWER[DYE_INDEX_Black], DYE_FLUIDS_FLOWER[DYE_INDEX_Yellow]),
            NF,
            launchpad);
        Injector.addRecipe1(
            T,
            16,
            64,
            make(BlocksGT.Concrete, 1, 7),
            FL.array(DYE_FLUIDS_CHEMICAL[DYE_INDEX_Black], DYE_FLUIDS_CHEMICAL[DYE_INDEX_Yellow]),
            NF,
            launchpad);

        Welder.addRecipe1(T, 16, 128, stickLong.mat(MT.StainlessSteel, 6), structureTower);

        Loom.addRecipe2(T, 16, 16, tag(1), make(Blocks.wool, 2, 0), genericSeat);
        Loom.addRecipe2(T, 16, 16, tag(2), make(Items.string, 8, 0), genericSeat);

        Welder.addRecipeX(
            T,
            16,
            512,
            array(tag(0), plateCurved.mat(MT.StainlessSteel, 4), pipeSmall.mat(MT.Al, 2)),
            engine);
        Welder.addRecipeX(T, 16, 512, array(tag(0), plateCurved.mat(MT.Ti, 4), pipeMedium.mat(MT.Cr, 2)), engine);

        RollFormer.addRecipe1(T, 16, 128, plateCurved.mat(MT.StainlessSteel, 2), fuelTank);

        // Whats sawblade for again?

        // TODO: Concrete (Swap all ar stuff to GT's)!

        Welder.addRecipe1(T, 16, 64, plate.mat(MT.StainlessSteel, 2), airLock);

    }

}
