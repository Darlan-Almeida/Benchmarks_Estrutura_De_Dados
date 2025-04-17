package main.java.example.com;


import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class App {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                    .include(HashMapHashSetBenchmark.class.getSimpleName()) // Nome da classe de benchmark
                    .forks(1) // Número de forks (execuções independentes)
                    .result("HashMapHashSetBenchmark.json")
                    .resultFormat(ResultFormatType.JSON)
                    .build();
    
        new Runner(opt).run();
        }
}
