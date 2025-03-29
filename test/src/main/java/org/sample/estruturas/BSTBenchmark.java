package org.sample.estruturas;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@BenchmarkMode(Mode.All) 
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class BSTBenchmark {
    private BST bst;
    private Random random;
    private int[] dataset;

    @Param({"1000", "10000", "100000"}) // Tamanhos diferentes para teste
    private int size;

    @Setup(Level.Trial) // Inicializa a BST apenas uma vez por tamanho de teste
    public void setUp() {
        bst = new BST();
        random = new Random();
        dataset = random.ints(size, 0, 100000).toArray();
        for (int value : dataset) {
            bst.add(value);
        }
    }

    @Benchmark
    public void testInsert() {
        bst.add(random.nextInt(10000));
    }

    @Benchmark
    public boolean testSearch() {
        return bst.search(dataset[random.nextInt(dataset.length)]) != null;
    }

    @Benchmark
    public void testRemove() {
        bst.remove(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public int testMin() {
        Node minNode = bst.min();
        return (minNode != null) ? minNode.value : -1;
    }

    @Benchmark
    public int testMax() {
        Node maxNode = bst.max();
        return (maxNode != null) ? maxNode.value : -1;
    }

    @Benchmark
    public Integer testPredecessor() {
        Node node = bst.search(dataset[random.nextInt(dataset.length)]);
        Node predecessor = bst.predecessor(node);
        return (predecessor != null) ? predecessor.value : null;
    }

    @Benchmark
    public Integer testSuccessor() {
        Node node = bst.search(dataset[random.nextInt(dataset.length)]);
        Node successor = bst.sucessor(node);
        return (successor != null) ? successor.value : null;
    }

    @Benchmark
    public List<Integer> testInOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        bst.inOrder(); // A versão original imprimia os valores em vez de retorná-los
        return result;
    }

    @Benchmark
    public List<Integer> testLevelOrderTraversal() {
        return bst.bfs();
    }
}