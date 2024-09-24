package Parallel_Process;

import java.util.concurrent.Phaser;

public class PhaserTest {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // "1" to register self

        for (int i = 0; i < 3; i++) {
            phaser.register();
            new Thread(new Task(phaser)).start();
        }

        phaser.arriveAndDeregister(); // Deregister self
        System.out.println("Main thread deregistered");
    }

    static class Task implements Runnable {
        private Phaser phaser;

        Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " started");
            phaser.arriveAndAwaitAdvance(); // Wait for all threads to reach this point
            System.out.println(Thread.currentThread().getName() + " finished");
        }
    }
}