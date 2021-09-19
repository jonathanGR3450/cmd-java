package operativos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Historial {
    private String Historia;
    public Historial(){
        this.Historia = "";
    }
    public String getHistoria() {
        return Historia;
    }
    public void setHistoria( String Historia ) {
        this.Historia += Historia+"--\n";
    }
    public void CrearFichero(){
        String ruta = "C:\\Users\\DiK\\Desktop\\historia.txt";
        File archivo = new File( ruta );
        BufferedWriter bw;
        if( archivo.exists() ) {
           try{
                bw = new BufferedWriter( new FileWriter( archivo ) );
                bw.write( this.getHistoria() );
                bw.close();
           }catch( Exception e ){
               System.out.println( "Error: "+e.getLocalizedMessage() );
           }
        } else {
            try{
                bw = new BufferedWriter( new FileWriter( archivo ) );
                bw.write( this.getHistoria() );
                bw.close();
            }catch( Exception e ){
                System.out.println( "Error: "+e.getLocalizedMessage() );
            }    
        }  
        
    }
}
