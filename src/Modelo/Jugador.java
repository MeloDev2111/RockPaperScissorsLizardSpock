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

    @Override
    public String toString() {
        return "Jugador{" + "nombreJugador=" + nombreJugador + ", tipo=" + tipo + '}';
    }
    
    
    
}
