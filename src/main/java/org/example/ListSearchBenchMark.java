package org.example;

import org.openjdk.jmh.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)

public class ListSearchBenchMark {

    private List<Integer> arrayList;
    private List<Integer> linkedList;

    @Param({"1000","100000","1000000"})
    private int size;

    @Setup
    public void setup(){
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();

        //Populando as listas
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    @Benchmark
    public void acessandoArrayContains(){
        arrayList.contains(500);
    }

    @Benchmark
    public void acessandoLinkedContains(){
        linkedList.contains(500);
    }

    @Benchmark
    public void acessandoArrayIndexOf(){
        arrayList.indexOf(500);
    }


    @Benchmark
    public void acessandoLinkedIndexOf(){
        linkedList.indexOf(500);
    }
}
