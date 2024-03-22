/*
 */
package examen2labp2_davidoliva;

import java.io.Serializable;

/**
 *
 * @author DAVIDANDRESOLIVAHERN
 */
public class Carro implements Serializable{

    private String Marca;
    private String Modelo;
    private int velocidad;

    public Carro() {
    }

    public Carro(String Marca, String Modelo, int velocidad) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.velocidad = velocidad;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return  Marca + " " + Modelo;
    }

}
