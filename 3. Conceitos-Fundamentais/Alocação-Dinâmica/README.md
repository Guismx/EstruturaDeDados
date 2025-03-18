# Alocação Dinâmica de Memória

## Introdução

A alocação dinâmica de memória é uma abordagem que permite que um programa **reserve, utilize e libere memória em tempo de execução**, de acordo com a necessidade. Diferente da alocação estática, onde a quantidade de memória é definida antes da execução do programa, a alocação dinâmica oferece **maior flexibilidade e eficiência**, especialmente em cenários onde o volume de dados pode variar.

Este tipo de alocação é amplamente utilizado em situações onde o número de elementos a serem manipulados não pode ser previsto com antecedência, permitindo que os recursos sejam utilizados de forma mais eficiente.

---

## Como Funciona a Alocação Dinâmica?

Na alocação dinâmica, a memória é gerenciada **durante a execução** do programa. Isso significa que:

- A memória é alocada **sob demanda**, conforme o programa precisa.
- Quando os dados não são mais necessários, a memória pode ser **liberada** para evitar desperdícios.
- O programador tem maior **controle sobre o uso da memória**, podendo expandi-la ou reduzi-la conforme necessário.

Em Java, a alocação dinâmica é feita principalmente através de estruturas como **ArrayList**, **LinkedList** e outras classes da biblioteca `java.util`.

### Exemplo de Alocação Dinâmica em Java:

```java
import java.util.ArrayList;

public class AlocacaoDinamica {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(); // Lista dinâmica
        
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        
        System.out.println("Elementos da lista dinâmica:");
        for (int num : numeros) {
            System.out.println(num);
        }
        
        numeros.remove(1); // Removendo o segundo elemento (índice 1)
        
        System.out.println("Lista após remoção de um elemento:");
        for (int num : numeros) {
            System.out.println(num);
        }
    }
}
```

Neste exemplo:
- Criamos uma **lista dinâmica** `numeros` usando `ArrayList`.
- Adicionamos três elementos sem precisar definir um tamanho fixo.
- Removemos um elemento, mostrando a flexibilidade da alocação dinâmica.

---

## Vantagens da Alocação Dinâmica

✅ **Uso eficiente da memória**: Apenas a memória necessária é alocada, evitando desperdício.
✅ **Flexibilidade**: Permite redimensionamento durante a execução do programa.
✅ **Adequado para grandes aplicações**: Útil em sistemas que lidam com volumes variáveis de dados.

---

## Desvantagens da Alocação Dinâmica

❌ **Maior complexidade**: O gerenciamento da memória pode ser mais complexo e exigir boas práticas de programação.
❌ **Desempenho levemente inferior**: Em alguns casos, operações dinâmicas podem ser mais lentas do que acessos diretos a memória estática.
❌ **Possibilidade de vazamento de memória**: Se a memória não for liberada corretamente, pode haver desperdício de recursos.

---

## O que contém nesta pasta?

📂 **Exemplo de Alocação Dinâmica:**
- Implementação de uma **lista dinâmica** usando `ArrayList`.
- Demonstração de como adicionar, remover e manipular elementos em tempo de execução.

A alocação dinâmica é essencial para aplicações que precisam lidar com quantidades variáveis de dados e otimizar o uso da memória. Para cenários onde a quantidade de memória necessária é previsível, a **alocação estática** pode ser uma opção mais simples e eficiente (veja a pasta `Alocação-Estática`).

