package operativos;

import java.io.File;

public class Directorios extends Comandos{
    public Directorios( String dirOrigen ){
        super( dirOrigen );
    }
    public void crearDiectorios(){
        int x = this.getDirOrigen().length();
        if( this.getDirOrigen().charAt( x-1 ) == 92 || this.getDirOrigen().charAt( x-1 ) == '/' ){
            File nuevo = new File( this.getDirOrigen()+"Nueva Carpeta" );
            if( !nuevo.isDirectory() )
                nuevo.mkdir();
        }else{
            File nuevo = new File( this.getDirOrigen() );
            if( !nuevo.isDirectory() )
                nuevo.mkdir();
        }
    }
}
