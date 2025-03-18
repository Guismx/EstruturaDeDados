
# Estrutura de Dados: Pilhas (Stacks)

## Introdução

A **pilha** (*stack*) é uma estrutura de dados linear que segue o princípio **LIFO** (*Last In, First Out*), ou seja, o último elemento a entrar é o primeiro a sair. Este comportamento é semelhante a uma pilha de pratos, onde o último prato colocado é o primeiro a ser retirado. 

As pilhas são amplamente utilizadas em situações como:

- Algoritmos de backtracking (exemplo: resolução de labirintos)
- Armazenamento temporário de dados durante a execução de programas (como em chamadas de função)
- Verificação de expressões matemáticas ou sintáticas (como balanceamento de parênteses)
- Navegação em páginas da web (histórico de navegação)

## Principais Operações

### 1️⃣ Empilhar (*push*)

Adiciona um elemento ao topo da pilha.

```java
import java.util.Stack;

public class PilhaExemplo {
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();
        
        pilha.push("A"); // Empilha o elemento "A"
        pilha.push("B"); // Empilha o elemento "B"
        pilha.push("C"); // Empilha o elemento "C"
        
        System.out.println("Pilha após empilhar: " + pilha);
    }
}
```

📌 **Saída Esperada:**
```shell
Pilha após empilhar: [A, B, C]
```

---

### 2️⃣ Desempilhar (*pop*)

Remove o elemento do topo da pilha.

```java
import java.util.Stack;

public class PilhaExemplo {
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();
        pilha.push("A");
        pilha.push("B");
        pilha.push("C");
        
        // Desempilha o elemento do topo
        String removido = pilha.pop(); // Remove "C"
        
        System.out.println("Elemento desempilhado: " + removido);
        System.out.println("Pilha após desempilhar: " + pilha);
    }
}
```

📌 **Saída Esperada:**
```shell
Elemento desempilhado: C
Pilha após desempilhar: [A, B]
```

---

### 3️⃣ Espiar (*peek*)

Obtém o elemento do topo da pilha sem removê-lo.

```java
import java.util.Stack;

public class PilhaExemplo {
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();
        pilha.push("A");
        pilha.push("B");
        pilha.push("C");
        
        // Espiando o topo da pilha
        String topo = pilha.peek(); // Retorna "C" sem remover
        System.out.println("Elemento no topo da pilha: " + topo);
        System.out.println("Pilha após espiar: " + pilha);
    }
}
```

📌 **Saída Esperada:**
```shell
Elemento no topo da pilha: C
Pilha após espiar: [A, B, C]
```

---

### 4️⃣ Verificar se a pilha está vazia

```java
import java.util.Stack;

public class PilhaExemplo {
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();
        
        // Verificando se a pilha está vazia
        boolean estaVazia = pilha.isEmpty();
        System.out.println("A pilha está vazia? " + estaVazia);
        
        pilha.push("A");
        
        estaVazia = pilha.isEmpty();
        System.out.println("A pilha está vazia após empilhar um elemento? " + estaVazia);
    }
}
```

📌 **Saída Esperada:**
```shell
A pilha está vazia? true
A pilha está vazia após empilhar um elemento? false
```

---

### 5️⃣ Tamanho da pilha

```java
import java.util.Stack;

public class PilhaExemplo {
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();
        pilha.push("A");
        pilha.push("B");
        pilha.push("C");
        
        // Obtendo o tamanho da pilha
        int tamanho = pilha.size();
        System.out.println("Tamanho da pilha: " + tamanho);
    }
}
```

📌 **Saída Esperada:**
```shell
Tamanho da pilha: 3
```

---

## Conclusão

A estrutura de dados **pilha** é muito útil em diversos contextos que exigem o processamento de elementos de forma reversa, ou seja, a partir do topo da pilha. As operações principais são **empilhar (push)**, **desempilhar (pop)** e **espiar (peek)**, e são frequentemente aplicadas em problemas de busca, execução de funções recursivas e verificação de expressões.

🚀 **Agora que você compreendeu os conceitos de pilha, explore a implementação no código e experimente testar diferentes cenários!**
