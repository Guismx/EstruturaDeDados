import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Simulação de um sistema de atendimento de clientes em uma concessionária.
 *
 * O programa utiliza o conceito de filas (FIFO - First In First Out) para representar o atendimento dos clientes.
 * Os clientes entram na fila com informações como nome, idade e tipo de carro de interesse.
 * O sistema permite adicionar clientes à fila, atender clientes na ordem de chegada e exibir o estado da fila.
 *
 * Funcionalidades:
 * 1. Adicionar clientes à fila de atendimento.
 * 2. Atender o próximo cliente na fila.
 * 3. Exibir a fila de atendimento.
 * 4. Verificar se a fila está vazia.
 * 5. Permitir que o usuário escolha entre as opções de interação.
 */

class Cliente {
    private String nome;
    private int idade;
    private String tipoDeCarroInteressado;

    // Construtor da classe Cliente
    public Cliente(String nome, int idade, String tipoDeCarroInteressado) {
        this.nome = nome;
        this.idade = idade;
        this.tipoDeCarroInteressado = tipoDeCarroInteressado;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public String getTipoDeCarroInteressado() {
        return tipoDeCarroInteressado;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " (Idade: " + idade + ", Carro: " + tipoDeCarroInteressado + ")";
    }
}

class Concessionaria {
    // Fila de atendimento, que é uma Queue (Primeiro a entrar, primeiro a sair)
    private Queue<Cliente> filaDeAtendimento;

    // Construtor da concessionária
    public Concessionaria() {
        // Inicializando a fila usando LinkedList como implementação da Queue
        filaDeAtendimento = new LinkedList<>();
    }

    // Método para adicionar um cliente à fila
    public void adicionarCliente(Cliente cliente) {
        filaDeAtendimento.add(cliente); // A fila recebe o novo cliente no final
        System.out.println(cliente.getNome() + " entrou na fila.");
    }

    // Método para atender o próximo cliente da fila
    public void atenderProximoCliente() {
        if (filaDeAtendimento.isEmpty()) { // Verifica se a fila está vazia
            System.out.println("Não há clientes na fila.");
        } else {
            // O método poll() remove e retorna o primeiro cliente da fila (FIFO)
            Cliente clienteAtendido = filaDeAtendimento.poll();
            System.out.println("Atendendo o cliente: " + clienteAtendido);
        }
    }

    // Método para mostrar a fila de atendimento
    public void mostrarFila() {
        if (filaDeAtendimento.isEmpty()) { // Verifica se a fila está vazia
            System.out.println("A fila de atendimento está vazia.");
        } else {
            System.out.println("Fila de atendimento: ");
            // Itera sobre todos os clientes na fila e os exibe
            for (Cliente cliente : filaDeAtendimento) {
                System.out.println(cliente);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // Criando a concessionária
        Concessionaria concessionaria = new Concessionaria();
        Scanner scanner = new Scanner(System.in);

        // Loop principal para interação com o usuário
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar cliente à fila");
            System.out.println("2. Atender o próximo cliente");
            System.out.println("3. Mostrar fila de atendimento");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    // Adicionando cliente à fila
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a idade do cliente: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer de entrada
                    System.out.print("Digite o tipo de carro de interesse (SUV, Sedan, etc.): ");
                    String tipoDeCarro = scanner.nextLine();
                    // Criando um novo cliente com os dados fornecidos
                    Cliente novoCliente = new Cliente(nome, idade, tipoDeCarro);
                    // Adicionando o cliente à fila de atendimento
                    concessionaria.adicionarCliente(novoCliente);
                    break;

                case 2:
                    // Atendendo o próximo cliente (retira da fila e exibe)
                    concessionaria.atenderProximoCliente();
                    break;

                case 3:
                    // Exibindo a fila de atendimento
                    concessionaria.mostrarFila();
                    break;

                case 4:
                    // Saindo do programa
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
