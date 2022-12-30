/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.Listas.ListaEnlazada;
import modelo.Casa;

/**
 *
 * @author Iván González
 */
public class ControladorCasa {
    
    private ListaEnlazada<Casa> listaCasas = new ListaEnlazada<>();

    public ListaEnlazada<Casa> getListaCasas() {
        return listaCasas;
    }

    public void setListaCasas(ListaEnlazada<Casa> listaCasas) {
        this.listaCasas = listaCasas;
    }
    
}
