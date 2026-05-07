package revilo.reach.util;

/*
 * External Detections functions.
 */
public class ED {

    public static boolean isGithubActions() {
        return "true".equals(System.getenv("GITHUB_ACTIONS"));
    }
}
