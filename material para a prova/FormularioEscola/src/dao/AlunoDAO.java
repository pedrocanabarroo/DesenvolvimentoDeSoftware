/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import beans.Aluno;
import java.sql.Connection;
import conexao.Conexao;
import java.sql.*;
import java.sql.SQLException;


public class AlunoDAO {
    private Conexao conexao;
    private Connection conn;

    public AlunoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    
    public Aluno getAluno(int idaluno) {

        String sql = "SELECT * FROM aluno WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, idaluno);
            ResultSet rs = stmt.executeQuery();

            Aluno a = new Aluno();

            rs.first();
            a.setIdaluno(idaluno);
            a.setNome(rs.getString("nome"));
            a.setIdade(rs.getInt("idade"));
            a.setCurso(rs.getString("Curso"));
            return a;

        } catch (SQLException ex) {

            System.out.println("Erro ao consultar a pessoa" + ex.getMessage());
        }
        return null;
    }
    
    public void inserir (Aluno Aluno){
        
        try {
            
            String sql = "INSERT INTO aluno(nome, idade, curso) VALUES (?,?,?);";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,Aluno.getNome());
            stmt.setInt(2,Aluno.getIdade());
            stmt.setString(3,Aluno.getCurso());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir pessoa:"+ex.getMessage());
        }
    }
    
    public void editar(Aluno aluno) {

        try {
            String sql = "UPDATE aluno set nome =? ,idade=?, curso=? where id =? ";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getCurso());
            stmt.setInt(4, aluno.getIdaluno());

            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar aluno:" + ex.getMessage());
        }
        
          
    }
    
    public void excluir(int id) {

        try {

            String sql = "delete from aluno where id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException ex) {
            
            System.out.println("Erro ao excluir aluno" + ex.getMessage());
        }

        

    }
    
    
}
    
