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


    public Nota[] getNotas() {
        Nota[] notasAtuais = new Nota[qtdNotas];
        for (int i = 0; i < qtdNotas; i++) {
            notasAtuais[i] = this.notas[i]; // Copia do array interno this.notas
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