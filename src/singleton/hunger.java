package singleton;

public class hunger {
    private static hunger ourInstance = new hunger();

    public static hunger getInstance() {
        return ourInstance;
    }

    private hunger() {
    }
}
