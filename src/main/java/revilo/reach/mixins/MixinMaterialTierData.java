package revilo.reach.mixins;

import static gregapi.data.CS.*;
import static gregapi.data.MT.*;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import gregapi.data.ANY;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.oredict.OreDictItemData;
import revilo.reach.data.RCMT;

@Mixin(MT.DATA.class)
public class MixinMaterialTierData {

    /*
     * TODO:
     * PUV1 - MAX+ Cables
     * Finalise Tiers Materials (E.g HV - Stainless Steel)
     * T10+ Circuits
     */

    @Final
    @Mutable
    @Shadow
    public static OreDictItemData[] WIRES_01;

    @Final
    @Mutable
    @Shadow
    public static OreDictItemData[] WIRES_04;

    @Final
    @Mutable
    @Shadow
    public static OreDictItemData[] CABLES_01;

    @Final
    @Mutable
    @Shadow
    public static OreDictItemData[] CABLES_04;

    @Final
    @Mutable
    @Shadow
    public static OreDictItemData[] CIRCUITS;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void onDataInit(CallbackInfo ci) {
        OUT.println("Reach: Refactoring GT6's Material Data");
        WIRES_01 = new OreDictItemData[] { OP.wireGt01.dat(Pb), // ULV
            OP.wireGt01.dat(Sn), // LV
            OP.wireGt01.dat(ANY.Cu), // MV
            OP.wireGt01.dat(Au), // HV
            OP.wireGt01.dat(Al), // EV
            OP.wireGt01.dat(Pt), // IV
            OP.wireGt01.dat(Nq), // LuV
            OP.wireGt01.dat(Nq_528), // ZPM
            OP.wireGt01.dat(RCMT.Ubn), // UV
            OP.wireGt01.dat(Nq_522), // PUV1
            OP.wireGt01.dat(Graphene), // PUV2
            OP.wireGt01.dat(Superconductor), // PUV3
            OP.wireGt01.dat(Superconductor), // PUV4
            OP.wireGt01.dat(Superconductor), // PUV5
            OP.wireGt01.dat(Superconductor), // MAX
            OP.wireGt01.dat(Superconductor) // MAX+
        };
        WIRES_04 = new OreDictItemData[] { OP.wireGt04.dat(Pb), // ULV
            OP.wireGt04.dat(Sn), // LV
            OP.wireGt04.dat(ANY.Cu), // MV
            OP.wireGt04.dat(Au), // HV
            OP.wireGt04.dat(Al), // EV
            OP.wireGt04.dat(Pt), // IV
            OP.wireGt04.dat(Nq), // LuV
            OP.wireGt04.dat(Nq_528), // ZPM
            OP.wireGt04.dat(RCMT.Ubn), // UV
            OP.wireGt04.dat(Nq_522), // PUV1
            OP.wireGt04.dat(Graphene), // PUV2
            OP.wireGt04.dat(Superconductor), // PUV3
            OP.wireGt04.dat(Superconductor), // PUV4
            OP.wireGt04.dat(Superconductor), // PUV5
            OP.wireGt04.dat(Superconductor), // MAX
            OP.wireGt04.dat(Superconductor) // MAX+
        };
        CABLES_01 = new OreDictItemData[] { OP.cableGt01.dat(Pb), // ULV
            OP.cableGt01.dat(Sn), // LV
            OP.cableGt01.dat(ANY.Cu), // MV
            OP.cableGt01.dat(Au), // HV
            OP.cableGt01.dat(Al), // EV
            OP.cableGt01.dat(Pt), // IV
            OP.cableGt01.dat(Nq), // LuV
            OP.cableGt01.dat(Nq_528), // ZPM
            OP.cableGt01.dat(RCMT.Ubn), // UV
            OP.cableGt01.dat(Nq_522), // PUV1
            OP.wireGt01.dat(Graphene), // PUV2
            OP.wireGt01.dat(Superconductor), // PUV3
            OP.wireGt01.dat(Superconductor), // PUV4
            OP.wireGt01.dat(Superconductor), // PUV5
            OP.wireGt01.dat(Superconductor), // MAX
            OP.wireGt01.dat(Superconductor) // MAX+
        };
        CABLES_04 = new OreDictItemData[] { OP.cableGt04.dat(Pb), // ULV
            OP.cableGt04.dat(Sn), // LV
            OP.cableGt04.dat(ANY.Cu), // MV
            OP.cableGt04.dat(Au), // HV
            OP.cableGt04.dat(Al), // EV
            OP.cableGt04.dat(Pt), // IV
            OP.cableGt04.dat(Nq), // LuV
            OP.cableGt04.dat(Nq_528), // ZPM
            OP.cableGt04.dat(RCMT.Ubn), // UV
            OP.cableGt04.dat(Nq_522), // PUV1
            OP.wireGt04.dat(Graphene), // PUV2
            OP.wireGt04.dat(Superconductor), // PUV3
            OP.wireGt04.dat(Superconductor), // PUV4
            OP.wireGt04.dat(Superconductor), // PUV5
            OP.wireGt04.dat(Superconductor), // MAX
            OP.wireGt04.dat(Superconductor) // MAX+
        };
        CIRCUITS = new OreDictItemData[] { OP.circuit.dat(Primitive), OP.circuit.dat(Basic), OP.circuit.dat(Good),
            OP.circuit.dat(Advanced), OP.circuit.dat(Elite), OP.circuit.dat(Master), OP.circuit.dat(Ultimate),
            OP.circuit.dat(RCMT.Nano), OP.circuit.dat(RCMT.Atomic), OP.circuit.dat(Quantum), OP.circuit.dat(Quantum),
            OP.circuit.dat(Quantum), OP.circuit.dat(Quantum), OP.circuit.dat(Quantum), OP.circuit.dat(Quantum),
            OP.circuit.dat(Quantum) };
    }
}
