package revilo.reach.config;

import carbonconfiglib.CarbonConfig;
import carbonconfiglib.config.Config;
import carbonconfiglib.config.ConfigEntry.BoolValue;
import carbonconfiglib.config.ConfigHandler;
import carbonconfiglib.config.ConfigSection;

public class ReachConfig implements Runnable {

    public static ConfigHandler CONFIG;
    public static BoolValue DEV_ENV;

    @Override
    public void run() {
        Config config = new Config("reach");
        ConfigSection developer = config.add("developer");
        // TODO: Make sure it's not shipped with this.
        DEV_ENV = developer.addBool("developer environment", true, "Is in a developer environment?");
        CONFIG = CarbonConfig.CONFIGS.createConfig(config);
        CONFIG.register();
    }

}
