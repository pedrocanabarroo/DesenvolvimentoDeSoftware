/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Geometrica;

/**
 *
 * @author laboratorio
 */
public class Triangulo extends FormaGeometrica{
    public float altura;
    
    @Override
    public void calcularArea(){
        area = altura * lado / 2;
    }
   
}
