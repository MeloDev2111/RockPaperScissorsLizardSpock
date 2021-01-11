package Modelo;

public class Ronda {
    private int numeroRonda;
    private Jugada jugada_Jugador1;
    private Jugada jugada_Jugador2;
    private Jugador ganadorRonda;

    public Ronda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public Ronda() {
    }
    
    public int getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public Jugada getJugada_Jugador1() {
        return jugada_Jugador1;
    }

    public void setJugada_Jugador1(Jugada jugada_Jugador1) {
        this.jugada_Jugador1 = jugada_Jugador1;
    }

    public Jugada getJugada_Jugador2() {
        return jugada_Jugador2;
    }

    public void setJugada_Jugador2(Jugada jugada_Jugador2) {
        this.jugada_Jugador2 = jugada_Jugador2;
    }

    public Jugador getGanadorRonda() {
        return ganadorRonda;
    }

    public void setGanadorRonda(Jugador ganadorRonda) {
        this.ganadorRonda = ganadorRonda;
    }

    @Override
    public String toString() {
        return "Ronda{" + "numeroRonda=" + numeroRonda + ", jugada_Jugador1=" + jugada_Jugador1 + ", jugada_Jugador2=" + jugada_Jugador2 + ", ganadorRonda=" + ganadorRonda + '}';
    }
    
}
