package blck;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        // issue

        var instance1 = Singleton.getInstance();
        byte[] output;

        try (var outputStream = new ByteArrayOutputStream();
            var objectStream = new ObjectOutputStream(outputStream)) {
            objectStream.writeObject(instance1);
            output = outputStream.toByteArray();
        }

        Singleton instance2 = null;
        try (var inputStream = new ByteArrayInputStream(output);
            var objectStream = new ObjectInputStream(inputStream)) {
            if (objectStream.readObject() instanceof Singleton instance) {
                instance2 = instance;
            }
        }

        System.out.printf("%s | %s\n", instance1, instance2);
    }

}
