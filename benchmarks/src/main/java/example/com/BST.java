import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
class BSTBenchmark {
    private BST<Integer> bst;
    private Random random;
    private int[] dataset;

    @Setup(Level.Invocation)
    public void setUp() {
        bst = new BST<>();
        random = new Random();
        dataset = random.ints(1000, 0, 10000).toArray();
        for (int value : dataset) {
            bst.insert(value);
        }
    }

    @Benchmark
    public void testInsert() {
        bst.insert(random.nextInt(10000));
    }

    @Benchmark
    public boolean testSearch() {
        return bst.search(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public void testRemove() {
        bst.remove(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public int testMin() {
        return bst.findMin();
    }

    @Benchmark
    public int testMax() {
        return bst.findMax();
    }

    @Benchmark
    public Integer testPredecessor() {
        return bst.predecessor(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public Integer testSuccessor() {
        return bst.successor(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public List<Integer> testInOrderTraversal() {
        return bst.inOrderTraversal();
    }

    @Benchmark
    public List<Integer> testLevelOrderTraversal() {
        return bst.levelOrderTraversal();
    }
}
