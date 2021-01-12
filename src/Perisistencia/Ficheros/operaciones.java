package Perisistencia.Ficheros;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class operaciones{
    BufferedReader br;
    BufferedWriter bw;

    protected String Line;
    protected String dir;
    
    public operaciones(String dir) {
        
        try{
            CrearFichero(dir);
            this.br = new BufferedReader( new FileReader(dir));
            this.bw = new BufferedWriter(new FileWriter(dir,true));
            this.dir = dir;
        }catch(Exception e){
            System.out.println("ERROR en operaciones Constructor");
        }
    }
    
    public void ReadBuff(){
        try{
            br = new BufferedReader( new FileReader(this.dir));
            Line = br.readLine();
            while (Line!=null) {
                System.out.println(Line);
                Line = br.readLine();
            }
        }catch(Exception e){
            System.out.println("Error al leer");
        }
    }
    
  
    public void WriteAppendLine(String l){
        try{
            bw = new BufferedWriter(new FileWriter(dir,true));
            bw.write(l);
            bw.newLine();//\r\n reemplazo en FilerWriter
            bw.flush();//guardar            
        }catch(Exception e){
            System.out.println("Error al escribir");
        }
    }
    
    public void LimpiarFichero(){
        try{
            bw = new BufferedWriter(new FileWriter(dir));
            bw.write("");
            bw.flush();
        }catch(Exception e){
            System.out.println("Error al borrar");
        }
    }
    
    private void CrearFichero(String dir){
        
        try{
          File registro = new File(dir);
          bw = new BufferedWriter(new FileWriter(dir,true));
            if (registro.exists()) {
            }else{
                bw.write("");
                System.out.println("FICHERO CREADO");
            }  
        }catch(Exception e){
            System.out.println("Error al crear");
        }
        
    }
    public void EliminarFichero(){
        File registro = new File(dir);
            if (registro.exists()) {
                registro.delete();
                System.out.println("FICHERO ELIMINADO");
            }else{
                System.out.println("FICHERO NO EXISTENTE");
            }  
    }
    
    public String getUltimaLinea(){
        boolean flag = true;
        try{
            br = new BufferedReader( new FileReader(this.dir));
            BufferedReader br2 = new BufferedReader( new FileReader(this.dir));
            br2.readLine();
            
            while (flag) {
                Line = br.readLine();
                String nextLine = br2.readLine();
                if (nextLine==null) {
                    flag=false;
                }
            }
            
            return Line;
        }catch(Exception e){
            System.out.println("Error al leer");
        }
        
        return null;
    }
    
}
