package blck;

public class Main {

    public static void main(String[] args) {

        var instance1 = Singleton.getInstance();
        var instance2 = Singleton.getInstance();

        var instance1HashCode = System.identityHashCode(instance1);
        var instance2HashCode = System.identityHashCode(instance2);

        System.out.printf("%d | %d%n", instance1HashCode, instance2HashCode);

        assert instance1 == instance2;

    }

}
