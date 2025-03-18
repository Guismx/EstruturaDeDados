import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Concessionaria {

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

    // Lista para armazenar os carros na concessionária
    // Usamos uma lista do tipo ArrayList para armazenar os carros disponíveis.
    // A lista é dinâmica, ou seja, seu tamanho pode aumentar ou diminuir conforme os carros são adicionados ou removidos.
    static List<Carro> listaCarros = new ArrayList<>();

    // Método para adicionar um carro à lista
    public static void adicionarCarro() {
        Scanner scanner = new Scanner(System.in);

        // Solicitando os dados do carro ao usuário
        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite a marca do carro: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o ano de fabricação do carro: ");
        int ano = scanner.nextInt();
        System.out.print("Digite o preço do carro: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();  // Limpar o buffer de leitura

        // Criando um carro com os dados informados pelo usuário
        // O carro é então adicionado à lista de carros
        Carro carro = new Carro(modelo, marca, ano, preco);
        listaCarros.add(carro); // A operação de adição é feita através do método add da lista
        System.out.println("Carro adicionado com sucesso!");
    }

    // Método para remover um carro da lista
    public static void removerCarro() {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário o modelo do carro que deseja remover
        System.out.print("Digite o modelo do carro que deseja remover: ");
        String modelo = scanner.nextLine();

        // Variável para verificar se o carro foi removido com sucesso
        boolean removido = false;

        // Itera sobre a lista de carros para encontrar e remover o carro correspondente ao modelo informado
        for (int i = 0; i < listaCarros.size(); i++) { // Aqui estamos percorrendo a lista
            if (listaCarros.get(i).modelo.equalsIgnoreCase(modelo)) { // Verifica se o modelo do carro corresponde
                listaCarros.remove(i); // Remove o carro da lista
                removido = true;
                System.out.println("Carro removido com sucesso!");
                break; // Para o loop assim que o carro é removido
            }
        }

        // Caso o carro não tenha sido encontrado na lista
        if (!removido) {
            System.out.println("Carro não encontrado.");
        }
    }

    // Método para listar todos os carros disponíveis na concessionária
    public static void listarCarros() {
        // Verifica se a lista está vazia antes de tentar listar os carros
        if (listaCarros.isEmpty()) {
            System.out.println("Não há carros disponíveis na concessionária.");
        } else {
            System.out.println("Carros disponíveis:");
            // Itera sobre todos os carros da lista e imprime suas informações
            for (Carro carro : listaCarros) { // Aqui estamos percorrendo a lista para exibir os carros
                System.out.println(carro);
            }
        }
    }

    // Método para consultar um carro específico
    public static void consultarCarro() {
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário o modelo do carro a ser consultado
        System.out.print("Digite o modelo do carro que deseja consultar: ");
        String modelo = scanner.nextLine();

        // Variável para verificar se o carro foi encontrado na lista
        boolean encontrado = false;

        // Itera sobre a lista para procurar o carro pelo modelo
        for (Carro carro : listaCarros) { // Aqui estamos percorrendo a lista para encontrar o carro
            if (carro.modelo.equalsIgnoreCase(modelo)) {
                System.out.println("Detalhes do carro: " + carro);
                encontrado = true;
                break; // Para o loop quando o carro é encontrado
            }
        }

        // Caso o carro não tenha sido encontrado
        if (!encontrado) {
            System.out.println("Carro não encontrado.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            // Exibindo o menu de opções para o usuário
            System.out.println("\n===== Concessionária =====");
            System.out.println("1. Adicionar carro");
            System.out.println("2. Remover carro");
            System.out.println("3. Listar carros");
            System.out.println("4. Consultar carro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer de leitura

            // Ações de acordo com a opção escolhida
            switch (opcao) {
                case 1:
                    adicionarCarro(); // Chama o método para adicionar um carro
                    break;
                case 2:
                    removerCarro(); // Chama o método para remover um carro
                    break;
                case 3:
                    listarCarros(); // Chama o método para listar os carros disponíveis
                    break;
                case 4:
                    consultarCarro(); // Chama o método para consultar um carro específico
                    break;
                case 5:
                    System.out.println("Saindo..."); // Finaliza o programa
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente."); // Caso o usuário insira uma opção inválida
                    break;
            }
        } while (opcao != 5); // O menu se repete até o usuário escolher sair
    }
}
