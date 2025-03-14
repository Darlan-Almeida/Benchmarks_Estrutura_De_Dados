package org.sample.estruturas;

import org.openjdk.jmh.annotations.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class TreeSetBenchmark {
    private TreeSet<Integer> treeSet;
    private Random random;
    private int[] dataset;

    @Param({"10" , "20"}) // Tamanhos variáveis para o benchmark
    private int size;

    @Setup(Level.Trial) // Inicializa apenas uma vez por tamanho
    public void setUp() {
        treeSet = new TreeSet<>();
        random = new Random();
        dataset = random.ints(size, 0, 100000).toArray();
        for (int value : dataset) {
            treeSet.add(value);
        }
    }

    @Benchmark
    public void testInsert() {
        treeSet.add(random.nextInt(100000));
    }

    @Benchmark
    public boolean testSearch() {
        return treeSet.contains(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public void testRemove() {
        treeSet.remove(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public int testMin() {
        return treeSet.first();
    }

    @Benchmark
    public int testMax() {
        return treeSet.last();
    }

    @Benchmark
    public List<Integer> testDescendingIteration() {
        return new ArrayList<>(treeSet.descendingSet());
    }
}
