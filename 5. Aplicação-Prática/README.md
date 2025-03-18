# 📝 Editor de Texto com Sistema de Undo/Redo usando Pilhas

## 📌 Aplicação Prática

**Enunciado:**  
Escolha um problema prático que possa ser resolvido com o uso de uma das estruturas de dados lineares (listas, filas ou pilhas).  
Descreva o problema e explique como a estrutura de dados escolhida pode ser usada para resolvê-lo.  
No Repositório do GitHub, na pasta raiz, crie um arquivo readme.md explicando o problema prático escolhido e um arquivo .py ou .js com a resolução do problema prático utilizando a estrutura de dados escolhida.

---

## 🎯 Problema Prático Escolhido

### **Editor de Texto com Funcionalidade de Undo/Redo**

O problema consiste em simular o comportamento de um **editor de texto simples**, onde o usuário pode:
- Escrever palavras,
- Remover a última palavra,
- Limpar o texto,
- Desfazer (Undo) a última ação realizada,
- Refazer (Redo) uma ação desfeita,
- Visualizar o texto atual.

Este comportamento é semelhante ao que encontramos em editores de texto populares, como o Microsoft Word ou Google Docs, onde o histórico de ações permite ao usuário reverter ou repetir alterações feitas no documento.

---

## 🛠️ Estrutura de Dados Utilizada

Para resolver este problema, foi utilizada a estrutura de dados **Pilha (Stack)**.

### Como foi aplicada:
- **Pilha de Undo:** Guarda o histórico das ações realizadas, permitindo que o usuário reverta alterações anteriores (último a entrar é o primeiro a sair - LIFO).
- **Pilha de Redo:** Armazena ações que foram desfeitas, permitindo que o usuário as refaça, caso deseje.

---

## 💡 Justificativa

As pilhas são ideais para problemas onde é necessário desfazer ou refazer ações, pois seguem o princípio **LIFO (Last In, First Out)**.  
A cada nova ação do usuário (escrever, remover ou limpar), o estado atual do texto é salvo na pilha de **Undo** e a pilha de **Redo** é esvaziada, simulando fielmente o comportamento de um editor real.

---

## 🚀 Funcionalidades implementadas

O sistema permite as seguintes operações:

- **escrever(String palavra):** adiciona uma nova palavra ao texto.
- **removerUltima():** remove a última palavra digitada.
- **limpar():** limpa todo o texto atual.
- **desfazer():** desfaz a última ação realizada.
- **refazer():** refaz uma ação desfeita.
- **mostrarTexto():** exibe o texto atual.

---

## 🧩 Exemplo de uso

```plaintext
1 - Escrever palavra: "Hello"
2 - Escrever palavra: "World"
3 - Mostrar texto: "Hello World"
4 - Remover última palavra ("World")
5 - Desfazer (texto volta para "Hello World")
6 - Refazer (texto volta para "Hello")
7 - Limpar texto
8 - Desfazer (texto volta para "Hello")

## 📂 Estrutura do projeto
/ (pasta raiz do repositório)
│
├── README.md        
└── AppPratica.java <-- (código da aplicação em Java)