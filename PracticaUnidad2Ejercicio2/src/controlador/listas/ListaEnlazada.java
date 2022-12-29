/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Listas;

import controlador.Listas.excepciones.AtributoException;
import controlador.Listas.excepciones.ListaNullException;
import controlador.Listas.excepciones.PosicionNoEncontradaExcepcion;
import controlador.utilidades.Utilidades;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 *
 * @author ivangonzalez
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size;
    private ListaEnlazada<E> lista;
    public static Integer DESCENDENTE = 1;
    public static Integer ASCENDENTE = 2;

    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public ListaEnlazada<E> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<E> lista) {
        this.lista = lista;
    }

    public Boolean estaVacia() {
        return cabecera == null;
    }

    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            this.cabecera = nodo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        size++;
    }

    public void insertarCabecera(E dato) {

        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            size++;
        }
    }

    public void insertarPosicion(E dato, Integer pos) throws PosicionNoEncontradaExcepcion {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            if (pos == (size - 1)) {
                insertar(dato);
            } else if (pos == 0) {
                insertarCabecera(dato);
            } else {
                NodoLista<E> nodo = new NodoLista(dato, null);
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < (pos - 1); i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nodo);
                nodo.setSiguiente(siguiente);
                size++;
            }

        } else {
            throw new PosicionNoEncontradaExcepcion();
        }
    }

    public void imprimir() {
        System.out.println("-------------LISTA ENLAZADA---------------");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.print(aux.getDato().toString() + "\n");
            aux = aux.getSiguiente();
        }
        System.out.println("\n------------------------------------------");

    }

    public void generarLista(Integer numDatos) {
        for (int i = 0; i < numDatos; i++) {
            float num = (float) (Math.random() * 5001);
            Object aux = (float) (Math.round(num * 100d) / 100d);
            insertar((E) aux);
        }
    }

    public void imprimirListaFloat() {
        System.out.println("-------------LISTA ENLAZADA---------------");
        NodoLista<E> aux = cabecera;
        int i = 1;
        int j = 1;
        while (aux != null) {
            i++;
            System.out.print(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
            j++;
            if (i > 10) {
                System.out.println("\n");
                i = 1;
            }
        }
        System.out.println("\n------------------------------------------");

    }

    public E obtener(Integer pos) throws ListaNullException, PosicionNoEncontradaExcepcion {

        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
            } else {
                throw new PosicionNoEncontradaExcepcion();
            }

            return dato;
        } else {
            throw new ListaNullException();
        }
    }

    public void modificarDato(E dato, Integer pos) throws PosicionNoEncontradaExcepcion {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            if (pos == 0) {
                cabecera.setDato(dato);
            } else {
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }
        } else {
            throw new PosicionNoEncontradaExcepcion();
        }
    }

    public E eliminar(Integer pos) throws ListaNullException, PosicionNoEncontradaExcepcion {
        System.out.println("pos " + pos);
        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }
            } else {
                throw new PosicionNoEncontradaExcepcion();
            }

            return dato;
        } else {
            throw new ListaNullException();
        }
    }

    public E[] toArray() {
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) Array.newInstance(cabecera.getDato().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] matriz) {
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

    public void vaciar() {
        this.cabecera = null;
        this.size = 0;
    }

    public ListaEnlazada<E> burbuja(String atributo, Integer tipoOrdenacion) throws Exception {
        Class<E> clazz = null;
        E[] matriz = toArray();
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            for (int i = matriz.length; i > 1; i--) {
                for (int j = 0; j < i - 1; j++) {
                    if (isObject) {
                        intercambioObjetoBurbuja(j, matriz, clazz, tipoOrdenacion, atributo);
                    } else {
                        intercambioDatoBurbuja(j, matriz, clazz, tipoOrdenacion);
                    }
                }
            }
        }
        if (matriz != null) {
            toList(matriz);
        }
        return this;
    }

    private void intercambioDatoBurbuja(int j, E[] matriz, Class clazz, Integer tipoOrdenacion) throws PosicionNoEncontradaExcepcion {
        E auxJ = matriz[j];
        E auxJ1 = matriz[j + 1];
        intercambioBurbuja(j, matriz, auxJ, auxJ1, tipoOrdenacion);
    }

    private void intercambioObjetoBurbuja(int j, E[] matriz, Class clazz, Integer tipoOrdenacion, String atributo) throws Exception {
        E auxJ = matriz[j];
        E auxJ1 = matriz[j + 1];
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } else {
            field.setAccessible(true);
            Object a = field.get(auxJ);
            Object b = field.get(auxJ1);
            intercambioBurbuja(j, matriz, a, b, tipoOrdenacion);
        }
    }

    private void intercambioBurbuja(int j, E[] matriz, Object auxJ, Object auxJ1, Integer tipoOrdenacion) throws PosicionNoEncontradaExcepcion {
        Class clazz = auxJ.getClass();
        E a = matriz[j];
        E b = matriz[j + 1];
        if (Utilidades.isNumber(clazz)) {
            if (tipoOrdenacion == DESCENDENTE) {
                if (((Number) auxJ).doubleValue() < ((Number) auxJ1).doubleValue()) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            } else {
                if (((Number) auxJ).doubleValue() > ((Number) auxJ1).doubleValue()) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            }
        } else if (Utilidades.isString(clazz)) {
            if (tipoOrdenacion == DESCENDENTE) {
                if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) < 0) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            } else {
                if (auxJ.toString().toLowerCase().compareTo(auxJ1.toString().toLowerCase()) > 0) {
                    matriz[j] = b;
                    matriz[j + 1] = a;
                }
            }

        }
        
    }

    public ListaEnlazada<E> ordenarShellSort(String atributo, Integer tipoOrdenacion) throws Exception {
        Class<E> clazz = null;
        E[] matriz = toArray();
        int bloque;
        bloque = matriz.length / 2;
        while (bloque > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            for (int i = bloque; i < matriz.length; i++) {
                int j = i - bloque;
                while (j >= 0) {
                    int k = j + bloque;
                    if (isObject) {
                        intercambioObjetoShell(j, k, matriz, clazz, tipoOrdenacion, atributo);
                        j -= bloque;
                    } else {
                        intercambioDatoShell(j, k, matriz, clazz, tipoOrdenacion, atributo);
                        j -= bloque;
                    }
                }
            }
            bloque = bloque / 2;
        }
        if (matriz != null) {
            toList(matriz);
        }
        return this;
    }

    private void intercambioDatoShell(Integer j, Integer k, E[] matriz, Class clazz, Integer TipoOrdenacion, String atributo) throws PosicionNoEncontradaExcepcion {
        E auxj = matriz[j];
        E auxk = matriz[k];
        intercambioShell(j, k, matriz, auxj, auxk, TipoOrdenacion);
    }

    private void intercambioObjetoShell(Integer j, Integer k, E[] matriz, Class clazz, Integer TipoOrdenacion, String atributo) throws Exception {
        E auxj = matriz[j];
        E auxk = matriz[k];
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } else {
            field.setAccessible(true);
            Object a = field.get(auxj);
            Object b = field.get(auxk);
            intercambioShell(j, k, matriz, a, b, TipoOrdenacion);
        }
    }

    private void intercambioShell(int j, int k, E[] matriz, Object auxj, Object auxk, Integer TipoOrdenacion) throws PosicionNoEncontradaExcepcion {
        Class clazz = auxj.getClass();
        if (Utilidades.isNumber(clazz)) {
            if (TipoOrdenacion == ASCENDENTE) {
                if (((Number) auxj).doubleValue() <= ((Number) auxk).doubleValue()) {
                    j = -1;
                } else {
                    E aux = matriz[j];
                    matriz[j] = matriz[k];
                    matriz[k] = aux;
                }
            } else {
                if (((Number) auxj).doubleValue() >= ((Number) auxk).doubleValue()) {
                    j = -1;
                } else {
                    E aux = matriz[j];
                    matriz[j] = matriz[k];
                    matriz[k] = aux;
                }
            }
        } else if (Utilidades.isString(clazz)) {
            if (TipoOrdenacion == ASCENDENTE) {
                if (auxj.toString().toUpperCase().compareTo(auxk.toString().toUpperCase()) <= 0) {
                    j = -1;
                } else {
                    E aux = matriz[j];
                    matriz[j] = matriz[k];
                    matriz[k] = aux;
                }
            } else {
                if (auxj.toString().toUpperCase().compareTo(auxk.toString().toUpperCase()) >= 0) {
                    j = -1;
                } else {
                    E aux = matriz[j];
                    matriz[j] = matriz[k];
                    matriz[k] = aux;
                }
            }
        }
        
    }

    public ListaEnlazada<E> busquedaSecuencial(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> result = new ListaEnlazada<>();
        if (size > 0) {
            E[] matriz = toArray();
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);

            for (int i = 0; i < matriz.length; i++) {
                if (isObject) {;
                    Boolean band = evaluarBusquedaObjetoSecuencial(matriz[i], dato, clazz, atributo);
                    if (band) {
                        result.insertar(matriz[i]);
                    }
                } else {
                    Boolean band = buscarPosicionSecuencial(matriz[i], dato);
                    if (band) {
                        result.insertar(matriz[i]);
                    }
                }
            }
        }
        return result;
    }
    
    private Boolean evaluarBusquedaObjetoSecuencial(E aux, Object dato, Class clazz, String atributo) throws Exception {
        Field field = Utilidades.obtenerAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        }
        field.setAccessible(true);
        Object a = field.get(aux);
        return buscarPosicionSecuencial(a, dato);
    }

    private Boolean buscarPosicionSecuencial(Object datoMatriz, Object busqueda) {
        if (Utilidades.isNumber(busqueda.getClass())) {
            if (((Number) datoMatriz).doubleValue() == ((Number) busqueda).doubleValue()) {
                return true;
            }
        } else if (Utilidades.isString(busqueda.getClass())) {
            if (datoMatriz.toString().toLowerCase().startsWith(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().endsWith(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().equalsIgnoreCase(busqueda.toString().toLowerCase())
                    || datoMatriz.toString().toLowerCase().contains(busqueda.toString().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public Integer buscarBinario(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        E[] matriz = toArray();
        Integer result = -1;
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
            Boolean isObject = Utilidades.isObject(clazz);
            Integer central, bajo, alto;
            Object valorCentral;
            bajo = 0;
            alto = matriz.length - 1;
            while (bajo <= alto) {
                central = (bajo + alto) / 2;
                valorCentral = matriz[central];
                if (isObject) {
                    //dato, matriz[centra], atributo, clazz
                    Field field = Utilidades.obtenerAtributo(clazz, atributo);
                    if (field == null) {
                        throw new Exception();
                    }
                    field.setAccessible(true);
                    Object datoMatriz = field.get(valorCentral);
                    if(Utilidades.isNumber(datoMatriz.getClass())){
                        if (((Number) dato).doubleValue() == ((Number) datoMatriz).doubleValue()) {
                            return central;
                        } else if (((Number) dato).doubleValue() < ((Number) datoMatriz).doubleValue()) {
                            alto = central - 1;
                        } else {
                            bajo = central + 1;
                        }
                    } else if(Utilidades.isString(datoMatriz.getClass())){
                        if (dato.toString().toUpperCase().equals(datoMatriz.toString().toUpperCase())) {
                            return central;
                        } else if (dato.toString().toUpperCase().compareTo(datoMatriz.toString().toUpperCase()) < 0) {
                            alto = central - 1;
                        } else {
                            bajo = central + 1;
                        }
                    } else throw new Exception();

                } else {
                    if (Utilidades.isNumber(matriz[0].getClass())) {
                        if (((Number) dato).doubleValue() == ((Number) valorCentral).doubleValue()) {
                            return central;
                        } else if (((Number) dato).doubleValue() < ((Number) valorCentral).doubleValue()) {
                            alto = central - 1;
                        } else {
                            bajo = central + 1;
                        }
                    } else if (Utilidades.isString(matriz[0].getClass())) {
                        if (dato.toString().toUpperCase().equals(valorCentral.toString().toUpperCase())) {
                            return central;
                        } else if (dato.toString().toUpperCase().compareTo(valorCentral.toString().toUpperCase()) < 0) {
                            alto = central - 1;
                        } else {
                            bajo = central + 1;
                        }
                    } else throw new Exception();
                }
            }
        }
        return result;
    }
}
