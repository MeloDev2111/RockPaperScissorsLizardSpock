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
                }
                Line = br.readLine();
            }
            
            if (flag) {
                WriteAppendLine(index);
            }
        } catch (Exception ex) {
            System.out.println("NO SE PUDO INDEXAR, YA EXISTE");
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
            System.out.println("NRO DE PARTIDAS");
            System.out.println(nroPartidas);
            
            if (nroPartidas==0) {
                return null;
            }
            
            Object P[][] = new Object[nroPartidas][5];
            int i=0;
            for (String dirPartida : Listadirs) {
                File fichero = new File(dirPartida);

                if (fichero.exists()) {
                    BufferedReader br2 = new BufferedReader( new FileReader(dirPartida));
                    Line = br2.readLine();
                    for (int j = 0; j < 5; j++) {
                        P[i][j]= Line;
                        System.out.println("LINEA");
                        System.out.println(P[i][j].toString());
                        Line = br2.readLine();
                    }
                    i++;
                }
            }  
            System.out.println(P.toString());
            return P;
            
        } catch (Exception ex) {
            System.out.println("Error al leer el indexado - getPartidas()");
            Logger.getLogger(OperacionesIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    
}
