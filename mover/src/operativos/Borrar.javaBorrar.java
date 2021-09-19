/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos;

import java.io.File;

/**
 * Clase que contiene las instrucciones del comando de borrado o eliminaciòn.
 *
 * @author DANIEL RESTREPO - FABRICIO CAICEDO
 */
public class Borrar extends Comandos {

    /**
     * Constructor de la clase encargado de inicializar los atributos, que para
     * el caso son heredados de la clase padre.
     *
     * @param dirOrigen El paràmetro contiene el valor que se le asignarà al.
     * atributo correspodiente
     */
    public Borrar(String dirOrigen) {
        super(dirOrigen);
        this.eliminarBinario(this.getDirOrigen());
    }

    /**
     * Mètodo cuya funciòn es ejcutar las instrucciones de borrado, ya sea de un
     * archivo o de un directorio.
     *
     * @param dirOrigen El paràmetro es una cadena "String" que contiene la ruta
     * del archivo o directorio que se desea eliminar.
     */
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
}
