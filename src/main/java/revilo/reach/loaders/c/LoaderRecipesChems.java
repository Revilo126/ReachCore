package revilo.reach.loaders.c;

import static gregapi.data.CS.*;

import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.data.RM;
import gregapi.util.ST;
import revilo.reach.data.RCMT;

public class LoaderRecipesChems implements Runnable {

    @Override
    public void run() {
        // Rocket Fuel
        RM.Distillery.addRecipe1(T, 16, 128, ST.tag(1), FL.Kerosine.make(25), FL.make("rocketpropellant", 25), NI);

        RM.CryoMixer.addRecipe1(
            T,
            16,
            16,
            ST.tag(0),
            FL.array(FL.make("rocketpropellant", 8), FL.Liquid_Oxygen.make(8)),
            FL.make("rocketfuelmix", 16),
            NI);
        RM.Freezer.addRecipe1(T, 8192, 2048, ST.tag(0), FL.Helium.make(6), FL.make("superfluidhelium", 6), NI);

        // Sr2Ru04 line
        RM.Mixer.addRecipe1(
            T,
            512,
            512,
            OP.dust.mat(MT.OREMATS.Celestine, 1),
            FL.Water.make(100),
            FL.CarbonDioxide.make(100),
            OP.dust.mat(RCMT.SrCO3, 1)); // too lazy to find h2s probs add later
        RM.Smelter
            .addRecipe1(T, 512, 2048, OP.dust.mat(MT.Ru, 1), FL.make("chlorine", 100), NF, OP.dust.mat(RCMT.RuCl3, 1));
        RM.Smelter
            .addRecipe1(T, 512, 2048, OP.dust.mat(RCMT.RuCl3, 1), FL.Water.make(250), NF, OP.dust.mat(RCMT.RuO2, 1));
        RM.BurnMixer.addRecipe2(
            T,
            2048L,
            1024L,
            OP.dust.mat(RCMT.SrCO3, 1),
            OP.dust.mat(RCMT.RuO2, 1),
            OP.dust.mat(RCMT.Sr2RuO4, 1));

        // Gas Centrifuge Enriching
        // RCRM.GasCentrifuge.addRecipe0(T, 256, 2048, MT.UF6.gas(144, F), MT.U238F6.gas(143, F), MT.U235F6.gas(1, F));

        RM.BurnMixer.addRecipe1(T, 16, 2048, OP.dust.mat(MT.P, 1), MT.Cl.gas(6 * U, T), NF, RCMT.PCL3.liquid(1 * U, T));
        RM.Mixer
            .addRecipe0(T, 16, 1024, RCMT.PCL3.liquid(2 * U, T), FL.Oxygen.make(1 * U), RCMT.POCL3.liquid(2 * U, T));
    }
}
