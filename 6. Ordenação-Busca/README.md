# 📘 Sistema de Gerenciamento de Notas Escolares

> Projeto acadêmico desenvolvido para demonstrar a aplicação de estruturas de dados lineares (arrays) e algoritmos fundamentais em Java, simulando um sistema de controle de dados escolares via console.

---

## 🧠 Objetivo

Criar um sistema de gerenciamento acadêmico, baseado exclusivamente no uso de **arrays nativos (sem uso de Java Collections Framework)**, que permita o cadastro e controle de **turmas, alunos, disciplinas e notas**. O projeto visa exercitar a implementação manual de funcionalidades como inserção, remoção, ordenação e busca.

---

## 📌 Funcionalidades

### 📥 Cadastro

- Cadastro de **turmas** com ID, nome, ano e capacidades iniciais.
- Cadastro de **disciplinas globais** (disponíveis para qualquer turma).
- Cadastro de **alunos**, associados diretamente a uma turma.

### ➕ Associação e Lançamentos

- Associação de disciplinas globais a turmas específicas.
- Lançamento de **notas** para alunos em disciplinas de suas turmas.

### 🔍 Consulta e Visualização

- Listagem de turmas, disciplinas, alunos e notas.
- Visualização detalhada de turmas (alunos ordenados, disciplinas, notas).
- Consulta por **nome de aluno**, **faixa de média** e **ranking**.
- Visualização individual de notas por aluno.

### 🗑️ Remoção

- Remoção de turmas do sistema.
- Remoção de alunos de turmas específicas.

### 🔄 Ordenação (Manual - Bubble Sort)

- Alunos por **nome** e por **média**.
- Notas por **valor crescente/decrescente** e por **disciplina**.

---

## 🧱 Estrutura de Dados

### 🔢 Arrays utilizados

- **Turmas**: array principal contendo todas as turmas.
- **Disciplinas globais**: array com disciplinas disponíveis no sistema.
- **Alunos por turma**: cada `Turma` possui um array de alunos.
- **Disciplinas por turma**: array de referências a disciplinas globais.
- **Notas por aluno**: array com notas associadas às disciplinas.

### 🧩 Lógica de redimensionamento

Todos os arrays foram implementados com redimensionamento automático (dobro da capacidade atual quando o limite é atingido), simulando listas dinâmicas.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java (console)
- **Paradigma:** Programação orientada a objetos
- **Restrições:** Sem uso de coleções prontas (ex: `ArrayList`, `HashMap`, etc.)
- **Estruturas:** Arrays lineares com lógica manual de redimensionamento

---

## 💡 Justificativa Pedagógica

O uso de arrays neste projeto tem fins didáticos e reforça o entendimento de:

- Armazenamento sequencial de dados
- Gerenciamento de capacidade e redimensionamento
- Algoritmos de ordenação e busca manuais
- Controle explícito de quantidades e índices

---

## 🧪 Exemplo de Uso

```plaintext
=== MENU PRINCIPAL ===
1 - Cadastrar
2 - Adicionar
3 - Lançar nota
4 - Visualizar
5 - Remover
6 - Ranking de Alunos por Média
0 - Sair

Escolha: 1
--- Menu Cadastrar ---
1 - Cadastrar Turma
2 - Cadastrar Disciplina
3 - Cadastrar Aluno
0 - Voltar

Turma cadastrada com sucesso!
Disciplina cadastrada globalmente com sucesso!
Aluno cadastrado e adicionado à turma 3A.
Nota lançada com sucesso para Joao Silva na disciplina Matematica.

Visualização:
Notas de Joao Silva
1 - Ordem de lançamento
2 - Ordenadas por valor crescente
