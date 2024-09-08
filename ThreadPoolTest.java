package Parallel_Process;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
public static void main(String[] args) {
int numberOfThreads = 5;
ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

for (int i = 0; i < numberOfThreads; i++) {
executor.execute(new Task(i));
}
executor.shutdown();
}
}