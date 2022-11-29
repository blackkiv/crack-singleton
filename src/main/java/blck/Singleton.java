package blck;

public class Singleton {

    private static Singleton INSTANCE; // lazy init

    private Singleton() {
        if (INSTANCE != null) {
            throw new RuntimeException();
         }
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return String.valueOf(System.identityHashCode(this));
    }
}
