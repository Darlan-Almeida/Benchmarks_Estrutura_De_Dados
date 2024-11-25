package benchmarks.src.main.java.example.com;


public class App {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                    .include(ListBenchmark.class.getSimpleName()) // Nome da classe de benchmark
                    .forks(1) // Número de forks (execuções independentes)
                    .build();
    
        new Runner(opt).run();
        }
}
