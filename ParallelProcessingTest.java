package Parallel_Process;

public class ParallelProcessingTest
{
    public static void main(String[] args)
    {
        int numberOfThreads = 5;
        for (int i = 0; i < numberOfThreads; i++)
        {
            Thread thread = new Thread(new Task(i));
            thread.start();
        }
    }
}

class Task implements Runnable {
    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
        // Simulate some work with sleep
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskId + " is completed on thread " + Thread.currentThread().getName());
    }
}
