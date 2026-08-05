public class ContaCorrente {

    private float saldo;

    public void definirSaldoInicial(float valor) {
        saldo = valor;
    }

    public void depositar(float valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("O valor do depósito deve ser maior que zero.");
        }
    }

    public boolean sacar(float valor) {
        if (valor <= 0) {
            System.out.println("O valor do saque deve ser maior que zero.");
            return false;
        }

        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }

        System.out.println("Saldo insuficiente para realizar o saque.");
        return false;
    }

    public float getSaldo() {
        return saldo;
    }
}
