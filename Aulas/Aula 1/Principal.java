/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio3;

/**
 *
 * @author laboratorio
 */
public class Principal {
    public static void main(String[] args) {
        Casa c = new Casa();
        float valor = c.calcularPreco(52);
        System.out.println("Valor da casa: " +valor);
        valor = c.calcularPreco(52, 3);
        System.out.println("Valor da casa 2: " +valor);
    }
}
