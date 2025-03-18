# Conceitos Fundamentais: Variáveis, Tipos de Dados e Alocação de Memória

## Introdução

Todo programa de computador manipula dados de alguma forma, seja para armazenar informações do usuário, realizar cálculos ou tomar decisões com base em determinadas condições. Para que isso seja possível, é essencial entender como os dados são armazenados e gerenciados na memória do sistema. 

Neste diretório, exploramos os conceitos fundamentais de variáveis, tipos de dados e alocação de memória. Além disso, discutimos a diferença entre alocação estática e dinâmica, mostrando como cada abordagem afeta o desempenho e a flexibilidade dos programas. 

## Variáveis e Tipos de Dados

### O que são variáveis?

Uma variável é um espaço reservado na memória do computador que armazena um valor que pode ser modificado durante a execução do programa. Cada variável possui um **nome**, um **tipo de dado** e um **valor armazenado**.

Por exemplo, em Java, podemos declarar uma variável da seguinte forma:

```java
int idade = 25;  // Variável do tipo inteiro armazenando o valor 25
```

### Tipos de Dados

Os tipos de dados definem a natureza dos valores que uma variável pode armazenar. Em Java, os principais tipos de dados primitivos são:

- **Inteiros** (`byte`, `short`, `int`, `long`) → Armazenam números inteiros.
- **Ponto Flutuante** (`float`, `double`) → Armazenam números decimais.
- **Caractere** (`char`) → Armazena um único caractere.
- **Booleano** (`boolean`) → Representa valores `true` ou `false`.

Além dos tipos primitivos, Java também oferece **tipos de referência**, como classes e arrays, que permitem armazenar coleções de dados e objetos mais complexos.

### Relação entre Tipos de Dados e Alocação de Memória

Cada tipo de dado ocupa um espaço específico na memória. Por exemplo:

| Tipo de Dado | Tamanho Ocupado |
|-------------|----------------|
| `byte`      | 1 byte         |
| `short`     | 2 bytes        |
| `int`       | 4 bytes        |
| `long`      | 8 bytes        |
| `float`     | 4 bytes        |
| `double`    | 8 bytes        |
| `char`      | 2 bytes        |
| `boolean`   | 1 byte         |

Essa relação é importante porque a escolha de um tipo de dado impacta diretamente o consumo de memória e a eficiência do programa.

---

## Alocação de Memória

A alocação de memória se refere à maneira como os dados são armazenados e gerenciados durante a execução de um programa. Existem dois tipos principais:

### 1. Alocação Estática

Na alocação estática, o espaço de memória necessário para uma variável ou estrutura de dados é determinado **antes** da execução do programa e não pode ser alterado posteriormente. Isso significa que a quantidade de memória utilizada é fixa e definida pelo programador.

## Estrutura do Diretório

Neste diretório, há dois subdiretórios com exemplos práticos para ilustrar a diferença entre os tipos de alocação:

### 📂 `Alocação-Estática`
- Contém exemplos de como a alocação de memória é feita de maneira fixa, com variáveis de tamanho pré-definido.
- **Exemplo**: Implementação de um array de tamanho fixo para armazenar dados.

### 📂 `Alocação-Dinâmica`
- Contém exemplos de alocação dinâmica, mostrando como podemos gerenciar a memória de forma flexível.
- **Exemplo**: Uso de `ArrayList` para manipulação dinâmica de elementos.

Esses exemplos ajudarão a visualizar as diferenças entre as abordagens e como elas afetam o desempenho e a eficiência de um programa.

---

## Conclusão

Entender os conceitos de variáveis, tipos de dados e alocação de memória é essencial para escrever programas eficientes e bem estruturados. A escolha entre alocação estática e dinâmica depende do problema a ser resolvido e dos requisitos do sistema. 

Nos subdiretórios deste repositório, você encontrará exemplos práticos que ilustram essas diferenças na prática. Analise os códigos e compare os impactos no desempenho para aprofundar seu conhecimento sobre o assunto.

📌 Próximos passos: Explore os exemplos e experimente modificá-los para ver como diferentes abordagens afetam a execução do programa!