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

    public void adicionarDisciplina(Disciplina disciplina) {
        if (qtdDisciplinas >= disciplinas.length) {
            Disciplina[] novoArray = new Disciplina[disciplinas.length * 2];
            for (int i = 0; i < disciplinas.length; i++) {
                novoArray[i] = disciplinas[i];
            }
            disciplinas = novoArray;
        }
        disciplinas[qtdDisciplinas++] = disciplina;
    }

    public void ordenarAlunosPorNome() {
        for (int i = 0; i < qtdAlunos - 1; i++) {
            for (int j = 0; j < qtdAlunos - i - 1; j++) {
                if (alunos[j].getNome().compareToIgnoreCase(alunos[j + 1].getNome()) > 0) {
                    Aluno temp = alunos[j];
                    alunos[j] = alunos[j + 1];
                    alunos[j + 1] = temp;
                }
            }
        }
    }

    public Aluno buscarAlunoPorNomeBinaria(String nome) {
        int inicio = 0;
        int fim = qtdAlunos - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int cmp = alunos[meio].getNome().compareToIgnoreCase(nome);
            if (cmp == 0) {
                return alunos[meio];
            } else if (cmp < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return null;
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
