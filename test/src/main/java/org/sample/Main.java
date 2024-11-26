package org.sample;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {
    public static void main(String[] args) throws RunnerException {
        System.out.println("Start!");
        Options opt = new OptionsBuilder()
                .include(ListBenchmark.class.getSimpleName()) // Nome da classe de benchmark
                .forks(1) // Número de forks (execuções independentes)
                .build();

        new Runner(opt).run();
    }
}