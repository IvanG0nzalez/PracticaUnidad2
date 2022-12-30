/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica2ejercicio2;

import controlador.Listas.ListaEnlazada;
import modelo.Casa;

/**
 *
 * @author Iván González
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaEnlazada<Casa> lista = new ListaEnlazada<>();

        Casa c1 = new Casa("08-26", 4, "Rojo", 20.5f, 30.3f);
        Casa c2 = new Casa("11-66", 2, "Azul",20f, 1f);
        Casa c3 = new Casa("09-01", 5, "Morado",15f, 9f);
        Casa c4 = new Casa("10-35", 1, "Amarillo",21f, 33f);
        Casa c5 = new Casa("07-40", 2, "Fucsia",40f, 60f);
        Casa c6 = new Casa("01-01", 3, "Verde",41f, 30f);
        Casa c7 = new Casa("01-0f", 10, "Negro",60f, 20f);
        Casa c8 = new Casa("01-0a", 11, "Gris",20f, 70f);
        
        
        lista.insertar(c1);
        lista.insertar(c2);
        lista.insertar(c3);
        lista.insertar(c4);
        lista.insertar(c5);
        lista.insertar(c6); 
        lista.insertar(c7);
        lista.insertar(c8);
        lista.imprimir();
        try {
            lista.ordenarShellSort("color", ListaEnlazada.ASCENDENTE);
            System.out.println("ASCENDENTE");
            lista.imprimir();
//            System.out.println(lista.obtener(lista.buscarBinario("color", "negro"))); 
            lista.busquedaLinealBinaria("color", "negro").imprimir();

        } catch (Exception e) {
            e.printStackTrace();
        }

//        ListaEnlazada<Float> lista2 = new ListaEnlazada<>();
//
//        lista2.insertar(0f);
//        lista2.insertar(19f);
//        lista2.insertar(20.5f);
//        lista2.insertar(40.7f);
//        lista2.insertar(1f);
//        lista2.insertar(9.6f);
//        lista2.insertar(9.5f);
//        lista2.insertar(40.7f);
//        lista2.imprimir();
//
//        try {
//            lista2.ordenarShellSort(null, ListaEnlazada.ASCENDENTE);
//            lista2.imprimir();
////            System.out.println("Valor: " + lista2.buscarBinario(null, 40.7f));
//            lista2.busquedaLinealBinaria(null, 1f).imprimir();
////            lista2.buscar(null, 40.7f).imprimir();
//        } catch (Exception e) {
//        }
    }

}
