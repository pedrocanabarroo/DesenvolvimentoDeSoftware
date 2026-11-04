/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Professor;
import java.sql.Connection;
import conexao.Conexao;
import java.sql.*;
import java.sql.SQLException;

public class ProfessorDAO {
    private Conexao conexao;
    private Connection conn;

    public ProfessorDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    
    public Professor getProfessor(int id) {

        String sql = "SELECT * FROM professor WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Professor p = new Professor();

            rs.first();
            p.setIdProfessor(id);
            p.setNome(rs.getString("nome"));
            p.setIdade(rs.getInt("idade"));
            p.setDisciplina(rs.getString("Disciplina"));
            return p;

        } catch (SQLException ex) {

            System.out.println("Erro ao consultar a pessoa" + ex.getMessage());
        }
        return null;
    }
    
    public void inserir (Professor Professor){
        
        try {
            
            String sql = "INSERT INTO professor (nome, idade, curso) VALUES (?,?,?);";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,Professor.getNome());
            stmt.setInt(2,Professor.getIdade());
            stmt.setString(3,Professor.getDisciplina());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir professor:"+ex.getMessage());
        }
    }
    
    public void editar(Professor professor) {

        try {
            String sql = "UPDATE professor set nome =? ,idade=?, disciplina=? where id =? ";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3, professor.getDisciplina());
            stmt.setInt(4, professor.getIdProfessor());

            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar pessoa:" + ex.getMessage());
        }
        
          
    }
    
    public void excluir(int id) {

        try {

            String sql = "delete from professor where id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException ex) {
            
            System.out.println("Erro ao excluir pessoa" + ex.getMessage());
        }

        

    }
    
    
}
    
