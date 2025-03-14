package main.java.example.com;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.Throughput) // Mede operações por unidade de tempo
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Unidades em milissegundos
@State(Scope.Thread) // Cada thread tem seu próprio estado
public class HashMapHashSetBenchmark {

    @Param({"1000", "10000", "100000"}) // Tamanhos das coleções testadas
    private int size;

    private Map<Integer, Integer> hashMap;
    private Set<Integer> hashSet;
    private List<Integer> testKeys;

    @Setup(Level.Iteration) // Configuração antes de cada iteração do benchmark
    public void setup() {
        hashMap = new HashMap<>();
        hashSet = new HashSet<>();
        testKeys = new ArrayList<>();

        Random random = new Random();
        IntStream.range(0, size).forEach(i -> {
            int key = random.nextInt(size * 10);
            hashMap.put(key, i);
            hashSet.add(key);
            testKeys.add(key);
        });
    }

    // Benchmark de Inserção no HashMap
    @Benchmark
    public void benchmarkHashMapPut() {
        hashMap.put(size + 1, size + 1);
    }

    // Benchmark de Inserção no HashSet
    @Benchmark
    public void benchmarkHashSetAdd() {
        hashSet.add(size + 1);
    }

    // Benchmark de Busca no HashMap
    @Benchmark
    public Integer benchmarkHashMapGet() {
        return hashMap.get(testKeys.get(size / 2));
    }

    // Benchmark de Busca no HashSet
    @Benchmark
    public boolean benchmarkHashSetContains() {
        return hashSet.contains(testKeys.get(size / 2));
    }

    // Benchmark de Remoção no HashMap
    @Benchmark
    public void benchmarkHashMapRemove() {
        hashMap.remove(testKeys.get(size / 2));
    }

    // Benchmark de Remoção no HashSet
    @Benchmark
    public void benchmarkHashSetRemove() {
        hashSet.remove(testKeys.get(size / 2));
    }

    // Benchmark de Iteração no HashMap
    @Benchmark
    public void benchmarkHashMapIteration() {
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int key = entry.getKey();
        }
    }

    // Benchmark de Iteração no HashSet
    @Benchmark
    public void benchmarkHashSetIteration() {
        for (Integer value : hashSet) {
            int x = value;
        }
    }
}

