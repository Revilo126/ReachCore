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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import gregapi.data.ANY;
import gregapi.data.FL;
import gregapi.data.IL;
import gregapi.data.MD;
import gregapi.data.MT;
import zmaster587.advancedRocketry.api.AdvancedRocketryAPI;

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
        sawBlade = make(MD.GC_ADV_ROCKETRY, "sawBlade", 1), concrete = make(MD.GC_ADV_ROCKETRY, "tile.concrete", 1),
        platePress = make(MD.GC_ADV_ROCKETRY, "blockHandPress", 1),
        airLock = make(MD.GC_ADV_ROCKETRY, "item.smallAirlock", 1),
        landingPad = make(MD.GC_ADV_ROCKETRY, "dockingPad", 1),
        atmosDetector = make(MD.GC_ADV_ROCKETRY, "tile.atmosphereDetector", 1),
        co2Scrubber = make(MD.GC_ADV_ROCKETRY, "tile.scrubber", 1),
        oxygenVent = make(MD.GC_ADV_ROCKETRY, "tile.oxygenVent", 1), lens = make(MD.GC_ADV_ROCKETRY, "lens", 1);

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
        carbonCartridge = make(MD.GC_ADV_ROCKETRY, "item.carbonScrubberCartridge", 1),
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
        delate(atmosDetector);
        delate(co2Scrubber);
        delate(oxygenVent);
        delate(lens);

        shapeless(landingPad, array(make(BlocksGT.Concrete, 1, 0)));

        shaped(
            atmosDetector,
            DEF_REV_NCC,
            "wPd",
            "CMC",
            "SGS",
            'P',
            plate.mat(MT.StainlessSteel, 1),
            'C',
            OD_CIRCUITS[3],
            'M',
            casingMachine.mat(MT.StainlessSteel, 1),
            'S',
            screw.mat(MT.StainlessSteel, 1),
            'G',
            carbonCartridge);
        shaped(
            co2Scrubber,
            DEF_REV_NCC,
            "wPd",
            "CRC",
            "GMG",
            'P',
            plate.mat(MT.StainlessSteel, 1),
            'C',
            OD_CIRCUITS[3],
            'M',
            casingMachine.mat(MT.StainlessSteel, 1),
            'G',
            carbonCartridge,
            'R',
            rotor.mat(MT.StainlessSteel, 1));
        shaped(
            oxygenVent,
            DEF_REV_NCC,
            "wPd",
            "CMC",
            "ROR",
            'P',
            plate.mat(MT.StainlessSteel, 1),
            'C',
            OD_CIRCUITS[3],
            'M',
            casingMachine.mat(MT.StainlessSteel, 1),
            'R',
            rotor.mat(MT.StainlessSteel, 1),
            'O',
            IL.MOTORS[3]);

    }

    @Override
    public void loadMachines() {
        for (byte i = 0; i < 4; i++) {
            // Allow universal hazmat to space
            ItemStack uniSpace = make((Item) ArmorsGT.HAZMAT_UNIVERSAL[i], 1, 0);
            uniSpace.addEnchantment(AdvancedRocketryAPI.enchantmentSpaceProtection, 1);
            Laminator.addRecipe2(
                T,
                64,
                128,
                plate.mat(ANY.Rubber, 2),
                make((Item) ArmorsGT.HAZMAT_UNIVERSAL[i], 1, 0),
                uniSpace);
        }

        Injector.addRecipe1(
            T,
            64,
            64,
            make(BlocksGT.Concrete, 1, 7),
            FL.array(DYE_FLUIDS_WATER[DYE_INDEX_Black], DYE_FLUIDS_WATER[DYE_INDEX_Yellow]),
            NF,
            launchpad);
        Injector.addRecipe1(
            T,
            64,
            64,
            make(BlocksGT.Concrete, 1, 7),
            FL.array(DYE_FLUIDS_FLOWER[DYE_INDEX_Black], DYE_FLUIDS_FLOWER[DYE_INDEX_Yellow]),
            NF,
            launchpad);
        Injector.addRecipe1(
            T,
            64,
            64,
            make(BlocksGT.Concrete, 1, 7),
            FL.array(DYE_FLUIDS_CHEMICAL[DYE_INDEX_Black], DYE_FLUIDS_CHEMICAL[DYE_INDEX_Yellow]),
            NF,
            launchpad);

        Welder.addRecipe2(
            T,
            64,
            128,
            stickLong.mat(MT.StainlessSteel, 6),
            plate.mat(MT.StainlessSteel, 2),
            structureTower);

        Loom.addRecipe2(T, 16, 16, tag(1), make(Blocks.wool, 2, 0), genericSeat);
        Loom.addRecipe2(T, 16, 16, tag(2), make(Items.string, 8, 0), genericSeat);

        Welder.addRecipeX(
            T,
            256,
            512,
            array(tag(0), plateCurved.mat(MT.StainlessSteel, 4), pipeSmall.mat(MT.Al, 2)),
            engine);
        Welder.addRecipeX(T, 1024, 512, array(tag(0), plateCurved.mat(MT.Ti, 4), pipeMedium.mat(MT.Cr, 2)), advEngine);

        RollFormer.addRecipe1(T, 256, 128, plateCurved.mat(MT.StainlessSteel, 2), fuelTank);

        Welder.addRecipe2(T, 256, 64, plateDouble.mat(MT.StainlessSteel, 2), gear.mat(MT.Cr, 4), airLock);

    }

}
