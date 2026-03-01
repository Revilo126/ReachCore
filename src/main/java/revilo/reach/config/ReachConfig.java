package revilo.reach.config;

import carbonconfiglib.CarbonConfig;
import carbonconfiglib.config.Config;
import carbonconfiglib.config.ConfigEntry.DoubleValue;
import carbonconfiglib.config.ConfigHandler;
import carbonconfiglib.config.ConfigSection;

public class ReachConfig implements Runnable {

    public static DoubleValue modpackVersion;

    public ConfigHandler handler;

    @Override
    public void run() {
        Config config = new Config("reach");
        ConfigSection versioning = config.add("versioning");
        modpackVersion = versioning.addDouble("Current Modpack Version", 0.1);

        handler = CarbonConfig.CONFIGS.createConfig(config);
        handler.register();
    }

    public static double getModpackVersion() {
        return modpackVersion.get();
    }

}
