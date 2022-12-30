/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTablas;

import controlador.Listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iván González
 */
public class ModeloTablaFloat extends AbstractTableModel{
    
    private ListaEnlazada<Float> lista = new ListaEnlazada<>();

    public ListaEnlazada<Float> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Float> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.getSize();
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Número";
            case 1: return "Valor";
            default: return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Float numero = null;
        try {
            numero = lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println(e);
        }
        switch(columnIndex){
            case 0: return (rowIndex+1);
            case 1: return (numero != null) ? numero: "NO DEFINIDO";
            default: return null;
        }
    }
    
}
