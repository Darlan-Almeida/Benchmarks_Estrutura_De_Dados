package org.sample;

import org.openjdk.jmh.annotations.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput) // Mede a taxa de operações por segundo
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Unidade de tempo no resultado
@State(Scope.Thread) // Cada thread tem sua própria instância
public class ListBenchmark {

    private List<Integer> arrayList;
    private List<Integer> linkedList;

    @Param({"1000", "10000", "100000"}) // Tamanhos diferentes para teste
    private int size;

    @Setup(Level.Iteration) // Executado antes de cada iteração de benchmark
    public void setup() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        // Preenche as listas com dados
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    @Benchmark
    public void arrayListAdd() {
        arrayList.add(0, -1); // Adiciona no início
    }

    @Benchmark
    public void linkedListAdd() {
        linkedList.add(0, -1); // Adiciona no início
    }

    @Benchmark
    public int arrayListGet() {
        return arrayList.get(size / 2); // Acessa o elemento no meio
    }

    @Benchmark
    public int linkedListGet() {
        return linkedList.get(size / 2); // Acessa o elemento no meio
    }
}

