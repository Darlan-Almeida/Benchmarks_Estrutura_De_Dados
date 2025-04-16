package org.example;

import org.openjdk.jmh.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * "BenchmarkMode" Cálculado em tempo médio de nanosegundos por operação
 * "OutputTimeUnit" Retorna resultado em nanosegundos
 * "State" Instância uma thread por vez
 */
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.NANOSECONDS)

public class ListSearchBenchMark {

    private List<Integer> arrayList;
    private List<Integer> linkedList;

    /**
     * Diferentes quantidades de entradas usadas nos benchmarks
     */
    @Param({"1000","100000","1000000"})
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
     * Teste voltado a percorrer a arraylist, buscando pelo elemento "500".
     */
    @Benchmark
    public void acessandoArrayContains(){
        arrayList.contains(500);
    }

    /**
     * Teste voltado a percorrer a linked list, buscando pelo elemento "500".
     */
    @Benchmark
    public void acessandoLinkedContains(){
        linkedList.contains(500);
    }

    /**
     * Teste voltado a acessar um índice da arraylist.
     */
    @Benchmark
    public void acessandoArrayIndexOf(){
        arrayList.indexOf(500);
    }

    /**
     * Teste voltado a acessar um índice da linked list.
     */
    @Benchmark
    public void acessandoLinkedIndexOf(){
        linkedList.indexOf(500);
    }

    /**
     * Teste voltado a percorrer toda a arraylist,visto que a busca de um elemento inexistente
     * na estrutura corresponde à O(n).
     */
    @Benchmark
    public void buscandoElementosInexistenteArray(){
        arrayList.contains(-1);
    }

    /**
     * Teste voltado a percorrer toda a linked list,visto que a busca de um elemento inexistente
     * na estrutura corresponde à O(n).
     */
    @Benchmark
    public void buscandoElementosInexistenteLinked(){
        arrayList.contains(-1);
    }
}
