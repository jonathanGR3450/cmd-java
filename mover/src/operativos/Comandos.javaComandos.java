/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos;

import java.util.Scanner;

/**
 * Clase que contiene los atributos esenciales de un comando que pueda ser
 * ingresado por un usuario, generaliza a clases como: "copiar, borrar, mover, y
 * otros.
 *
 * @author DANIEL RESTREPO - FABRICIO CAICEDO
 */
public class Comandos {

    private String dirOrigen;
    private String dirDestino;

    /**
     * Constructor por defecto de la clase
     */
    public Comandos() {
    }

    /**
     * Constructor sobrecargado de la clase que asigna valores no "default" a
     * todos los atributos de la clase.
     *
     * @param dirOrigen El paràmetro es una cadena "String" que contiene una
     * direcciòn o ruta origen.
     * @param dirDestino El paràmetro es una cadena "String" que contiene una
     * direcciòn o ruta origen.
     */
    public Comandos(String dirOrigen, String dirDestino) {
        this.setDirDestino(dirDestino);
        this.setDirOrigen(dirOrigen);
    }

    /**
     * Constructor sobrecargado de la clase que asigna un valor no "default" a
     * un atributo de la clase.
     *
     * @param dirOrigen El paràmetro es una cadena "String" que contiene una
     * direcciòn o ruta origen.
     */
    public Comandos(String dirOrigen) {
        this.setDirOrigen(dirOrigen);
    }

    /**
     * Mètodo de retorno "get" que devuelve el valor del atributo que lleva como
     * nombre.
     *
     * @return Devuelve una cadena "String" que contiene la direcciòn o ruta de
     * origen.
     */
    public String getDirOrigen() {
        return dirOrigen;
    }

    /**
     ** Mètodo de asignaciòn "set" que da un valor no "default" al atributo de
     * clase que lleva por nombre.
     *
     * @param dirOrigen El paràmetro es una cadena "String" que contiene el
     * directorio o ruta de origen.
     */
    public void setDirOrigen(String dirOrigen) {
        Scanner entrada = new Scanner(System.in);
        while (true) {
            if (dirOrigen.compareTo("") != 0 && !dirOrigen.equals(null)) {
                this.dirOrigen = dirOrigen;
                break;
            } else {
                System.out.println("Ingrese la direccion origen: ");
                dirOrigen = entrada.nextLine();
            }
        }
    }

    /**
     * Mètodo de retorno "get" que devuelve el valor del atributo que lleva como
     * nombre.
     *
     * @return Devuelve una cadena "String" que contiene la direccion o ruta de
     * destino.
     */
    public String getDirDestino() {
        return dirDestino;
    }

    /**
     * Mètodo de asignaciòn "set" que da un valor no "default" al atributo de
     * clase que lleva por nombre.
     *
     * @param dirDestino El paràmetro es una cadena "String" que contiene el
     * directorio o ruta de destino.
     */
    public void setDirDestino(String dirDestino) {
        Scanner entrada = new Scanner(System.in);
        while (true) {
            if (dirDestino.compareTo("") != 0 && !dirDestino.equals(null)) {
                this.dirDestino = dirDestino;
                break;
            } else {
                System.out.println("Ingrese la direccion destino: ");
                dirDestino = entrada.nextLine();
            }
        }
    }
}
