import java.util.ArrayList;
import java.util.Scanner;

class AlocacaoDinamica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando uma lista dinâmica para armazenar alunos
        ArrayList<Aluno1> listaAlunos = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Remover Aluno");
            System.out.println("3. Listar Alunos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    // Adicionando um novo aluno dinamicamente
                    System.out.print("Nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade do aluno: ");
                    int idade = scanner.nextInt();
                    System.out.print("Nota do aluno: ");
                    double nota = scanner.nextDouble();

                    listaAlunos.add(new Aluno1(nome, idade, nota));
                    System.out.println("Aluno adicionado com sucesso!");
                    break;

                case 2:
                    // Removendo um aluno pelo índice
                    if (listaAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado para remover.");
                    } else {
                        System.out.print("Informe o índice do aluno a ser removido (0 a " + (listaAlunos.size() - 1) + "): ");
                        int indice = scanner.nextInt();
                        if (indice >= 0 && indice < listaAlunos.size()) {
                            listaAlunos.remove(indice);
                            System.out.println("Aluno removido com sucesso.");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    break;

                case 3:
                    // Listando todos os alunos
                    if (listaAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                    } else {
                        System.out.println("\nLista de Alunos:");
                        for (int i = 0; i < listaAlunos.size(); i++) {
                            System.out.print("[" + i + "] ");
                            listaAlunos.get(i).exibirInformacoes();
                        }
                    }
                    break;

                case 4:
                    // Encerrando o programa
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}

// Classe auxiliar para representar um Aluno
class Aluno1 {
    private String nome;
    private int idade;
    private double nota;

    // Construtor para inicializar o aluno
    public Aluno1(String nome, int idade, double nota) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }

    // Método para exibir informações do aluno
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome + ", Idade: " + idade + ", Nota: " + nota);
    }
}
