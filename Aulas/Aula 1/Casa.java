/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio3;

/**
 *
 * @author laboratorio
 */
public class Casa {
    
    public float calcularPreco(int tamanho){
        float valor;
        valor = tamanho * 3547.44f;
        return valor;
    }
    
    public float calcularPreco(int tamanho, int qtdQuartos){
        float valor = (float) ((tamanho * 3327.51) + (qtdQuartos * 2321.49));
        return valor;
    }
}
