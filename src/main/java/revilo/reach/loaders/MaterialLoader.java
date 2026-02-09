package revilo.reach.loaders;

import static gregapi.data.CS.*;

import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.data.RM;
import gregapi.util.OM;
import gregapi.util.ST;
import revilo.reach.api.data.RCMT;

public class MaterialLoader implements Runnable {

    @Override
    public void run() {
        // Sr2Ru04 line //
        RM.Mixer.addRecipe1(
            T,
            512,
            512,
            OM.dust(MT.OREMATS.Celestine),
            FL.Water.make(100),
            FL.CarbonDioxide.make(100),
            OM.dust(RCMT.SrCO3)); // too lazy to find h2s probs add later
        RM.Smelter.addRecipe1(T, 512, 2048, 10000, OM.dust(MT.Ru), FL.make("chlorine", 100), NF, OM.dust(RCMT.RuCl3));
        RM.Smelter.addRecipe1(T, 512, 2048, 10000, OM.dust(RCMT.RuCl3), FL.Water.make(250), NF, OM.dust(RCMT.RuO2));
        RM.BurnMixer
            .addRecipe2(T, 2048L, 1024L, 10000L, OM.dust(RCMT.SrCO3), OM.dust(RCMT.RuO2), OM.dust(RCMT.Sr2RuO4));

        RM.Mixer.addRecipe2(T, 16L, 1024L, 10000L, OM.dust(MT.Al), OM.dust(MT.Fe, 3), OM.dust(RCMT.Thermite, 4)); // Thermite

        RM.Fusion
            .addRecipe1(
                F,
                -8192,
                4096,
                ST.tag(1),
                FL.array(MT.Bk.liquid(U, T), MT.Ti.liquid(U, T)),
                FL.array(MT.Uue.liquid(U, T)),
                ZL_IS)
            .setSpecialNumber(4096L * 8192L * 16L); // Theoretical Elements - Fusion only
        RM.Fusion
            .addRecipe1(
                F,
                -8192,
                4352,
                ST.tag(2),
                FL.array(MT.Cf.liquid(U, T), MT.Ti.liquid(U, T)),
                FL.array(MT.Ubn.liquid(U, T)),
                ZL_IS)
            .setSpecialNumber(4352L * 8192L * 16L);
        // RM.Fusion
        // .addRecipe1(
        // F,
        // -8192,
        // 4608,
        // ST.tag(1),
        // FL.array(MT.U_238.liquid(U, T), MT.Cu.liquid(U, T)),
        // FL.array(MT.Ubu.liquid(U, T)),
        // ZL_IS)
        // .setSpecialNumber(4608L * 8192L * 16L);
    }

}
