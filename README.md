# Benchmarks - Estrutura de Dados
# Overview
Este projeto visa realizar benchmarks detalhados de diversas estruturas de dados em Java, utilizando a ferramenta Java MicroBenchmarking Harness (JMH). 

Para isso, será implementado um conjunto de benchmarks, através da ferramenta de código aberto, para avaliar o desempenho das estruturas em operações indispensáveis em programação, como acesso, inserção, remoção, pesquisa e ordenação. A motivação está em entender os trade-offs associados a diferentes escolhas de estrutura e algoritmos, especialmente em situações pertinentes, como de carga elevada. A relevância do trabalho está em sua aplicação prática e paradidática, uma vez que os resultados obtidos no benchmark dos custos sobre as operações possibilita a interpretação dos fenômenos alinhada as análises assintóticas das implementações. Portanto, ao obter dados concretos de diferentes estruturas de dados e casos particulares, a tomada de decisão fica mais clara, à medida que se pode comparar distintas possibilidades de implementação de estruturas de dados, de acordo com a problemática. 
# Funcionalidades
Utilizando o projeto open source JMH, desenvolveremos códigos para benchmarks, executaremos os experimentos, coletaremos os resultados e realizaremos análises detalhadas. As análises incluirão a interpretação dos resultados com base em complexidades assintóticas para compreender os padrões observados e validar hipóteses de desempenho.

Para o controle de carga, aumentaremos gradativamente o número de elementos armazenados nas estruturas e a quantidade de operações realizadas. Com isso, compararemos o impacto no desempenho à medida que os tamanhos das estruturas aumentam e o desempenho de diferentes algoritmos para resolução de uma mesma problemática.

# Como executar os benchmarks
1. Clone esse repositório
2. Caso não possua o Maven instalado na sua máquina, certifique-se de instalar seguindo as instruções do site oficial: [Apache Maven](https://maven.apache.org/download.cgi)
3. Se utilizando alguma IDE, certifique-se que ela possui acesso ao catálogo central, e procure o arquetipo `org.openjdk.jmh:jmh-$Java-benchmark-archetype`
4. Compile o projeto digitando `mvn clean install` no seu terminal
5. Execute os benchmarks


# Máquina em que o experimento foi executado


## Análise das estruturas

### Arvóres


#### BST

- **testInsert**: A inserção em uma BST balanceada tem complexidade O(log n), mas pode chegar a O(n) em casos desbalanceados.
- **testSearch**: Em média, O(log n), porém O(n) no pior caso.
- **testRemove**: Semelhante à busca, depende do balanceamento.
- **testMin/testMax**: O(n) no pior caso (árvore degenerada), mas O(log n) em média.
- **testPredecessor/testSuccessor**: O(log n), pois requer navegação na árvore.
- **testInOrderTraversal/testLevelOrderTraversal**: O(n), pois percorrem toda a árvore.

#### PriorityDeque

- **testInsert**: O(log n), pois mantém a ordem de prioridade.
- **testRemove**: O(log n), pois remove o elemento de maior prioridade.
- **testPeek**: O(1), já que retorna o elemento no topo sem removê-lo.
- **testContains**: O(n), pois pode exigir varredura completa.

#### TreeSet

- **testInsert**: O(log n), pois usa uma árvore balanceada.
- **testContains**: O(log n), pois a busca ocorre na árvore.
- **testRemove**: O(log n), pela mesma razão.
- **testFloor/testCeiling**: O(log n), pois são buscas específicas na árvore.
- **testMin/testMax**: O(1), pois a árvore mantém referências diretas.
- **testDescendingIteration**: O(n), pois gera uma cópia reversa da árvore.

### TreeMap

- **testInsert**: O(log n), pois mantém a ordenação das chaves.
- **testContains**: O(log n), pois é necessário percorrer a árvore.
- **testRemove**: O(log n), pois depende da reorganização da árvore.
- **testMin/testMax**: O(1), pois a estrutura mantém referências.
- **testKeySetIteration**: O(n), pois percorre todas as chaves ordenadamente.

### Conclusão
- **BST** é eficiente quando balanceada, mas pode ter desempenho ruim caso contrário.
- **PriorityDeque** é ótima para operações de prioridade, mas não é eficiente para buscas arbitrárias.
- **TreeSet e TreeMap** oferecem ordenação automática, com desempenho logarítmico para operações básicas.

A escolha da estrutura depende do caso de uso: se precisar de busca rápida, use HashMap; para ordenação, prefira TreeSet/TreeMap; se precisar de prioridade, use PriorityDeque.


# Dependências
[JMH](https://github.com/openjdk/jmh)
