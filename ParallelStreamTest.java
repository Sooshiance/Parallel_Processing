package Parallel_Process;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamTest {
public static void main(String[] args) {
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
list.parallelStream().forEach(i -> {
System.out.println("Processing " + i + " on thread " + Thread.currentThread().getName());
});
}
}