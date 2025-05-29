public class Turma {

    private Long id_turma;
    private String nome;
    private int ano_turma;

    public Turma() {

    }

    public Turma(Long id_turma, String nome, int ano_turma) {
        this.id_turma = id_turma;
        this.nome = nome;
        this.ano_turma = ano_turma;
    }

    public Long getId_turma() {
        return id_turma;
    }
    public void setId_turma(Long id_turma) {
        this.id_turma = id_turma;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno_turma() {
        return ano_turma;
    }
    public void setAno_turma(int ano_turma) {
        this.ano_turma = ano_turma;
    }
    
}
