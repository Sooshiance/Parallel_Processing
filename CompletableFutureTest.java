package Parallel_Process;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest
{
    public static void main(String[] args)
    {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            
            System.out.println("Task is running asynchronously on thread " + Thread.currentThread().getName());
            
            try
            {
                Thread.sleep(1000);
            }
            
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Task is completed on thread " + Thread.currentThread().getName());
        });

        future.join(); // Wait for the task to complete
    }
}
