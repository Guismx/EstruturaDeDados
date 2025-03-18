# Estrutura de Dados: Filas (Queues)

## Introdução

A **fila** (*queue*) é uma estrutura de dados linear que segue o princípio **FIFO** (*First In, First Out*), ou seja, o primeiro elemento a entrar é o primeiro a sair. Essa característica faz com que as filas sejam amplamente utilizadas em cenários como:

- Sistemas de atendimento ao cliente
- Processamento de tarefas em ordem cronológica
- Impressão de documentos em uma impressora
- Algoritmos de busca em largura (BFS)

## Principais Operações

### 1️⃣ Enfileirar (*enqueue*)

Adiciona um elemento ao final da fila.

```java
import java.util.LinkedList;
import java.util.Queue;

public class FilaExemplo {
    public static void main(String[] args) {
        // Criando uma fila
        Queue<String> fila = new LinkedList<>();
        
        // Adicionando elementos na fila
        fila.add("A"); // Adiciona o elemento "A"
        fila.add("B"); // Adiciona o elemento "B"
        fila.add("C"); // Adiciona o elemento "C"
        
        // Exibindo a fila após enfileirar os elementos
        System.out.println("Fila após enfileirar: " + fila);
    }
}
```

📌 **Saída Esperada:**
```shell
Fila após enfileirar: [A, B, C]
```

---

### 2️⃣ Desenfileirar (*dequeue*)

Remove o primeiro elemento da fila (o mais antigo).

```java
import java.util.LinkedList;
import java.util.Queue;

public class FilaExemplo {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        fila.add("A");
        fila.add("B");
        fila.add("C");
        
        // Removendo o primeiro elemento da fila
        String removido = fila.poll(); // Remove "A"
        
        System.out.println("Elemento removido: " + removido);
        System.out.println("Fila após desenfileirar: " + fila);
    }
}
```

📌 **Saída Esperada:**
```shell
Elemento removido: A
Fila após desenfileirar: [B, C]
```

---

### 3️⃣ Espiar (*peek*)

Obtém o primeiro elemento da fila sem removê-lo.

```java
import java.util.LinkedList;
import java.util.Queue;

public class FilaExemplo {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        fila.add("A");
        fila.add("B");
        fila.add("C");
        
        // Obtendo o primeiro elemento sem removê-lo
        String primeiro = fila.peek(); // Retorna "A" sem remover
        
        System.out.println("Primeiro elemento da fila: " + primeiro);
        System.out.println("Fila após operação de espiar: " + fila);
    }
}
```

📌 **Saída Esperada:**
```shell
Primeiro elemento da fila: A
Fila após operação de espiar: [A, B, C]
```

---

### 4️⃣ Verificar se a fila está vazia

```java
import java.util.LinkedList;
import java.util.Queue;

public class FilaExemplo {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        
        // Verificando se a fila está vazia
        boolean estaVazia = fila.isEmpty();
        
        System.out.println("A fila está vazia? " + estaVazia);
        
        // Adicionando um elemento
        fila.add("A");
        estaVazia = fila.isEmpty();
        
        System.out.println("A fila está vazia após adicionar um elemento? " + estaVazia);
    }
}
```

📌 **Saída Esperada:**
```shell
A fila está vazia? true
A fila está vazia após adicionar um elemento? false
```

---

### 5️⃣ Tamanho da fila

```java
import java.util.LinkedList;
import java.util.Queue;

public class FilaExemplo {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        fila.add("A");
        fila.add("B");
        fila.add("C");
        
        // Obtendo o tamanho da fila
        int tamanho = fila.size();
        
        System.out.println("Tamanho da fila: " + tamanho);
    }
}
```

📌 **Saída Esperada:**
```shell
Tamanho da fila: 3
```

---

## Conclusão

A estrutura de dados **fila** é essencial para modelar processos que exigem processamento sequencial de elementos. As operações principais são **enfileirar (enqueue)**, **desenfileirar (dequeue)** e **espiar (peek)**, sendo aplicáveis a diversas situações como agendamento de tarefas e manipulação de dados em tempo real.

🚀 **Agora que você compreendeu os conceitos de fila, explore a implementação no código e experimente testar diferentes cenários!**

