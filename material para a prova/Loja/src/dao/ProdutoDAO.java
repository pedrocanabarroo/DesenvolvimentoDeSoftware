package dao;

import beans.Produto;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private final Conexao conexao;
    private final Connection conn;

    public ProdutoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    private Produto montarProduto(ResultSet rs, CategoriaDAO cDAO) throws SQLException {
        Produto p = new Produto();
        p.setId(rs.getInt("id"));
        p.setNome(rs.getString("nome"));
        p.setPreco(rs.getDouble("preco"));
        p.setQuantidade(rs.getInt("quantidade"));
        p.setCategoria(cDAO.getCategoria(rs.getInt("categoria_id")));
        return p;
    }

    public List<Produto> getProduto() {
        String sql = "SELECT * FROM produto";
        List<Produto> listaproduto = new ArrayList<>();
        CategoriaDAO cDAO = new CategoriaDAO(conn); // reaproveita a mesma conexão

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                listaproduto.add(montarProduto(rs, cDAO));
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar produtos: " + ex.getMessage());
        }
        return listaproduto;
    }

    public Produto getProduto(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        CategoriaDAO cDAO = new CategoriaDAO(conn);

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return montarProduto(rs, cDAO);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao consultar produto: " + ex.getMessage());
        }
        return null;
    }

    /** Pesquisa por ID (exato), nome do produto ou nome da categoria (parcial). */
    public List<Produto> pesquisar(String texto) {
        String sql = "SELECT p.* FROM produto p "
                   + "LEFT JOIN categoria c ON c.id = p.categoria_id "
                   + "WHERE p.id = ? OR p.nome LIKE ? OR c.nome LIKE ?";
        List<Produto> lista = new ArrayList<>();
        CategoriaDAO cDAO = new CategoriaDAO(conn);

        int id;
        try {
            id = Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            id = -1; // texto não é número: não casa com nenhum id
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, "%" + texto.trim() + "%");
            stmt.setString(3, "%" + texto.trim() + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(montarProduto(rs, cDAO));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao pesquisar produtos: " + ex.getMessage());
        }
        return lista;
    }

    public void inserir(Produto produto) {
        String sql = "INSERT INTO produto(nome, preco, quantidade, categoria_id) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getCategoria().getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
        }
    }

    public void editar(Produto produto) {
        String sql = "UPDATE produto SET nome=?, preco=?, quantidade=?, categoria_id=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getCategoria().getId());
            stmt.setInt(5, produto.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar produto: " + ex.getMessage());
        }
    }

    public void excluir(int idproduto) {
        String sql = "DELETE FROM produto WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idproduto);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir produto: " + ex.getMessage());
        }
    }
}
