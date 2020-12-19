/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.Presentador;
import Modelo.Jugador;
import Modelo.OpcionesJugada;

public interface IVPartida {
    public void setPresentador(Presentador p);
    public void iniciar();
    public String getnombreJugador();
    public OpcionesJugada getJugada(Jugador j);
    public void setSalida(String nombreJugador);

}
