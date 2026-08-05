public class PrincipalPagamento {

    public static void main(String[] args) {

        MetodoPagamento pagamentoCartao =
                new CartaoCreditoPagamento(
                        "1234567890123456",
                        "Pedro Henrique"
                );

        MetodoPagamento pagamentoPayPal =
                new PayPalPagamento(
                        "pedro@email.com"
                );

        MetodoPagamento pagamentoPix =
                new PixPagamento(
                        "123.456.789-00"
                );

        pagamentoCartao.processaPagamento(350.90);
        pagamentoCartao.mostraDetalhesPagamento();

        System.out.println("------------------------------");

        pagamentoPayPal.processaPagamento(150.75);
        pagamentoPayPal.mostraDetalhesPagamento();

        System.out.println("------------------------------");

        pagamentoPix.processaPagamento(89.90);
        pagamentoPix.mostraDetalhesPagamento();
    }
}
