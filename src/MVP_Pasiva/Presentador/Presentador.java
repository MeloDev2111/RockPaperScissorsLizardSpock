/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVP_Pasiva.Presentador;

import MVP_Pasiva.Vista.IVPartida;
import Modelo.Partida;
import Modelo.Ronda;

public class Presentador {
    private IVPartida vista;
    private Ronda mRonda;
    private Partida Partida = new Partida();

    public void registrarJugador(){
            switch (Partida.getTipo()) {
                case JvJ:
                case JvB:
                    break;
                default:
                    throw new AssertionError();
            }
    }
    
    public void jugar(){
    }
}
