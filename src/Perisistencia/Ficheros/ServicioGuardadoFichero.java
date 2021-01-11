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
import Modelo.Partida;
import Modelo.Ronda;
import Modelo.TiposJugador;
import java.io.File;

/**
 *
 * @author eddyf
 */
public class ServicioGuardadoFichero {
    
    public void guardarPartida(Partida p){
        OperacionesIndex index = new OperacionesIndex(); 
        String dir="RegistroDePartidas\\";
        String id= String.valueOf( index.getidNuevaPartida() );
        
        dir = dir + p.getIdPartida()+".txt";
        
        OperacionesPartida fichero = new OperacionesPartida(dir);
        
        try{
            fichero.guardar(p);
            index.registrarIndexado(id);
        }catch(Exception e){
            System.out.println("NO SE PUDO GUARDAR");
        }
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
//                
//          System.out.println(op.getUltimaLinea());

    }
   
}
