public class Disciplina {
    private String nome;
    private int cod_disciplina;
    private String professor;
    private String turno;

    public Disciplina() {

    }

    public Disciplina(String nome, int cod_disciplina, String professor, String turno) {
        this.nome = nome;
        this.cod_disciplina = cod_disciplina;
        this.professor = professor;
        this.turno = turno;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod_disciplina() {
        return cod_disciplina;
    }
    public void setCod_disciplina(int cod_disciplina) {
        this.cod_disciplina = cod_disciplina;
    }

    public String getProfessor() {
        return professor;
    }
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
    
}
