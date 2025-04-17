package org.example.decisionTree;
import java.util.Scanner;

/**
 * Classe principal que executa uma árvore de decisão interativa para
 * recomendar a melhor estrutura de dados com base no custo de operações.
 *
 * O usuário responde perguntas sobre o desempenho desejado para operações
 * como inserção, remoção e busca, e recebe uma recomendação no final.
 */
public class DecisionTree {

    /** Menu de opções padrão para cada pergunta sobre complexidade. */
    private static final String menu = buildMenu();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DecisionNode current = buildDecisionTree();

        while (!current.isLeaf()) {
            System.out.println(current.question);
            System.out.print("Escolha: \n");
            System.out.println(menu);
            String input = scanner.nextLine().toLowerCase();

            if (current.options.containsKey(input)) {
                current = current.options.get(input);
            } else {
                System.out.println("Opção inválida. Tente novamente.\n");
            }
        }

        System.out.println("Recomendação: " + current.recommendation);
        scanner.close();
    }

    /**
     * Constrói a árvore de decisão com base em perguntas relacionadas
     * ao custo de inserção, remoção e busca.
     *
     * @return O nó raiz da árvore de decisão.
     */
    private static DecisionNode buildDecisionTree() {
        // Nós folha com recomendações
        DecisionNode arrayList = new DecisionNode(null, "Use ArrayList (ótima para acesso rápido por índice)");
        DecisionNode linkedList = new DecisionNode(null, "Use LinkedList (acesso sequencial, inserção/remoção rápidas nos extremos)");
        DecisionNode hashMap = new DecisionNode(null, "Use Tabela Hash (HashMap) (buscas rápidas com chave)");
        DecisionNode treeMap = new DecisionNode(null, "Use Árvore Binária de Busca (TreeMap ou BST) (buscas ordenadas com O(log n))");
        DecisionNode heap = new DecisionNode(null, "Use Heap (PriorityQueue) (ótima para prioridades, O(log n) para inserção/remoção)");

        // Subárvore para decisão de busca
        DecisionNode buscaON = new DecisionNode(null, "Use LinkedList");
        DecisionNode buscaO1 = new DecisionNode(null, "Use Tabela Hash (HashMap)");
        DecisionNode buscaOlogn = new DecisionNode(null, "Use Árvore Binária de Busca (TreeMap ou BST)");

        DecisionNode searchCost = new DecisionNode("Qual o custo pretendido para busca?");
        searchCost.addOption("a", buscaO1);      // O(1)
        searchCost.addOption("b", buscaON);      // O(n)
        searchCost.addOption("c", buscaOlogn);   // O(log n)

        // Subárvore para decisão de remoção
        DecisionNode removalCost = new DecisionNode("Qual o custo pretendido para remoção?");
        removalCost.addOption("a", searchCost);  // O(1)
        removalCost.addOption("b", arrayList);   // O(n)
        removalCost.addOption("c", heap);        // O(log n)

        // Subárvore para decisão de inserção arbitrária
        DecisionNode insertionCost = new DecisionNode("Qual o custo pretendido para inserção em uma posição arbitrária?");
        insertionCost.addOption("a", removalCost); // O(1)
        insertionCost.addOption("b", arrayList);   // O(n)
        insertionCost.addOption("c", treeMap);     // O(log n)

        // Nó raiz: decisão de inserção nos extremos
        DecisionNode insertionAtEndCost = new DecisionNode("Qual o custo pretendido para inserção nos extremos (início e fim)?");
        insertionAtEndCost.addOption("a", linkedList);    // O(1)
        insertionAtEndCost.addOption("b", insertionCost); // O(n)
        insertionAtEndCost.addOption("c", treeMap);       // O(log n)

        return insertionAtEndCost;
    }

    /**
     * Constrói o menu padrão de opções de custos assintóticos.
     *
     * @return String formatada com opções (a), (b) e (c).
     */
    private static String buildMenu() {
        return """
                a: O(1)
                b: O(n)
                c: O(log n)
                """;
    }
}
