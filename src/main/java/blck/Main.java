package blck;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws Exception {
        // issue

        var executor = Executors.newFixedThreadPool(2);
        var futures = executor.invokeAll(List.of(Singleton::getInstance, Singleton::getInstance));

        var instances = futures.stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList().stream().map(obj -> {
            if (obj instanceof Singleton instance) {
                return Optional.of(instance.toString());
            } else {
                return Optional.empty();
            }
        }).mapMulti(Optional::ifPresent).toList();

        var instance1 = instances.get(0);
        var instance2 = instances.get(1);

        executor.shutdown();

        System.out.printf("%s | %s\n", instance1, instance2);
    }

}
