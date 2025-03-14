package org.example;

import org.openjdk.jmh.annotations.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.Throughput) // Mede a taxa de operações por segundo
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Unidade de tempo no resultado
@State(Scope.Thread) // Cada thread tem sua própria instância
public class StreamBenchmark {

    private static Set<Integer> hashSet;
    private static Set<Integer> treeSet;
    private static List<Integer> linkedList;
    private static List<Integer> arrayList;
    private static Random random;


    @Param({"1000", "10000", "100000", "1000000"}) // Tamanhos diferentes para teste
    private int size;

    @Setup(Level.Iteration) // Executado antes de cada iteração de benchmark
    public void setup() {
        random = new Random();
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


//    //count()
//    // --------------------------------------------
//    @Benchmark
//    public long hashSetCountStream() {
//        return hashSet.stream().count();
//    }
//
//    @Benchmark
//    public long hashSetCountParallelStream() {
//        return hashSet.parallelStream().count();
//    }
//
//    @Benchmark
//    public long treeSetCountStream() {
//        return treeSet.stream().count();
//    }
//
//    @Benchmark
//    public long treeSetCountParallelStream() {
//        return treeSet.parallelStream().count();
//    }
//
//    @Benchmark
//    public long linkedListCountStream() {
//        return linkedList.stream().count();
//    }
//
//    @Benchmark
//    public long linkedListCountParallelStream() {
//        return linkedList.parallelStream().count();
//    }
//
//    @Benchmark
//    public long arrayListCountStream() {
//        return arrayList.stream().count();
//    }
//
//    @Benchmark
//    public long arrayListCountParallelStream() {
//        return arrayList.parallelStream().count();
//    }

    // --------------------------------------------

//    //distinct()
//    // --------------------------------------------
//    @Benchmark
//    public List<Integer> linkedListDistinctStream() {
//        return linkedList.stream().distinct().collect(Collectors.toList());
//    }
//
//    @Benchmark
//    public List<Integer> linkedListDistinctParallelStream() {
//        return linkedList.parallelStream().distinct().collect(Collectors.toList());
//    }
//
//    @Benchmark
//    public List<Integer> arrayListDistinctStream() {
//        return arrayList.stream().distinct().collect(Collectors.toList());
//    }
//
//    @Benchmark
//    public List<Integer> arrayListDistinctParallelStream() {
//        return arrayList.parallelStream().distinct().collect(Collectors.toList());
//    }

    // --------------------------------------------

    //findAny()
    // --------------------------------------------
    @Benchmark
    public Optional<Integer> hashSetFindAnyStream() {
        return hashSet.stream().findAny();
    }

    @Benchmark
    public Optional<Integer> hashSetFindAnyParallelStream() {
        return hashSet.parallelStream().findAny();
    }

    @Benchmark
    public Optional<Integer> treeSetFindAnyStream() {
        return treeSet.stream().findAny();
    }

    @Benchmark
    public Optional<Integer> treeSetFindAnyParallelStream() {
        return treeSet.parallelStream().findAny();
    }

    @Benchmark
    public Optional<Integer> linkedListFindAnyStream() {
        return linkedList.stream().findAny();
    }

    @Benchmark
    public Optional<Integer> linkedListFindAnyParallelStream() {
        return linkedList.parallelStream().findAny();
    }

    @Benchmark
    public Optional<Integer> arrayListFindAnyStream() {
        return arrayList.stream().findAny();
    }

    @Benchmark
    public Optional<Integer> arrayListFindAnyParallelStream() {
        return arrayList.parallelStream().findAny();
    }

    // --------------------------------------------

//    //forEach()
//    // --------------------------------------------
//    @Benchmark
//    public void hashSetForEachStream() {
//        hashSet.stream().forEach(i -> {});
//    }
//
//    @Benchmark
//    public void hashSetForEachParallelStream() {
//        hashSet.parallelStream().forEach(i -> {});
//    }
//
//    @Benchmark
//    public void treeSetForEachStream() {
//        treeSet.stream().forEach(i -> {});
//    }
//
//    @Benchmark
//    public void treeSetForEachParallelStream() {
//        treeSet.parallelStream().forEach(i -> {});
//    }
//
//    @Benchmark
//    public void linkedListForEachStream() {
//        linkedList.stream().forEach(i -> {});
//    }
//
//    @Benchmark
//    public void linkedListForEachParallelStream() {
//        linkedList.parallelStream().forEach(i -> {});
//    }
//
//    @Benchmark
//    public void linkedListForEachTraditional() {
//        for (Integer i : linkedList) {}
//    }
//
//    @Benchmark
//    public void arrayListForEachStream() {
//        arrayList.stream().forEach(i -> {});
//    }
//
//    @Benchmark
//    public void arrayListForEachParallelStream() {
//        arrayList.parallelStream().forEach(i -> {});
//    }
//
//    @Benchmark
//    public void arrayListForEachTraditional() {
//        for (Integer i : arrayList) {}
//    }

    // --------------------------------------------



}


