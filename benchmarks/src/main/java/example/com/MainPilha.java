package benchmarks.src.main.java.example.com;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class MainPilha {
	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(PilhaBenchmark.class.getSimpleName()) // Nome da classe de benchmark
				.result("Benchmark.json") // Retorna o resultado do benchmark em um arquivo JSON
				.resultFormat(ResultFormatType.JSON).forks(1) // Número de forks (execuções independentes)
				.build();

		new Runner(opt).run();
	}
}
