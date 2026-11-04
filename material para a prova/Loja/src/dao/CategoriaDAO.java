package dao;

import beans.Categoria;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hermes
 */
public class CategoriaDAO {

    private final Conexao conexao;
    private final Connection conn;

    public CategoriaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    /** Usado pelo ProdutoDAO para reaproveitar a mesma conexão. */
    public CategoriaDAO(Connection conn) {
        this.conexao = null;
        this.conn = conn;
    }

    public List<Categoria> getCategoria() {
        String sql = "SELECT * FROM categoria";
        List<Categoria> listaCategoria = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                listaCategoria.add(c);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar Categoria: " + ex.getMessage());
        }
        return listaCategoria;
    }

    public Categoria getCategoria(int id) {
        String sql = "SELECT * FROM categoria WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Categoria c = new Categoria();
                    c.setId(rs.getInt("id"));
                    c.setNome(rs.getString("nome"));
                    return c;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar Categoria: " + ex.getMessage());
        }
        return null;
    }

    public void inserir(Categoria categoria) {
        String sql = "INSERT INTO categoria(nome) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, categoria.getNome());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Categoria: " + ex.getMessage());
        }
    }

    public void editar(Categoria categoria) {
        String sql = "UPDATE categoria SET nome=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar Categoria: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM categoria WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir Categoria: " + ex.getMessage());
        }
    }
}
