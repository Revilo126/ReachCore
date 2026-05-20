package revilo.reach.scripts;

import static gregapi.data.CS.*;
import static gregapi.data.CS.OreDictToolNames.*;
import static gregapi.data.MD.*;
import static gregapi.data.OD.*;
import static gregapi.data.OP.*;
import static gregapi.data.RM.*;
import static gregapi.util.CR.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import gregapi.code.ModData;
import gregapi.data.ANY;
import gregapi.data.FL;
import gregapi.data.IL;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.util.ST;
import zmaster587.advancedRocketry.api.AdvancedRocketryAPI;

@SuppressWarnings("unused")
public class ScriptAdvRocketry implements IScriptLoader {

    /*
     * Recipes for Advanced Rocketry are majority crafting table, however most parts should be welded or others.
     */

    // Blocks
    private ItemStack launchpad = make("launchpad", 1), structureTower = make("structureTower", 1),
        genericSeat = make("seat", 1), engine = make("rocketmotor", 1), advEngine = make("tile.advRocket", 1),
        fuelTank = make("fuelTank", 1), sawBlade = make("sawBlade", 1), concrete = make("tile.concrete", 1),
        platePress = make("blockHandPress", 1), airLock = make("item.smallAirlock", 1),
        landingPad = make("dockingPad", 1), atmosDetector = make("tile.atmosphereDetector", 1),
        co2Scrubber = make("tile.scrubber", 1), oxygenVent = make("tile.oxygenVent", 1), lens = make("tile.lens", 1);

    // Items
    private ItemStack wafer = make("wafer", 1), circuitPlate = make("circuitplate", 1),
        circuitIC = make("circuitIC", 1), miscPart = make("miscpart", 1), sawBladeI = make("sawBlade", 1),
        spaceStationChip = make("stationChip", 1), elevatorChip = make("elevatorChip", 1),
        asteroidChip = make("asteroidChip", 1), stationPacked = make("station", 1),
        smallAirlock = make("smallAirlock", 1), carbonCartridge = make("item.carbonScrubberCartridge", 1),
        lensI = make("lens", 1), satellitePowerSource = make("satellitePowerSource", 1),
        satellitePrimaryFunction = make("satellitePrimaryFunction", 1);

    @Override
    public String getScriptName() {
        return "Advanced Rocketry Recipes";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ModIDs.GC_ADV_ROCKETRY, ModIDs.VULPES);
    }

    @Override
    public ModData getModData() {
        return MD.GC_ADV_ROCKETRY;
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

        shapeless(landingPad, ST.array(make(BlocksGT.Concrete, 1, 0)));

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

        Loom.addRecipe2(T, 16, 16, ST.tag(1), make(Blocks.wool, 2, 0), genericSeat);
        Loom.addRecipe2(T, 16, 16, ST.tag(2), make(Items.string, 8, 0), genericSeat);

        Welder.addRecipeX(
            T,
            256,
            512,
            ST.array(ST.tag(0), plateCurved.mat(MT.StainlessSteel, 4), pipeSmall.mat(MT.Al, 2)),
            engine);
        Welder.addRecipeX(
            T,
            1024,
            512,
            ST.array(ST.tag(0), plateCurved.mat(MT.Ti, 4), pipeMedium.mat(MT.Cr, 2)),
            advEngine);

        RollFormer.addRecipe1(T, 256, 128, plateCurved.mat(MT.StainlessSteel, 2), fuelTank);

        Welder.addRecipeX(
            T,
            256,
            64,
            ST.array(plateDouble.mat(MT.StainlessSteel, 2), gear.mat(MT.StainlessSteel, 4), IL.MOTORS[4].get(1)),
            airLock);

    }

}
