class AlocacaoEstatica {
    public static void main(String[] args) {
        // Declaração de um array de tamanho fixo (alocação estática)
        int[] numeros = new int[5];
        
        // Atribuição de valores ao array
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;
        
        System.out.println("Valores armazenados no array:");
        
        // Exibição dos valores armazenados no array
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posição " + i + ": " + numeros[i]);
        }
        
        // Tentativa de adicionar um novo elemento (não permitido na alocação estática)
        System.out.println("\nTentando adicionar um novo elemento...");
        
        try {
            numeros[5] = 60; // Isso causará um erro pois o array tem tamanho fixo
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Não é possível adicionar mais elementos ao array estático.");
        }
    }
}