package Parallel_Process;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task = () -> {
            // Simulate some work
            Thread.sleep(1000);
            return Thread.currentThread().getName() + " finished work";
        };

        Future<String> future1 = executor.submit(task);
        Future<String> future2 = executor.submit(task);
        Future<String> future3 = executor.submit(task);

        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}