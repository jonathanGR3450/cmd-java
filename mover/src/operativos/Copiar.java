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
 * Clase que contiene las instrucciones de clonaciòn o copia de un archivo.
 *
 * @author DANIEL RESTREPO - FABRICIO CAICEDO
 */
public class Copiar extends Comandos {

    /**
     * Constructor de la clase que inicializa los atributos de la clase "padre"
     * con valores no "default".
     *
     * @param dirOrigen El paràmetro es una cadena "String" que contiene la ruta
     * del archivo que se desea copiar.
     * @param dirDestino El paràmetro es una cadena "String" que contiene la
     * ruta donde quedarà la copia del archivo.
     */
    public Copiar(String dirOrigen, String dirDestino) {
        super(dirOrigen, dirDestino);
    }

    /**
     * Mètodo cuya funciòn es ejcutar las instrucciones de copia de un archivo.
     */
    public void copiarBinario() {
        File Origen = new File(this.getDirOrigen());
        if (Origen.exists()) {
            int x = 0;
            String nombre = this.nombre("copia_" + x + " " + Origen.getName(), x);
            try {
                BufferedInputStream Original = new BufferedInputStream(new FileInputStream(Origen));
                BufferedOutputStream Copia = new BufferedOutputStream(new FileOutputStream(this.getDirDestino() + nombre));
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

    public String nombre(String nombreEx, int x) {
        File nombre = new File(this.getDirDestino() + nombreEx);
        if (!nombre.exists()) {
            return nombre.getName();
        } else {
            x++;
            String Final = "copia_" + x + " " + this.Nombre(nombre.getName(), x - 1);
            return (this.nombre(Final, x));
        }
    }

    private String Nombre(String cadena, int y) {
        String A[] = cadena.split("copia_" + y + " ");
        return (A[1]);
    }
}
