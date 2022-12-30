/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica2ejercicio1;

import controlador.Listas.ListaEnlazada;
import java.text.DecimalFormat;

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
        ListaEnlazada<Float> lista = new ListaEnlazada<>();
        
        lista.generarLista(20000);
        
//        lista.insertar(10.45f);
//        lista.insertar(4f);
//        lista.insertar(7f);
//        lista.insertar(9f);
//        lista.insertar(304f);
//        lista.insertar(5f);
//        lista.insertar(10.46f);
//        lista.insertar(0f);
        
//        lista.imprimirListaFloat();
//        lista.ordenarShellSort(null, ListaEnlazada.ASCENDENTE);
//        System.out.println("ASCENDENTE");
//        lista.imprimirListaFloat();
//        lista.ordenarShellSort(null, ListaEnlazada.DESCENDENTE);
//        System.out.println("DESCENDENTE");
//        lista.imprimirListaFloat();


        lista.imprimirListaFloat();
        lista.ordenarQuickSort(null, ListaEnlazada.ASCENDENTE);
        System.out.println("ASCENDENTE");
        lista.imprimirListaFloat();
        lista.ordenarQuickSort(null, ListaEnlazada.DESCENDENTE);
        System.out.println("DESCENDENTE");
        lista.imprimirListaFloat();



//        for (int i = 0; i <= 2000; i++) {
//            Double num = Math.random() * 1001 ;
//            Double aux = Math.round(num * 100d)/100d;
//            Float f = aux.floatValue();
//            lista.insertar(f);
//            System.out.println(f);
//        }

    }
    
}
