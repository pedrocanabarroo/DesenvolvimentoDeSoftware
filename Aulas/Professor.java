/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstratasInterface;

/**
 *
 * @author laboratorio
 */
public class Professor extends Pessoa {

    @Override
    void cadastrar() {
        System.out.println("Cadastrando professor");
        super.apresentarDados();
    }
    
}
