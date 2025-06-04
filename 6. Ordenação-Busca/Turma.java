public class Turma {
    private int id;
    private String nome;
    private int ano;
    private Aluno[] alunos; // array que armazena os alunos da turma
    private int qtdAlunos = 0; // quantidade atual de alunos na turma
    private Disciplina[] disciplinas; // array que armazena as disciplinas da turma
    private int qtdDisciplinas = 0; // quantidade atual de disciplinas da turma

    // construtor que inicializa os atributos e define as capacidades dos arrays
    public Turma(int id, String nome, int ano, int capacidadeAlunos, int capacidadeDisciplinas) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.alunos = new Aluno[capacidadeAlunos];
        this.disciplinas = new Disciplina[capacidadeDisciplinas];
        this.qtdAlunos = 0;
        this.qtdDisciplinas = 0;
    }

    // método que adiciona um aluno, redimensionando o array se necessário
    public void adicionarAluno(Aluno aluno) {
        if (qtdAlunos >= alunos.length) {
            Aluno[] novoArray = new Aluno[alunos.length * 2];
            for (int i = 0; i < alunos.length; i++)
                novoArray[i] = alunos[i];
            alunos = novoArray;
        }
        alunos[qtdAlunos++] = aluno;
    }

    // método que adiciona uma disciplina, redimensionando o array se necessário
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

    // método que ordena os alunos da turma em ordem alfabética pelo nome
    public void ordenarAlunosPorNome() {
        for (int i = 0; i < qtdAlunos - 1; i++) { // laço externo controla o número de passagens (iterações) sobre o
                                                  // vetor
            for (int j = 0; j < qtdAlunos - i - 1; j++) { // laço interno faz as comparações entre pares adjacentes e
                                                          // realiza trocas quando necessário
                if (this.alunos[j] != null && this.alunos[j + 1] != null && // verifica se os dois alunos comparados não
                                                                            // são nulos para evitar erro de ponteiro
                                                                            // nulo
                        this.alunos[j].getNome().compareToIgnoreCase(this.alunos[j + 1].getNome()) > 0) { // compara os
                                                                                                          // nomes dos
                                                                                                          // alunos de
                                                                                                          // forma
                                                                                                          // case-insensitive
                    // se o nome do aluno na posição j for "maior" (vem depois alfabeticamente) que
                    // o da posição j+1,
                    // então troca os dois de lugar (ordenação Bubble Sort)
                    Aluno temp = this.alunos[j];
                    this.alunos[j] = this.alunos[j + 1];
                    this.alunos[j + 1] = temp;
                }
            }
        }
    }

    // método que busca um aluno pelo nome utilizando busca binária (pressupõe que
    // está ordenado)
    public Aluno buscarAlunoPorNomeBinaria(String nome) {
        int inicio = 0; // índice inicial da busca
        int fim = qtdAlunos - 1; // índice final da busca

        // enquanto o intervalo de busca for válido
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2; // calcula o índice do meio do intervalo atual
            if (alunos[meio] == null) { // verifica se o elemento do meio é nulo (pode ocorrer se houver posições
                                        // vazias)
                if (nome.compareToIgnoreCase(alunos[fim].getNome()) > 0) // se o nome buscado é maior que o nome no fim
                                                                         // do vetor, ajusta o início da busca
                    inicio = fim + 1; // sai do laço, pois não encontrou
                else
                    fim = meio - 1; // reduz o intervalo movendo o fim para esquerda
                continue; // volta para o início do while
            }

            // compara o nome do aluno no meio com o nome buscado (ignora
            // maiúsculas/minúsculas)
            int cmp = alunos[meio].getNome().compareToIgnoreCase(nome);
            if (cmp == 0) { // nome encontrado, retorna o aluno correspondente
                return alunos[meio];
            } else if (cmp < 0) { // nome no meio vem antes do nome buscado, então busca na metade direita
                inicio = meio + 1;
            } else { // nome no meio vem depois do nome buscado, então busca na metade esquerda
                fim = meio - 1;
            }
        }

        // se não encontrou o aluno, retorna null
        return null;
    }

    // método que exibe todas as disciplinas cadastradas na turma
    public void exibirDisciplinas() {
        System.out.println("Disciplinas da Turma " + nome + ":"); // imprime o cabeçalho com o nome da turma
        if (qtdDisciplinas == 0) { // verifica se não há disciplinas cadastradas
            System.out.println("Nenhuma disciplina cadastrada para esta turma.");
            return; // sai do método
        }
        // percorre o vetor de disciplinas até a quantidade cadastrada
        for (int i = 0; i < qtdDisciplinas; i++) {
            if (this.disciplinas[i] != null) { // verifica se a disciplina na posição i não é nula
                // imprime as informações da disciplina: nome, professor e turno
                System.out.println("Disciplina: " + this.disciplinas[i].getNome() +
                        ", Professor: " + this.disciplinas[i].getProfessor() +
                        ", Turno: " + this.disciplinas[i].getTurno());
            }
        }
    }

    // método que exibe todos os alunos cadastrados na turma
    public void exibirAlunos() {
        System.out.println("Alunos da Turma " + nome + ":"); // imprime o cabeçalho com o nome da turma
        // verifica se não há alunos cadastrados
        if (qtdAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado para esta turma.");
            return; // sai do método
        }
        // percorre o vetor de alunos até a quantidade cadastrada
        for (int i = 0; i < qtdAlunos; i++) {
            if (this.alunos[i] != null) { // verifica se o aluno na posição i não é nulo
                System.out.println("Matrícula: " + this.alunos[i].getNumeroMatricula() + // imprime as informações do
                                                                                         // aluno: matrícula e nome
                        ", Nome: " + this.alunos[i].getNome());
            }
        }
    }

    // método que lista alunos cuja média está dentro de uma faixa especificada
    public void listarAlunosPorFaixaDeMedia(double min, double max) {
        System.out.println("Alunos com média entre " + min + " e " + max + ":"); // imprime o cabeçalho com a faixa de
                                                                                 // média buscada
        boolean encontrou = false; // flag para verificar se encontrou algum aluno

        // percorre o vetor de alunos até a quantidade cadastrada
        for (int i = 0; i < qtdAlunos; i++) {
            Aluno a = this.alunos[i];

            // verifica se o aluno não é nulo
            if (a != null) {
                double media = a.calcularMedia(); // calcula a média do aluno

                // verifica se a média está dentro da faixa especificada (inclusive)
                if (media >= min && media <= max) {
                    // imprime matrícula, nome e média formatada com duas casas decimais
                    System.out.printf("Matrícula: %d, Nome: %s, Média: %.2f\n",
                            a.getNumeroMatricula(), a.getNome(), media);
                    encontrou = true; // marca que encontrou pelo menos um aluno
                }
            }
        }
        // se nenhum aluno foi encontrado na faixa, imprime mensagem informando
        if (!encontrou) {
            System.out.println("Nenhum aluno encontrado nesta faixa de média.");
        }
    }

    // método que exibe as notas de todos os alunos em uma disciplina específica
    public void visualizarNotasPorDisciplina(String nomeDisciplina) {
        // imprime o cabeçalho com o nome da disciplina e da turma
        System.out.println("Notas da disciplina: " + nomeDisciplina + " na turma " + this.nome);
        boolean encontrouNotas = false; // flag para indicar se encontrou alguma nota

        // percorre o vetor de alunos até a quantidade cadastrada
        for (int i = 0; i < qtdAlunos; i++) {
            Aluno a = this.alunos[i];

            // verifica se o aluno não é nulo
            if (a != null) {
                Nota[] notasDoAluno = a.getNotas(); // obtém o vetor de notas do aluno

                // percorre todas as notas do aluno
                for (int k = 0; k < notasDoAluno.length; k++) {
                    Nota n = notasDoAluno[k];

                    // verifica se a disciplina da nota corresponde à disciplina pesquisada (ignora
                    // maiúsculas/minúsculas)
                    if (n.getDisciplina().getNome().equalsIgnoreCase(nomeDisciplina)) {
                        // imprime o nome do aluno e a nota formatada com duas casas decimais
                        System.out.printf("Aluno: %s - Nota: %.2f\n", a.getNome(), n.getNota());
                        encontrouNotas = true; // marca que encontrou pelo menos uma nota
                    }
                }
            }
        }
        // se não encontrou nenhuma nota para a disciplina, imprime mensagem informando
        if (!encontrouNotas) {
            System.out.println("Nenhuma nota encontrada para esta disciplina nesta turma.");
        }
    }

    // método que retorna os alunos ordenados pela média (crescente ou decrescente)
    public Aluno[] getAlunosOrdenadosPorMedia(boolean crescente) {
        Aluno[] alunosParaOrdenar = getAlunos(); // cria uma cópia do array atual de alunos para não modificar o
                                                 // original
        int n = alunosParaOrdenar.length;

        // usa o algoritmo bubble sort para ordenar o array pelo cálculo da média dos
        // alunos
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean deveTrocar;

                // define a condição para trocar os elementos com base na ordem desejada
                if (crescente) {
                    deveTrocar = alunosParaOrdenar[j].calcularMedia() > alunosParaOrdenar[j + 1].calcularMedia(); // troca
                                                                                                                  // se
                                                                                                                  // a
                                                                                                                  // média
                                                                                                                  // do
                                                                                                                  // aluno
                                                                                                                  // atual
                                                                                                                  // for
                                                                                                                  // maior
                                                                                                                  // que
                                                                                                                  // a
                                                                                                                  // do
                                                                                                                  // próximo
                                                                                                                  // (ordem
                                                                                                                  // crescente)
                } else {
                    // troca se a média do aluno atual for menor que a do próximo (ordem
                    // decrescente)
                    deveTrocar = alunosParaOrdenar[j].calcularMedia() < alunosParaOrdenar[j + 1].calcularMedia();
                }

                // realiza a troca dos elementos quando a condição for verdadeira
                if (deveTrocar) {
                    Aluno temp = alunosParaOrdenar[j];
                    alunosParaOrdenar[j] = alunosParaOrdenar[j + 1];
                    alunosParaOrdenar[j + 1] = temp;
                }
            }
        }
        return alunosParaOrdenar; // retorna o array ordenado pela média
    }

    // método que retorna todas as notas lançadas na turma
    public Nota[] getTodasNotasDaTurma() {
        int totalNotas = 0;

        // percorre todos os alunos para contar quantas notas no total existem na turma
        for (int i = 0; i < qtdAlunos; i++) {
            if (this.alunos[i] != null) {
                totalNotas += this.alunos[i].getQtdNotas(); // soma a quantidade de notas de cada aluno
            }
        }

        Nota[] todasNotasArray = new Nota[totalNotas]; // cria um array para armazenar todas as notas da turma
        int indiceAtual = 0;

        // percorre novamente todos os alunos para copiar suas notas no array criado
        for (int i = 0; i < qtdAlunos; i++) {
            if (this.alunos[i] != null) {
                Nota[] notasDoAluno = this.alunos[i].getNotas();
                for (int j = 0; j < notasDoAluno.length; j++) {
                    todasNotasArray[indiceAtual++] = notasDoAluno[j]; // adiciona as notas no array
                }
            }
        }
        return todasNotasArray; // retorna o array com todas as notas da turma
    }

    // método que retorna todas as notas da turma ordenadas por valor (crescente ou
    // decrescente)
    public Nota[] getTodasNotasDaTurmaOrdenadasPorValor(boolean crescente) {
        Nota[] todasNotas = getTodasNotasDaTurma(); // obtém todas as notas da turma
        int n = todasNotas.length;

        // usa bubble sort para ordenar as notas pelo valor numérico da nota
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean deveTrocar;

                // define a condição para trocar baseado na ordem crescente ou decrescente
                if (crescente) {
                    // troca se a nota atual for maior que a próxima (ordem crescente)
                    deveTrocar = todasNotas[j].getNota() > todasNotas[j + 1].getNota();
                } else {
                    // troca se a nota atual for menor que a próxima (ordem decrescente)
                    deveTrocar = todasNotas[j].getNota() < todasNotas[j + 1].getNota();
                }

                // realiza a troca dos elementos caso a condição seja verdadeira
                if (deveTrocar) {
                    Nota temp = todasNotas[j];
                    todasNotas[j] = todasNotas[j + 1];
                    todasNotas[j + 1] = temp;
                }
            }
        }
        return todasNotas; // retorna o array ordenado por valor das notas
    }

    // método que retorna todas as notas da turma ordenadas alfabeticamente pelo
    // nome da disciplina
    public Nota[] getTodasNotasDaTurmaOrdenadasPorDisciplina() {
        Nota[] todasNotas = getTodasNotasDaTurma(); // obtém todas as notas da turma
        int n = todasNotas.length;

        // ordena as notas pelo nome da disciplina em ordem alfabética, ignorando
        // maiúsculas e minúsculas
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // compara o nome da disciplina da nota atual com a da próxima
                if (todasNotas[j].getDisciplina().getNome()
                        .compareToIgnoreCase(todasNotas[j + 1].getDisciplina().getNome()) > 0) {
                    // troca se a disciplina da nota atual vier depois da próxima alfabeticamente
                    Nota temp = todasNotas[j];
                    todasNotas[j] = todasNotas[j + 1];
                    todasNotas[j + 1] = temp;
                }
            }
        }
        return todasNotas; // retorna o array ordenado por nome da disciplina
    }

    // método que remove um aluno da turma com base na matrícula
    public boolean removerAlunoPorMatricula(int matricula) {
        int indiceRemover = -1;

        // busca o índice do aluno que possui a matrícula informada
        for (int i = 0; i < qtdAlunos; i++) {
            if (this.alunos[i] != null && this.alunos[i].getNumeroMatricula() == matricula) {
                indiceRemover = i; // marca o índice do aluno para remoção
                break; // sai do loop após encontrar
            }
        }

        // se encontrou o aluno para remover
        if (indiceRemover != -1) {
            // desloca todos os alunos após o índice para "fechar o espaço"
            for (int i = indiceRemover; i < qtdAlunos - 1; i++) {
                this.alunos[i] = this.alunos[i + 1];
            }
            // diminui a quantidade de alunos e coloca null na última posição
            this.alunos[--qtdAlunos] = null;
            return true; // indica que o aluno foi removido com sucesso
        }
        return false; // indica que não encontrou aluno com essa matrícula
    }

    // método que retorna um array com os alunos atualmente cadastrados
    public Aluno[] getAlunos() {
        Aluno[] alunosAtuais = new Aluno[qtdAlunos]; // cria array com tamanho atual da turma

        // copia os alunos cadastrados para o novo array
        for (int i = 0; i < qtdAlunos; i++) {
            alunosAtuais[i] = this.alunos[i];
        }
        return alunosAtuais; // retorna o array com os alunos atuais
    }

    // método que define o array de alunos diretamente
    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos; // atribui o array passado para o atributo alunos da turma
    }

    // método que retorna as disciplinas atualmente cadastradas
    public Disciplina[] getDisciplinas() {
        Disciplina[] disciplinasAtuais = new Disciplina[qtdDisciplinas]; // cria array com tamanho atual de disciplinas

        // copia as disciplinas cadastradas para o novo array
        for (int i = 0; i < qtdDisciplinas; i++) {
            disciplinasAtuais[i] = this.disciplinas[i];
        }
        return disciplinasAtuais; // retorna o array com as disciplinas atuais
    }

    // método que retorna a quantidade de disciplinas da turma
    public int getQtdDisciplinas() {
        return qtdDisciplinas;
    }

    // getters e setters para os atributos básicos da turma
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

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }
}
