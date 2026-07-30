/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Heranca;

/**
 *
 * @author laboratorio
 */
public class Principal {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.nome = "Pedro";
        p.cpf = "12121321";
        System.out.println("Pessoa: " +p);
        
        Professor prof = new Professor();
        prof.nome = "Ricardo";
        prof.cpf = "21302103219";
        
        prof.curso = "Sistemas de Informacao";
        prof.matricula = 123456;
        
        System.out.println("Professor: " +prof);
    }
}
