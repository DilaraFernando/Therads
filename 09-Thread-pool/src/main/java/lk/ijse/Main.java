package lk.ijse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Runnable runnable = new MyRunnable("ThreadName" + i);
            executor.execute(runnable);
        }
        executor.shutdown();
    }
}