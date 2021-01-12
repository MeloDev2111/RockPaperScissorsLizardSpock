/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import MVP_Pasiva.Presentador.PresentadorMenu;
import MVP_Pasiva.Vista.IVMenu;
import MVP_Pasiva.Vista.Validacion;
import MVP_Pasiva.Vista.VMenuConsola;
import MVP_Pasiva.Vista.VMenuSwing;
import Modelo.Partida;

/**
 *
 * @author eddyf
 */
public class Test {
    public static void main(String[] args) {
//        Jugador j1 = new Jugador("Carlitos");
//        Jugador j2 = new Jugador("PablitoBot");
//        
//        Partida p1 = new Partida();
//        p1.setJugador1(j1);
//        p1.setJugador2(j2);
//        
//        Jugada jugada_j1 = new Jugada(j1, OpcionesJugada.SCISSOR);
//        Jugada jugada_j2 = new Jugada(j2, OpcionesJugada.ROCK);
//        
//        Jugada jugada2_j1 = new Jugada(j1, OpcionesJugada.PAPER);
//        Jugada jugada2_j2 = new Jugada(j2, OpcionesJugada.ROCK);
//        
//        Ronda r1 = new Ronda(1, jugada_j1, jugada_j2);
//        Ronda r2 = new Ronda(2, jugada2_j1, jugada2_j2);
//        Ronda r3 = new Ronda(3, jugada_j1, jugada_j2);
//        Ronda r4 = new Ronda(4, jugada_j1, jugada_j2);
//        
//        r1.evaluarGanadorRonda();
//        r2.evaluarGanadorRonda();
//        r3.evaluarGanadorRonda();
//        r4.evaluarGanadorRonda();
//        
//        p1.agregarRonda(r1);
//        p1.agregarRonda(r2);
//        p1.agregarRonda(r3);
//        p1.agregarRonda(r4);
//        
//        p1.evaluarGanadorPartida();
//        if (p1.existeGanador()) {
//            System.out.println(p1.getGanador().getNombreJugador());
//        }

//VERSION 1.0
//          Partida p1 = new Partida();
//          IVPartida_Ver01 vista = new VPartidaConsola_Ver01();
//          Presentador_Version_01 p = new Presentador_Version_01(vista,p1);
//          vista.setPresentador(p);
//          vista.iniciar();
//VERSION 2.0
          Partida p1 = new Partida();
          IVMenu vista = new VMenuConsola();
          PresentadorMenu p = new PresentadorMenu(vista, p1);
          vista.setPresentador(p);
          vista.iniciar();

    }
}