/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Clase que contiene las instrucciones necesarias para ejecutar comandos
 * externos a los que contiene la aplicaciòn.
 *
 * @author DANIEL RESTREPO - FABRICIO CAICEDO
 */
public class Externo {

    //Atributos
    private String externo;

    /**
     * Mètodo encargado de ejecutar comandos externos de acuerdo al sistema
     * operativo en el que se estè trabajando-
     *
     * @param comando El paràmetro es una cadena "String" que contiene el
     * comando que se desea ejecutar.
     */
    public void externo(String comando) {
        Process Guardar;
        String salida;
        try {
            String Nombre[] = System.getProperty("os.name").split(" ");
            if (Nombre[0].compareTo("Windows") == 0) {
                this.externo = "cmd /c " + comando;
                Guardar = Runtime.getRuntime().exec(this.externo);
                InputStreamReader entrada = new InputStreamReader(Guardar.getInputStream());
                BufferedReader stdInput = new BufferedReader(entrada);
                if ((salida = stdInput.readLine()) != null) {
                    System.out.println("Comando ejecutado Correctamente");
                    while ((salida = stdInput.readLine()) != null) {
                        System.out.println(salida);
                    }
                } else {
                    System.out.println("No se ha producido ninguna salida");
                }
            } else {
                this.externo = comando;
                Guardar = Runtime.getRuntime().exec(this.externo);
                InputStreamReader entrada = new InputStreamReader(Guardar.getInputStream());
                BufferedReader stdInput = new BufferedReader(entrada);
                if ((salida = stdInput.readLine()) != null) {
                    System.out.println("Comando ejecutado Correctamente");
                    while ((salida = stdInput.readLine()) != null) {
                        System.out.println(salida);
                    }
                } else {
                    System.out.println("No se ha producido ninguna salida");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }
}
