package Parallel_Process;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest extends RecursiveTask<Integer>
{
    private int[] arr;
    private int start, end;

    public ForkJoinTest(int[] arr, int start, int end)
    {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute()
    {
        if (end - start <= 10)
        {
            int sum = 0;

            for (int i = start; i < end; i++)
            {
                sum += arr[i];
            }

            return sum;
        }
        
        else
        {
            int mid = (start + end) / 2;
            
            ForkJoinTest leftTask = new ForkJoinTest(arr, start, mid);
            ForkJoinTest rightTask = new ForkJoinTest(arr, mid, end);
            
            leftTask.fork();
            
            return rightTask.compute() + leftTask.join();
        }
    }

    public static void main(String[] args)
    {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = i;
        }
        
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTest task = new ForkJoinTest(arr, 0, arr.length);
        
        int result = pool.invoke(task);
        
        System.out.println("Sum: " + result);
    }
}