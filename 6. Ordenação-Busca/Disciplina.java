public class Disciplina {
    private String nome;
    private String professor;
    private String turno;

    public Disciplina(String nome, String professor, String turno) {
        this.nome = nome;
        this.professor = professor;
        this.turno = turno;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
