@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
class TreeSetBenchmark {
    private TreeSet<Integer> treeSet;
    private Random random;
    private int[] dataset;

    @Setup(Level.Invocation)
    public void setUp() {
        treeSet = new TreeSet<>();
        random = new Random();
        dataset = random.ints(1000, 0, 10000).toArray();
        for (int value : dataset) {
            treeSet.add(value);
        }
    }

    @Benchmark
    public void testInsert() {
        treeSet.add(random.nextInt(10000));
    }

    @Benchmark
    public boolean testSearch() {
        return treeSet.contains(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public void testRemove() {
        treeSet.remove(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public int testMin() {
        return treeSet.first();
    }

    @Benchmark
    public int testMax() {
        return treeSet.last();
    }

    @Benchmark
    public List<Integer> testDescendingIteration() {
        return new ArrayList<>(treeSet.descendingSet());
    }
}
