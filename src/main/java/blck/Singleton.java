package blck;

public class Singleton {

    private static Singleton INSTANCE; // lazy init

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

}
