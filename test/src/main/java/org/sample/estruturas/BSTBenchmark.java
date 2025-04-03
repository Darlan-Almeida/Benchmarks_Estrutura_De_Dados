package org.sample.estruturas;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.AverageTime) 
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class BSTBenchmark {
    private BST bstBalanced;
    private BST bstUnbalanced;
    private Random random;
    private int[] dataset;

    @Param({"1000", "10000", "100000"})  // Tamanhos diferentes para teste
    private int size;

    @Setup(Level.Invocation) // Garante uma nova árvore a cada invocação do benchmark
    public void setUp() {
        random = new Random();
        dataset = generateUniqueRandomNumbers(size, 0, 100000);

        // Árvore Balanceada
        bstBalanced = new BST();
        Arrays.sort(dataset);
        insertBalanced(bstBalanced, dataset, 0, dataset.length - 1);

        // Árvore Não Balanceada
        bstUnbalanced = new BST();
        for (int value : dataset) {
            bstUnbalanced.add(value);
        }
    }

    private int[] generateUniqueRandomNumbers(int size, int min, int max) {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();
        while (uniqueNumbers.size() < size) {
            uniqueNumbers.add(random.nextInt(max - min) + min);
        }
        return uniqueNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    private void insertBalanced(BST tree, int[] arr, int start, int end) {
        if (start > end) return;
        int mid = (start + end) / 2;
        tree.add(arr[mid]);
        insertBalanced(tree, arr, start, mid - 1);
        insertBalanced(tree, arr, mid + 1, end);
    }


    @Benchmark
    public void testInsertBalanced() {
        bstBalanced.add(random.nextInt(100000));
    }

    @Benchmark
    public void testInsertUnbalanced() {
        bstUnbalanced.add(random.nextInt(100000));
    }


    
    @Benchmark
    public boolean testSearchBalanced() {
        return bstBalanced.search(dataset[random.nextInt(dataset.length)]) != null;
    }

    @Benchmark
    public boolean testSearchUnbalanced() {
        return bstUnbalanced.search(dataset[random.nextInt(dataset.length)]) != null;
    }

    @Benchmark
    public void testRemoveBalanced() {
        bstBalanced.remove(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public void testRemoveUnbalanced() {
        bstUnbalanced.remove(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public int testMinBalanced() {
        Node minNode = bstBalanced.min();
        return (minNode != null) ? minNode.value : -1;
    }

    @Benchmark
    public int testMinUnbalanced() {
        Node minNode = bstUnbalanced.min();
        return (minNode != null) ? minNode.value : -1;
    }

    @Benchmark
    public int testMaxBalanced() {
        Node maxNode = bstBalanced.max();
        return (maxNode != null) ? maxNode.value : -1;
    }

    @Benchmark
    public int testMaxUnbalanced() {
        Node maxNode = bstUnbalanced.max();
        return (maxNode != null) ? maxNode.value : -1;
    }

    @Benchmark
    public Integer testPredecessorBalanced() {
        Node node = bstBalanced.search(dataset[random.nextInt(dataset.length)]);
        Node predecessor = bstBalanced.predecessor(node);
        return (predecessor != null) ? predecessor.value : null;
    }

    @Benchmark
    public Integer testPredecessorUnbalanced() {
        Node node = bstUnbalanced.search(dataset[random.nextInt(dataset.length)]);
        Node predecessor = bstUnbalanced.predecessor(node);
        return (predecessor != null) ? predecessor.value : null;
    }

    @Benchmark
    public Integer testSuccessorBalanced() {
        Node node = bstBalanced.search(dataset[random.nextInt(dataset.length)]);
        Node successor = bstBalanced.sucessor(node);
        return (successor != null) ? successor.value : null;
    }

    @Benchmark
    public Integer testSuccessorUnbalanced() {
        Node node = bstUnbalanced.search(dataset[random.nextInt(dataset.length)]);
        Node successor = bstUnbalanced.sucessor(node);
        return (successor != null) ? successor.value : null;
    }

    @Benchmark
    public void testInOrderTraversalBalanced() {
        bstBalanced.inOrder();
    }

    @Benchmark
    public void testInOrderTraversalUnbalanced() {
        bstUnbalanced.inOrder();
    }

    @Benchmark
    public List<Integer> testLevelOrderTraversalBalanced() {
        return bstBalanced.bfs();
    }

    @Benchmark
    public List<Integer> testLevelOrderTraversalUnbalanced() {
        return bstUnbalanced.bfs();
    }
}
