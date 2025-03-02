package benchmarks.src.main.java.example.com;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput) // Mede a taxa de operações por segundo
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Unidade de tempo no resultado
@State(Scope.Thread) // Cada thread tem sua própria instância
public class PilhaBenchmark {

	private Stack<Integer> stack;
	private Deque<Integer> deque;

	@Param({ "1000", "10000", "100000" }) // Tamanhos diferentes para teste
	private int size;

	@Setup(Level.Iteration) // Executado antes de cada iteração de benchmark, para cada tamanho de estrutura
	public void setup() {
		stack = new Stack<>();
		deque = new ArrayDeque<>();

		// Popula as listas
		for (int i = 0; i < size; i++) {
			stack.push(i);
			deque.add(i);
		}
	}

	@Benchmark
	public void stackPush(Blackhole blackhole) {
		stack.push(0); // Adiciona mais um elemento no topo
		blackhole.consume(stack.peek()); // Evita dead code elimination de jmh
	}

	@Benchmark
	public void dequeAddFirst(Blackhole blackhole) {
		deque.addFirst(0); // Adiciona mais um elemento na pilha representada por deque
		blackhole.consume(deque.peekFirst()); // Evita dead code elimination de jmh
	}

	@Benchmark
	public void stackPop(Blackhole blackhole) {
		int removido = stack.pop(); // Remove o elemento do topo
		blackhole.consume(removido); // Evita dead code elimination de jmh
	}

	@Benchmark
	public void dequeRemoveFirst(Blackhole blackhole) {
		int removido = deque.removeFirst(); // Remove o elemento do topo da pilha representada por deque
		blackhole.consume(removido); // Evita dead code elimination de jmh
	}

	@Benchmark
	public void stackContains(Blackhole blackhole) {
		boolean presenca = stack.contains(9999999); // Procura o número 9999999 na pilha
		blackhole.consume(presenca); // Evita dead code elimination de jmh
	}

	@Benchmark
	public void dequeContains(Blackhole blackhole) {
		boolean presenca = deque.contains(9999999); // Procura o número 9999999 na pilha
		blackhole.consume(presenca); // Evita dead code elimination de jmh
	}

	@Benchmark
	public void stackBuscarElemento(Blackhole blackhole) {
		int indice = stack.search(10001); // Procura o ínidce número 10001 na pilha
		blackhole.consume(indice); // Evita dead code elimination de jmh
	}

	@Benchmark
	public void dequeBuscarElemento(Blackhole blackhole) {
		int index = -1;
		int currentIndex = 0;

		for (Integer element : stack) { // Só para teste, implementar com as políticas de pilha.
			if (element == 10001) {
				index = currentIndex;
				break;
			}
			currentIndex++;
		}
		blackhole.consume(index); // Evita dead code elimination de jmh
	}

}