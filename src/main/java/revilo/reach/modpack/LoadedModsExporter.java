package revilo.reach.modpack;

import static gregapi.data.CS.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;

/*
 * Exports all loaded mods to ModList.md
 * For use once I use git for management
 */
public class LoadedModsExporter implements Runnable {

    private boolean exportModList() {
        List<ModContainer> mods = Loader.instance()
            .getModList();
        File mdFile = new File(DirectoriesGT.MINECRAFT, "modlist.md");

        try (PrintWriter writer = new PrintWriter(mdFile)) {
            writer.println("# Reach Mod List");
            writer.println("");

            writer.println("| Mod Name | Mod ID | Version |");
            writer.println("| :-: | :-: | :-: |");

            for (ModContainer mod : mods) {
                writer.println("| " + mod.getName() + " | `" + mod.getModId() + "` | " + mod.getVersion() + " |");
            }
            return T;
        } catch (Exception e) {
            e.printStackTrace(ERR);
        }
        return F;
    }

    @SuppressWarnings("unused")
    @Override
    public void run() {
        // Disable for now.
        if (false) {
            if (exportModList()) {
                OUT.println("Reach: Generated mod list to \"modlist.md\"!");
            } else {
                ERR.println("Reach: Couldn't export mod file!");
            }
        } else {
            OUT.println("Reach: Not Dev Env");
        }
    }
}
