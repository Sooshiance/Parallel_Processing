package Parallel_Process;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
public static void main(String[] args) throws InterruptedException {
int threadCount = 3;
CountDownLatch latch = new CountDownLatch(threadCount);

for (int i = 0; i < threadCount; i++) {
new Thread(() -> {
try {
// Simulate some work
Thread.sleep(1000);
System.out.println(Thread.currentThread().getName() + " finished work");
} catch (InterruptedException e) {
e.printStackTrace();
} finally {
latch.countDown();
}
}).start();
}

latch.await();
System.out.println("All threads have finished work");
}
}