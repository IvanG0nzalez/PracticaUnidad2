/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.Listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Casa;

/**
 *
 * @author Iván González
 */
public class ModeloTablaCasa extends AbstractTableModel{

    ListaEnlazada<Casa> lista = new ListaEnlazada<>();

    public ListaEnlazada<Casa> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Casa> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Puesto";
            case 1: return "Numero de casa";
            case 2: return "Color";
            case 3: return "Numero de pisos";
            case 4: return "Ancho";
            case 5: return "Largo";
            default: return null;
            
        }
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Casa c = null;
        try {
            c = lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println(e);
        }
        switch(columnIndex){
            case 0: return (rowIndex+1);
            case 1: return (c != null) ? c.getNumeroCasa(): "NO DEFINIDO";
            case 2: return (c != null) ? c.getColor(): "NO DEFINIDO";
            case 3: return (c != null) ? c.getNumeroPisos(): "NO DEFINIDO";
            case 4: return (c != null) ? c.getAncho(): "NO DEFINIDO";
            case 5: return (c != null) ? c.getLargo(): "NO DEFINIDO";
            default: return null;
                
        }
    }
    
}
