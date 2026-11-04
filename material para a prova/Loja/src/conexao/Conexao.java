package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/Loja"
            + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "Senha123";

    public Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão efetuada!");
            return conn;
        } catch (SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, "Erro ao conectar no BD", e);
            // Lança a exceção em vez de retornar null, para não esconder a causa real com NullPointerException
            throw new RuntimeException("Erro ao conectar no BD: " + e.getMessage(), e);
        }
    }
}
