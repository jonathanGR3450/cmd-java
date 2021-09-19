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
 * @author JONATHAN GARZON - FABRICIO CAICEDO
 */
public class Mover extends Comandos {
    private Copiar a;
    /**
     * Constructor de la clase que inicializa los atributos de la clase "padre"
     * con valores no "default".
     *
     * @param dirOrigen El paràmetro es una cadena "String" que contiene la ruta
     * del archivo que se desea mover.
     * @param dirDestino El paràmetro es una cadena "String" que contiene la
     * ruta donde quedarà el archivo.
     */
    public Mover(String dirOrigen, String dirDestino ) {
        super(dirOrigen, dirDestino);
        this.a = new Copiar( this.getDirOrigen(), this.getDirDestino());
    }

    /**
     * Mètodo procedimental encargado de ejecutar y llevar a cabo las
     * instrucciones necesarias para mover un archivo.
     */
    public void CopiarDirectorio(){
        this.a.Directorio();
    }
    public void CopiarFichero(){
        this.a.copiarBinario();
    }
    public void eliminarBinario( String dirOrigen ) {
        File eliminar = new File(dirOrigen);
        if (eliminar.exists()) {
            if (eliminar.isDirectory()) {
                File Lista[] = eliminar.listFiles();
                if (Lista.length > 0) {
                    for (int x = 0; x < Lista.length; x++) {
                        this.eliminarBinario( Lista[x].getPath() );
                    }
                    eliminar.delete();
                } else 
                    eliminar.delete();
            } else {
                eliminar.delete();
            }
        } else {
            System.out.println("No existe, o ruta invalida");
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
