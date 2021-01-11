/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perisistencia.Ficheros;

import MVP_Pasiva.Presentador.PresentadorPartida;
import MVP_Pasiva.Vista.IVPartida;
import MVP_Pasiva.Vista.VPartidaConsola;
import MVP_Pasiva.Vista.VPartidaSwing;
import Modelo.Jugador;
import Modelo.OpcionesJugada;
import Modelo.Partida;
import Modelo.Ronda;
import Modelo.TiposJugador;
import java.io.File;

/**
 *
 * @author eddyf
 */
public class ServicioGuardadoFichero {
    String baseDir="RegistroDePartidas\\";
    
    public void guardarPartida(Partida p){
        OperacionesIndex index = new OperacionesIndex(); 
        String dir=baseDir+p.getIdPartida()+".txt";
//        String id= String.valueOf( index.getidNuevaPartida() );
//        dir = dir + p.getIdPartida()+".txt";
        
        OperacionesPartida fichero = new OperacionesPartida(dir);
        
        try{
            fichero.guardar(p);
            index.registrarIndexado(p.getIdPartida());
        }catch(Exception e){
            System.out.println("NO SE PUDO GUARDAR");
        }
    }
    
    public Partida cargarPartida(String idPartida){ 
        String dir=baseDir+idPartida+".txt";
        OperacionesPartida fichero = new OperacionesPartida(dir);
        
        try{
            Partida p = fichero.getPartida();
            return p;
        }catch(Exception e){
            System.out.println("NO SE PUDO CARGAR");
        }
        
        return null;
    }   
    
    public static void main(String[] args) {
        OperacionesIndex index = new OperacionesIndex(); 
        String dir="RegistroDePartidas\\4.txt";
        OperacionesPartida op = new OperacionesPartida(dir);
        Partida p = op.getPartida();
        
        
//        System.out.println(p.toString());
//        for (Ronda ronda : p.getRondas()) {
//            System.out.println(ronda.toString());
//        }
        IVPartida vistaPartida = new VPartidaSwing();
        PresentadorPartida presentadorPartida = new PresentadorPartida(vistaPartida, p);
        
        vistaPartida.setPresentador(presentadorPartida);
        
        vistaPartida.iniciar();
//            System.out.println(OpcionesJugada.LIZARD.name());
//            System.out.println(OpcionesJugada.LIZARD.toString());
//                
//          System.out.println(op.getUltimaLinea());

    }
   
}
