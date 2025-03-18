# Introdução às Estruturas de Dados

## O que são Estruturas de Dados e sua Importância na Ciência da Computação

Em computação, normalmente utilizamos os dados de forma conjunta. A forma como estes dados serão agregados e organizados depende muito de como serão utilizados e processados, levando-se em consideração, por exemplo, a eficiência para buscas, o volume dos dados trabalhados, a complexidade da implementação e a forma como os dados se relacionam. Estas diversas formas de organização são as chamadas estruturas de dados.

As estruturas de dados são essenciais para:
- Melhorar a eficiência de algoritmos;
- Reduzir o uso de memória e processamento;
- Facilitar a organização e recuperação de dados;
- Resolver problemas computacionais de maneira estruturada.

---

## Exemplos de Problemas do Mundo Real Resolvidos com Estruturas de Dados

As estruturas de dados são fundamentais para resolver uma grande variedade de problemas no mundo real, pois ajudam a organizar, armazenar e acessar dados de forma eficiente. A escolha da estrutura de dados adequada pode influenciar diretamente o desempenho de uma aplicação. Abaixo, fornecemos dois exemplos práticos:

### 1. **Gestão de Inventário**

**Objetivo:** Gerenciar o estoque de produtos de uma loja, onde seja possível:
- Adicionar produtos ao estoque;
- Atualizar a quantidade disponível de um produto;
- Remover um produto quando ele for vendido;
- Verificar a quantidade disponível de cada produto rapidamente.

**Estrutura de Dados Utilizada:**
- **Dicionário (Map ou HashMap em Java)**
- O uso de uma estrutura de mapeamento permite armazenar pares chave-valor, onde o nome do produto é a chave e a quantidade em estoque é o valor associado. 

#### Exemplo de Implementação em Java:

```java
import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private static Map<String, Integer> estoque = new HashMap<>();

    public static void adicionarProduto(String produto, int quantidade) {
        estoque.put(produto, estoque.getOrDefault(produto, 0) + quantidade);
        System.out.println(quantidade + " unidades de " + produto + " adicionadas ao estoque.");
    }

    public static void venderProduto(String produto, int quantidade) {
        if (estoque.containsKey(produto) && estoque.get(produto) >= quantidade) {
            estoque.put(produto, estoque.get(produto) - quantidade);
            System.out.println(quantidade + " unidades de " + produto + " vendidas.");
        } else {
            System.out.println("Não há quantidade suficiente de " + produto + " no estoque.");
        }
    }

    public static void exibirEstoque() {
        System.out.println("Estoque atual:");
        for (Map.Entry<String, Integer> entry : estoque.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " unidades");
        }
    }

    public static void main(String[] args) {
        adicionarProduto("ProdutoA", 20);
        venderProduto("ProdutoB", 10);
        exibirEstoque();
    }
}
```

**Saída Esperada:**
```
20 unidades de ProdutoA adicionadas ao estoque.
Não há quantidade suficiente de ProdutoB no estoque.
Estoque atual:
ProdutoA: 20 unidades
```

---

### 2. **Fila de Atendimento**

**Objetivo:** Gerenciar uma fila de atendimento de clientes em um sistema de atendimento (como em um banco ou uma loja), onde seja possível:
- Adicionar um cliente à fila quando ele chega;
- Atender o cliente da frente da fila;
- Garantir que os clientes sejam atendidos na ordem de chegada (FIFO: First In, First Out).

**Estrutura de Dados Utilizada:**
- **Fila (Queue em Java)**
- A fila é ideal para esse problema porque segue o princípio de FIFO (First In, First Out), ou seja, o primeiro cliente a chegar será o primeiro a ser atendido.

#### Exemplo de Implementação em Java:

```java
import java.util.LinkedList;
import java.util.Queue;

public class FilaAtendimento {
    private static Queue<String> fila = new LinkedList<>();

    public static void adicionarCliente(String cliente) {
        fila.add(cliente);
        System.out.println("Cliente " + cliente + " entrou na fila.");
    }

    public static void atenderCliente() {
        if (!fila.isEmpty()) {
            String clienteAtendido = fila.poll();
            System.out.println("Atendendo o cliente " + clienteAtendido + ".");
        } else {
            System.out.println("Não há clientes na fila para atendimento.");
        }
    }

    public static void exibirFila() {
        System.out.println("Fila de atendimento atual: " + fila);
    }

    public static void main(String[] args) {
        adicionarCliente("Cliente1");
        adicionarCliente("Cliente2");
        atenderCliente();
        exibirFila();
        atenderCliente();
        exibirFila();
    }
}
```

**Saída Esperada:**
```
Cliente Cliente1 entrou na fila.
Cliente Cliente2 entrou na fila.
Atendendo o cliente Cliente1.
Fila de atendimento atual: [Cliente2]
Atendendo o cliente Cliente2.
Fila de atendimento atual: []
```

---

Este documento forneceu uma visão introdutória sobre estruturas de dados, destacando sua importância na computação e apresentando exemplos práticos de aplicação no mundo real. Nos próximos módulos, exploraremos outras estruturas e seu impacto no desempenho dos programas.

---