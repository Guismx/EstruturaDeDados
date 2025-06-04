public class Nota {
    private double nota;
    private Aluno aluno;
    private Disciplina disciplina;

    // construtor padrão (sem parâmetros), útil para inicialização sem valores
    // imediatos
    public Nota() {

    }

    // construtor que inicializa todos os atributos da nota com os valores
    // fornecidos
    public Nota(double nota, Aluno aluno, Disciplina disciplina) {
        this.nota = nota;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    // método getter que retorna o valor da nota
    public double getNota() {
        return nota;
    }

    // método setter que atualiza o valor da nota
    public void setNota(double nota) {
        this.nota = nota;
    }

    // método getter que retorna aluno associado à nota
    public Aluno getAluno() {
        return aluno;
    }

    // método setter que atualiza aluno associado à nota
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    // método getter que retorna o objeto disciplina associado à nota
    public Disciplina getDisciplina() {
        return disciplina;
    }

    // método setter que atualiza o objeto disciplina associado à nota
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
