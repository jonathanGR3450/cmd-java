/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos;

import java.io.File;

/**
 * Clase que contiene las instrucciones del comando encargado de trasladar al
 * usuario a la ruta que el desee.
 *
 * @author DANIEL RESTREPO - FABRICIO CAICEDO
 */
public class Ir extends Comandos {

    /**
     * Mètodo procedimental encargado de ejecutar y llevar a cabo las
     * instrucciones necesarias para cambiar de ruta.
     */
    public void ir() {
        File ruta = new File(this.getDirDestino());
        if (ruta.isDirectory()) {
            System.setProperty("user.dir", this.getDirDestino());
            System.out.println("Ahora estás en el directorio " + System.getProperty("user.dir"));
        } else {
            System.out.println("Directorio no existe, o inválido");
        }
    }
}
