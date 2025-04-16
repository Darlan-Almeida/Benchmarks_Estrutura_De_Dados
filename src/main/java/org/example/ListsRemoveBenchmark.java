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
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class ListsRemoveBenchmark {

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
   @Setup(Level.Invocation)
    public void setup() {
       arrayList = new ArrayList<>();
       linkedList = new LinkedList<>();

       for (int i = 0; i < size; i++) {
           arrayList.add(i);
           linkedList.add(i);
       }
   }

    /**
     * Teste voltado a remover o primeiro elemento da arraylist
     */
    @Benchmark
    public void arrayRemoveFirst() {
        if (!arrayList.isEmpty()) {
            arrayList.remove(0);
        }
    }

    /**
     * Teste voltado a remover o primeiro elemento da linked list
     */
    @Benchmark
    public void linkedRemoveFirst() {
        if (!linkedList.isEmpty()) {
            linkedList.remove(0);
        }
    }

    /**
     * Teste voltado a remover o último elemento da arraylist
     */
    @Benchmark
    public void arrayRemoveLast(){
        arrayList.remove(arrayList.size() - 1);
    }

    /**
     * Teste voltado a remover o último elemento da linked list
     */
    @Benchmark
    public void linkedRemoveLast(){
        linkedList.removeLast();
    }

    /**
     * Teste voltado a remover o elemento do meio da arraylist
     */
    @Benchmark
    public void arrayRemoveMiddle(){
       arrayList.remove(arrayList.size() / 2);
    }

    /**
     * Teste voltado a remover o elemento do meio da linked list
     */
    @Benchmark
    public void linkedRemoveMiddle(){
       linkedList.remove(linkedList.size() / 2);
    }
}
