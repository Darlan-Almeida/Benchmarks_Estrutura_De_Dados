package org.example;

import org.openjdk.jmh.annotations.*;

import java.sql.Time;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class ListOperationBenchmark {

    private List<Integer> arrayList;
    private List<Integer> linkedList;

    @Param({"1000", "100000", "1000000"})
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
    public void copyingArray(){
        List<Integer> lista = new ArrayList<Integer>();
        lista.addAll(arrayList);
    }

    @Benchmark
    public void copyingLinkedList(){
        List<Integer> lista = new LinkedList<Integer>();
        lista.addAll(linkedList);
    }
}
