# Resultados do Benchmark

Os resultados abaixo comparam o desempenho de operações em `ArrayList` e `LinkedList` em diferentes tamanhos de lista.

| Operação               | Tamanho   | ArrayList (ops/ms)   | LinkedList (ops/ms)   |
|------------------------|-----------|----------------------|-----------------------|
| **Add**               | 1.000     | 16,986 ± 0,051       | 4.048,940 ± 1.776,312 |
|                       | 10.000    | 16,055 ± 0,336       | 4.955,478 ± 3.880,723 |
|                       | 100.000   | 9,480 ± 2,079        | 5.543,749 ± 3.986,703 |
|                       | 1.000.000 | 1,331 ± 0,194        | 5.714,670 ± 3.452,248 |
| **Add First**         | 1.000     | 16,985 ± 0,162       | 4.621,922 ± 3.468,837 |
|                       | 10.000    | 16,126 ± 0,103       | 5.569,887 ± 4.316,566 |
|                       | 100.000   | 9,676 ± 0,573        | 5.443,272 ± 1.937,573 |
|                       | 1.000.000 | 1,357 ± 0,013        | 4.859,647 ± 3.153,347 |
| **Contains**          | 1.000     | 1.042,629 ± 6,867    | 346,878 ± 15,443      |
|                       | 10.000    | 78,031 ± 0,768       | 30,911 ± 1,170        |
|                       | 100.000   | 3,127 ± 0,656        | 2,095 ± 0,027         |
|                       | 1.000.000 | 0,521 ± 0,237        | 0,246 ± 0,046         |
| **Get**               | 1.000     | 407.510,962 ± 10.921,375 | 1.436,647 ± 139,509  |
|                       | 10.000    | 409.082,767 ± 2.139,760 | 93,234 ± 6,717       |
|                       | 100.000   | 409.019,401 ± 1.705,924 | 4,685 ± 1,347        |
|                       | 1.000.000 | 408.321,836 ± 2.062,787 | 0,446 ± 0,199        |

### Conclusões
- **`ArrayList`**:
  - Tem melhor desempenho geral para operações de leitura (`get`).
  - Perde eficiência em operações que requerem redimensionamento, como `add`, especialmente para tamanhos maiores.

- **`LinkedList`**:
  - Consistente em operações de inserção, mas apresenta pior desempenho em buscas (`contains` e `get`).
