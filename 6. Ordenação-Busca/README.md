# 🎓 Sistema de Gerenciamento de Notas Escolares

## 📌 Aplicação Prática

**Contexto:** Este projeto visa demonstrar a aplicação de estruturas de dados lineares (arrays) e algoritmos fundamentais para resolver um problema prático de gerenciamento de informações em um contexto escolar.

**Desafio:** Desenvolver um sistema em Java que permita o cadastro, manipulação e consulta de dados referentes a turmas, alunos, disciplinas e suas respectivas notas, sem utilizar o Java Collections Framework para as estruturas de armazenamento principais e algoritmos de ordenação/busca.

---

## 🎯 Problema Prático Escolhido

### **Gerenciamento de Dados Escolares (Turmas, Alunos, Disciplinas e Notas)**

O problema consiste em criar um sistema interativo via console para gerenciar informações acadêmicas básicas. O sistema deve permitir que usuários (como administradores ou professores) realizem operações como:

-   **Cadastrar** novas turmas, disciplinas (de forma global para o sistema) e alunos (associando-os a turmas).
-   **Adicionar** disciplinas globais a turmas específicas.
-   **Lançar notas** para os alunos em suas respectivas disciplinas dentro de uma turma.
-   **Visualizar** informações detalhadas, como listas de turmas, alunos por turma (com opção de ordenação), disciplinas por turma, notas de alunos (com opções de ordenação) e rankings de alunos por média.
-   **Buscar** alunos por nome ou por faixa de média.
-   **Remover** turmas ou alunos de turmas.

O objetivo é fornecer uma ferramenta funcional para organizar e acessar dados acadêmicos de forma estruturada.

---

## 🛠️ Estrutura de Dados Utilizada

Para resolver este problema, a estrutura de dados fundamental utilizada foi o **Array (Vetor)**, simulando o comportamento de listas lineares.

### Como foi aplicada:

-   **Arrays de Turmas:** Um array para armazenar todas as turmas cadastradas no sistema.
-   **Arrays de Disciplinas Globais:** Um array para armazenar todas as disciplinas disponíveis no sistema, que podem ser posteriormente associadas a diferentes turmas.
-   **Arrays de Alunos (dentro de cada Turma):** Cada objeto `Turma` contém um array para armazenar seus alunos.
-   **Arrays de Disciplinas (dentro de cada Turma):** Cada objeto `Turma` contém um array para armazenar as disciplinas que são lecionadas naquela turma (referências às disciplinas globais).
-   **Arrays de Notas (dentro de cada Aluno):** Cada objeto `Aluno` contém um array para armazenar suas notas em diferentes disciplinas.

Todos os arrays são implementados com capacidade inicial e lógica de redimensionamento dinâmico (dobrando a capacidade quando cheios) para acomodar um número crescente de elementos.

---

## 💡 Justificativa

Os **arrays** foram escolhidos como a estrutura de dados base para este projeto por diversos motivos didáticos e práticos no contexto do desafio proposto:

-   **Fundamentalismo:** Arrays são uma das estruturas de dados mais básicas e fundamentais na programação, permitindo um entendimento claro de como os dados são armazenados sequencialmente na memória.
-   **Restrição do Desafio:** O projeto visava a implementação manual de funcionalidades que seriam simplificadas pelo Java Collections Framework. Utilizar arrays forçou a implementação de lógicas de inserção, remoção, busca, ordenação e redimensionamento.
-   **Simulação de Listas:** Arrays são a base para a construção de listas lineares, e seu uso direto permite explorar os desafios de gerenciar coleções de tamanho variável.
-   **Controle de Baixo Nível:** Trabalhar com arrays e contadores de quantidade de elementos (`qtdAlunos`, `qtdTurmas`, etc.) oferece um controle mais granular sobre o armazenamento e manipulação dos dados.

Apesar de suas limitações (tamanho fixo após criação, necessidade de redimensionamento manual), o uso de arrays neste projeto é crucial para demonstrar a compreensão e aplicação de conceitos de estruturas de dados e algoritmos elementares.

---

## 🚀 Funcionalidades implementadas

O sistema, operado via menu de console, permite as seguintes operações principais:

1.  **Cadastros:**
    -   `cadastrarTurma()`: Cria uma nova turma com ID, nome, ano e capacidades iniciais.
    -   `cadastrarDisciplinaGlobal()`: Adiciona uma nova disciplina ao sistema (nome, professor, turno).
    -   `cadastrarAluno()`: Registra um novo aluno (nome, matrícula) e o associa a uma turma existente.

2.  **Associações e Lançamentos:**
    -   `adicionarDisciplinaTurma()`: Associa uma disciplina global já cadastrada a uma turma específica.
    -   `lancarNota()`: Lança uma nota para um aluno em uma disciplina específica de sua turma.

3.  **Visualizações e Consultas:**
    -   `listarTurmas()`: Exibe todas as turmas cadastradas.
    -   `detalharTurma()`: Oferece um submenu para visualizar detalhes de uma turma, incluindo:
        -   Listar alunos da turma (ordenados por nome).
        -   Listar disciplinas da turma.
        -   Ver todas as notas da turma (ordenadas por valor crescente/decrescente ou por disciplina).
        -   Ver alunos da turma por faixa de média.
        -   Ver notas da turma para uma disciplina específica.
    -   `visualizarNotasAlunoEspecifico()`: Mostra as notas de um aluno buscado por nome, com opções para ordenar as notas (por valor ou por disciplina).
    -   `listarDisciplinasGlobaisComDetalhes()`: Exibe todas as disciplinas cadastradas no sistema com seus detalhes.
    -   `rankingNotas()`: Exibe o ranking de alunos de uma turma específica com base em suas médias (ordem crescente ou decrescente).

4.  **Buscas:**
    -   Alunos podem ser buscados globalmente por nome (para lançamento de notas, remoção, etc.).
    -   Dentro de uma turma, alunos podem ser listados por faixa de média.
    -   A classe `Turma` implementa uma busca binária por nome de aluno (requer que a lista de alunos esteja ordenada).

5.  **Remoções:**
    -   `removerTurma()`: Remove uma turma do sistema.
    -   `removerAlunoDeTurma()`: Remove um aluno de sua turma (utilizando um método encapsulado na classe `Turma`).

6.  **Ordenações (implementadas manualmente, e.g., Bubble Sort):**
    -   Alunos em uma turma: por nome, por média.
    -   Notas de um aluno: por valor (crescente/decrescente), por disciplina.
    -   Todas as notas de uma turma: por valor (crescente/decrescente), por disciplina.

---

## 🧩 Exemplo de uso

```plaintext
=== MENU PRINCIPAL ===
1 - Cadastrar
2 - Adicionar (aluno/disciplina à turma)
3 - Lançar nota
4 - Visualizar
5 - Remover
6 - Ranking de Alunos por Média
0 - Sair
Escolha: 1

--- Menu Cadastrar ---
1 - Cadastrar Turma
2 - Cadastrar Disciplina (global para o sistema)
3 - Cadastrar Aluno (e associar a uma turma)
0 - Voltar
Escolha: 1
ID da Turma: 101
Nome da Turma: 3A
Ano da Turma: 2025
Capacidade inicial de alunos da turma: 5
Capacidade inicial de disciplinas da turma: 3
Turma cadastrada com sucesso!

Escolha: 2 (Cadastrar Disciplina)
Nome da Disciplina: Matematica
Nome do Professor: Prof. Carlos
Turno (Manhã, Tarde, Noite): Manhã
Disciplina cadastrada globalmente com sucesso!

Escolha: 0 (Voltar ao Menu Principal)

Escolha: 2 (Adicionar)
--- Menu Adicionar ---
1 - Adicionar disciplina (global) a uma turma
0 - Voltar
Escolha: 1
Turmas disponíveis para adicionar a disciplina:
ID: 101 - Nome: 3A (2025)
Digite o ID da turma desejada: 101
Disciplinas globais disponíveis:
- Matematica
Nome da disciplina global para adicionar à turma: Matematica
Disciplina 'Matematica' adicionada à turma '3A'.

Escolha: 1 (Cadastrar - no menu principal)
Escolha: 3 (Cadastrar Aluno)
Turmas disponíveis para adicionar o aluno:
ID: 101 - Nome: 3A (2025)
Digite o ID da turma desejada: 101
Nome do Aluno: Joao Silva
Número de Matrícula: 12345
Aluno Joao Silva cadastrado e adicionado à turma 3A.

Escolha: 3 (Lançar nota - no menu principal)
Digite o nome do aluno para lançamento de nota: Joao Silva
Disciplinas disponíveis na turma 3A para o aluno Joao Silva:
- Matematica (Professor: Prof. Carlos)
Nome da disciplina para lançar a nota: Matematica
Digite a nota (0.0 a 10.0): 8.5
Nota lançada com sucesso para Joao Silva na disciplina Matematica.

Escolha: 4 (Visualizar - no menu principal)
Escolha: 3 (Visualizar notas de um aluno específico)
Digite o nome do aluno para visualizar as notas: Joao Silva
--- Notas de Joao Silva ---
1 - Ver notas (ordem de lançamento)
2 - Ver notas ordenadas por valor (crescente)
...
Escolha: 1
Resultados para Joao Silva:
Disciplina: Matematica        | Nota: 8.50