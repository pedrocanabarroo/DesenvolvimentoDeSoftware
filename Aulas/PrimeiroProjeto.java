/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.pedro.primeiroprojeto;

/**
 *
 * @author laboratorio
 */
public class PrimeiroProjeto {
    public static void main(String[] args) {
        ContaCorrente novaConta = new ContaCorrente();
        System.out.println("Conta Instanciada!");
        novaConta.definirSaldoInicial(1000);
        System.out.println("Saldo: " +novaConta.getSaldo());
        if (novaConta.sacar(500) == true){
            System.out.println("Saque Efetuado");
        }
        else{
            System.out.println("Saque não efetuado!");
        }
        
        novaConta.depositar(50);
        System.out.println("Saldo 2: " +novaConta.getSaldo());
        
        if (novaConta.sacar(600)){
            System.out.println("Saque efetuado");
        }
        else {
            System.out.println("Saldo insuficiente para o saque");
        }
    }  
}
