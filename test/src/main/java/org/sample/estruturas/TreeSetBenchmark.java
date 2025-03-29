package org.sample.estruturas;

import org.openjdk.jmh.annotations.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.All) // Mede a taxa de operações por segundo
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Unidade de tempo no resultado
@State(Scope.Thread) // Cada thread tem sua própria instância

public class TreeSetBenchmark {
    private TreeSet<Integer> treeSet;
    private Random random;
    private int[] dataset;

    @Param({"1000", "10000", "100000"}) // Tamanhos diferentes para teste
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
    public boolean testContains() {
        return treeSet.contains(dataset[random.nextInt(dataset.length)]);
    }


    @Benchmark
    public void testRemove() {
        treeSet.remove(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public int testFloor() { 
    return treeSet.floor(dataset[random.nextInt(dataset.length)]);
    
    }

    @Benchmark
    public Integer testCeiling() { 
        return treeSet.ceiling(dataset[random.nextInt(dataset.length)]);
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
