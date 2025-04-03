package org.sample.estruturas;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class PriorityDequeBenchmark {
    private PriorityQueue<Integer> priorityDeque;
    private Random random;
    private int[] dataset;

    @Param({"1000", "10000", "100000"})  // Tamanhos diferentes para teste
    private int size;

    @Setup(Level.Trial) // Inicializa a PriorityDeque apenas uma vez por tamanho de teste
    public void setUp() {
        priorityDeque = new PriorityQueue<>();
        random = new Random();
        dataset = generateUniqueRandomNumbers(size, 0, 100000);
        for (int value : dataset) {
            priorityDeque.add(value);
        }
    }

    private int[] generateUniqueRandomNumbers(int size, int min, int max) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();
        while (uniqueNumbers.size() < size) {
            uniqueNumbers.add(random.nextInt(max - min) + min);
        }
        return uniqueNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    @Benchmark
    public void testInsert() {
        if (priorityDeque.size() > size) {
            priorityDeque.poll(); // Remove o menor elemento para evitar crescimento indefinido
        }
        priorityDeque.add(random.nextInt(10000));
    }



   
}