package blck;

import java.io.Serial;
import java.io.Serializable;

public class Singleton implements Serializable {

    private static final Long serialVersionUID = 1L;

    private static volatile Singleton INSTANCE; // lazy init

    private Singleton() {
        if (INSTANCE != null) {
            throw new RuntimeException();
        }
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String toString() {
        return String.valueOf(System.identityHashCode(this));
    }

    // https://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
    @Serial
    private Object readResolve() {
        return getInstance();
    }

}
