/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author hermes
 */
public class Professor {
    
    private int idProfessor;
    private String nome;
    private int idade;
    private String disciplina;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Professor{" + "nome=" + nome + ", idade=" + idade + ", disciplina=" + disciplina + '}';
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int id) {
        this.idProfessor = id;
    }
   
    
    
}
