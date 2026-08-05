public class Casa {

    private static final double PRECO_POR_METRO_QUADRADO = 3000.00;
    private static final double VALOR_POR_QUARTO = 20000.00;

    public double calcularPreco(int tamanho) {
        return tamanho * PRECO_POR_METRO_QUADRADO;
    }

    public double calcularPreco(int tamanho, int numeroQuartos) {
        double precoPeloTamanho = tamanho * PRECO_POR_METRO_QUADRADO;
        double precoPelosQuartos = numeroQuartos * VALOR_POR_QUARTO;

        return precoPeloTamanho + precoPelosQuartos;
    }
}
