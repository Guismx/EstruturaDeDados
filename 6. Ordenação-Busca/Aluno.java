import java.util.List;

public class Aluno {
    private String nome;
    private int numero_matricula;
    private Turma nome_turma;
    private int periodo;
    private List<Nota> notas;

    public Aluno(){
    }

    public Aluno(String nome, int numero_matricula, Turma nome_turma, int periodo) {
        this.nome = nome;
        this.numero_matricula = numero_matricula;
        this.nome_turma = nome_turma;
        this.periodo = periodo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero_matricula() {
        return numero_matricula;
    }
    public void setNumero_matricula(int numero_matricula) {
        this.numero_matricula = numero_matricula;
    }

    public Turma getNome_turma() {
        return nome_turma;
    }
    public void setNome_turma(Turma nome_turma) {
        this.nome_turma = nome_turma;
    }

    public int getPeriodo() {
        return periodo;
    }
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
}
