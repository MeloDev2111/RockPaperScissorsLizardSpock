package Modelo;

public class Jugador {
    private String nombreJugador;
    private TiposJugador tipo;

    public Jugador(String nombreJugador, TiposJugador tipo) {
        this.nombreJugador = nombreJugador;
        this.tipo = tipo;
    }

    public Jugador() {
    }
    
    
    public OpcionesJugada jugar(){
        int indiceRandom=(int)( Math.random()*(OpcionesJugada.values().length-1) );
        return OpcionesJugada.values()[indiceRandom]; 
    }
    
    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public TiposJugador getTipo() {
        return tipo;
    }

    public void setTipo(TiposJugador tipo) {
        this.tipo = tipo;
    }
    
}
