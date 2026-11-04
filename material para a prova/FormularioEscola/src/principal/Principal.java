/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import beans.Professor;
import conexao.Conexao;
import dao.ProfessorDAO;

/**
 *
 * @author laboratorio
 */
public class Principal {
    public static void main(String[] args) {
        
        Conexao c = new Conexao();
        c.getConexao();
        Professor p = new Professor();
        p.setNome("Vitor Bortoluzzi");
        p.setIdade(32);
        p.setDisciplina("CC");
        ProfessorDAO pdao = new ProfessorDAO();
        pdao.inserir(p);
        
        Professor r = new Professor();
        r.setNome("Jose da Silva");
        r.setIdade(45);
        r.setDisciplina("CC");
        
        ProfessorDAO rdao = new ProfessorDAO();
        rdao.inserir(r);
        
        
        
    }
    
}
