package org.example;

import org.openjdk.jmh.annotations.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput) // Mede a taxa de operações por segundo
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Unidade de tempo no resultado
@State(Scope.Thread) // Cada thread tem sua própria instância
public class ListsRemoveBenchmark {

    private List<Integer> arrayList;
   private List<Integer> linkedList;

   @Param({"1000", "100000", "1000000"})
    private int size;

   @Setup(Level.Iteration)
    public void setup() {
       arrayList = new ArrayList<>();
       linkedList = new LinkedList<>();

       //Populando as listas
       for (int i = 0; i < size; i++) {
           arrayList.add(i);
           linkedList.add(i);
       }
   }

   @Benchmark
    public void arrayRemoveFirst() {
       arrayList.add(0, -1);
       arrayList.remove(0);
   }


    @Benchmark
    public void linkedRemoveFirst() {
        linkedList.add(0, -1);
        linkedList.remove(0);
    }


    @Benchmark
    public void arrayRemoveLast(){
        arrayList.remove(arrayList.size() - 1);
    }


    @Benchmark
    public void linkedRemoveLast(){
        linkedList.remove(linkedList.size() - 1);
    }

    @Benchmark
    public void arrayRemoveMiddle(){
       arrayList.remove(arrayList.size() / 2);
    }

    @Benchmark
    public void linkedRemoveMiddle(){
       linkedList.remove(linkedList.size() / 2);
    }
}
