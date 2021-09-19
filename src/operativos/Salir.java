/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Clase que contiene las instruccions del comando de salida.
 *
 * @author JONATHAN GARZON - FABRICIO CAICEDO
 */
public class Salir extends Comandos {

    //Atributos
    private String salir;

    //Mètodos
    /**
     * Mètodo procedimental encargado de ejecutar las instrucciones necesarias
     * para salir.
     *
     * @param comando El paràmetro es una cadena "String" que contiene el
     * comando ingresado por el usuario.
     */
    public void salir(String comando) {
        Process Guardar;
        String salida;
        try {
            String Nombre[] = System.getProperty("os.name").split(" ");
            if (Nombre[0].compareTo("Windows") == 0) {
                this.salir = "cmd /c " + comando;
                Guardar = Runtime.getRuntime().exec(this.salir);
                InputStreamReader entrada = new InputStreamReader(Guardar.getInputStream());
                BufferedReader stdInput = new BufferedReader(entrada);
                if ((salida = stdInput.readLine()) != null) {
                    System.out.println("Comando ejecutado Correctamente");
                    while ((salida = stdInput.readLine()) != null) {
                        System.out.println(salida);
                    }
                } else {
                    System.out.println("Hasta pronto...");
                }
            } else {
                this.salir = "exit";
                Guardar = Runtime.getRuntime().exec(this.salir);
                InputStreamReader entrada = new InputStreamReader(Guardar.getInputStream());
                BufferedReader stdInput = new BufferedReader(entrada);
                if ((salida = stdInput.readLine()) != null) {
                    System.out.println("Comando ejecutado Correctamente");
                    while ((salida = stdInput.readLine()) != null) {
                        System.out.println(salida);
                    }
                } else {
                    System.out.println("Hasta pronto...");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }
}
