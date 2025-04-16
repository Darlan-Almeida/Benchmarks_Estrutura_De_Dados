package org.example;

import org.openjdk.jmh.annotations.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * "BenchmarkMode" Cálculado em tempo médio de nanosegundos por operação
 * "OutputTimeUnit" Retorna resultado em nanosegundos
 * "State" Instância uma thread por vez
 */
@BenchmarkMode(Mode.AverageTime) // Medição em nanossegundos por operação
@OutputTimeUnit(TimeUnit.NANOSECONDS) // Unidade de tempo no resultado
@State(Scope.Thread) // Cada thread tem sua própria instância
public class ListBenchmark {

    private List<Integer> arrayList;
    private List<Integer> linkedList;

    /**
     * Diferentes quantidades de entradas usadas nos benchmarks
     */
    @Param({"1000", "10000", "100000"}) // Tamanhos diferentes para teste
    private int size;

    /**
     * Preparação inicial voltada a popular as listas, sendo executado previamente antes
     * de cada lista
     */
    @Setup(Level.Iteration)
    public void setup() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    /**
     * Teste voltado à adição de um novo elemento no início do arraylist
     */
    @Benchmark
    public void arrayListAdd() {
        arrayList.add(0, -1);
    }

    /**
     * Teste voltado à adição de um novo elemento no início da linked list
     */
    @Benchmark
    public void linkedListAdd() {
        linkedList.add(0, -1);
    }

    /**
     * Teste voltado à acessar um elemento do arraylist
     */
    @Benchmark
    public int arrayListGet() {
        return arrayList.get(size / 2);
    }

    /**
     * Teste voltado à acessar um elemento da linked list
     */
    @Benchmark
    public int linkedListGet() {
        return linkedList.get(size / 2);
    }
}

