public class Nota {
    private double nota;
    private Aluno aluno;
    private Disciplina disciplina;
    
    public Nota() {

    }

    public Nota(double nota, Aluno aluno, Disciplina disciplina) {
        this.nota = nota;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }
    
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
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
