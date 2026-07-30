/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Geometrica;

/**
 *
 * @author laboratorio
 */
public class Principal {
    public static void main(String[] args) {
        FormaGeometrica quadrado = new FormaGeometrica();
        quadrado.lado = 3.7f;
        quadrado.calcularArea();
        System.out.println("Área do quadrado: " +quadrado.area);
        
        Triangulo t = new Triangulo();
        t.altura = 3.7f;
        t.lado = 5.4f;
        t.calcularArea();
        
        System.out.println("Área do triangulo: " +t.area);
    }
            
    
}
