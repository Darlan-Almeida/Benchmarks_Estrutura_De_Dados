package benchmarks.src.main.java.example.com;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class MainList {
	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(ListBenchmark.class.getSimpleName()) // Nome da classe de benchmark
				.forks(1) // Número de forks (execuções independentes)
				.build();

		new Runner(opt).run();
	}
}
