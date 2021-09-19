/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Clase que contiene las instrucciones para la movilizaciòn de un archivo.
 *
 * @author DANIEL RESTREPO - FABRICIO CAICEDO
 */
public class Mover extends Comandos {

    /**
     * Constructor de la clase que inicializa los atributos de la clase "padre"
     * con valores no "default".
     *
     * @param dirOrigen El paràmetro es una cadena "String" que contiene la ruta
     * del archivo que se desea mover.
     * @param dirDestino El paràmetro es una cadena "String" que contiene la
     * ruta donde quedarà el archivo.
     */
    public Mover(String dirOrigen, String dirDestino) {
        super(dirOrigen, dirDestino);
    }

    /**
     * Mètodo procedimental encargado de ejecutar y llevar a cabo las
     * instrucciones necesarias para mover un archivo.
     */
    public void copiarBinario() {
        File Origen = new File(this.getDirOrigen());
        if (Origen.exists()) {
            try {
                BufferedInputStream Original = new BufferedInputStream(new FileInputStream(Origen));
                BufferedOutputStream Copia = new BufferedOutputStream(new FileOutputStream(this.getDirDestino() + Origen.getName()));
                int copia = Original.read();
                while (copia != -1) {
                    Copia.write(copia);
                    copia = Original.read();
                }
                Copia.close();
                Original.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getLocalizedMessage());
            }
        } else {
            System.out.println("No existe el archivo");
        }
    }

    public void moverBinario() {
        File eliminar = new File(this.getDirOrigen());
        File Nombre = new File(this.getDirDestino() + eliminar.getName());
        if (eliminar.getPath().compareTo(Nombre.getPath()) != 0) {
            eliminar.delete();
        }
    }
}
