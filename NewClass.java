/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioflujos;


import java.io.File;
import java.io.IOException;

/**
 *
 * @author instalador
 */
public class NewClass {
 
 public static void main(String[] args) throws IOException {
     EjercicioFlujos Ejercicio = new EjercicioFlujos();
     File archivo= null;
     
        Ejercicio.info(); // Ejercicio 1
        archivo = Ejercicio.crear(archivo); // Ejercicio 2
        Ejercicio.mostrar(archivo); //Ejercicio 3
        Ejercicio.directorios(); //Ejercicio 4
        Ejercicio.copiar(); //Ejercicio 5a
        Ejercicio.mover(archivo); // Ejercicio 5b
        Ejercicio.borrardirectorio(); //Ejercicio 6
        Ejercicio.leerFile(); // Ejercicio 7
        Ejercicio.leerBuffer(); // Ejercicio 8
        Ejercicio.usuario(); //Ejercicio 9
        Ejercicio.escribirBuffer(); // Ejercicio 10
        Ejercicio.linea(); //Ejercicio 11
    }

}
