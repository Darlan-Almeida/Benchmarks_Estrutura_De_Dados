package benchmarks.src.main.java.example.com;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Classe principal que executa o benchmark definido na classe StackBenchmark.
 *
 * Essa classe utiliza o JMH (Java Microbenchmarking Harness) para configurar e rodar os testes de desempenho
 * realizados pela classe StackBenchmark e gerar resultados no formato JSON.
 */
public class MainStack {
	
	/**
     * Método principal que configura e executa o benchmark.
     *
     * Ele cria uma configuração para o JMH, especificando a classe de benchmark a ser executada, o formato
     * do resultado, e outras opções como o número de forks (execuções independentes).
     *
     * @param args Argumentos da linha de comando (não utilizados neste exemplo).
     * @throws RunnerException Se ocorrer um erro ao executar o benchmark.
     */
	public static void main(String[] args) throws RunnerException {
		// Cria as opções de configuração para o JMH.
		Options opt = new OptionsBuilder().include(StackBenchmark.class.getSimpleName()) // Define que o benchmark a ser executado é o StackBenchmark.
				.result("StackBenchmark.json") // Define que o resultado do benchmark será salvo no arquivo StackBenchmark.json.
				.resultFormat(ResultFormatType.JSON) // Define que o formato do resultado será JSON.
				.forks(1) // Define o número de forks (execuções independentes) do benchmark. Aqui, está configurado para 1 fork
				.build();
		
		 // Executa o benchmark utilizando as opções configuradas.
		new Runner(opt).run();
	}
}
