package Parallel_Process;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        int threadCount = 3;
        CyclicBarrier barrier = new CyclicBarrier(threadCount,
                () -> System.out.println("All threads reached the barrier"));

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    // Simulate some work
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " reached the barrier");
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}