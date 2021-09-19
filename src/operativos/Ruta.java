/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos;

/**
 * Clase que contiene las instrucciones del comando indicador del actual
 * directorio.
 *
 * @author JONATHAN GARZON - FABRICIO CAICEDO
 */
public class Ruta extends Comandos {

    /**
     * Mètodo de retorno "get" encargado de ejecutar las instrucciones para
     * obtener el directorio actual de trabajo.
     *
     * @return Devuelve una cadena "String" que contiene el directorio o ruta
     * actual en la que està ubicado el usuario.
     */
    public String actual() {
        String ruta = System.getProperty("user.dir");
        return ruta;
    }
}
