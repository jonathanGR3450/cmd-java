/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos;

import java.util.Scanner;

/**
 * Clase que contiene el mètodo principal "main" mediate el cual inicia la
 * aplicacion
 *
 * @author DANIEL RESTREPO - FABRICIO CAICEDO
 */
public class Inicio {

    /**
     * Mètodo cuya funciòn es tratar el comando ingresado por el usuario, y asì
     * facilitar a la aplicaciòn la comprensiòn de èste
     *
     * @param mediaIn El paràmetro contiene una cadena "String" la cual es en si
     * el comando ingresado por el usuario
     * @return Devuelve un arregle de cadenas "String" que contienen las partes
     * en las que se divide el comando: paràmetros
     */
    public String[] Instruccion(String mediaIn) {
        String completo[] = mediaIn.split(" ");
        String completaIn[] = new String[3];
        int contador = 0;
        for (int x = 0; x < completo.length; x++) {
            if (completo[x].compareTo("") != 0 && contador >= 0 && contador <= 2) {
                completaIn[contador] = completo[x];
                contador++;
            }
        }
        return completaIn;
    }

    /**
     * Mètodo principal "main" por donde inicia la aplicacion
     *
     * @param args El paràmetro es un conjunto de datos que se le pueden mandar
     * a la aplicaciòn al mismo tiempo que inicia
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Inicio inicio = new Inicio();
        System.out.println("--------------------------------------");
        System.out.println("Bienvenido a la shell FACA");
        System.out.println("--------------------------------------");
        System.out.print("Ingrese un Comando:  ");
        String comando = entrada.nextLine();
        String Instruccion[] = inicio.Instruccion(comando);
        while (true) {
            if (Instruccion[0] == null) {
                Instruccion[0] = " ";

            }
            if (Instruccion[0].compareTo("copiar") == 0) {
                if (Instruccion.length > 2) {
                    if (Instruccion[1] != null && Instruccion[2] != null) {
                        Copiar copiar = new Copiar(Instruccion[1], Instruccion[2]);
                        copiar.copiarBinario();
                    } else {
                        System.out.println("Error en los parametros");
                    }
                }
            } else if (Instruccion[0].compareTo("mover") == 0) {
                if (Instruccion.length > 2) {
                    if (Instruccion[1] != null && Instruccion[2] != null) {
                        Mover mover = new Mover(Instruccion[1], Instruccion[2]);
                        mover.copiarBinario();
                        mover.moverBinario();
                    } else {
                        System.out.println("Error en los parametros");
                    }
                }

            } else if (Instruccion[0].compareTo("borrar") == 0) {
                if (Instruccion.length > 1) {
                    if (Instruccion[1] != null) {
                        Borrar borrar = new Borrar(Instruccion[1]);
                    } else {
                        System.out.println("Error en los parametros");
                    }
                }
            } else if (Instruccion[0].compareTo("info") == 0) {
                if (Instruccion.length > 1) {
                    if (Instruccion[1] != null) {
                        Informacion info = new Informacion(Instruccion[1]);
                    } else {
                        System.out.println("Error en los parametros");
                    }

                }
            } else if (Instruccion[0].compareTo("ejecutar") == 0) {
                if (Instruccion.length > 1) {
                    if (Instruccion[1] != null) {
                        Ejecutar ejecutar = new Ejecutar(Instruccion[1]);
                    } else {
                        System.out.println("Error en los parametros");
                    }
                }
            } else if (Instruccion[0].compareTo("ruta") == 0) {
                Ruta ruta = new Ruta();
                System.out.println(ruta.actual());
            } else if (Instruccion[0].compareTo("ir") == 0) {
                if (Instruccion.length > 1) {
                    Ir ir = new Ir();
                    ir.setDirDestino(Instruccion[1]);
                    ir.ir();
                } else {
                    System.out.println("Error en los parametros");
                }
            } else if (Instruccion[0].compareTo("salir") == 0) {
                Salir salir = new Salir();
                salir.salir(Instruccion[0]);
                break;
            } else {
                Externo externo = new Externo();
                externo.externo(Instruccion[0]);
            }
            System.out.print("Ingrese un Comando:  ");
            comando = entrada.nextLine();
            Instruccion = inicio.Instruccion(comando);
        }
    }

}
