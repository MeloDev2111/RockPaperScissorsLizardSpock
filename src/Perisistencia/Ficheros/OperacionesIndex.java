package Perisistencia.Ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesIndex extends operaciones{
    
    public OperacionesIndex() {
        super("RegistroDePartidas\\IndicePartidas.txt");
    }
    
    public int getidNuevaPartida(){
        int ptro =Integer.valueOf(this.getUltimaLinea());
        ptro++;
        
        return ptro;
    }
    
    public void registrarIndexado(String index){
        boolean flag=true;
        try {
            br = new BufferedReader( new FileReader(this.dir));
            Line = br.readLine();
            
            while (Line!=null) {
                if (Line.equals(index)) {
                    flag=false;
                }
                Line = br.readLine();
            }
            
            if (flag) {
                WriteAppendLine(index);
            }
        } catch (Exception ex) {
            System.out.println("NO SE PUDO INDEXAR");
        }
    }
    
}
