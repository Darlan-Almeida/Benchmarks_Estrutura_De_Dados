package org.example;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class FilterCollectStreamBenchmark {

    private static Set<Integer> hashSet;
    private static Set<Integer> treeSet;
    private static List<Integer> linkedList;
    private static List<Integer> arrayList;

    @Param({"1000", "10000", "100000"})
    private int size;

    @Setup(Level.Iteration)
    public void setup() {
        Random random = new Random();
        hashSet = new HashSet<>();
        treeSet = new TreeSet<>();
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int valor = random.nextInt(size);
            hashSet.add(valor);
            treeSet.add(valor);
            linkedList.add(valor);
            arrayList.add(valor);
        }
    }

    @Benchmark
    public List<Integer> hashSetFilterCollect() {
        return hashSet.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

    @Benchmark
    public List<Integer> treeSetFilterCollect() {
        return treeSet.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

    @Benchmark
    public List<Integer> linkedListFilterCollect() {
        return linkedList.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

    @Benchmark
    public List<Integer> arrayListFilterCollect() {
        return arrayList.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }
}
