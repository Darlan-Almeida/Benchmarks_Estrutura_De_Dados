
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
class TreeMapBenchmark {
    private TreeMap<Integer, Integer> treeMap;
    private Random random;
    private int[] dataset;

    @Setup(Level.Invocation)
    public void setUp() {
        treeMap = new TreeMap<>();
        random = new Random();
        dataset = random.ints(1000, 0, 10000).toArray();
        for (int value : dataset) {
            treeMap.put(value, value);
        }
    }

    @Benchmark
    public void testInsert() {
        treeMap.put(random.nextInt(10000), random.nextInt(10000));
    }

    @Benchmark
    public boolean testSearch() {
        return treeMap.containsKey(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public void testRemove() {
        treeMap.remove(dataset[random.nextInt(dataset.length)]);
    }

    @Benchmark
    public int testMin() {
        return treeMap.firstKey();
    }

    @Benchmark
    public int testMax() {
        return treeMap.lastKey();
    }

    @Benchmark
    public List<Integer> testKeySetIteration() {
        return new ArrayList<>(treeMap.keySet());
    }
}
