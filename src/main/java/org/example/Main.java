package org.example;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Classe de execução dos testes. Cada um foi executado individualmente,
 * visando um tratamento individual dado aos resultados.
 */
public class Main {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ListBenchmark.class.getSimpleName()) // Nome da classe de benchmark
                .forks(1) // Número de forks (execuções independentes)
                .result("FirstBenchmarkAT.json") //Output do JSON com resultados
                .resultFormat(ResultFormatType.JSON) //Formatação dos resultados
                .build();

        new Runner(opt).run();
    }
}