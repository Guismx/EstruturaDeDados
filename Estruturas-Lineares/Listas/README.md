
# Estrutura de Dados: Listas (Lists)

## Introdução

A **lista** (*list*) é uma estrutura de dados linear que permite armazenar uma coleção de elementos, onde é possível adicionar, remover e acessar elementos em qualquer posição. As listas são amplamente utilizadas em diversos cenários, como manipulação de coleções de dados, gerenciamento de listas de tarefas, e outros algoritmos que necessitam de flexibilidade nas operações de inserção e remoção.

Diferente de outras estruturas de dados, como filas ou pilhas, as listas permitem a inserção de elementos em qualquer posição, podendo ser ordenadas ou não.

## Principais Operações

### 1️⃣ Inserir Elemento na Lista

Adiciona um elemento em uma posição específica na lista ou no final.

```java
import java.util.ArrayList;
import java.util.List;

public class ListaExemplo {
    public static void main(String[] args) {
        // Criando uma lista
        List<String> lista = new ArrayList<>();
        
        // Adicionando elementos à lista
        lista.add("A"); // Adiciona "A" no final
        lista.add("B"); // Adiciona "B" no final
        lista.add("C"); // Adiciona "C" no final
        
        // Exibindo a lista após inserir os elementos
        System.out.println("Lista após inserir: " + lista);
    }
}
```

📌 **Saída Esperada:**
```shell
Lista após inserir: [A, B, C]
```

---

### 2️⃣ Remover Elemento da Lista

Remove um elemento de uma posição específica ou pelo valor.

```java
import java.util.ArrayList;
import java.util.List;

public class ListaExemplo {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        
        // Removendo o elemento "B" da lista
        lista.remove("B");
        
        System.out.println("Lista após remover 'B': " + lista);
    }
}
```

📌 **Saída Esperada:**
```shell
Lista após remover 'B': [A, C]
```

---

### 3️⃣ Acessar Elemento por Índice

Permite acessar um elemento da lista utilizando o índice.

```java
import java.util.ArrayList;
import java.util.List;

public class ListaExemplo {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        
        // Acessando o elemento na posição 1
        String elemento = lista.get(1); // Retorna "B"
        
        System.out.println("Elemento na posição 1: " + elemento);
    }
}
```

📌 **Saída Esperada:**
```shell
Elemento na posição 1: B
```

---

### 4️⃣ Alterar Elemento da Lista

Modifica o valor de um elemento existente na lista.

```java
import java.util.ArrayList;
import java.util.List;

public class ListaExemplo {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        
        // Alterando o elemento na posição 1
        lista.set(1, "NovoB"); // Modifica "B" para "NovoB"
        
        System.out.println("Lista após alterar o elemento: " + lista);
    }
}
```

📌 **Saída Esperada:**
```shell
Lista após alterar o elemento: [A, NovoB, C]
```

---

### 5️⃣ Verificar o Tamanho da Lista

Obtém o número de elementos presentes na lista.

```java
import java.util.ArrayList;
import java.util.List;

public class ListaExemplo {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        
        // Obtendo o tamanho da lista
        int tamanho = lista.size();
        
        System.out.println("Tamanho da lista: " + tamanho);
    }
}
```

📌 **Saída Esperada:**
```shell
Tamanho da lista: 3
```

---

### 6️⃣ Verificar se a Lista Contém um Elemento

Verifica se um determinado valor está presente na lista.

```java
import java.util.ArrayList;
import java.util.List;

public class ListaExemplo {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        
        // Verificando se a lista contém o elemento "B"
        boolean contemB = lista.contains("B");
        
        System.out.println("A lista contém 'B'? " + contemB);
    }
}
```

📌 **Saída Esperada:**
```shell
A lista contém 'B'? true
```

---

## Conclusão

A **lista** é uma das estruturas de dados mais flexíveis e amplamente usadas. Ela permite não só adicionar e remover elementos de qualquer posição, mas também acessar elementos de forma rápida, verificar seu tamanho, e muito mais. Listas são essenciais para aplicações que envolvem a manipulação dinâmica de dados, como listas de tarefas, coleções de objetos, e manipulação de conjuntos de dados variáveis.

🚀 **Agora que você compreendeu os conceitos de listas, explore a implementação no código e experimente testar diferentes cenários!**
