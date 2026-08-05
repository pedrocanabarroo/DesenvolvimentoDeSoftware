public class PrincipalContaCorrente {

    public static void main(String[] args) {

        ContaCorrente novaConta = new ContaCorrente();

        novaConta.definirSaldoInicial(1000);

        System.out.printf(
                "Saldo inicial: R$ %.2f%n",
                novaConta.getSaldo()
        );

        boolean primeiroSaque = novaConta.sacar(500);

        if (primeiroSaque) {
            System.out.println("Saque de R$ 500,00 realizado com sucesso.");
        } else {
            System.out.println("Não foi possível realizar o saque de R$ 500,00.");
        }

        novaConta.depositar(50);

        System.out.printf(
                "Saldo após o saque e o depósito: R$ %.2f%n",
                novaConta.getSaldo()
        );

        boolean segundoSaque = novaConta.sacar(600);

        if (segundoSaque) {
            System.out.println("Saque de R$ 600,00 realizado com sucesso.");
        } else {
            System.out.println("Não foi possível realizar o saque de R$ 600,00.");
        }

        System.out.printf(
                "Saldo final: R$ %.2f%n",
                novaConta.getSaldo()
        );
    }
}