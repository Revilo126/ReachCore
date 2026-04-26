package revilo.reach.items.armour.module;

import java.util.HashMap;
import java.util.Map;

public class ArmorModuleRegistry {

    public static final Map<String, IArmorModule> MODULES = new HashMap<>();

    public static void register(IArmorModule module) {
        MODULES.put(module.getID(), module);
    }

    public static IArmorModule get(String id) {
        return MODULES.get(id);
    }

    public static boolean exists(String id) {
        return MODULES.containsKey(id);
    }
}
