public class Disciplina {
    private String nome;
    private int codigo;
    private String professor;
    private String turno;

    public Disciplina(String nome, int codigo, String professor, String turno) {
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
        this.turno = turno;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
