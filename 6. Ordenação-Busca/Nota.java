import java.math.BigDecimal;

public class Nota {
    private BigDecimal nota;
    private Aluno aluno;
    private Disciplina disciplina;
    
    public Nota() {

    }

    public Nota(BigDecimal nota, Aluno aluno, Disciplina disciplina) {
        this.nota = BigDecimal.ZERO;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }
    
    public BigDecimal getNota() {
        return nota;
    }
    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
