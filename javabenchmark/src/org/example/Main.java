package org.example;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(FilterCollectStreamBenchmark.class.getSimpleName())
                .include(DistinctStreamBenchmark.class.getSimpleName())
                .include(ForEachStreamBenchmark.class.getSimpleName())
                .forks(1)
                .result("resultados.json")
                .resultFormat(ResultFormatType.JSON)
                .build();

        new Runner(opt).run();
    }
}
