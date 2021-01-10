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
import Modelo.Partida;
import Modelo.Ronda;
import java.io.File;

/**
 *
 * @author eddyf
 */
public class ServicioFicheros {
    
//    public void guardarPartida(Partida p){
//        String dir="RegistroDePartidas\\P1.txt";
////        String id=FicherosIndice.getNombreFichero();
//        int contador=1;
//        File registro = new File(dir+id+contador);
//        
//        while (registro.exists()) {
//            contador++;
//            registro = new File(dir+id+contador);
//        }
////        FicherosPartida.guardar(p);
//    }
    
    public static void main(String[] args) {
        String dir="RegistroDePartidas\\P1.txt";
        OperacionesPartida op = new OperacionesPartida(dir);
        Partida p = op.getPartida();
        System.out.println(p.toString());
        for (Ronda ronda : p.getRondas()) {
            System.out.println(ronda.toString());
        }
        IVPartida vistaPartida = new VPartidaSwing();
        PresentadorPartida presentadorPartida = new PresentadorPartida(vistaPartida, p);
        
        vistaPartida.setPresentador(presentadorPartida);
        
        vistaPartida.iniciar();
                
    }
   
}
