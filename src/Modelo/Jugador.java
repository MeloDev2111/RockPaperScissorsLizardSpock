package Modelo;

public abstract class Jugador {
    private String nombreJugador;
    private TiposJugador tipo;

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    
    public abstract OpcionesJugada jugar();
    
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
