/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;
/**
 *
 * @author hermes
 */
public class Veiculo {
    
    private int idveiculo;
    private String modelo;
    private String placa;
    private Pessoa pessoaid;

    public Veiculo() {
    }

    public Veiculo(int idveiculo, String modelo, String placa, Pessoa pessoaid) {
        this.idveiculo = idveiculo;
        this.modelo = modelo;
        this.placa = placa;
        this.pessoaid = pessoaid;
    }

    public int getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(int idveiculo) {
        this.idveiculo = idveiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Pessoa getPessoaid() {
        return pessoaid;
    }

    public void setPessoaid(Pessoa pessoaid) {
        this.pessoaid = pessoaid;
    }

    @Override
    public String toString() {
        return "veiculo{" + "idveiculo=" + idveiculo + ", modelo=" + modelo + ", placa=" + placa + ", pessoaid=" + pessoaid + '}';
    }
    
    

}



