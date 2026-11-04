/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Pessoa;
import beans.Veiculo;
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
public class VeiculoDAO {

    private Conexao conexao;
    private Connection conn;

    public VeiculoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public List<Veiculo> getVeiculo() {

        String sql = "SELECT * FROM veiculo";

        try {

            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery(); //retorno da consulta e armena no ResultSet

            List<Veiculo> listaVeiculos = new ArrayList();

            while (rs.next()) {

                Veiculo v = new Veiculo();
                
                v.setIdveiculo(rs.getInt("id"));
                v.setModelo(rs.getString("modelo"));
                v.setPlaca(rs.getString("placa"));
                
                PessoaDAO pDAO = new PessoaDAO();
                
                Pessoa p = pDAO.getPessoa(rs.getInt("id_pessoa"));
                v.setPessoaid(p);
                
                listaVeiculos.add(v);

            }

            return listaVeiculos;

        } catch (SQLException ex) {

            System.out.println("Erro ao consultar todos os veiculos: " + ex.getMessage());

            return null;

        }}
    
    
    public Veiculo getVeiculo(int idveiculo) {

        String sql = "SELECT * FROM veiculo WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, idveiculo);
            
            ResultSet rs = stmt.executeQuery();

            Veiculo v = new Veiculo();

            rs.first();
            
            v.setIdveiculo(rs.getInt("id"));
            v.setModelo(rs.getString("Modelo"));
            v.setPlaca(rs.getString("Placa"));
            
            PessoaDAO pDAO = new PessoaDAO();
            Pessoa p = pDAO.getPessoa(rs.getInt("id_pessoa"));
            
           
            return v;

        } catch (SQLException ex) {

            System.out.println("Erro ao consultar a pessoa" + ex.getMessage());
        }
        return null;
    }

    public void inserir(Veiculo veiculo) {
        try {
            String sql = "INSERT INTO veiculo(modelo, placa, id_pessoa) VALUES (?,?,?);";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getPessoaid().getId());

            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir veiculo:" + ex.getMessage());
        }
    }

    public void editar(Veiculo veiculo) {
        try {
            String sql = "UPDATE veiculo SET modelo=?, placa=?, id_pessoa=? WHERE id=?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getPessoaid().getId());
            stmt.setInt(4, veiculo.getIdveiculo());

            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar veiculo:" + ex.getMessage());
        }
    }

    public void excluir(int idveiculo) {
        try {
            String sql = "DELETE FROM veiculo WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idveiculo);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir veiculo:" + ex.getMessage());
        }
    }
}
