/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author eddyf
 */
public class JugadorPersona extends Jugador{

    public JugadorPersona(String nombreJugador) {
        super(nombreJugador,TiposJugador.PERSONA);
    }
    
    @Override
    public OpcionesJugada jugar() {
        System.out.println("EL JUGADOR INGRESA SU JUGADA POR LA VISTA");
        return null;
    }
    
}
