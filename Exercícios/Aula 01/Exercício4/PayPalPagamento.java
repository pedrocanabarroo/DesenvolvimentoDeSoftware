public class PayPalPagamento extends MetodoPagamento {

    private String email;

    public PayPalPagamento(String email) {
        super("PayPal");

        this.email = email;
    }

    @Override
    public void processaPagamento(double valor) {
        System.out.printf(
                "Pagamento de R$ %.2f processado com PayPal.%n",
                valor
        );
    }

    @Override
    public void mostraDetalhesPagamento() {
        System.out.println("Método: " + getNomeMetodo());
        System.out.println("ID do pagamento: " + getIdPagamento());
        System.out.println("E-mail do PayPal: " + email);
    }
}
