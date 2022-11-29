package blck;

public class Main {

    public static void main(String[] args) throws Exception {

        // issue
        var instance1 = Singleton.getInstance();
        var declaredConstructor = Singleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        var instanceReflection = declaredConstructor.newInstance();

        System.out.printf("%s | %s\n", instance1, instanceReflection);
    }

}
