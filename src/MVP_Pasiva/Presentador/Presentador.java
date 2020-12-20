/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVP_Pasiva.Presentador;

import MVP_Pasiva.Vista.IVPartida;
import Modelo.Jugada;
import Modelo.Jugador;
import Modelo.JugadorBot;
import Modelo.JugadorPersona;
import Modelo.Partida;
import Modelo.Ronda;

public class Presentador {
    private IVPartida vista;
    private Ronda ronda;
    private Partida mPartida;

    public Presentador(IVPartida vista, Partida mPartida) {
        this.vista = vista;
        this.mPartida = mPartida;
    }
    
    
    public void establecerTipoPartida(){
        mPartida.setTipo(vista.getTipoPartida());
    }
    
    public void establecerPuntosMximos(){
        mPartida.setAlMejorDe(vista.getPuntosMaximos());
    }
    
    public void registrarJugador(){
            switch (mPartida.getTipo()) {
                case JvJ:
                    mPartida.setJugador1( new JugadorPersona(vista.getnombreJugador()) );  
                    mPartida.setJugador2( new JugadorPersona(vista.getnombreJugador()) );
                    break;
                case JvB:
                    mPartida.setJugador1( new JugadorPersona(vista.getnombreJugador()) );
                    mPartida.setJugador1( new JugadorBot("PablitoBot") );    
                    break;
            }
    }
    
    public void jugar(){
        int nroRonda=1;
        do{
            Jugador j1 = mPartida.getJugador1();
            Jugador j2 = mPartida.getJugador2();
            Jugada jugada_j1 = new Jugada(j1, vista.getJugada(j1));
            Jugada jugada_j2=null;
            switch (mPartida.getTipo()) {
                case JvJ:
                    jugada_j2 = new Jugada(j2, vista.getJugada(j2));
                    break;
                case JvB:
                    jugada_j2 = new Jugada(j2, j2.jugar());
                    break;    
            }
            ronda = new Ronda(nroRonda,jugada_j1,jugada_j2);
            ronda.evaluarGanadorRonda();
            mPartida.agregarRonda(ronda);
            mPartida.evaluarGanadorPartida();
        }while (!mPartida.existeGanador());
        
        System.out.println("EL GANADOR ES: "+
                mPartida.getGanador().getNombreJugador());
    } 
}
  