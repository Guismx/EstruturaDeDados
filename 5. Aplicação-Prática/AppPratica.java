import java.util.Scanner;
import java.util.Stack;

class EditorTexto {

    private Stack<String> undoStack;
    private Stack<String> redoStack;
    private String textoAtual;

    public EditorTexto() {
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
        this.textoAtual = "";
    }

    private void salvarEstado() {
        undoStack.push(textoAtual);
        redoStack.clear(); // sempre limpa o redo quando uma nova ação é feita
    }

    public void escrever(String palavra) {
        salvarEstado();
        textoAtual += palavra + " ";
        System.out.println("Palavra '" + palavra + "' adicionada.");
    }

    public void removerUltima() {
        if (textoAtual.isEmpty()) {
            System.out.println("Nada para remover.");
            return;
        }
        salvarEstado();
        String[] palavras = textoAtual.trim().split(" ");
        textoAtual = "";
        for (int i = 0; i < palavras.length - 1; i++) {
            textoAtual += palavras[i] + " ";
        }
        System.out.println("Última palavra removida.");
    }

    public void limpar() {
        if (!textoAtual.isEmpty()) {
            salvarEstado();
            textoAtual = "";
            System.out.println("Texto limpo.");
        } else {
            System.out.println("Texto já está vazio.");
        }
    }

    public void desfazer() {
        if (!undoStack.isEmpty()) {
            redoStack.push(textoAtual);
            textoAtual = undoStack.pop();
            System.out.println("Ação desfeita.");
        } else {
            System.out.println("Nada para desfazer.");
        }
    }

    public void refazer() {
        if (!redoStack.isEmpty()) {
            undoStack.push(textoAtual);
            textoAtual = redoStack.pop();
            System.out.println("Ação refeita.");
        } else {
            System.out.println("Nada para refazer.");
        }
    }

    public void mostrarTexto() {
        if (textoAtual.isEmpty()) {
            System.out.println("Texto vazio.");
        } else {
            System.out.println("Texto atual: '" + textoAtual.trim() + "'");
        }
    }

    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Editor de Texto ===");
            System.out.println("1 - Escrever palavra");
            System.out.println("2 - Remover última palavra");
            System.out.println("3 - Limpar texto");
            System.out.println("4 - Desfazer");
            System.out.println("5 - Refazer");
            System.out.println("6 - Mostrar texto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir o \n

            switch (opcao) {
                case 1:
                    System.out.print("Digite a palavra: ");
                    String palavra = scanner.nextLine();
                    editor.escrever(palavra);
                    break;
                case 2:
                    editor.removerUltima();
                    break;
                case 3:
                    editor.limpar();
                    break;
                case 4:
                    editor.desfazer();
                    break;
                case 5:
                    editor.refazer();
                    break;
                case 6:
                    editor.mostrarTexto();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
