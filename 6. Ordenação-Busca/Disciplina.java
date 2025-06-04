public class Disciplina {
    private String nome;
    private String professor;
    private String turno;

    // construtor que inicializa os atributos com os valores fornecidos
    public Disciplina(String nome, String professor, String turno) {
        this.nome = nome;
        this.professor = professor;
        this.turno = turno;
    }

    // método getter que retorna o nome da disciplina
    public String getNome() {
        return nome;
    }

    // método setter que atualiza o nome da disciplina
    public void setNome(String nome) {
        this.nome = nome;
    }

    // método getter que retorna o nome do professor da disciplina
    public String getProfessor() {
        return professor;
    }

    // método setter que atualiza o nome do professor da disciplina
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    // método getter que retorna o turno da disciplina
    public String getTurno() {
        return turno;
    }

    // método setter que atualiza o turno da disciplina
    public void setTurno(String turno) {
        this.turno = turno;
    }
}
