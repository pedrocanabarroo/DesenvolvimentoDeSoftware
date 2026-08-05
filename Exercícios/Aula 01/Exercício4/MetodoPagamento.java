import java.util.Random;

public abstract class MetodoPagamento {

    private String nomeMetodo;
    private int idPagamento;

    public MetodoPagamento(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
        this.idPagamento = gerarIdPagamento();
    }

    private int gerarIdPagamento() {
        Random random = new Random();

        return random.nextInt(900000) + 100000;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public abstract void processaPagamento(double valor);

    public abstract void mostraDetalhesPagamento();
}