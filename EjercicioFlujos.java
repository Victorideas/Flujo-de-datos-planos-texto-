/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioflujos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author instalador
 */
public class EjercicioFlujos {

    // final String direccion = "C:\\Users\\Instalador\\Desktop";
     final String direccion = "C:\\Users\\Víctor\\Desktop";
    File archivo = null;

    /**
     * @param args the command line arguments
     */
    public void info() {
        System.out.println("Datos de la ruta en consola..." + "\n");
        Path p1 = Paths.get(direccion);

        System.out.println(p1.toString());
        System.out.println(p1.getFileName());
        System.out.println(p1.getName(1));
        System.out.println(p1.getNameCount());
        System.out.println(p1.subpath(0, 2)+ "\n");
        System.out.println("Apartado 1 Completo..." + "\n");
        System.out.println("-------------------------------------------------" + "\n");
    }

    public File crear(File archivo) {

        try {
            archivo = new File(direccion, "\\Archivo.txt");
            archivo.createNewFile();

            if (archivo.exists()) {
                System.out.println("Apartado 2 Completo...El fichero se ha creado correctamente" + "\n");
            } else {
                System.out.println("Fallo: Ha explotado la direccion");
            }
            System.out.println("----------------------------------------------------");
        } catch (IOException e) {
            System.out.println("Fallo: El fichero no se ha creado");
        }
        return archivo;
    }

    public void mostrar(File archi) {
        if (archi.exists()) {
            System.out.println("Caracteristicas del fichero..." + "\n");
            System.out.println("Nombre del fichero: " + archi.getName());
            System.out.println("Ruta: " + archi.getPath());
            System.out.println("Ruta absoluta: " + archi.getAbsolutePath());
            System.out.println("Se puede leer: " + archi.canRead());
            System.out.println("Se puede escribir: " + archi.canWrite());
            System.out.println("Tamaño: " + archi.length());
            System.out.println("Es un directorio: " + archi.isDirectory());
            System.out.println("Es un fichero: " + archi.isFile());
            System.out.println("Nombre del directorio padre: " + archi.getParent() + "\n");
            System.out.println("Apartado 3 Completo..." + "\n");
            System.out.println("-------------------------------------------------" + "\n");
        } else {
            System.out.println("El archivo no se ha podido leer");
        }
    }

    public void directorios() {
        System.out.println("Datos del directorio..." + "\n");
        File direc = new File(direccion);
        try {
            String[] lista = direc.list();
            System.out.println("Ficheros en la direccion actual: " + lista.length);
            for (int i = 0; i < lista.length; i++) {
                File uno = new File(direc, lista[i]);
                System.out.println("Nombre:" + lista[i] + " ¿es fichero?: " + uno.isFile() + " ¿es directorio?: " + uno.isDirectory() + "\n");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("Apartado 4 Completo..." + "\n");
        System.out.println("--------------------------------------------" + "\n");
    }

    public void copiar() {
        //Files.move(path, path1, cos);
        File dir = new File(direccion, "Carpeta Copia");
        dir.mkdir();

        String nuevadirec = dir.getPath();
        int c;

        FileReader leer = null;
        FileWriter escribir = null;

        File nuevo = new File(nuevadirec, "Archivo Copia.txt");

        try {
            nuevo.createNewFile();
            leer = new FileReader(direccion + "\\Archivo.txt");
            escribir = new FileWriter(nuevo);
            c = leer.read();
            while (c != -1) {
                escribir.write(c);
                c = leer.read();
            }
            escribir.close();
            leer.close();
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("Apartado 5a Archivo Copiado" + "\n");
        System.out.println("------------------------------------------" + "\n");
    }

    public void mover(File archivo) {
        File dir = new File(direccion, "Carpeta Mover");
        dir.mkdir();

        String nuevadirec = dir.getPath();
        int c;

        FileReader leer = null;
        FileWriter escribir = null;

        File nuevo = new File(nuevadirec, "Archivo Movido.txt");

        try {
            nuevo.createNewFile();
            leer = new FileReader(direccion + "\\Archivo.txt");
            escribir = new FileWriter(nuevo);
            c = leer.read();
            while (c != -1) {
                escribir.write(c);
                c = leer.read();
            }
            escribir.close();
            leer.close();

        } catch (IOException e) {
            e.getMessage();
        }
        archivo.delete();
        System.out.println("Apartado 5b Archico movido de carpeta " + "\n");
        System.out.println("-------------------------------------------------" + "\n");
    }

    public void borrardirectorio() {
        String nueva = direccion + "\\Hola";

        File directorio = new File(direccion, "Hola");
        directorio.mkdir();
        File f1 = null;
        File f2 = null;
        try {
            f1 = new File(nueva, "Hola 1.txt");
            f2 = new File(nueva, "Hola 2.txt");
            f1.createNewFile();
            f2.createNewFile();
        } catch (Exception e) {
            e.getMessage();
        }
        f1.delete(); //Comentar estas lineas delete() si se quiere visualizar las carpetas creadas
        f2.delete();
        directorio.delete();
        System.out.println("Apartado 6 Completo...Directorio y ficheros creados y eliminados " + "\n");
        System.out.println("----------------------------------------------------------------- " + "\n");
    }

    public void leerFile() { //Ejercicio 7
        System.out.println("Aparatado 7...Leyendo fichero caracter a caracter...");
        String texto = "";
        int c;
        FileReader leer = null;
        try {
            leer = new FileReader(direccion + "\\ArchivoLeer.txt"); //Hay que crear este archico con texto dentro para poderlo leer
            c = leer.read();
            while (c != -1) {
                texto = texto + (char) c;
                c = leer.read();
            }
            leer.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
        System.out.println(texto);
        System.out.println("----------------------------------------------------------------- " + "\n");
    }

    public void leerBuffer() {
        FileReader fr = null;
        BufferedReader br = null;
        System.out.println("Apartado 8...Leyendo fichero con Buffer:");
        try {
            fr = new FileReader(direccion + "\\ArchivoLeer.txt"); //Hay que crear este archico con texto dentro para poderlo leer
            br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void usuario() {
        System.out.println("----------------------------------------------------------------- " + "\n");
        File usuario = null;
        Scanner sca = new Scanner(System.in);
        String[] lista = new String[2];
        System.out.println("Introduzca su nombre:");
        lista[0] = sca.nextLine();
        System.out.println("Introduzca su edad:");
        lista[1] = sca.nextLine();
        FileWriter fw = null;

        try {
            usuario = new File(direccion, "\\datos.txt");
            if (usuario.exists()) {
                usuario.delete();
                System.out.println("Existe ya un usuario. Se procede a borrar sus datos.");
            }
            fw = new FileWriter(usuario);
            for (int i = 0; i < 2; i++) {
                fw.write(lista[i] + "\n");
            }
            System.out.println("Nuevo usuario guardado correctamente en datos.txt.");
            System.out.println("------------------------------------");
            fw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void escribirBuffer() {
        File usuario = new File(direccion + "\\datos1.txt");
        BufferedWriter bw = null;
        String nombre;
        String edad;
        Scanner sca = new Scanner(System.in);

        System.out.println("Introduzca su nombre:");
        nombre = sca.nextLine();
        System.out.println("Introduzca su edad:");
        edad = sca.nextLine();
        try {
            if (usuario.exists()) {
                usuario.delete();
            }
            bw = new BufferedWriter(new FileWriter(usuario, true));
            bw.write("Nombre: " + nombre + "\n");
            bw.write("Edad: " + edad + "\n");
            bw.close();
            System.out.println("Nuevo usuario guardado correctamente en datos1.txt.");
            System.out.println("------------------------------------------ " + "\n");
        } catch (IOException e) {
            e.getMessage();
        }

    }

    public void linea() {
        File linea = new File(direccion + "\\linea.txt");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(linea, true));
            bw.write("------------------------------------" + "\n");
            bw.close();
            System.out.println("Linea creada ---------------------------------------------- " + "\n");
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
