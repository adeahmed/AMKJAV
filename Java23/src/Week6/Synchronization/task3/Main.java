package Week6.Synchronization.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {
        ThreadSafeArrayList<String> threadSafeList = new ThreadSafeArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 1000; i++) {
            final int index = i;
            executor.execute(() -> threadSafeList.addElement("Element " + index)); // Käytä final-muuttujaa lambda-lausekkeessa
        }

        for (int i = 0; i < 1000; i++) {
            final int index = i;
            executor.execute(() -> threadSafeList.addElement("Element " + index)); // Käytä final-muuttujaa lambda-lausekkeessa
        }

        for (int i = 0; i < 1000; i++) {
            final int index = i;
            executor.execute(() -> threadSafeList.removeElement("Element " + index)); // Käytä final-muuttujaa lambda-lausekkeessa
        }

        executor.shutdown();

        threadSafeList.printSize("Safe print size: ");
    }
}
