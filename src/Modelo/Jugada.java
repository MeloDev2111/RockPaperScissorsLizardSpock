
package Modelo;

public class Jugada {
    private Jugador jugador;
    private OpcionesJugada jugada_Seleccionada;

    public Jugada(Jugador jugador, OpcionesJugada jugada_Seleccionada) {
        this.jugador = jugador;
        this.jugada_Seleccionada = jugada_Seleccionada;
    }  

    public Jugada() {
    }
    
    //
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public OpcionesJugada getJugada_Seleccionada() {
        return jugada_Seleccionada;
    }

    public void setJugada_Seleccionada(OpcionesJugada jugada_Seleccionada) {
        this.jugada_Seleccionada = jugada_Seleccionada;
    }
}
