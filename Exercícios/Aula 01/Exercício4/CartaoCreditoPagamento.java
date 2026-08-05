public class CartaoCreditoPagamento extends MetodoPagamento {

    private String numeroCartao;
    private String nomeTitular;

    public CartaoCreditoPagamento(
            String numeroCartao,
            String nomeTitular
    ) {
        super("Cartão de Crédito");

        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
    }

    @Override
    public void processaPagamento(double valor) {
        System.out.printf(
                "Pagamento de R$ %.2f processado com Cartão de Crédito.%n",
                valor
        );
    }

    @Override
    public void mostraDetalhesPagamento() {
        System.out.println("Método: " + getNomeMetodo());
        System.out.println("ID do pagamento: " + getIdPagamento());
        System.out.println("Titular: " + nomeTitular);
        System.out.println("Cartão: " + ocultarNumeroCartao());
    }

    private String ocultarNumeroCartao() {
        if (numeroCartao == null || numeroCartao.length() < 4) {
            return "Número inválido";
        }

        String ultimosDigitos =
                numeroCartao.substring(numeroCartao.length() - 4);

        return "**** **** **** " + ultimosDigitos;
    }
}