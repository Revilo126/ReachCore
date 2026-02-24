package revilo.reach.mixins;

// @Mixin(value = GT6_Main.class)
public class MixinGregtechTierData {

    /**
     * @Inject(method = "onModPreInit2", at = @At("HEAD"))
     *                private void reach$changeTierData(CallbackInfo ci) {
     *                List<OreDictItemData> listWires_01 = new ArrayList<>(Arrays.asList(MT.DATA.WIRES_01));
     *                List<OreDictItemData> listWires_04 = new ArrayList<>(Arrays.asList(MT.DATA.WIRES_04));
     * 
     *                for (byte i = 0; i < 9; i++) {
     *                listWires_01.remove(i + 7);
     *                listWires_04.remove(i + 7);
     *                }
     * 
     *                listWires_01.add(OP.wireGt01.dat(RCMT.Sr2RuO4)); // ZPM
     *                listWires_04.add(OP.wireGt01.dat(RCMT.Sr2RuO4));
     * 
     *                }
     */
}
