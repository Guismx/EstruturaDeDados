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
            System.out.println("2 - Adicionar (aluno/disciplina à turma)");
            System.out.println("3 - Lançar nota");
            System.out.println("4 - Visualizar");
            System.out.println("5 - Remover");
            System.out.println("6 - Ranking de Alunos por Média");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            
            if (sc.hasNextInt()){
                opcao = sc.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next(); 
                opcao = -1; 
            }
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
        sc.close();
    }

    private static void menuCadastrar() {
        int opcao;
        do {
            System.out.println("\n--- Menu Cadastrar ---");
            System.out.println("1 - Cadastrar Turma");
            System.out.println("2 - Cadastrar Disciplina (global para o sistema)");
            System.out.println("3 - Cadastrar Aluno (e associar a uma turma)");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            if (sc.hasNextInt()){
                opcao = sc.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next();
                opcao = -1;
            }
            sc.nextLine(); 

            switch (opcao) {
                case 1: cadastrarTurma(); break;
                case 2: cadastrarDisciplinaGlobal(); break;
                case 3: cadastrarAluno(); break;
                case 0: break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarTurma() {
        if (qtdTurmas >= turmas.length) {
            Turma[] novoArray = new Turma[turmas.length * 2];
            System.arraycopy(turmas, 0, novoArray, 0, turmas.length);
            turmas = novoArray;
            System.out.println("Capacidade de turmas expandida.");
        }
        System.out.print("ID da Turma: ");
        int id = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i] != null && turmas[i].getId() == id) {
                System.out.println("Erro: ID de turma já existente.");
                return;
            }
        }
        System.out.print("Nome da Turma: ");
        String nome = sc.nextLine();
        System.out.print("Ano da Turma: ");
        int ano = sc.nextInt(); sc.nextLine();
        System.out.print("Capacidade inicial de alunos da turma: ");
        int capAlunos = sc.nextInt(); sc.nextLine();
        System.out.print("Capacidade inicial de disciplinas da turma: ");
        int capDisc = sc.nextInt(); sc.nextLine();

        Turma turma = new Turma(id, nome, ano, capAlunos, capDisc);
        turmas[qtdTurmas++] = turma;
        System.out.println("Turma cadastrada com sucesso!");
    }

    private static void cadastrarDisciplinaGlobal() {
        if (qtdDisciplinas >= disciplinas.length) {
            Disciplina[] novoArray = new Disciplina[disciplinas.length * 2];
            System.arraycopy(disciplinas, 0, novoArray, 0, disciplinas.length);
            disciplinas = novoArray;
            System.out.println("Capacidade de disciplinas globais expandida.");
        }
        System.out.print("Nome da Disciplina: ");
        String nome = sc.nextLine();
        if (buscarDisciplinaGlobalPorNome(nome) != null) {
            System.out.println("Erro: Disciplina com este nome já cadastrada no sistema.");
            return;
        }
        System.out.print("Nome do Professor: ");
        String professor = sc.nextLine();
        System.out.print("Turno (Manhã, Tarde, Noite): ");
        String turno = sc.nextLine();

        disciplinas[qtdDisciplinas++] = new Disciplina(nome, professor, turno);
        System.out.println("Disciplina cadastrada globalmente com sucesso!");
    }

    private static void cadastrarAluno() {
        if (qtdTurmas == 0) {
            System.out.println("Nenhuma turma cadastrada. Cadastre uma turma primeiro.");
            return;
        }
        Turma turma = escolherTurma("para adicionar o aluno");
        if (turma == null) return;

        System.out.print("Nome do Aluno: ");
        String nome = sc.nextLine();
        System.out.print("Número de Matrícula: ");
        int matricula = sc.nextInt(); sc.nextLine();
        
        Aluno[] alunosDaTurma = turma.getAlunos();
        for(int i=0; i < alunosDaTurma.length; i++){ 
            if(alunosDaTurma[i].getNumeroMatricula() == matricula){
                System.out.println("Erro: Aluno com esta matrícula já existe nesta turma.");
                return;
            }
        }
        
        Aluno aluno = new Aluno(nome, matricula, turma);
        turma.adicionarAluno(aluno);
        System.out.println("Aluno " + nome + " cadastrado e adicionado à turma " + turma.getNome() + ".");
    }

    private static void menuAdicionar() {
        int opcao;
        do {
            System.out.println("\n--- Menu Adicionar ---");
            System.out.println("1 - Adicionar disciplina (global) a uma turma");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
             if (sc.hasNextInt()){
                opcao = sc.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next();
                opcao = -1;
            }
            sc.nextLine();

            switch (opcao) {
                case 1: adicionarDisciplinaTurma(); break;
                case 0: break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void adicionarDisciplinaTurma() {
        if (qtdTurmas == 0) { System.out.println("Nenhuma turma cadastrada."); return; }
        if (qtdDisciplinas == 0) { System.out.println("Nenhuma disciplina global cadastrada."); return; }

        Turma turma = escolherTurma("para adicionar a disciplina");
        if (turma == null) return;

        System.out.println("Disciplinas globais disponíveis:");
        listarDisciplinasGlobais(); 

        System.out.print("Nome da disciplina global para adicionar à turma: ");
        String nomeDisc = sc.nextLine();
        Disciplina disciplinaGlobal = buscarDisciplinaGlobalPorNome(nomeDisc);

        if (disciplinaGlobal == null) { System.out.println("Disciplina global não encontrada."); return; }
        
        Disciplina[] disciplinasDaTurma = turma.getDisciplinas();
        for(int i=0; i< disciplinasDaTurma.length; i++){
            if(disciplinasDaTurma[i].getNome().equalsIgnoreCase(disciplinaGlobal.getNome())){
                System.out.println("Esta disciplina já foi adicionada à turma " + turma.getNome());
                return;
            }
        }

        turma.adicionarDisciplina(disciplinaGlobal);
        System.out.println("Disciplina '" + nomeDisc + "' adicionada à turma '" + turma.getNome() + "'.");
    }

    private static void lancarNota() {
        if (qtdTurmas == 0) { System.out.println("Nenhuma turma cadastrada."); return; }
        
        Aluno aluno = buscarAlunoGlobalPorNome("para lançamento de nota");
        if (aluno == null) { System.out.println("Aluno não encontrado no sistema."); return; }

        Turma turmaDoAluno = aluno.getTurma();
        if (turmaDoAluno.getQtdDisciplinas() == 0) {
            System.out.println("A turma do aluno (" + turmaDoAluno.getNome() + ") não possui disciplinas.");
            return;
        }

        System.out.println("Disciplinas disponíveis na turma " + turmaDoAluno.getNome() + " para o aluno " + aluno.getNome() + ":");
        listarDisciplinasDaTurma(turmaDoAluno);

        System.out.print("Nome da disciplina para lançar a nota: ");
        String nomeDisc = sc.nextLine();
        
        Disciplina disciplinaNaTurma = null;
        Disciplina[] disciplinasDaTurma = turmaDoAluno.getDisciplinas();
        for(int i=0; i < disciplinasDaTurma.length; i++){
            if(disciplinasDaTurma[i].getNome().equalsIgnoreCase(nomeDisc)){
                disciplinaNaTurma = disciplinasDaTurma[i];
                break;
            }
        }

        if (disciplinaNaTurma == null) { System.out.println("Disciplina não encontrada na turma do aluno."); return; }

        System.out.print("Digite a nota (0.0 a 10.0): ");
        double valorNota;
        if(sc.hasNextDouble()){
            valorNota = sc.nextDouble();
            if(valorNota < 0.0 || valorNota > 10.0){
                System.out.println("Nota inválida. Deve ser entre 0.0 e 10.0.");
                sc.nextLine(); 
                return;
            }
        } else {
            System.out.println("Entrada inválida para nota.");
            sc.next(); 
            return;
        }
        sc.nextLine(); 

        aluno.adicionarNota(new Nota(valorNota, aluno, disciplinaNaTurma));
        System.out.println("Nota lançada com sucesso para " + aluno.getNome() + " na disciplina " + disciplinaNaTurma.getNome() + ".");
    }

    private static void menuVisualizar() {
        int opcao;
        do {
            System.out.println("\n--- Menu Visualizar ---");
            System.out.println("1 - Listar todas as turmas cadastradas");
            System.out.println("2 - Detalhar uma turma específica");
            System.out.println("3 - Visualizar notas de um aluno específico");
            System.out.println("4 - Listar todas as disciplinas globais cadastradas");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            if (sc.hasNextInt()){
                opcao = sc.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next();
                opcao = -1;
            }
            sc.nextLine(); 

            switch (opcao) {
                case 1: listarTurmas(); break;
                case 2: detalharTurma(); break;
                case 3: visualizarNotasAlunoEspecifico(); break;
                case 4: listarDisciplinasGlobaisComDetalhes(); break;
                case 0: break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void detalharTurma() {
        Turma turma = escolherTurma("para detalhar");
        if (turma == null) return;

        int opcao;
        do {
            System.out.println("\n--- Detalhes da Turma: " + turma.getNome() + " (" + turma.getAno() + ") ---");
            System.out.println("1 - Listar alunos da turma (ordenados por nome)");
            System.out.println("2 - Listar disciplinas da turma");
            System.out.println("3 - Ver todas as notas da turma (ordenadas por valor crescente)");
            System.out.println("4 - Ver todas as notas da turma (ordenadas por valor decrescente)");
            System.out.println("5 - Ver todas as notas da turma (ordenadas por disciplina)");
            System.out.println("6 - Ver alunos da turma por faixa de média");
            System.out.println("7 - Ver notas da turma para uma disciplina específica");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            if (sc.hasNextInt()){
                opcao = sc.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next();
                opcao = -1;
            }
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    turma.ordenarAlunosPorNome(); 
                    Aluno[] alunos = turma.getAlunos(); 
                    System.out.println("Alunos da Turma " + turma.getNome() + " (ordenados por nome):");
                    if (alunos.length == 0) System.out.println("Nenhum aluno nesta turma.");
                    for (int i=0; i < alunos.length; i++) {
                        System.out.println("- " + alunos[i].getNome() + " (Matrícula: " + alunos[i].getNumeroMatricula() + ")");
                    }
                    break;
                case 2:
                    turma.exibirDisciplinas();
                    break;
                case 3:
                    exibirListaDeNotas(turma.getTodasNotasDaTurmaOrdenadasPorValor(true), 
                                       "Notas da Turma " + turma.getNome() + " (Valor Crescente)");
                    break;
                case 4:
                    exibirListaDeNotas(turma.getTodasNotasDaTurmaOrdenadasPorValor(false), 
                                       "Notas da Turma " + turma.getNome() + " (Valor Decrescente)");
                    break;
                case 5:
                    exibirListaDeNotas(turma.getTodasNotasDaTurmaOrdenadasPorDisciplina(), 
                                       "Notas da Turma " + turma.getNome() + " (Por Disciplina)");
                    break;
                case 6:
                    System.out.print("Média mínima: "); double min = sc.nextDouble();
                    System.out.print("Média máxima: "); double max = sc.nextDouble();
                    sc.nextLine(); 
                    turma.listarAlunosPorFaixaDeMedia(min, max);
                    break;
                case 7:
                    System.out.print("Nome da disciplina para visualizar notas: ");
                    String nomeDisc = sc.nextLine();
                    turma.visualizarNotasPorDisciplina(nomeDisc);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    private static void visualizarNotasAlunoEspecifico() {
        System.out.println("--- Visualizar Notas de Aluno Específico ---");
        Aluno aluno = buscarAlunoGlobalPorNome("para visualizar as notas");
        if (aluno == null) { System.out.println("Aluno não encontrado no sistema."); return; }
        exibirNotasDeAluno(aluno);
    }

    private static void listarDisciplinasGlobaisComDetalhes() {
        System.out.println("\n--- Todas as Disciplinas Cadastradas no Sistema ---");
        if (qtdDisciplinas == 0) { System.out.println("Nenhuma disciplina cadastrada no sistema."); return; }
        for (int i = 0; i < qtdDisciplinas; i++) {
            Disciplina d = disciplinas[i];
            if (d != null) {
                System.out.printf("Nome: %s, Professor: %s, Turno: %s\n",
                        d.getNome(), d.getProfessor(), d.getTurno());
            }
        }
    }

    private static void menuRemover() {
        System.out.println("\n--- Menu Remover ---");
        System.out.println("1 - Remover turma");
        System.out.println("2 - Remover aluno de uma turma");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");
        int op = sc.nextInt(); sc.nextLine();

        switch(op){
            case 1: removerTurma(); break;
            case 2: removerAlunoDeTurma(); break;
            case 0: break;
            default: System.out.println("Opção inválida.");
        }
    }

    private static void removerTurma() {
        if (qtdTurmas == 0) { System.out.println("Nenhuma turma para remover."); return; }
        listarTurmas();
        System.out.print("ID da turma a remover: ");
        int id = sc.nextInt(); sc.nextLine();

        int indiceRemover = -1;
        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i] != null && turmas[i].getId() == id) {
                indiceRemover = i;
                break;
            }
        }

        if (indiceRemover != -1) {
            for (int i = indiceRemover; i < qtdTurmas - 1; i++) {
                turmas[i] = turmas[i + 1];
            }
            turmas[--qtdTurmas] = null; 
            System.out.println("Turma removida!");
        } else {
            System.out.println("Turma com ID " + id + " não encontrada.");
        }
    }

    private static void removerAlunoDeTurma() {
        System.out.println("--- Remover Aluno de uma Turma ---");
        Aluno aluno = buscarAlunoGlobalPorNome("para remover da turma");
        if (aluno == null) { System.out.println("Aluno não encontrado no sistema."); return; }
        
        Turma turmaDoAluno = aluno.getTurma();
        if (turmaDoAluno.removerAlunoPorMatricula(aluno.getNumeroMatricula())) {
            System.out.println("Aluno " + aluno.getNome() + " removido da turma " + turmaDoAluno.getNome() + ".");
        } else {
            System.out.println("Erro: Aluno " + aluno.getNome() + " não pode ser removido da turma " + turmaDoAluno.getNome() + " (não encontrado na turma).");
        }
    }

    private static void rankingNotas() {
        Turma turma = escolherTurma("para exibir o ranking de alunos");
        if (turma == null) return;

        if (turma.getQtdAlunos() == 0) {
            System.out.println("A turma " + turma.getNome() + " não possui alunos.");
            return;
        }

        System.out.println("\n--- Ranking de Alunos por Média da Turma: " + turma.getNome() + " ---");
        System.out.println("1 - Ranking por média (decrescente - melhores primeiro)");
        System.out.println("2 - Ranking por média (crescente - piores primeiro)");
        System.out.print("Escolha a ordem do ranking: ");
        int ordem = sc.nextInt(); sc.nextLine(); 

        boolean crescente;
        if (ordem == 1) crescente = false;
        else if (ordem == 2) crescente = true;
        else { System.out.println("Opção inválida."); return; }

        Aluno[] alunosOrdenados = turma.getAlunosOrdenadosPorMedia(crescente);

        System.out.println("\n--- Ranking ---");
        if (alunosOrdenados.length == 0) {
            System.out.println("Não há alunos com notas lançadas nesta turma para exibir no ranking.");
            return;
        }
        for (int i=0; i < alunosOrdenados.length; i++) {
            Aluno a = alunosOrdenados[i];
            System.out.printf("Aluno: %s, Matrícula: %d, Média: %.2f\n",
                    a.getNome(), a.getNumeroMatricula(), a.calcularMedia());
        }
    }

    private static void listarTurmas() {
        System.out.println("\n--- Turmas Cadastradas ---");
        if (qtdTurmas == 0) { System.out.println("Nenhuma turma cadastrada."); return; }
        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i] != null) {
                System.out.println("ID: " + turmas[i].getId() + " - Nome: " + turmas[i].getNome() + " (" + turmas[i].getAno() + ")");
            }
        }
    }

    private static void listarDisciplinasGlobais() {
        System.out.println("\n--- Disciplinas Globais Disponíveis no Sistema ---");
        if (qtdDisciplinas == 0) { System.out.println("Nenhuma disciplina global cadastrada."); return; }
        for (int i = 0; i < qtdDisciplinas; i++) {
            if (disciplinas[i] != null) {
                System.out.println("- " + disciplinas[i].getNome());
            }
        }
    }

    private static void listarDisciplinasDaTurma(Turma turma) {
        System.out.println("Disciplinas da Turma " + turma.getNome() + ":");
        Disciplina[] disciplinasDaTurma = turma.getDisciplinas(); 
        if (disciplinasDaTurma.length == 0) {
            System.out.println("Nenhuma disciplina associada a esta turma.");
            return;
        }
        for (int i=0; i < disciplinasDaTurma.length; i++) { 
            Disciplina d = disciplinasDaTurma[i];
            System.out.println("- " + d.getNome() + " (Professor: " + d.getProfessor() + ")");
        }
    }

    private static Turma escolherTurma(String motivo) {
        if (qtdTurmas == 0) { System.out.println("Nenhuma turma cadastrada no sistema."); return null; }
        System.out.println("Turmas disponíveis" + (motivo.isEmpty() ? "" : " " + motivo) + ":");
        listarTurmas();
        System.out.print("Digite o ID da turma desejada: ");
        int idTurma = sc.nextInt(); sc.nextLine(); 

        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i] != null && turmas[i].getId() == idTurma) {
                return turmas[i];
            }
        }
        System.out.println("Turma com ID " + idTurma + " não encontrada.");
        return null;
    }

    private static Disciplina buscarDisciplinaGlobalPorNome(String nome) {
        for (int i = 0; i < qtdDisciplinas; i++) {
            if (disciplinas[i] != null && disciplinas[i].getNome().equalsIgnoreCase(nome)) {
                return disciplinas[i];
            }
        }
        return null;
    }
    
    private static Aluno buscarAlunoGlobalPorNome(String motivo) {
        if (qtdTurmas == 0) {
            return null;
        }
        System.out.print("Digite o nome do aluno" + (motivo.isEmpty() ? "" : " " + motivo) + ": ");
        String nomeAluno = sc.nextLine();

        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i] != null) {
                Aluno[] alunosDaTurma = turmas[i].getAlunos(); 
                for (int j=0; j < alunosDaTurma.length; j++) { 
                    Aluno aluno = alunosDaTurma[j];
                    if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
                        return aluno;
                    }
                }
            }
        }
        return null;
    }

    private static void exibirListaDeNotas(Nota[] notas, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        if (notas == null || notas.length == 0) {
            System.out.println("Nenhuma nota encontrada para exibir.");
            return;
        }
        for (int i=0; i < notas.length; i++) {
            Nota n = notas[i];
            System.out.printf("Aluno: %-20s | Disciplina: %-15s | Nota: %.2f\n",
                    n.getAluno().getNome(), n.getDisciplina().getNome(), n.getNota());
        }
    }

    private static void exibirNotasDeAluno(Aluno aluno) {
        if (aluno.getQtdNotas() == 0) {
            System.out.println("O aluno " + aluno.getNome() + " não possui notas lançadas.");
            return;
        }
        
        int opcao;
        do {
            System.out.println("\n--- Notas de " + aluno.getNome() + " ---");
            System.out.println("1 - Ver notas (ordem de lançamento)");
            System.out.println("2 - Ver notas ordenadas por valor (crescente)");
            System.out.println("3 - Ver notas ordenadas por valor (decrescente)");
            System.out.println("4 - Ver notas ordenadas por disciplina");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            if (sc.hasNextInt()){
                opcao = sc.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next();
                opcao = -1;
            }
            sc.nextLine(); 

            Nota[] notasDoAluno = null; 
            switch (opcao) {
                case 1: notasDoAluno = aluno.getNotas(); break;
                case 2: notasDoAluno = aluno.getNotasOrdenadasPorValor(true); break;
                case 3: notasDoAluno = aluno.getNotasOrdenadasPorValor(false); break;
                case 4: notasDoAluno = aluno.getNotasOrdenadasPorDisciplina(); break;
                case 0: return; 
                default: System.out.println("Opção inválida."); continue; 
            }

            if (notasDoAluno == null || notasDoAluno.length == 0) {
                System.out.println("Nenhuma nota para o critério selecionado.");
            } else {
                System.out.println("\nResultados para " + aluno.getNome() + ":");
                for (int i=0; i < notasDoAluno.length; i++) {
                    Nota n = notasDoAluno[i];
                    System.out.printf("Disciplina: %-15s | Nota: %.2f\n",
                            n.getDisciplina().getNome(), n.getNota());
                }
            }
        } while (opcao != 0);
    }
}