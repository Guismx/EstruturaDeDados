public class Aluno {
    private String nome;
    private int numeroMatricula;
    private Turma turma;
    private Nota[] notas;
    private int qtdNotas = 0;

    public Aluno(String nome, int numeroMatricula, Turma turma) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
        this.turma = turma;
        this.notas = new Nota[10];
        this.qtdNotas = 0;
    }

    public void adicionarNota(Nota nota) {
        if (qtdNotas >= notas.length) {
            Nota[] novoArray = new Nota[notas.length * 2];
            for (int i = 0; i < notas.length; i++) novoArray[i] = notas[i];
            notas = novoArray;
        }
        notas[qtdNotas++] = nota;
    }

    public void exibirNotas() {
    System.out.println("Notas de " + nome + ":");
    for (int i = 0; i < qtdNotas; i++) {
        System.out.println("Disciplina: " + notas[i].getDisciplina().getNome() + 
                           ", Nota: " + notas[i].getNota());
        }
    }

    public double calcularMedia() {
        if (qtdNotas == 0) return 0.0;

        double soma = 0.0;
        for (int i = 0; i < qtdNotas; i++) {
            soma += notas[i].getNota();
        }
        return soma / qtdNotas;
    }

    public Nota[] getNotasOrdenadasPorValor(boolean crescente) {
        Nota[] notasParaOrdenar = getNotas();
        int n = notasParaOrdenar.length;
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
        return notasParaOrdenar;
    }

    public Nota[] getNotasOrdenadasPorDisciplina() {
        Nota[] notasParaOrdenar = getNotas();
        int n = notasParaOrdenar.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (notasParaOrdenar[j].getDisciplina().getNome().compareToIgnoreCase(notasParaOrdenar[j + 1].getDisciplina().getNome()) > 0) {
                    Nota temp = notasParaOrdenar[j];
                    notasParaOrdenar[j] = notasParaOrdenar[j + 1];
                    notasParaOrdenar[j + 1] = temp;
                }
            }
        }
        return notasParaOrdenar;
    }


    public Nota[] getNotas() {
        Nota[] notasAtuais = new Nota[qtdNotas];
        for (int i = 0; i < qtdNotas; i++) {
            notasAtuais[i] = this.notas[i]; 
        }
        return notasAtuais;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public Turma getTurma() {
        return turma;
    }
    public int getQtdNotas() {
        return qtdNotas;
    }
}