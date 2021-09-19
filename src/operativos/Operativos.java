package operativos;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author JONATHAN GARZON - FABRICIO CAICEDO
 */
public class Operativos {

    public static String[] Instruccion(String mediaIn) {
        String completo[] = mediaIn.split(" ");
        String completaIn[] = new String[4];
        int contador = 0;
        for (int x = 0; x < completo.length; x++) {
            if (completo[x].compareTo("") != 0 && contador >= 0 && contador <= 3) {
                completaIn[contador] = completo[x];
                contador++;
            }
        }
        return completaIn;
    }
    public static boolean Verificar( String Origen ){
        File OR = new File( Origen );
        return ( OR.isDirectory() && OR.exists() );
    }
    public static String Modificar( String a ){
        String B = "";
        for( int x = 0; x < a.length(); x++ ){
            if( a.charAt( x ) != '*' )
                B += a.charAt( x );
            else
                B += (char)32;
        }
        return B;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String Nombre[] = System.getProperty("os.name").split(" ");
        boolean linux = false;
        if( Nombre[ 0 ].compareTo( "Windows" ) == 0 )
            linux = false;
        else
            linux = true;
        Historial historia = new Historial();
        System.out.println("--------------------------------------");
        System.out.println("Bienvenido a la shell");
        System.out.println("--------------------------------------");
        System.out.print("Ingrese un Comando:  ");
        String comando = entrada.nextLine();
        String Instruccion[] = Instruccion( comando );
        while ( true ) {
            if( Instruccion[0] == null )
                Instruccion[0] = " ";
            if( Instruccion[0].compareTo("copiar") == 0 ) {
                System.out.println( "copiando...." );
                if( Instruccion[ 1 ].compareTo( "-r" ) == 0 ) {
                    if( Instruccion[ 2 ] != null && Instruccion[ 3 ] != null ){
                        Instruccion[ 2 ] = Modificar( Instruccion[ 2 ] );
                        Instruccion[ 3 ] = Modificar( Instruccion[ 3 ] );
                        if( Verificar( Instruccion[ 2 ] ) ){
                            Copiar copiar = new Copiar( Instruccion[ 2 ], Instruccion[ 3 ] );
                            copiar.Directorio();
                        }else
                            System.out.println( "No es un directorio" );
                    }else
                        System.out.println( "Error parametros" );
                }else{
                    if( Instruccion[ 1 ] != null && Instruccion[ 2 ] != null ){
                        Instruccion[ 1 ] = Modificar( Instruccion[ 1 ] );
                        Instruccion[ 2 ] = Modificar( Instruccion[ 2 ] );
                        if( !Verificar( Instruccion[ 1 ] ) ){
                            System.out.println( "Archivo" );
                            Copiar copiar = new Copiar( Instruccion[ 1 ], Instruccion[ 2 ] );
                            copiar.copiarBinario();
                        }else
                            System.out.println( "es un directorio" );
                    }else
                        System.out.println( "Error parametros" );
                }
                historia.setHistoria( Instruccion[ 0 ] );
            }else if ( Instruccion[ 0 ].compareTo( "mover" ) == 0 ) {
                    if( Instruccion[ 1 ].compareTo( "-r" ) == 0 ) {
                        if( Instruccion[ 2 ] != null && Instruccion[ 3 ] != null ){
                            Instruccion[ 2 ] = Modificar( Instruccion[ 2 ] );
                            Instruccion[ 3 ] = Modificar( Instruccion[ 3 ] );
                            if( Verificar( Instruccion[ 2 ] ) ){
                                Mover mover = new Mover( Instruccion[ 2 ], Instruccion[ 3 ] );
                                mover.CopiarDirectorio();
                                mover.eliminarBinario( Instruccion[ 2 ] );
                            }else
                                System.out.println( "No es un directorio" );
                        }else
                            System.out.println( "Error de los parametros" );
                    } else {
                        if( Instruccion[ 1 ] != null && Instruccion[ 2 ] != null ){
                            Instruccion[ 1 ] = Modificar( Instruccion[ 1 ] );
                            Instruccion[ 2 ] = Modificar( Instruccion[ 2 ] );
                            if( !Verificar( Instruccion[ 1 ] ) ){
                                Mover mover = new Mover( Instruccion[ 1 ], Instruccion[ 2 ] );
                                mover.CopiarFichero();
                                mover.eliminarBinario( Instruccion[ 1 ] );
                        }else
                            System.out.println( "es un directorio" );
                    }
                }
                historia.setHistoria( Instruccion[ 0 ] );
            }else if ( Instruccion[ 0 ].compareTo( "borrar" ) == 0 ) {
                if( Instruccion[ 1 ].compareTo( "-r" ) == 0 ) {
                    if( Instruccion[ 2 ] != null ){
                        Instruccion[ 2 ] = Modificar( Instruccion[ 2 ] );
                        if( Verificar( Instruccion[ 2 ] ) ){
                            Borrar borrar = new Borrar( Instruccion[ 2 ] );
                            borrar.eliminarBinario( Instruccion[ 2 ] );
                        }else
                            System.out.println( "No es un directorio" );
                    }
                }else{
                    if( Instruccion[ 1 ] != null ){
                        Instruccion[ 1 ] = Modificar( Instruccion[ 1 ] );
                        if( !Verificar( Instruccion[ 1 ] ) ){
                            Borrar borrar = new Borrar( Instruccion[ 1 ] );
                            borrar.EArchivo( Instruccion[ 1 ] );
                        }else
                            System.out.println( "s un directorio" );
                    }
                }            
                historia.setHistoria( Instruccion[ 0 ] );
            }else if ( Instruccion[0].compareTo( "info" ) == 0 ) {
                if ( Instruccion[ 1 ] != null ){ 
                    Instruccion[ 1 ] = Modificar( Instruccion[ 1 ] );
                    Informacion info = new Informacion( Instruccion[ 1 ] );
                }else 
                        System.out.println( "Error en los parametros" );    
                historia.setHistoria( Instruccion[ 0 ] );        
            } else if ( Instruccion[0].compareTo( "ejecutar" ) == 0 ) {
                if ( Instruccion[ 1 ] != null ) {
                    Instruccion[ 1 ] = Modificar( Instruccion[ 1 ] );
                    Ejecutar ejecutar = new Ejecutar( Instruccion[ 1 ] );
               } else
                        System.out.println( "Error en los parametros" );
                historia.setHistoria( Instruccion[ 0 ] );
            } else if ( Instruccion[ 0 ].compareTo( "ruta" ) == 0 ) {
                Ruta ruta = new Ruta();
                System.out.println( ruta.actual() );
                historia.setHistoria( Instruccion[ 0 ] );
            } else if ( Instruccion[ 0 ].compareTo( "ir" ) == 0 ) {
                if ( Instruccion[ 1 ] != null ) {
                    Ir ir = new Ir();
                    Instruccion[ 1 ] = Modificar( Instruccion[ 1 ] );
                    ir.setDirDestino( Instruccion[ 1 ] );
                    ir.ir();
                } else 
                    System.out.println("Error en los parametros");
                historia.setHistoria( Instruccion[ 0 ] );
            } else if ( Instruccion[ 0 ].compareTo( "dir" ) == 0 ) {
                if ( Instruccion[ 1 ] != null ) {
                    Instruccion[ 1 ] = Modificar( Instruccion[ 1 ] );
                    Directorios a = new Directorios( Instruccion[ 1 ] );
                    a.crearDiectorios();
                } else 
                    System.out.println("Error en los parametros");
                historia.setHistoria( Instruccion[ 0 ] );
            } else if ( Instruccion[ 0 ].compareTo( "salir" ) == 0 ) {
                Salir salir = new Salir();
                salir.salir( Instruccion[ 0 ] );
                historia.setHistoria( Instruccion[ 0 ] );
                break;
            }else if( Instruccion[ 0 ].compareTo( "historia" ) == 0 ){
                System.out.println( historia.getHistoria() );
                historia.CrearFichero();
                historia.setHistoria( Instruccion[ 0 ] );
            } 
            System.out.print( "Ingrese un Comando:  " );
            comando = entrada.nextLine();
            Instruccion = Instruccion( comando );
        }
    }
    
}
