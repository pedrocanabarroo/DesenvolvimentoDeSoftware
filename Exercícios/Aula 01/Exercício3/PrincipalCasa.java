public class PrincipalCasa {

    public static void main(String[] args) {

        Casa casa = new Casa();

        double precoPorTamanho = casa.calcularPreco(100);

        double precoPorTamanhoEQuartos =
                casa.calcularPreco(100, 3);

        System.out.printf(
                "Preço considerando somente o tamanho: R$ %.2f%n",
                precoPorTamanho
        );

        System.out.printf(
                "Preço considerando o tamanho e os quartos: R$ %.2f%n",
                precoPorTamanhoEQuartos
        );
    }
}