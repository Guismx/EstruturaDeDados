import java.util.Scanner;

public class Main {
    // array para armazenar até 10 turmas inicialmente
    private static Turma[] turmas = new Turma[10];
    // contador para quantidade de turmas cadastradas
    private static int qtdTurmas = 0;
    // array para armazenar até 10 disciplinas globais inicialmente
    private static Disciplina[] disciplinas = new Disciplina[10];
    // contador para quantidade de disciplinas globais cadastradas
    private static int qtdDisciplinas = 0;
    // scanner para leitura de entrada do usuário
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            // exibe o menu principal com opções para o usuário
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Adicionar (aluno/disciplina à turma)");
            System.out.println("3 - Lançar nota");
            System.out.println("4 - Visualizar");
            System.out.println("5 - Remover");
            System.out.println("6 - Ranking de Alunos por Média");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            // verifica se a entrada é um número inteiro
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
            } else {
                // entrada inválida, descarta o valor e define opção inválida
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next();
                opcao = -1;
            }
            sc.nextLine(); // consome a quebra de linha após a entrada

            // seleciona a ação conforme a opção escolhida
            switch (opcao) {
                case 1:
                    menuCadastrar(); // abre o menu para cadastro
                    break;
                case 2:
                    menuAdicionar(); // abre o menu para adicionar aluno/disciplina
                    break;
                case 3:
                    lancarNota(); // função para lançar notas dos alunos
                    break;
                case 4:
                    menuVisualizar(); // menu para visualizar dados (não implementado aqui)
                    break;
                case 5:
                    menuRemover(); // menu para remover dados (não implementado aqui)
                    break;
                case 6:
                    rankingNotas(); // exibe ranking de alunos por média (não implementado aqui)
                    break;
                case 0:
                    System.out.println("Saindo..."); // finaliza o programa
                    break;
                default:
                    System.out.println("Opção inválida."); // trata opções fora do menu
            }
        } while (opcao != 0); // repete o menu até o usuário escolher sair
        sc.close(); // fecha o scanner para liberar recurso
    }

    // menu para cadastro de turmas, disciplinas e alunos
    private static void menuCadastrar() {
        int opcao;
        do {
            System.out.println("\n--- Menu Cadastrar ---");
            System.out.println("1 - Cadastrar Turma");
            System.out.println("2 - Cadastrar Disciplina (global para o sistema)");
            System.out.println("3 - Cadastrar Aluno (e associar a uma turma)");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next();
                opcao = -1;
            }
            sc.nextLine();

            // chama o método correspondente à opção selecionada
            switch (opcao) {
                case 1:
                    cadastrarTurma();
                    break;
                case 2:
                    cadastrarDisciplinaGlobal();
                    break;
                case 3:
                    cadastrarAluno();
                    break;
                case 0:
                    break; // sai do menu cadastrar
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0); // repete até o usuário escolher voltar
    }

    // cadastra uma nova turma, expandindo array se necessário
    private static void cadastrarTurma() {
        // verifica se precisa aumentar capacidade do array de turmas
        if (qtdTurmas >= turmas.length) {
            Turma[] novoArray = new Turma[turmas.length * 2];
            System.arraycopy(turmas, 0, novoArray, 0, turmas.length);
            turmas = novoArray;
            System.out.println("Capacidade de turmas expandida.");
        }
        System.out.print("ID da Turma: ");
        int id = sc.nextInt();
        sc.nextLine();

        // verifica se já existe turma com o mesmo id
        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i] != null && turmas[i].getId() == id) {
                System.out.println("Erro: ID de turma já existente.");
                return; // interrompe cadastro
            }
        }

        System.out.print("Nome da Turma: ");
        String nome = sc.nextLine();
        System.out.print("Ano da Turma: ");
        int ano = sc.nextInt();
        sc.nextLine();
        System.out.print("Capacidade inicial de alunos da turma: ");
        int capAlunos = sc.nextInt();
        sc.nextLine();
        System.out.print("Capacidade inicial de disciplinas da turma: ");
        int capDisc = sc.nextInt();
        sc.nextLine();

        // cria a nova turma com os dados fornecidos
        Turma turma = new Turma(id, nome, ano, capAlunos, capDisc);
        turmas[qtdTurmas++] = turma; // adiciona turma no array e incrementa contador
        System.out.println("Turma cadastrada com sucesso!");
    }

    // cadastra uma disciplina global ao sistema, com expansão dinâmica
    private static void cadastrarDisciplinaGlobal() {
        // verifica se é necessário expandir o array de disciplinas globais
        if (qtdDisciplinas >= disciplinas.length) {
            Disciplina[] novoArray = new Disciplina[disciplinas.length * 2];
            System.arraycopy(disciplinas, 0, novoArray, 0, disciplinas.length);
            disciplinas = novoArray;
            System.out.println("Capacidade de disciplinas globais expandida.");
        }
        System.out.print("Nome da Disciplina: ");
        String nome = sc.nextLine();

        // impede cadastro de disciplina com nome duplicado
        if (buscarDisciplinaGlobalPorNome(nome) != null) {
            System.out.println("Erro: Disciplina com este nome já cadastrada no sistema.");
            return;
        }

        System.out.print("Nome do Professor: ");
        String professor = sc.nextLine();
        System.out.print("Turno (Manhã, Tarde, Noite): ");
        String turno = sc.nextLine();

        // adiciona a disciplina global no array e incrementa contador
        disciplinas[qtdDisciplinas++] = new Disciplina(nome, professor, turno);
        System.out.println("Disciplina cadastrada globalmente com sucesso!");
    }

    // cadastra um aluno e associa ele a uma turma existente
    private static void cadastrarAluno() {
        // verifica se existe alguma turma cadastrada para associar o aluno
        if (qtdTurmas == 0) {
            System.out.println("Nenhuma turma cadastrada. Cadastre uma turma primeiro.");
            return;
        }
        // escolhe a turma para adicionar o aluno
        Turma turma = escolherTurma("para adicionar o aluno");
        if (turma == null)
            return;

        System.out.print("Nome do Aluno: ");
        String nome = sc.nextLine();
        System.out.print("Número de Matrícula: ");
        int matricula = sc.nextInt();
        sc.nextLine();

        // verifica se matrícula já existe na turma para evitar duplicidade
        Aluno[] alunosDaTurma = turma.getAlunos();
        for (int i = 0; i < alunosDaTurma.length; i++) {
            if (alunosDaTurma[i].getNumeroMatricula() == matricula) {
                System.out.println("Erro: Aluno com esta matrícula já existe nesta turma.");
                return;
            }
        }

        // cria aluno e adiciona na turma escolhida
        Aluno aluno = new Aluno(nome, matricula, turma);
        turma.adicionarAluno(aluno);
        System.out.println("Aluno " + nome + " cadastrado e adicionado à turma " + turma.getNome() + ".");
    }

    // menu para adicionar disciplinas globais a turmas
    private static void menuAdicionar() {
        int opcao;
        do {
            System.out.println("\n--- Menu Adicionar ---");
            System.out.println("1 - Adicionar disciplina (global) a uma turma");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next();
                opcao = -1;
            }
            sc.nextLine();

            // executa ação conforme opção
            switch (opcao) {
                case 1:
                    adicionarDisciplinaTurma();
                    break;
                case 0:
                    break; // sai do menu adicionar
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // adiciona uma disciplina global já cadastrada a uma turma selecionada
    private static void adicionarDisciplinaTurma() {
        // verifica existência de turmas e disciplinas globais
        if (qtdTurmas == 0) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }
        if (qtdDisciplinas == 0) {
            System.out.println("Nenhuma disciplina global cadastrada.");
            return;
        }

        // escolhe turma para adicionar a disciplina
        Turma turma = escolherTurma("para adicionar a disciplina");
        if (turma == null)
            return;

        System.out.println("Disciplinas globais disponíveis:");
        listarDisciplinasGlobais(); // exibe lista de disciplinas globais cadastradas

        System.out.print("Nome da disciplina global para adicionar à turma: ");
        String nomeDisc = sc.nextLine();
        // busca disciplina global pelo nome informado
        Disciplina disciplinaGlobal = buscarDisciplinaGlobalPorNome(nomeDisc);

        if (disciplinaGlobal == null) {
            System.out.println("Disciplina global não encontrada.");
            return;
        }

        // verifica se a disciplina já foi adicionada à turma para evitar duplicidade
        Disciplina[] disciplinasDaTurma = turma.getDisciplinas();
        for (int i = 0; i < disciplinasDaTurma.length; i++) {
            if (disciplinasDaTurma[i].getNome().equalsIgnoreCase(disciplinaGlobal.getNome())) {
                System.out.println("Esta disciplina já foi adicionada à turma " + turma.getNome());
                return;
            }
        }

        // adiciona a disciplina na turma
        turma.adicionarDisciplina(disciplinaGlobal);
        System.out.println("Disciplina '" + nomeDisc + "' adicionada à turma '" + turma.getNome() + "'.");
    }

    // método para lançar nota de alunos (incompleto no trecho enviado)
    private static void lancarNota() {
        // verifica se há turmas cadastradas no sistema
        if (qtdTurmas == 0) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        // busca um aluno globalmente pelo nome para lançamento de nota
        Aluno aluno = buscarAlunoGlobalPorNome("para lançamento de nota");
        if (aluno == null) {
            System.out.println("Aluno não encontrado no sistema.");
            return;
        }

        // obtém a turma do aluno selecionado
        Turma turmaDoAluno = aluno.getTurma();
        // verifica se a turma possui disciplinas cadastradas
        if (turmaDoAluno.getQtdDisciplinas() == 0) {
            System.out.println("A turma do aluno (" + turmaDoAluno.getNome() + ") não possui disciplinas.");
            return;
        }

        // exibe as disciplinas disponíveis da turma para o aluno
        System.out.println("Disciplinas disponíveis na turma " + turmaDoAluno.getNome() + " para o aluno "
                + aluno.getNome() + ":");
        listarDisciplinasDaTurma(turmaDoAluno);

        // solicita o nome da disciplina para lançar a nota
        System.out.print("Nome da disciplina para lançar a nota: ");
        String nomeDisc = sc.nextLine();

        // procura a disciplina na turma do aluno
        Disciplina disciplinaNaTurma = null;
        Disciplina[] disciplinasDaTurma = turmaDoAluno.getDisciplinas();
        for (int i = 0; i < disciplinasDaTurma.length; i++) {
            if (disciplinasDaTurma[i].getNome().equalsIgnoreCase(nomeDisc)) {
                disciplinaNaTurma = disciplinasDaTurma[i];
                break;
            }
        }

        // se disciplina não for encontrada na turma, exibe mensagem e retorna
        if (disciplinaNaTurma == null) {
            System.out.println("Disciplina não encontrada na turma do aluno.");
            return;
        }

        // solicita o valor da nota a ser lançada, validando entrada e intervalo
        System.out.print("Digite a nota (0.0 a 10.0): ");
        double valorNota;
        if (sc.hasNextDouble()) {
            valorNota = sc.nextDouble();
            if (valorNota < 0.0 || valorNota > 10.0) {
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

        // adiciona a nota ao aluno para a disciplina selecionada
        aluno.adicionarNota(new Nota(valorNota, aluno, disciplinaNaTurma));
        System.out.println("Nota lançada com sucesso para " + aluno.getNome() + " na disciplina "
                + disciplinaNaTurma.getNome() + ".");
    }

    private static void menuVisualizar() {
        int opcao;
        do {
            // exibe o menu de opções para visualizar dados do sistema
            System.out.println("\n--- Menu Visualizar ---");
            System.out.println("1 - Listar todas as turmas cadastradas");
            System.out.println("2 - Detalhar uma turma específica");
            System.out.println("3 - Visualizar notas de um aluno específico");
            System.out.println("4 - Listar todas as disciplinas globais cadastradas");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next();
                opcao = -1;
            }
            sc.nextLine();

            // executa a ação conforme a opção escolhida
            switch (opcao) {
                case 1:
                    listarTurmas();
                    break;
                case 2:
                    detalharTurma();
                    break;
                case 3:
                    visualizarNotasAlunoEspecifico();
                    break;
                case 4:
                    listarDisciplinasGlobaisComDetalhes();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void detalharTurma() {
        // permite escolher uma turma para visualizar detalhes
        Turma turma = escolherTurma("para detalhar");
        if (turma == null)
            return;

        int opcao;
        do {
            // exibe o menu de detalhes para a turma selecionada
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
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next();
                opcao = -1;
            }
            sc.nextLine();

            // executa a ação conforme a opção escolhida no menu de detalhes
            switch (opcao) {
                case 1:
                    // ordena alunos por nome e exibe lista
                    turma.ordenarAlunosPorNome();
                    Aluno[] alunos = turma.getAlunos();
                    System.out.println("Alunos da Turma " + turma.getNome() + " (ordenados por nome):");
                    if (alunos.length == 0)
                        System.out.println("Nenhum aluno nesta turma.");
                    for (int i = 0; i < alunos.length; i++) {
                        System.out.println(
                                "- " + alunos[i].getNome() + " (Matrícula: " + alunos[i].getNumeroMatricula() + ")");
                    }
                    break;
                case 2:
                    // exibe disciplinas da turma
                    turma.exibirDisciplinas();
                    break;
                case 3:
                    // exibe todas as notas da turma ordenadas por valor crescente
                    exibirListaDeNotas(turma.getTodasNotasDaTurmaOrdenadasPorValor(true),
                            "Notas da Turma " + turma.getNome() + " (Valor Crescente)");
                    break;
                case 4:
                    // exibe todas as notas da turma ordenadas por valor decrescente
                    exibirListaDeNotas(turma.getTodasNotasDaTurmaOrdenadasPorValor(false),
                            "Notas da Turma " + turma.getNome() + " (Valor Decrescente)");
                    break;
                case 5:
                    // exibe todas as notas da turma ordenadas por disciplina
                    exibirListaDeNotas(turma.getTodasNotasDaTurmaOrdenadasPorDisciplina(),
                            "Notas da Turma " + turma.getNome() + " (Por Disciplina)");
                    break;
                case 6:
                    // solicita faixa de média e lista alunos que se enquadram nela
                    System.out.print("Média mínima: ");
                    double min = sc.nextDouble();
                    System.out.print("Média máxima: ");
                    double max = sc.nextDouble();
                    sc.nextLine();
                    turma.listarAlunosPorFaixaDeMedia(min, max);
                    break;
                case 7:
                    // solicita nome da disciplina e exibe notas da turma para esta disciplina
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
        // exibe no console o título da funcionalidade para o usuário saber o que está
        // fazendo
        System.out.println("--- Visualizar Notas de Aluno Específico ---");

        // chama método para buscar aluno globalmente pelo nome
        // o parâmetro é uma mensagem para o usuário entender o motivo do pedido do nome
        Aluno aluno = buscarAlunoGlobalPorNome("para visualizar as notas");

        // verifica se o aluno foi encontrado, ou seja, se o método retornou um objeto
        // válido
        if (aluno == null) {
            // informa que o aluno não foi encontrado no sistema
            System.out.println("Aluno não encontrado no sistema.");
            // termina a execução deste método pois não há aluno para mostrar as notas
            return;
        }

        // se o aluno foi encontrado, chama o método para exibir suas notas detalhadas
        exibirNotasDeAluno(aluno);
    }

    private static void listarDisciplinasGlobaisComDetalhes() {
        // imprime o título da listagem detalhada de todas as disciplinas cadastradas
        System.out.println("\n--- Todas as Disciplinas Cadastradas no Sistema ---");

        // verifica se a quantidade de disciplinas cadastradas é zero, ou seja, se não
        // há disciplinas
        if (qtdDisciplinas == 0) {
            // informa que não existem disciplinas cadastradas
            System.out.println("Nenhuma disciplina cadastrada no sistema.");
            // finaliza o método pois não há dados para mostrar
            return;
        }

        // percorre o array de disciplinas até a quantidade cadastrada
        for (int i = 0; i < qtdDisciplinas; i++) {
            // pega a disciplina na posição atual do array
            Disciplina d = disciplinas[i];
            // verifica se a disciplina não é nula (existe de fato)
            if (d != null) {
                // imprime os dados da disciplina formatados: nome, professor e turno
                System.out.printf("Nome: %s, Professor: %s, Turno: %s\n",
                        d.getNome(), d.getProfessor(), d.getTurno());
            }
        }
    }

    private static void menuRemover() {
        // exibe o menu com opções de remoção para o usuário escolher o que deseja fazer
        System.out.println("\n--- Menu Remover ---");
        System.out.println("1 - Remover turma");
        System.out.println("2 - Remover aluno de uma turma");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");

        // lê a opção escolhida pelo usuário via entrada padrão (teclado)
        int op = sc.nextInt();
        sc.nextLine(); // consome a quebra de linha pendente para evitar problemas no próximo input

        // avalia a opção escolhida utilizando switch
        switch (op) {
            case 1:
                // chama o método responsável por remover uma turma
                removerTurma();
                break;
            case 2:
                // chama o método responsável por remover um aluno de uma turma
                removerAlunoDeTurma();
                break;
            case 0:
                // opção para voltar, não faz nada e sai do menu
                break;
            default:
                // caso o usuário digite uma opção inválida, exibe mensagem de erro
                System.out.println("Opção inválida.");
        }
    }

    private static void removerTurma() {
        // verifica se há alguma turma cadastrada no sistema para poder remover
        if (qtdTurmas == 0) {
            // caso não haja turmas, informa ao usuário e retorna para evitar erro
            System.out.println("Nenhuma turma para remover.");
            return;
        }

        // lista as turmas existentes para que o usuário possa escolher qual remover
        listarTurmas();

        // pede para o usuário informar o ID da turma que deseja remover
        System.out.print("ID da turma a remover: ");
        int id = sc.nextInt(); // lê o ID da turma
        sc.nextLine(); // consome a quebra de linha

        // variável para armazenar o índice da turma no array, inicializada com -1 (não
        // encontrada)
        int indiceRemover = -1;

        // percorre todas as turmas cadastradas para encontrar o índice da turma com o
        // ID informado
        for (int i = 0; i < qtdTurmas; i++) {
            // verifica se a turma existe e se o ID dela é igual ao informado pelo usuário
            if (turmas[i] != null && turmas[i].getId() == id) {
                // se encontrou, guarda o índice e para o loop
                indiceRemover = i;
                break;
            }
        }

        // verifica se encontrou a turma a ser removida (indiceRemover diferente de -1)
        if (indiceRemover != -1) {
            // desloca todos os elementos seguintes uma posição para a esquerda para
            // "remover" a turma
            for (int i = indiceRemover; i < qtdTurmas - 1; i++) {
                turmas[i] = turmas[i + 1];
            }
            // decrementa a quantidade de turmas cadastradas e seta a última posição como
            // null para liberar espaço
            turmas[--qtdTurmas] = null;

            // informa que a turma foi removida com sucesso
            System.out.println("Turma removida!");
        } else {
            // se não encontrou a turma, informa que o ID não corresponde a nenhuma turma
            // cadastrada
            System.out.println("Turma com ID " + id + " não encontrada.");
        }
    }

    private static void removerAlunoDeTurma() {
        // exibe título para o menu de remoção de aluno
        System.out.println("--- Remover Aluno de uma Turma ---");

        // busca o aluno pelo nome globalmente, pedindo o nome para o usuário
        Aluno aluno = buscarAlunoGlobalPorNome("para remover da turma");

        // verifica se o aluno foi encontrado, se não, informa e retorna
        if (aluno == null) {
            System.out.println("Aluno não encontrado no sistema.");
            return;
        }

        // obtém a turma que o aluno está associado (referência da turma)
        Turma turmaDoAluno = aluno.getTurma();

        // tenta remover o aluno da turma, passando o número de matrícula dele para
        // identificar
        boolean removido = turmaDoAluno.removerAlunoPorMatricula(aluno.getNumeroMatricula());

        // verifica se a remoção foi bem sucedida
        if (removido) {
            // informa que o aluno foi removido com sucesso da turma
            System.out.println("Aluno " + aluno.getNome() + " removido da turma " + turmaDoAluno.getNome() + ".");
        } else {
            // se não conseguiu remover, informa erro, pois o aluno não foi encontrado na
            // turma
            System.out.println("Erro: Aluno " + aluno.getNome() + " não pode ser removido da turma "
                    + turmaDoAluno.getNome() + " (não encontrado na turma).");
        }
    }

    private static void rankingNotas() {
        // solicita ao usuário que escolha uma turma para exibir ranking, passando
        // mensagem para facilitar
        Turma turma = escolherTurma("para exibir o ranking de alunos");

        // verifica se turma foi escolhida, se não, retorna para evitar erros
        if (turma == null)
            return;

        // verifica se a turma possui alunos cadastrados, se não, informa e retorna
        if (turma.getQtdAlunos() == 0) {
            System.out.println("A turma " + turma.getNome() + " não possui alunos.");
            return;
        }

        // exibe o menu de opções para escolher a ordem do ranking (decrescente ou
        // crescente)
        System.out.println("\n--- Ranking de Alunos por Média da Turma: " + turma.getNome() + " ---");
        System.out.println("1 - Ranking por média (decrescente - melhores primeiro)");
        System.out.println("2 - Ranking por média (crescente - piores primeiro)");
        System.out.print("Escolha a ordem do ranking: ");

        // lê a opção do usuário para a ordenação
        int ordem = sc.nextInt();
        sc.nextLine();

        // variavel para definir se a ordenação será crescente ou não
        boolean crescente;

        // define a ordenação baseada na escolha: 1 para decrescente, 2 para crescente
        if (ordem == 1)
            crescente = false;
        else if (ordem == 2)
            crescente = true;
        else {
            // caso opção inválida, informa o usuário e retorna
            System.out.println("Opção inválida.");
            return;
        }

        // obtém o array de alunos ordenados pela média da turma, segundo a ordem
        // escolhida
        Aluno[] alunosOrdenados = turma.getAlunosOrdenadosPorMedia(crescente);

        System.out.println("\n--- Ranking ---");

        // verifica se existem alunos com notas para exibir no ranking
        if (alunosOrdenados.length == 0) {
            System.out.println("Não há alunos com notas lançadas nesta turma para exibir no ranking.");
            return;
        }

        // percorre os alunos ordenados e imprime nome, matrícula e média formatados
        for (int i = 0; i < alunosOrdenados.length; i++) {
            Aluno a = alunosOrdenados[i];
            System.out.printf("Aluno: %s, Matrícula: %d, Média: %.2f\n",
                    a.getNome(), a.getNumeroMatricula(), a.calcularMedia());
        }
    }

    private static void listarTurmas() {
        // exibe título para listagem de turmas cadastradas
        System.out.println("\n--- Turmas Cadastradas ---");

        // verifica se não existem turmas cadastradas, se não, informa e retorna
        if (qtdTurmas == 0) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        // percorre o array de turmas cadastradas
        for (int i = 0; i < qtdTurmas; i++) {
            // verifica se a turma não é nula antes de acessar seus dados
            if (turmas[i] != null) {
                // imprime ID, nome e ano da turma formatados
                System.out.println("ID: " + turmas[i].getId() + " - Nome: " + turmas[i].getNome() + " ("
                        + turmas[i].getAno() + ")");
            }
        }
    }

    private static void listarDisciplinasGlobais() {
        // exibe título para listar todas as disciplinas globais disponíveis
        System.out.println("\n--- Disciplinas Globais Disponíveis no Sistema ---");

        // verifica se não existem disciplinas cadastradas, se não, informa e retorna
        if (qtdDisciplinas == 0) {
            System.out.println("Nenhuma disciplina global cadastrada.");
            return;
        }

        // percorre o array de disciplinas globais
        for (int i = 0; i < qtdDisciplinas; i++) {
            // verifica se a disciplina existe antes de exibir
            if (disciplinas[i] != null) {
                // exibe o nome da disciplina com um marcador
                System.out.println("- " + disciplinas[i].getNome());
            }
        }
    }

    private static void listarDisciplinasDaTurma(Turma turma) {
        // exibe título com o nome da turma para indicar que vai listar disciplinas
        // associadas a ela
        System.out.println("Disciplinas da Turma " + turma.getNome() + ":");

        // obtém o array de disciplinas vinculadas a essa turma
        Disciplina[] disciplinasDaTurma = turma.getDisciplinas();

        // verifica se não há disciplinas associadas, se não, informa e retorna
        if (disciplinasDaTurma.length == 0) {
            System.out.println("Nenhuma disciplina associada a esta turma.");
            return;
        }

        // percorre as disciplinas da turma e exibe nome e professor de cada uma
        for (int i = 0; i < disciplinasDaTurma.length; i++) {
            Disciplina d = disciplinasDaTurma[i];
            System.out.println("- " + d.getNome() + " (Professor: " + d.getProfessor() + ")");
        }
    }

    private static Turma escolherTurma(String motivo) {
        // verifica se existem turmas cadastradas, caso não exista, informa e retorna
        // null
        if (qtdTurmas == 0) {
            System.out.println("Nenhuma turma cadastrada no sistema.");
            return null;
        }

        // exibe as turmas disponíveis e o motivo da escolha (mensagem opcional)
        System.out.println("Turmas disponíveis" + (motivo.isEmpty() ? "" : " " + motivo) + ":");

        // lista as turmas para que o usuário escolha pelo ID
        listarTurmas();

        // solicita ao usuário o ID da turma desejada
        System.out.print("Digite o ID da turma desejada: ");
        int idTurma = sc.nextInt();
        sc.nextLine();

        // percorre as turmas para encontrar a turma com o ID informado
        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i] != null && turmas[i].getId() == idTurma) {
                // retorna a turma encontrada para uso posterior
                return turmas[i];
            }
        }

        // caso não encontre turma com o ID informado, informa e retorna null
        System.out.println("Turma com ID " + idTurma + " não encontrada.");
        return null;
    }

    private static Disciplina buscarDisciplinaGlobalPorNome(String nome) {
        // percorre todas as disciplinas globais cadastradas
        for (int i = 0; i < qtdDisciplinas; i++) {
            // verifica se a disciplina atual existe e se seu nome bate com o nome
            // pesquisado (ignorando maiúsculas/minúsculas)
            if (disciplinas[i] != null && disciplinas[i].getNome().equalsIgnoreCase(nome)) {
                // retorna a disciplina encontrada
                return disciplinas[i];
            }
        }
        // caso não encontre nenhuma disciplina com o nome pesquisado, retorna null
        return null;
    }

    private static Aluno buscarAlunoGlobalPorNome(String motivo) {
        // verifica se existem turmas cadastradas, se não, retorna null pois não há
        // alunos para buscar
        if (qtdTurmas == 0) {
            return null;
        }

        // solicita ao usuário o nome do aluno, explicando o motivo da busca
        System.out.print("Digite o nome do aluno" + (motivo.isEmpty() ? "" : " " + motivo) + ": ");
        String nomeAluno = sc.nextLine();

        // percorre todas as turmas cadastradas para buscar o aluno
        for (int i = 0; i < qtdTurmas; i++) {
            if (turmas[i] != null) {
                // obtém o array de alunos da turma atual
                Aluno[] alunosDaTurma = turmas[i].getAlunos();
                // percorre os alunos da turma
                for (int j = 0; j < alunosDaTurma.length; j++) {
                    Aluno aluno = alunosDaTurma[j];
                    // verifica se o nome do aluno atual bate com o nome pesquisado (ignorando
                    // maiúsculas/minúsculas)
                    if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
                        // retorna o aluno encontrado
                        return aluno;
                    }
                }
            }
        }
        // caso não encontre nenhum aluno com o nome informado, retorna null
        return null;
    }

    private static void exibirListaDeNotas(Nota[] notas, String titulo) {
        // exibe o título para o grupo de notas que será mostrado
        System.out.println("\n--- " + titulo + " ---");

        // verifica se o array de notas está vazio ou nulo, se sim, informa e retorna
        if (notas == null || notas.length == 0) {
            System.out.println("Nenhuma nota encontrada para exibir.");
            return;
        }

        // percorre o array de notas para exibir detalhes de cada uma
        for (int i = 0; i < notas.length; i++) {
            Nota n = notas[i];
            // imprime nome do aluno, nome da disciplina e valor da nota formatados
            System.out.printf("Aluno: %-20s | Disciplina: %-15s | Nota: %.2f\n",
                    n.getAluno().getNome(), n.getDisciplina().getNome(), n.getNota());
        }
    }

    private static void exibirNotasDeAluno(Aluno aluno) {
        // verifica se o aluno tem notas cadastradas, se não tiver, informa e retorna
        if (aluno.getQtdNotas() == 0) {
            System.out.println("O aluno " + aluno.getNome() + " não possui notas lançadas.");
            return;
        }

        int opcao;
        do {
            // exibe menu para o usuário escolher como quer visualizar as notas do aluno
            System.out.println("\n--- Notas de " + aluno.getNome() + " ---");
            System.out.println("1 - Ver notas (ordem de lançamento)");
            System.out.println("2 - Ver notas ordenadas por valor (crescente)");
            System.out.println("3 - Ver notas ordenadas por valor (decrescente)");
            System.out.println("4 - Ver notas ordenadas por disciplina");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            // valida se a entrada é um inteiro para evitar erro
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
            } else {
                // caso a entrada não seja número, informa erro e limpa buffer
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next();
                opcao = -1; // define opção inválida para continuar loop
            }
            sc.nextLine(); // consome o fim de linha

            Nota[] notasDoAluno = null;
            // avalia a opção escolhida e chama o método apropriado para obter as notas
            // ordenadas
            switch (opcao) {
                case 1:
                    // retorna notas na ordem original de lançamento
                    notasDoAluno = aluno.getNotas();
                    break;
                case 2:
                    // retorna notas ordenadas em ordem crescente (menor para maior)
                    notasDoAluno = aluno.getNotasOrdenadasPorValor(true);
                    break;
                case 3:
                    // retorna notas ordenadas em ordem decrescente (maior para menor)
                    notasDoAluno = aluno.getNotasOrdenadasPorValor(false);
                    break;
                case 4:
                    // retorna notas ordenadas por nome da disciplina
                    notasDoAluno = aluno.getNotasOrdenadasPorDisciplina();
                    break;
                case 0:
                    // volta para o menu anterior
                    break;
                default:
                    // caso opção inválida, exibe mensagem de erro
                    System.out.println("Opção inválida.");
            }

            // se alguma opção válida foi escolhida (exceto 0), exibe a lista de notas
            if (notasDoAluno != null) {
                exibirListaDeNotas(notasDoAluno, "Notas de " + aluno.getNome());
            }
        } while (opcao != 0); // repete até o usuário escolher voltar (opção 0)
    }
}