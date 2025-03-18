public class SemEstrutura {
    static String[] nomes = new String[5]; // Array fixo para armazenar nomes
    static int contador = 0;

    public static void adicionarUsuario(String nome) {
        if (contador < nomes.length) {
            nomes[contador] = nome;
            contador++;
        } else {
            System.out.println("Erro: Capacidade máxima atingida!");
        }
    }

    public static boolean buscarUsuario(String nome) {
        for (int i = 0; i < contador; i++) {
            if (nomes[i].equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public static void listarUsuarios() {
        System.out.println("Usuários cadastrados:");
        for (int i = 0; i < contador; i++) {
            System.out.println("- " + nomes[i]);
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
