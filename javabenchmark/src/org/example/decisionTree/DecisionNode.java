package org.example.decisionTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa um nó de decisão em uma árvore de decisão.
 * Cada nó pode ser uma pergunta com múltiplas opções de resposta,
 * levando a outros nós, ou uma recomendação final (nó folha).
 */
public class DecisionNode {

    /** A pergunta associada ao nó. */
    String question;

    /** Map de opções de resposta e os nós de decisão sucessores. */
    Map<String, DecisionNode> options;

    /** Recomendação final, quando esse nó for um nó folha. */
    String recommendation;

    /**
     * Construtor para um nó interno com uma pergunta.
     *
     * @param question A pergunta a ser feita neste nó.
     */
    DecisionNode(String question) {
        this.question = question;
        this.options = new HashMap<>();
    }

    /**
     * Construtor para um nó folha que contém uma recomendação final.
     *
     * @param question A pergunta associada a esse nó.
     * @param recommendation A recomendação final.
     */
    DecisionNode(String question, String recommendation) {
        this.question = question;
        this.recommendation = recommendation;
        this.options = new HashMap<>();
    }

    /**
     * Verifica se o nó é uma folha, que ocorre quando ele possui recomendação.
     *
     * @return true se for folha, false caso contrário.
     */
    boolean isLeaf() {
        return recommendation != null;
    }

    /**
     * Adiciona uma opção de resposta a esse nó, associando-a a outro nó de decisão.
     *
     * @param answer A resposta para a pergunta.
     * @param next O próximo nó de decisão associado a essa resposta.
     */
    void addOption(String answer, DecisionNode next) {
        options.put(answer.toLowerCase(), next);
    }
}