/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstratasInterface;

/**
 *
 * @author laboratorio
 */
abstract class Pessoa {
    public String nome;
    public int idade;
    
    abstract void cadastrar();
    
    public void apresentarDados(){
        System.out.println("Nome: " +nome);
        System.out.println("Idade: " +idade);
    }
    
}
