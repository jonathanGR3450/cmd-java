/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos;

import java.awt.Desktop;
import java.io.File;

/**
 * Clase que contiene las instrucciones del comando encargado de ejecutar
 * binarios.
 *
 * @author JONATHAN GARZON - FABRICIO CAICEDO
 */
public class Ejecutar extends Comandos {

    /**
     * Constructor de la clase que asigna un valor no "default" a un atributo de
     * la clase.
     *
     * @param dirOrigen El paràmetro es una cadena "String" que contiene una
     * direcciòn o ruta origen.
     */
    public Ejecutar(String dirOrigen) {
        super(dirOrigen);
        this.ejecutar();
    }

    /**
     * Mètodo procedimental encargado de ejecutar y llevar a cabo las
     * instrucciones necesarias para ejecutar binarios.
     */
    public void ejecutar() {
        File Ejecutar = new File(this.getDirOrigen());
        if (Ejecutar.exists()) {
            if (!Ejecutar.isDirectory()) {
                if (Ejecutar.canExecute()) {
                    try {
                        Desktop.getDesktop().open(Ejecutar);
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }
                } else {
                    System.out.println("No es un archivo ejecutable");
                }
            } else {
                System.out.println("La ruta indica que es un directorio");
            }
        } else {
            System.out.println("No existe esa ruta y/o archivo");
        }
    }
}
