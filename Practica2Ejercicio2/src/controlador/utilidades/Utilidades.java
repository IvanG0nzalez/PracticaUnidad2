/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.utilidades;


import com.google.gson.Gson;
import controlador.Listas.ListaEnlazada;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import controlador.ControladorCasa;
import modelo.Casa;

/**
 *
 * @author Iván González
 */
public class Utilidades {
    
    public static String DISCARPDATA = "data";
    
    public static Field obtenerAtributo(Class clase, String nombre) {
        Field atributo = null;
        for (Field aux : clase.getDeclaredFields()) {
            if (nombre.equalsIgnoreCase(aux.getName())) {
                atributo = aux;
                break;
            }
        }
        return atributo;
    }
    
    public static Boolean isNumber(Class clase) {
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }

    public static Boolean isString(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("String");
    }

    public static Boolean isCharacter(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }

    public static Boolean isBoolean(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }

    public static Boolean IsPrimitive(Class clase) {
        return clase.isPrimitive();
    }

    public static Boolean isObject(Class clase) {
        return (!IsPrimitive(clase) && !isBoolean(clase) && !isCharacter(clase) && !isNumber(clase) && !isString(clase));
    }
    
    public static boolean guardarJson(ControladorCasa casas){
        Gson gson = new Gson();
        String json = gson.toJson(casas);
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(DISCARPDATA + File.separatorChar + "casas.json"))) {
            bw.write(json);
            System.out.println("Fichero creado");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    public static ControladorCasa cargarJson(){
        String fichero = "";
        Gson gson = new Gson();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(DISCARPDATA + File.separatorChar + "casas.json"));
            String linea = "";
            while ((linea = br.readLine()) != null) {                
                fichero = fichero + linea;
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        ControladorCasa casas = gson.fromJson(fichero, ControladorCasa.class);
        return casas;
    }
    
    
}
