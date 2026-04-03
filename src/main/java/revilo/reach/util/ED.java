package revilo.reach.util;

import static gregapi.data.CS.*;

import revilo.reach.Reach;

/*
 * External Detections functions.
 */
public class ED {

    /*
     * For logging purposes.
     */
    public static boolean isGithubActions() {
        return "true".equals(System.getenv("GITHUB_ACTIONS"));
    }

    /*
     * Checks for if running on github actions and reverts to printing to normal log as GT's is not visible during
     * actions.
     */
    public static void out(String out) {
        if (isGithubActions()) {
            Reach.LOG.info(out);
        } else {
            OUT.println(out);
        }
    }

    public static void err(String err) {
        if (isGithubActions()) {
            Reach.LOG.error(err);
        } else {
            ERR.println(err);
        }
    }

    public static void debug(String debug) {
        if (isGithubActions()) {
            Reach.LOG.debug(debug);
        } else {
            DEB.println(debug);
        }
    }
}
