package org.example;

import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * "BenchmarkMode" Cálculado em tempo médio de nanosegundos por operação
 * "OutputTimeUnit" Retorna resultado em nanosegundos
 * "State" Instância uma thread por vez
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class ListBulkOperationBenchmark {

    private List<Integer> arrayList;
    private List<Integer> linkedList;

    /**
     * Diferentes quantidades de entradas usadas nos benchmarks
     */
    @Param({"1000", "100000", "1000000"})
    private int size;

    /**
     * Setup inicial voltado à popular os elementos de ambas as listas
     */
    @Setup
    public void setup(){
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    /**
     * Teste voltado à copiar os elementos de uma arraylist para outra arraylist
     */
    @Benchmark
    public void copyingArray(){
        List<Integer> lista = new ArrayList<Integer>();
        lista.addAll(arrayList);
    }

    /**
     * Teste voltado à copiar os elementos de uma linked list para outra linked list
     */
    @Benchmark
    public void copyingLinkedList(){
        List<Integer> lista = new LinkedList<Integer>();
        lista.addAll(linkedList);
    }
}
