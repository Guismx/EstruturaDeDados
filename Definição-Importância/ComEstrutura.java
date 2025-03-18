import java.util.ArrayList;

public class ComEstrutura {
    static ArrayList<String> usuarios = new ArrayList<>();

    public static void adicionarUsuario(String nome) {
        usuarios.add(nome);
    }

    public static boolean buscarUsuario(String nome) {
        return usuarios.contains(nome);
    }

    public static void listarUsuarios() {
        System.out.println("Usuários cadastrados:");
        for (String usuario : usuarios) {
            System.out.println("- " + usuario);
        }
    }

    public static void main(String[] args) {
        adicionarUsuario("Alice");
        adicionarUsuario("Bob");
        adicionarUsuario("Carlos");
        listarUsuarios();

        System.out.println("Buscar Bob: " + buscarUsuario("Bob"));
        System.out.println("Buscar Daniel: " + buscarUsuario("Daniel"));
    }
}
