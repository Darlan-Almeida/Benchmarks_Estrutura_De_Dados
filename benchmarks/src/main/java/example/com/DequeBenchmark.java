package example.com;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;

/**
 * Classe de benchmark que testa o desempenho das operações da classe ArrayDeque no Java.
 *
 * Alguns métodos da classe de benchmark são semelhantes em termos de operação, mas variam de acordo com o tipo de
 * retorno ou comportamento esperado das operações. Como por exemplo **poll** e **remove**: Ambas removem um elemento, a diferença está no tratamento de exceções:
 * O método **poll** retorna `null` se o deque estiver vazio, enquanto **remove** lança uma exceção `NoSuchElementException`.

 * Essa classe utiliza o JMH (Java Microbenchmarking Harness) para medir o desempenho de várias operações de deque em diferentes tamanhos de estrutura.
 * Cada operação é medida individualmente, e os resultados são reportados em termos de throughput (operações por segundo).
 */
@BenchmarkMode(Mode.AverageTime) // Mede a taxa de operações por segundo
@OutputTimeUnit(TimeUnit.NANOSECONDS) // Unidade de tempo no resultado
@State(Scope.Thread) // Cada thread tem sua própria instância
public class DequeBenchmark {
	
	// Instância do deque que será utilizado nas operações.
	private ArrayDeque<Integer> deque;
	
	/**
     * Parâmetro configurado para variar o tamanho do deque nos testes. 
     * JMH irá testar os valores: 1000, 10000, 100000.
     */
	@Param({ "1000", "10000", "100000" }) 
	private int size;
	
	/**
     * Método de configuração do benchmark. Ele é executado antes de cada chamada de benchmark.
     * Este método inicializa o deque com números inteiros de 0 até size-1.
     * 
     * @see Setup(Level.Invocation) 
     */
	@Setup(Level.Invocation)
	public void setup() {
		deque = new ArrayDeque<>();

		for (int i = 0; i < size; i++) {
			deque.add(i);
		}
	}
	
	 /**
     * Benchmark para medir a performance da operação addFirst.
     * A operação addFirst adiciona um novo elemento no início do deque.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador (dead code elimination).
     */
	@Benchmark
	public void dequeAddFirst(Blackhole blackhole) {
		deque.addFirst(0);
	}
	
	/**
     * Benchmark para medir a performance da operação addLast.
     * A operação addLast adiciona um novo elemento no final da deque.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador (dead code elimination).
     */
	@Benchmark
	public void dequeAddLast(Blackhole blackhole) {
		deque.addLast(0);
	}
	
	/**
     * Benchmark para medir a performance da operação getFirst.
     * A operação getFirst retorna o primeiro elemento do deque, sem removê-lo.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador (dead code elimination).
     */
	@Benchmark
	public void dequeGetFirst(Blackhole blackhole) {
		int primeiro = deque.getFirst();
		blackhole.consume(primeiro);
	}
	
	/**
     * Benchmark para medir a performance da operação getLast.
     * A operação getLast retorna o último elemento do deque, sem removê-lo.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador (dead code elimination).
     */
	@Benchmark
	public void dequeGetLast(Blackhole blackhole) {
		int ultimo = deque.getLast();
		blackhole.consume(ultimo);
	}
	
	/**
     * Benchmark para medir a performance da operação removeFirst.
     * A operação removeFirst remove e retorna o primeiro elemento da deque.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador (dead code elimination).
     */
	@Benchmark
	public void dequeRemoveFirst(Blackhole blackhole) {
		int removido = deque.removeFirst();
		blackhole.consume(removido);
	}
	
	 /**
     * Benchmark para medir a performance da operação removeLast.
     * A operação removeLast remove e retorna o último elemento da deque.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador (dead code elimination).
     */
	@Benchmark
	public void dequeRemoveLast(Blackhole blackhole) {
		int removido = deque.removeLast();
		blackhole.consume(removido); 
	}
	
	/**
     * Benchmark para medir a performance da operação contains.
     * A operação contains verifica se o deque contém o número 9999999.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador (dead code elimination).
     */
	@Benchmark
	public void dequeContains(Blackhole blackhole) {
		boolean presenca = deque.contains(9999999); 
		blackhole.consume(presenca); 
	}
	
	/**
     * Benchmark para medir a performance da operação removeFirstOccurrence.
     * A operação removeFirstOccurrence remove a primeira ocorrência do número 9999999.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador (dead code elimination).
     */
	@Benchmark
	public void dequeRemoveFirstOccurrence(Blackhole blackhole) {
		boolean presenca = deque.removeFirstOccurrence(9999999); 
		blackhole.consume(presenca); 
	}
	
	/**
     * Benchmark para medir a performance da operação clear.
     * A operação clear remove todos os elementos do deque.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador (dead code elimination).
     */
	@Benchmark
	public void dequeClear(Blackhole blackhole) {
		deque.clear(); 
	}
	
	 /**
     * Benchmark para medir a performance da operação clone.
     * A operação clone cria uma cópia (clone) do deque.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador (dead code elimination).
     */
	@Benchmark
	public void dequeClone(Blackhole blackhole) {
		ArrayDeque<Integer> clone = new ArrayDeque<>();
		clone = deque.clone(); 
		blackhole.consume(clone);
	}
	
	/**
     * Benchmark para medir a performance da operação isEmpty.
     * A operação isEmpty verifica se o deque está vazio.
     * 
     * @param blackhole Utilizado para evitar otimizações do compilador (dead code elimination).
     */
	@Benchmark
	public void dequeIsEmpty(Blackhole blackhole) {
		boolean vazia = deque.isEmpty();  
		blackhole.consume(vazia); 
	}
	
}
