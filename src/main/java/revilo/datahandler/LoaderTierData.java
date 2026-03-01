package revilo.datahandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.oredict.OreDictItemData;
import revilo.reach.api.data.RCMT;

public class LoaderTierData implements Runnable {

    @Override
    public void run() {
        List<OreDictItemData> WIRES_01 = new ArrayList<OreDictItemData>(Arrays.asList(MT.DATA.WIRES_01));
        List<OreDictItemData> WIRES_04 = new ArrayList<OreDictItemData>(Arrays.asList(MT.DATA.WIRES_04));
        List<OreDictItemData> CABLES_01 = new ArrayList<OreDictItemData>(Arrays.asList(MT.DATA.CABLES_01));
        List<OreDictItemData> CABLES_04 = new ArrayList<OreDictItemData>(Arrays.asList(MT.DATA.CABLES_04));

        // Wires 01

        WIRES_01.remove(7); // ZPM
        WIRES_01.add(7, OP.wireGt01.dat(RCMT.Sr2RuO4));
        WIRES_01.remove(8); // UV
        WIRES_01.add(8, OP.wireGt01.dat(RCMT.Ubn));
        WIRES_01.remove(9); // PUV1
        WIRES_01.add(9, OP.wireGt01.dat(MT.Nq_522));

        WIRES_04.remove(7);
        WIRES_04.add(7, OP.wireGt04.dat(RCMT.Sr2RuO4));
        WIRES_04.remove(8);
        WIRES_04.add(8, OP.wireGt04.dat(RCMT.Ubn));
        WIRES_04.remove(9);
        WIRES_04.add(9, OP.wireGt04.dat(MT.Nq_522));

        CABLES_01.remove(7);
        CABLES_01.add(7, OP.cableGt01.dat(RCMT.Sr2RuO4));
        CABLES_01.remove(8);
        CABLES_01.add(8, OP.cableGt01.dat(RCMT.Ubn));
        CABLES_01.remove(9);
        CABLES_01.add(9, OP.cableGt01.dat(MT.Nq_522));

        CABLES_04.remove(7);
        CABLES_04.add(7, OP.cableGt04.dat(RCMT.Sr2RuO4));
        CABLES_04.remove(8);
        CABLES_04.add(8, OP.cableGt04.dat(RCMT.Ubn));
        CABLES_04.remove(9);
        CABLES_04.add(9, OP.cableGt04.dat(MT.Nq_522));

        // MT.DATA.WIRES_01 = (OreDictItemData[]) WIRES_01.toArray();
        // FUCKING THE GT ARRAY IS A FINAL SO I CANT FUCINK EDIT IT!

    }

}
