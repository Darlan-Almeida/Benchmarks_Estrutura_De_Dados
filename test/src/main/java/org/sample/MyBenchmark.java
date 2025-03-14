package org.sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.sample.estruturas.BSTBenchmark;
import org.sample.estruturas.TreeMapBenchmark;
import org.sample.estruturas.TreeSetBenchmark;

public class MyBenchmark {

    @Benchmark
    public void runBenchmarks() {
        Options opt = new OptionsBuilder()
                .include(BSTBenchmark.class.getSimpleName())
                .include(TreeMapBenchmark.class.getSimpleName())
                .include(TreeSetBenchmark.class.getSimpleName())
                .forks(1)
                .result("resultados.json")
                .resultFormat(ResultFormatType.JSON)
                .build();






        try {
            new Runner(opt).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }
}
