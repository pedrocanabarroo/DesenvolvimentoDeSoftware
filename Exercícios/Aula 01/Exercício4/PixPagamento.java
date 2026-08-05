public class PixPagamento extends MetodoPagamento {

    private String chavePix;

    public PixPagamento(String chavePix) {
        super("PIX");

        this.chavePix = chavePix;
    }

    @Override
    public void processaPagamento(double valor) {
        System.out.printf(
                "Pagamento de R$ %.2f processado com PIX.%n",
                valor
        );
    }

    @Override
    public void mostraDetalhesPagamento() {
        System.out.println("Método: " + getNomeMetodo());
        System.out.println("ID do pagamento: " + getIdPagamento());
        System.out.println("Chave PIX: " + chavePix);
    }
}