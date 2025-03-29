package org.sample.estruturas;

import org.openjdk.jmh.annotations.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Unidade de tempo no resultado
@State(Scope.Thread) // Cada thread tem sua própria instância
public class TreeMapBenchmark {
    private TreeMap<Integer, Integer> treeMap;
    private Random random;
    private int[] dataset;

    @Param({"1000", "10000", "100000"}) // Tamanhos diferentes para teste
    private int size;

    @Setup(Level.Trial) // Inicializa apenas uma vez por tamanho
    public void setUp() {
        treeMap = new TreeMap<>();
        random = new Random();
        dataset = random.ints(size, 0, 100000).toArray();
        for (int value : dataset) {
            treeMap.put(value, value);
        }
    }

    @Benchmark
    public void testInsert() {
        treeMap.put(random.nextInt(100000), random.nextInt(100000));
    }

    @Benchmark
    public boolean testContains() {
        return treeMap.containsKey(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public void testRemove() {
        treeMap.remove(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public int testMin() {
        return treeMap.firstKey();
    }

    @Benchmark
    public int testMax() {
        return treeMap.lastKey();
    }

    @Benchmark
    public List<Integer> testKeySetIteration() {
        return new ArrayList<>(treeMap.keySet());
    }
}
