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
import operativos.Comandos;

/**
 * Clase que contiene las instrucciones de clonaciòn o copia de un archivo.
 *
 * @author JONATHAN GARZON - FABRICIO CAICEDO
 */
public class Copiar extends Comandos {
    private String CopiaCarpeta;
    private String Copia;
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

    Copiar() {}
    /**
     * Mètodo cuya funciòn es ejcutar las instrucciones de copia de un archivo.
     */
    public void ModificarW( File Or ){
        String A = Or.getPath(), B = this.getDirDestino();
        int x = B.length();
        if( B.charAt( x-1 ) == 92 || B.charAt( x-1 ) == '/' ){
            B += Or.getName();
            this.setDirDestino( B );
        }
    }
    public void copiarBinario() {
        this.Copia = this.getDirDestino();
        this.ModificarW( new File( this.getDirOrigen() ) );
        File Origen = new File( this.getDirOrigen() );
        File Destino = new File( this.getDirDestino() );
        if( Origen.exists() && !Destino.exists() ){
            try {
                BufferedInputStream Original = new BufferedInputStream( new FileInputStream( Origen ) );
                BufferedOutputStream Copia = new BufferedOutputStream( new FileOutputStream( this.getDirDestino() ) );
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
        }else if( Origen.exists() && Destino.exists() ){
            int x = 0;
            String nombre = this.nombre( x, Destino.getName() );
            try {
                BufferedInputStream Original = new BufferedInputStream(new FileInputStream(Origen));
                BufferedOutputStream Copia = new BufferedOutputStream(new FileOutputStream( this.Copia+nombre ));
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
        }else
            System.out.println( "No existe el Archivo" );
    }
    public String nombre( int x, String Nombre ) {
        File nombre = new File( this.Copia+Nombre );
        if ( !nombre.exists() ) {
            return nombre.getName();
        } else {
            x++;
            String Final = "";
            if( x > 1 ){
                Final = "copia_" + x + "_" + this.Nombre( nombre.getName() );
            }else{
                Final = "copia_" + x + "_" + nombre.getName();
            }
            return ( this.nombre( x, Final ) );
        }
    }
    private String Nombre( String cadena) {
        return ( cadena.substring( 8 ) );
    }
    public void Directorio(){
        this.CopiaCarpeta = this.getDirDestino();
        this.ModificarW( new File( this.getDirOrigen() ) );
        this.copiarDirectorio( new File( this.getDirOrigen() ), new File( this.getDirDestino() ) );
    }
    public void copiarDirectorio ( File Origen, File Destino ){
        if( Origen.isDirectory() ){
            if( !Destino.exists() )
                Destino.mkdir();
            String[] hijos = Origen.list(); 
            for ( int i = 0; i < hijos.length; i++ ) 
                copiarDirectorio( new File( Origen, hijos[i] ), new File( Destino, hijos[i] ) );                     
        }else{
            this.setDirOrigen( Origen.getPath() );
            this.setDirDestino( Destino.getPath() );
            this.copiarBinario();
        }
    }
}
