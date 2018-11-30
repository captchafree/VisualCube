package SetupThreads;

public class Initializer {

    public static void init() {
        Runtime.getRuntime().addShutdownHook(new CleanupThread());
    }
}
