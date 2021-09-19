/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase que contiene las instrucciones del comando que brinda informaciòn sobre
 * un archivo o un directorio.
 *
 * @author JONATHAN GARZON - FABRICIO CAICEDO
 */
public class Informacion extends Comandos {

    /**
     * Constructor que asigna un valor no "default" a un atributo de la clase.
     *
     * @param dirOrigen El paràmetro es una cadena "String" que contiene una
     * direcciòn o ruta origen.
     */
    public Informacion(String dirOrigen) {
        super(dirOrigen);
        this.Informacion(this.getDirOrigen());
    }

    /**
     *
     * @param ruta
     */
    public void Informacion(String ruta) {
        File Informacion = new File(ruta);
        if (Informacion.exists()) {
            if (Informacion.isDirectory()) {
                System.out.println("El directorio " + Informacion.getName() + " tiene: ");
                File Ficheros[] = Informacion.listFiles();
                for (int x = 0; x < Ficheros.length; x++) {
                    if (Ficheros[x].isDirectory()) {
                        System.out.println("Directorio: " + Ficheros[x].getName());
                    } else {
                        System.out.println("Archivo: " + Ficheros[x].getName());
                    }
                    System.out.println("Fecha de creacion:  " + this.FechaHoraCreacion(Informacion.getPath()));
                    long fecha = Informacion.lastModified();
                    System.out.println("Ultima modificacion:  " + this.FechaHoraModificacion(fecha));
                }
            } else {
                System.out.println("Nombre y extension: " + Informacion.getName());
                String Ruta[] = Informacion.getPath().split(Informacion.getName());
                System.out.println("Ruta: " + Ruta[0]);
                System.out.println("Fecha de creacion:  " + this.FechaHoraCreacion(Informacion.getPath()));
                long fecha = Informacion.lastModified();
                System.out.println("Ultima modificacion:  " + this.FechaHoraModificacion(fecha));
            }
        } else {
            System.out.println("No existe el archivo o directorio");
        }
    }

    /**
     *
     * @param fecha
     * @return
     */
    private String FechaHoraModificacion(long fecha) {
        Date Fecha = new Date(fecha);
        Calendar Completa = new GregorianCalendar();
        Completa.setTime(Fecha);
        return ("Fecha: " + Integer.toString(Completa.get(Calendar.DATE)) + "/" + Integer.toString(Completa.get(Calendar.MONTH)) + "/"
                + Integer.toString(Completa.get(Calendar.YEAR)) + " Hora: " + Integer.toString(Completa.get(Calendar.HOUR_OF_DAY)) + ":"
                + Integer.toString(Completa.get(Calendar.MINUTE)) + ":" + Integer.toString(Completa.get(Calendar.SECOND)));
    }

    /**
     *
     * @param direccion
     * @return
     */
    private String FechaHoraCreacion(String direccion) {
        String Creacion = "";
        try {
            Path file = Paths.get(direccion);
            BasicFileAttributes Info = Files.readAttributes(file, BasicFileAttributes.class);
            FileTime creacion = Info.creationTime();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss ");
            Creacion = df.format(creacion.toMillis());
        } catch (Exception e) {
            System.out.println();
        }
        return (Creacion);
    }
}
