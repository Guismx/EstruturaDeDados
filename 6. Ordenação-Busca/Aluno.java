public class Aluno {
    private String nome;
    private int numeroMatricula;
    private Turma turma;
    private int periodo;
    private Nota[] notas = new Nota[20];
    private int qtdNotas = 0;

    public Aluno(String nome, int numeroMatricula, Turma turma, int periodo) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
        this.turma = turma;
        this.periodo = periodo;
    }

    public void adicionarNota(Nota nota) {
        if (qtdNotas >= notas.length) {
            Nota[] novoArray = new Nota[notas.length * 2];
            for (int i = 0; i < notas.length; i++) novoArray[i] = notas[i];
            notas = novoArray;
        }
        notas[qtdNotas++] = nota;
    }

    public Nota[] getNotas() {
        return notas;
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

    public int getPeriodo() {
        return periodo;
    }
}