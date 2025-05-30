public class Turma {
    private int id;
    private String nome;
    private int ano;
    private Aluno[] alunos;
    private int qtdAlunos = 0;
    private Disciplina[] disciplinas;
    private int qtdDisciplinas;

    public Turma(int id, String nome, int ano, int capacidadeAlunos, int capacidadeDisciplinas) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.alunos = new Aluno[capacidadeAlunos];
        this.disciplinas = new Disciplina[capacidadeDisciplinas];
    }

    public void adicionarAluno(Aluno aluno) {
        if (qtdAlunos >= alunos.length) {
            Aluno[] novoArray = new Aluno[alunos.length * 2];
            for (int i = 0; i < alunos.length; i++) novoArray[i] = alunos[i];
            alunos = novoArray;
        }
        alunos[qtdAlunos++] = aluno;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }
    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }
    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }
    public int getQtdDisciplinas() {
        return qtdDisciplinas;
    }
}
