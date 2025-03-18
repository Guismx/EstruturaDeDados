# Alocação Estática de Memória

## Introdução

A alocação estática de memória é um método onde o espaço necessário para armazenar variáveis e estruturas de dados é definido **antes da execução do programa**. Isso significa que a quantidade de memória utilizada pelo programa é fixa e não pode ser alterada dinamicamente durante a execução.

Este tipo de alocação é amplamente utilizado quando se tem um conhecimento prévio sobre o número de elementos que serão manipulados, garantindo eficiência e previsibilidade no uso da memória.

---

## Como Funciona a Alocação Estática?

Na alocação estática, os espaços de memória são reservados **durante a compilação** e permanecem ocupados durante toda a execução do programa. Isso significa que:

- O programador define **antecipadamente** a quantidade de memória necessária.
- O compilador reserva esse espaço no segmento de **dados** do programa.
- A memória não pode ser aumentada ou reduzida dinamicamente.

### Exemplo de Alocação Estática em Java:

```java
public class AlocacaoEstatica {
    public static void main(String[] args) {
        int[] numeros = new int[5]; // Array de tamanho fixo (5 elementos)
        
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;

        System.out.println("Elementos do array:");
        for (int num : numeros) {
            System.out.println(num);
        }
    }
}
```

Neste exemplo:
- Criamos um array `numeros` de tamanho **fixo** (5 posições).
- Cada posição é preenchida com um valor pré-definido.
- O programa não pode adicionar mais elementos além do tamanho especificado.

---

## Vantagens da Alocação Estática

✅ **Desempenho mais rápido**: Como a memória é alocada de uma vez, não há sobrecarga com realocações.
✅ **Menos complexidade**: O código é mais simples e direto, pois não requer gerenciamento dinâmico da memória.
✅ **Menos riscos de vazamento de memória**: Como a memória é gerenciada pelo próprio sistema, não há necessidade de liberação manual.

---

## Desvantagens da Alocação Estática

❌ **Uso ineficiente da memória**: Se for alocada mais memória do que o necessário, haverá desperdício. Se for alocada menos, o programa poderá não funcionar corretamente.
❌ **Falta de flexibilidade**: Não é possível redimensionar a estrutura de dados durante a execução.
❌ **Limitações em grandes aplicações**: Em programas que lidam com quantidades variáveis de dados, a alocação dinâmica pode ser mais vantajosa.

---

## O que contém nesta pasta?

📂 **Exemplo de Alocação Estática:**
- Implementação de um array fixo para armazenar valores.
- Demonstração de como os dados são armazenados e acessados de forma sequencial.

A compreensão da alocação estática é fundamental para otimizar o uso da memória em cenários onde a quantidade de dados é previsível. Para aplicações que exigem maior flexibilidade, a alocação dinâmica pode ser uma melhor escolha (veja a pasta `Alocação-Dinâmica`).

