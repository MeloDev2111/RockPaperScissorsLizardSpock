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
public class ServicioFicheros {
    String baseDir="RegistroDePartidas\\";
    
    public void guardarPartida(Partida p){
        OperacionesIndex index = new OperacionesIndex(); 
        String dir=baseDir+p.getIdPartida()+".txt";
        
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
   
}
