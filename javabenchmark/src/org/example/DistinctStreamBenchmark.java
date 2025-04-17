package org.example;

import org.openjdk.jmh.annotations.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


@BenchmarkMode(Mode.AverageTime) // Mede a taxa de operações por segundo
@OutputTimeUnit(TimeUnit.NANOSECONDS) // Unidade de tempo no resultado
@State(Scope.Thread) // Cada thread tem sua própria instância
public class DistinctStreamBenchmark {


    private static Set<Integer> hashSet;
    private static Set<Integer> treeSet;
    private static List<Integer> linkedList;
    private static List<Integer> arrayList;


    @Param({"1000", "10000", "100000"}) // Tamanhos diferentes para teste
    private int size;

    @Setup(Level.Iteration) // Executado antes de cada iteração de benchmark
    public void setup() {
        Random random = new Random();
        hashSet = new HashSet<>();
        treeSet = new TreeSet<>();
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();

        // Preenche as listas com dados
        for (int i = 0; i < size; i++) {
            int valor = random.nextInt(size);
            hashSet.add(valor);
            treeSet.add(valor);
            linkedList.add(valor);
            arrayList.add(valor);
        }


    }

    @Benchmark
    public void linkedListDistinctStream() {
        Object o = linkedList.stream().distinct().collect(Collectors.toList());
    }

    @Benchmark
    public void arrayListDistinctStream() {
        Object o = arrayList.stream().distinct().collect(Collectors.toList());
    }

    @Benchmark
    public void treeSetDistinctStream() {
        Object o = treeSet.stream().distinct().collect(Collectors.toList());
    }

    @Benchmark
    public void hashSetDistinctStream() {
        Object o = hashSet.stream().distinct().collect(Collectors.toList());
    }
}
