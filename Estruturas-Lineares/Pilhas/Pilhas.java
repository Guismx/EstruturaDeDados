
import java.util.Stack;
import java.util.Scanner;

class ConcessionariaPilha {

    // Classe Carro representando um carro
    static class Carro {
        String modelo;
        String marca;
        int ano;
        double preco;

        // Construtor da classe Carro
        public Carro(String modelo, String marca, int ano, double preco) {
            this.modelo = modelo;
            this.marca = marca;
            this.ano = ano;
            this.preco = preco;
        }

        // Sobrescrevendo o método toString para exibir as informações do carro de maneira legível
        @Override
        public String toString() {
            return "Modelo: " + modelo + ", Marca: " + marca + ", Ano: " + ano + ", Preço: R$ " + preco;
        }
    }

    // Pilha para armazenar os carros na concessionária
    static Stack<Carro> pilhaCarros = new Stack<>();

    // Método para adicionar um carro à pilha
    public static void adicionarCarro(Scanner scanner) {
        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite a marca do carro: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o ano de fabricação do carro: ");
        int ano = scanner.nextInt();
        System.out.print("Digite o preço do carro: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer de leitura

        Carro carro = new Carro(modelo, marca, ano, preco);
        pilhaCarros.push(carro); // Adiciona o carro no topo da pilha
        System.out.println("Carro adicionado à pilha!");
    }

    // Método para remover um carro da pilha
    public static void removerCarro() {
        if (!pilhaCarros.isEmpty()) {
            Carro carroRemovido = pilhaCarros.pop(); // Remove o carro do topo da pilha
            System.out.println("Carro removido: " + carroRemovido);
        } else {
            System.out.println("Não há carros para remover.");
        }
    }

    // Método para listar os carros na pilha
    public static void listarCarros() {
        if (pilhaCarros.isEmpty()) {
            System.out.println("Não há carros na pilha.");
        } else {
            System.out.println("Carros na pilha:");
            for (Carro carro : pilhaCarros) {
                System.out.println(carro);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== Concessionária (Pilha) =====");
            System.out.println("1. Adicionar carro");
            System.out.println("2. Remover carro");
            System.out.println("3. Listar carros");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de leitura

            switch (opcao) {
                case 1:
                    adicionarCarro(scanner); // Adiciona um carro à pilha
                    break;
                case 2:
                    removerCarro(); // Remove um carro da pilha
                    break;
                case 3:
                    listarCarros(); // Lista os carros na pilha
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 4);

        scanner.close(); // Fechar o scanner após o uso
    }
}
