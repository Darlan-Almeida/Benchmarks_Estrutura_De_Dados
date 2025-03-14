# Resultados do Benchmark

Os resultados abaixo comparam o desempenho de operações em `HashMap` e `HashSet` em diferentes tamanhos de coleção.

| Operação                  | Tamanho   | Score (ops/ms)      | Erro (ops/ms)      |
|---------------------------|-----------|---------------------|--------------------|
| **HashMap Get**           | 1.000     | 169.685,123        | 35.547,623        |
|                           | 10.000    | 177.242,348        | 1.930,033         |
|                           | 100.000   | 170.417,466        | 35.490,715        |
| **HashMap Iteration**     | 1.000     | 470,319            | 13,860            |
|                           | 10.000    | 14,163             | 2,152             |
|                           | 100.000   | 0,482              | 0,553             |
| **HashMap Put**           | 1.000     | 79.868,638         | 91.275,846        |
|                           | 10.000    | 71.574,772        | 631,224           |
|                           | 100.000   | 75.571,983        | 23.585,289        |
| **HashMap Remove**        | 1.000     | 161.717,309       | 91.308,499        |
|                           | 10.000    | 194.616,052       | 110.294,690       |
|                           | 100.000   | 171.600,479       | 192.665,493       |
| **HashSet Add**           | 1.000     | 95.360,229        | 89.890,825        |
|                           | 10.000    | 103.771,577       | 49.646,538        |
|                           | 100.000   | 77.588,397        | 18.415,378        |
| **HashSet Contains**      | 1.000     | 148.682,344       | 37.237,382        |
|                           | 10.000    | 172.107,823       | 32.852,835        |
|                           | 100.000   | 165.406,918       | 1.073,147         |
| **HashSet Iteration**     | 1.000     | 208,602           | 8,463             |
|                           | 10.000    | 8,255             | 0,153             |
|                           | 100.000   | 0,528             | 1,198             |
| **HashSet Remove**        | 1.000     | 141.640,446       | 27.335,788        |
|                           | 10.000    | 129.016,136       | 43.937,519        |
|                           | 100.000   | 143.846,264       | 17.267,607        |

### Conclusões
- **`HashMap`**:
    - Tem excelente desempenho para operações de `get`, mesmo com tamanhos maiores.
    - Iteração em `HashMap` se torna significativamente lenta para coleções maiores.
    - `put` e `remove` apresentam boa performance, mas variam com o tamanho da coleção.

- **`HashSet`**:
    - Operação `contains` é bastante eficiente.
    - Iteração sofre grande impacto à medida que o tamanho aumenta.
    - `remove` tem um desempenho estável, mesmo para conjuntos maiores.

