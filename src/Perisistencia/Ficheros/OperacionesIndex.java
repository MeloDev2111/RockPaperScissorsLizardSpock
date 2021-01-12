package Perisistencia.Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesIndex extends operaciones{
    String baseDir="RegistroDePartidas\\";
    
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
                    System.out.println("Indexado existente");
                }
                Line = br.readLine();
            }
            
            if (flag) {
                WriteAppendLine(index);
            }
        } catch (Exception ex) {
            System.out.println("ERROR AL LEER FICHERO INDEX");
        }
    }

    public Object[][] getIndexPartidas() {
        ArrayList<String> Listadirs = new ArrayList<>();
        int nroPartidas=0;
        
        try {
            br = new BufferedReader( new FileReader(this.dir));
            Line = br.readLine();
            
            while (Line!=null) {
                Listadirs.add(baseDir+Line+".txt");
                
                Line = br.readLine();
            }
            
            nroPartidas=Listadirs.size();
            
            if (nroPartidas==0) {
                return null;
            }
            
            Object P[][] = new Object[nroPartidas][7];
            int i=0;
            for (String dirPartida : Listadirs) {
                File fichero = new File(dirPartida);

                if (fichero.exists()) {
                    br = new BufferedReader( new FileReader(dirPartida));
                    Line = br.readLine();
                    for (int j = 0; j < 7; j++) {
                        P[i][j]= Line;
                        Line = br.readLine();
                    }
                    i++;
                }
            }  
            return P;
            
        } catch (Exception ex) {
            System.out.println("Error al leer el indexado - getPartidas()");
            Logger.getLogger(OperacionesIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    
}
