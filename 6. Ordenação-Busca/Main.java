import java.util.Scanner;

public class Main {
    private static Turma[] turmas = new Turma[10];
    private static int qtdTurmas = 0;
    private static Disciplina[] disciplinas = new Disciplina[10];
    private static int qtdDisciplinas = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Adicionar disciplina ou aluno à turma");
            System.out.println("3 - Lançar nota");
            System.out.println("4 - Visualizar");
            System.out.println("5 - Remover");
            System.out.println("6 - Ranking de Notas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: menuCadastrar(); break;
                case 2: menuAdicionar(); break;
                case 3: lancarNota(); break;
                case 4: menuVisualizar(); break;
                case 5: menuRemover(); break;
                case 6: rankingNotas(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuCadastrar() {
        int opcao;
        do {
            System.out.println("\n--- Menu Cadastrar ---");
            System.out.println("1 - Cadastrar Turma");
            System.out.println("2 - Cadastrar Disciplina");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: cadastrarTurma(); break;
                case 2: cadastrarDisciplina(); break;
                case 3: cadastrarAluno(); break;
            }
        } while (opcao != 0);
    }

    private static void cadastrarTurma() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Ano: ");
        int ano = sc.nextInt();
        sc.nextLine();

        Turma turma = new Turma(id, nome, ano, 10, 10);
        turmas[qtdTurmas++] = turma;
        System.out.println("Turma cadastrada!");
    }

    private static void cadastrarDisciplina() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Professor: ");
        String professor = sc.nextLine();
        System.out.print("Turno: ");
        String turno = sc.nextLine();

        disciplinas[qtdDisciplinas++] = new Disciplina(nome, professor, turno);
        System.out.println("Disciplina cadastrada!");
    }

    private static void cadastrarAluno() {
        if (qtdTurmas == 0) {
            System.out.println("Cadastre uma turma primeiro.");
            return;
        }
        System.out.print("Nome do aluno: ");
        String nome = sc.nextLine();
        System.out.print("Matrícula: ");
        int matricula = sc.nextInt();
        sc.nextLine();

        Turma turma = escolherTurma();
        if (turma == null) return;

        turma.adicionarAluno(new Aluno(nome, matricula, turma));
        System.out.println("Aluno cadastrado e adicionado à turma!");
    }

    private static void menuAdicionar() {
        int opcao;
        do {
            System.out.println("\n--- Adicionar ---");
            System.out.println("1 - Adicionar disciplina à turma");
            System.out.println("2 - Adicionar aluno à turma");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) adicionarDisciplinaTurma();
            else if (opcao == 2) cadastrarAluno();
        } while (opcao != 0);
    }

    private static void adicionarDisciplinaTurma() {
        if (qtdTurmas == 0 || qtdDisciplinas == 0) {
            System.out.println("Cadastre uma turma e uma disciplina primeiro.");
            return;
        }
        Turma turma = escolherTurma();
        if (turma == null) return;

        listarDisciplinasGlobais();

        System.out.print("Nome da disciplina para adicionar: ");
        String nomeDisc = sc.nextLine();
        Disciplina disciplina = buscarDisciplinaPorNome(nomeDisc);
        if (disciplina != null) {
            turma.adicionarDisciplina(disciplina);
            System.out.println("Disciplina adicionada!");
        } else System.out.println("Disciplina não encontrada.");
    }

    private static void lancarNota() {
        System.out.print("Nome do aluno: ");
        String nomeAluno = sc.nextLine();

        Aluno aluno = buscarAlunoPorNome(nomeAluno);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        Turma turma = aluno.getTurma();
        listarDisciplinasTurma(turma);

        System.out.print("Nome da disciplina: ");
        String nomeDisc = sc.nextLine();
        Disciplina disciplina = buscarDisciplinaPorNome(nomeDisc);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Nota: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        aluno.adicionarNota(new Nota(valor, aluno, disciplina));
        System.out.println("Nota lançada!");
    }

    private static void menuVisualizar() {
        int opcao;
        do {
            System.out.println("\n--- Visualizar ---");
            System.out.println("1 - Listar turmas");
            System.out.println("2 - Detalhar turma");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) listarTurmas();
            else if (opcao == 2) detalharTurma();
        } while (opcao != 0);
    }

    private static void detalharTurma() {
        Turma turma = escolherTurma();
        if (turma == null) return;

        System.out.println("\n--- Detalhes da Turma ---");
        System.out.println("Nome: " + turma.getNome());
        System.out.println("Ano: " + turma.getAno());

        System.out.println("Alunos:");
        Aluno[] alunos = turma.getAlunos();
        for (int i = 0; i < turma.getQtdAlunos(); i++) {
            Aluno a = alunos[i];
            System.out.println("- " + a.getNome() + " (" + a.getNumeroMatricula() + ")");
            for (int j = 0; j < a.getQtdNotas(); j++) {
                Nota n = a.getNotas()[j];
                System.out.println("   " + n.getDisciplina().getNome() + ": " + n.getNota());
            }
        }
    }

    private static void menuRemover() {
        System.out.println("\n--- Remover ---");
        System.out.println("1 - Remover turma");
        System.out.println("2 - Remover aluno");
        System.out.print("Escolha: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op == 1) removerTurma();
        else if (op == 2) removerAluno();
    }

    private static void removerTurma() {
        listarTurmas();
        System.out.print("ID da turma a remover: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i] != null && turmas[i].getId() == id) {
                for (int j = i; j < qtdTurmas - 1; j++) {
                    turmas[j] = turmas[j + 1];
                }
                turmas[--qtdTurmas] = null;
                System.out.println("Turma removida!");
                return;
            }
        }
        System.out.println("Turma não encontrada.");
    }

    private static void removerAluno() {
        System.out.print("Nome do aluno: ");
        String nome = sc.nextLine();
        for (Turma turma : turmas) {
            if (turma != null) {
                Aluno[] alunos = turma.getAlunos();
                for (int i = 0; i < turma.getQtdAlunos(); i++) {
                    if (alunos[i] != null && alunos[i].getNome().equalsIgnoreCase(nome)) {
                        for (int j = i; j < turma.getQtdAlunos() - 1; j++) {
                            alunos[j] = alunos[j + 1];
                        }
                        turma.setQtdAlunos(turma.getQtdAlunos() - 1);
                        System.out.println("Aluno removido!");
                        return;
                    }
                }
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    private static void rankingNotas() {
        Turma turma = escolherTurma();
        if (turma == null) return;

        turma.ordenarAlunosPorNome(); // Exemplo de ordenação, substitua conforme necessário
        System.out.println("\n--- Ranking de Notas ---");
        Aluno[] alunos = turma.getAlunos();
        for (int i = 0; i < turma.getQtdAlunos(); i++) {
            Aluno a = alunos[i];
            double soma = 0;
            int count = 0;
            for (int j = 0; j < a.getQtdNotas(); j++) {
                soma += a.getNotas()[j].getNota();
                count++;
            }
            double media = count > 0 ? soma / count : 0;
            System.out.printf("- %s (Média: %.2f)\n", a.getNome(), media);
        }
    }

    private static void listarTurmas() {
        System.out.println("\nTurmas:");
        for (int i = 0; i < qtdTurmas; i++) {
            System.out.println("ID: " + turmas[i].getId() + " - " + turmas[i].getNome());
        }
    }

    private static void listarDisciplinasGlobais() {
        for (int i = 0; i < qtdDisciplinas; i++) {
            System.out.println("- " + disciplinas[i].getNome());
        }
    }

    private static void listarDisciplinasTurma(Turma turma) {
        System.out.println("Disciplinas:");
        for (int i = 0; i < turma.getQtdDisciplinas(); i++) {
            System.out.println("- " + turma.getDisciplinas()[i].getNome());
        }
    }

    private static Turma escolherTurma() {
        listarTurmas();
        System.out.print("ID da turma: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i].getId() == id) return turmas[i];
        }
        System.out.println("Turma não encontrada.");
        return null;
    }

    private static Disciplina buscarDisciplinaPorNome(String nome) {
        for (int i = 0; i < qtdDisciplinas; i++) {
            if (disciplinas[i].getNome().equalsIgnoreCase(nome)) return disciplinas[i];
        }
        return null;
    }

    private static Aluno buscarAlunoPorNome(String nome) {
        for (int i = 0; i < qtdTurmas; i++) {
            Aluno[] alunos = turmas[i].getAlunos();
            for (int j = 0; j < turmas[i].getQtdAlunos(); j++) {
                if (alunos[j].getNome().equalsIgnoreCase(nome)) return alunos[j];
            }
        }
        return null;
    }
}