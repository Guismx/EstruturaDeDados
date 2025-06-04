public class Aluno {
    private String nome;
    private int numeroMatricula;
    private Turma turma; // referência para a turma à qual o aluno pertence
    private Nota[] notas; // array que armazena os objetos do tipo Nota do aluno
    private int qtdNotas = 0;// quantidade de notas atualmente registradas no array

    // construtor da classe que inicializa os dados principais do aluno
    public Aluno(String nome, int numeroMatricula, Turma turma) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
        this.turma = turma;
        this.notas = new Nota[10]; // para definir que o array inicial terá capacidade para 10 notas
        this.qtdNotas = 0; // inicialmente, nenhuma nota cadastrada
    }

    // método que adiciona uma nova nota para o aluno
    public void adicionarNota(Nota nota) {
        // verifica se o array atual está cheio e precisa ser redimensionado
        if (qtdNotas >= notas.length) {
            Nota[] novoArray = new Nota[notas.length * 2]; // cria um novo array com o dobro do tamanho
            for (int i = 0; i < notas.length; i++)
                novoArray[i] = notas[i]; // copia as notas que possui para o novo array
            notas = novoArray; // substitui o array antigo pelo novo
        }
        notas[qtdNotas++] = nota; // adiciona a nova nota e incrementa o contador de notas
    }

    // método que exibe todas as notas do aluno, informando o nome da disciplina e
    // valor da nota
    public void exibirNotas() {
        System.out.println("Notas de " + nome + ":");
        for (int i = 0; i < qtdNotas; i++) {
            System.out.println("Disciplina: " + notas[i].getDisciplina().getNome() +
                    ", Nota: " + notas[i].getNota());
        }
    }

    // método que calcula e retorna a média das notas do aluno
    public double calcularMedia() {
        if (qtdNotas == 0)
            return 0.0; // verrificação para evitar divisão por zero se não houver notas

        double soma = 0.0;
        for (int i = 0; i < qtdNotas; i++) {
            soma += notas[i].getNota(); // soma todas as notas
        }
        return soma / qtdNotas; // retorna a média
    }

    // método que retorna um array de notas ordenado por valor
    public Nota[] getNotasOrdenadasPorValor(boolean crescente) {
        Nota[] notasParaOrdenar = getNotas(); // cria uma cópia do array de notas atual
        int n = notasParaOrdenar.length;

        // algoritmo de ordenação Bubble Sort com base no valor da nota
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean deveTrocar;

                if (crescente) {
                    deveTrocar = notasParaOrdenar[j].getNota() > notasParaOrdenar[j + 1].getNota();
                } else {
                    deveTrocar = notasParaOrdenar[j].getNota() < notasParaOrdenar[j + 1].getNota();
                }

                if (deveTrocar) {
                    Nota temp = notasParaOrdenar[j];
                    notasParaOrdenar[j] = notasParaOrdenar[j + 1];
                    notasParaOrdenar[j + 1] = temp;
                }
            }
        }
        return notasParaOrdenar; // retorna o array ordenado
    }

    // método que retorna um array de notas ordenado por nome da disciplina em ordem
    // alfabética
    public Nota[] getNotasOrdenadasPorDisciplina() {
        Nota[] notasParaOrdenar = getNotas(); // cria uma cópia do array de notas atual
        int n = notasParaOrdenar.length;

        // algoritmo de ordenação Bubble Sort com base no nome da disciplina
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (notasParaOrdenar[j].getDisciplina().getNome()
                        .compareToIgnoreCase(notasParaOrdenar[j + 1].getDisciplina().getNome()) > 0) {
                    Nota temp = notasParaOrdenar[j];
                    notasParaOrdenar[j] = notasParaOrdenar[j + 1];
                    notasParaOrdenar[j + 1] = temp;
                }
            }
        }
        return notasParaOrdenar; // retorna o array ordenado
    }

    // método que retorna uma cópia do array atual de notas
    public Nota[] getNotas() {
        Nota[] notasAtuais = new Nota[qtdNotas];
        for (int i = 0; i < qtdNotas; i++) {
            notasAtuais[i] = this.notas[i];
        }
        return notasAtuais;
    }

    // método que retorna o nome do aluno
    public String getNome() {
        return nome;
    }

    // método que retorna o número de matrícula do aluno
    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    // método que retorna o objeto da turma à qual o aluno pertence
    public Turma getTurma() {
        return turma;
    }

    // método que retorna a quantidade de notas cadastradas
    public int getQtdNotas() {
        return qtdNotas;
    }
}
