package benchmarks.src.main.java.example.com;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 * Classe de benchmark que testa a performance das operações mais comuns, que seguem o contrato de LIFO, na classe Stack
 * do Java utilizando o JMH (Java Microbenchmarking Harness).
 *
 * O objetivo deste benchmark é medir o throughput (taxa de operações por segundo) das operações
 * de pilha, como push, pop e peek em diferentes tamanhos de pilha.
 */
@BenchmarkMode(Mode.Throughput) // Mede a taxa de operações por segundo
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Unidade de tempo no resultado
@State(Scope.Thread) // Cada thread tem sua própria instância
public class StackBenchmark {
	
	// Instância da pilha que será utilizada nas operações.
	private Stack<Integer> stack;
	
	/**
     * Parâmetro configurado para variar o tamanho da pilha nos testes. 
     * JMH irá testar os valores: 1000, 10000, 100000.
     */
	@Param({ "1000", "10000", "100000" })
	private int size;
	
	/**
     * Método de configuração do benchmark. Ele é executado antes de cada iteração do benchmark.
     * Este método inicializa a pilha com números inteiros de 0 até size-1.
     * 
     * @see Setup(Level.Iteration) 
     */
	@Setup(Level.Iteration)
	public void setup() {
		stack = new Stack<>();

		for (int i = 0; i < size; i++) {
			stack.push(i);
		}
	}
	
	 /**
     * Benchmark para medir a performance da operação push.
     * A operação push adiciona um novo elemento ao topo da pilha.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador que possam eliminar
     *                  o código não utilizado (dead code elimination).
     */
	@Benchmark
	public void stackPush(Blackhole blackhole) {
		stack.push(0); 
		blackhole.consume(stack.peek()); 
	}
	
	/**
     * Benchmark para medir a performance da operação pop.
     * A operação pop remove o elemento do topo da pilha e o retorna.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador que possam eliminar
     *                  o código não utilizado (dead code elimination).
     */
	@Benchmark
	public void stackPop(Blackhole blackhole) {
		int removido = stack.pop(); 
		blackhole.consume(removido); 
	}
	
	/**
     * Benchmark para medir a performance da operação peek.
     * A operação peek retorna o elemento no topo da pilha sem removê-lo.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador que possam eliminar
     *                  o código não utilizado (dead code elimination).
     */
	@Benchmark
	public void stackPeek(Blackhole blackhole) {
		int ultimoElem = stack.peek();
		blackhole.consume(ultimoElem);
	}
	
	/**
     * Benchmark para medir a performance da operação isEmpty.
     * A operação isEmpty retorna true se a pilha estiver vazia, false caso contário.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador que possam eliminar
     *                  o código não utilizado (dead code elimination).
     */
	@Benchmark
	public void stackIsEmpty(Blackhole blackhole) {
		boolean vazia = stack.isEmpty();
		blackhole.consume(vazia);
	}
	
	

}