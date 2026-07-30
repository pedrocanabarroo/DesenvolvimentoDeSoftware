/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Heranca;

/**
 *
 * @author laboratorio
 */
public class Professor extends Pessoa{
    protected String curso;
    protected int matricula;

    public String getCurso() {
        return curso;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Professor{" + "curso=" + curso + ", matricula=" + matricula + '}';
    }
    
}
