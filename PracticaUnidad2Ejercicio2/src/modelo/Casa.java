/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Iván González
 */
public class Casa {
    
    private String numeroCasa;
    private Integer numeroPisos;
    private Float ancho;
    private Float largo;

    public Casa(String numeroCasa, Integer numeroPisos, Float ancho, Float largo) {
        this.numeroCasa = numeroCasa;
        this.numeroPisos = numeroPisos;
        this.ancho = ancho;
        this.largo = largo;
    }
    
    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public Integer getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(Integer numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    public Float getAncho() {
        return ancho;
    }

    public void setAncho(Float ancho) {
        this.ancho = ancho;
    }

    public Float getLargo() {
        return largo;
    }

    public void setLargo(Float largo) {
        this.largo = largo;
    }

    @Override
    public String toString() {
        return "casa: " + numeroCasa + " Pisos = " + numeroPisos + " Ancho = " + ancho + " Largo = " + largo;
    }
    
}
