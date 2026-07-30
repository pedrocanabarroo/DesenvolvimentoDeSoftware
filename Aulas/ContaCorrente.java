/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.pedro.primeiroprojeto;

/**
 *
 * @author laboratorio
 */
public class ContaCorrente {
    private float saldo;
    
    public void definirSaldoInicial(float valor){
        saldo = valor; 
    }

    public float getSaldo() {
        return saldo;
    }
    
    public void depositar(float valor){
        saldo += valor; //aldo = saldo + valor;
    }
    
    public boolean sacar(float valor){
        if (saldo >= valor){
            saldo -= valor;
            return true;
        }
        else{
            return false;
        }
    }
    
    
    
    
}
