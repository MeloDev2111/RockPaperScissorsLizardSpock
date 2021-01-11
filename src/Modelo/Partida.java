package Modelo;

import java.util.ArrayList;

public class Partida {
    private String IdPartida;
    private TiposPartida tipo;
    private Jugador jugador1;
    private Jugador jugador2;
    private int scorej1=0;
    private int scorej2=0;
    private Jugador ganador;
    
    private ArrayList<Ronda> Rondas = new ArrayList();
    private int alMejorDe=3;
    
    public void agregarRonda(Ronda r){
        Rondas.add(r);
    }
    
    public boolean existeGanador(){
        return (ganador!=null);
    }
    
    //GETTERS N SETTERS
    public String getIdPartida() {
        return IdPartida;
    }

    public void setIdPartida(String IdPartida) {
        this.IdPartida = IdPartida;
    }

    public TiposPartida getTipo() {
        return tipo;
    }

    public void setTipo(TiposPartida tipo) {
        this.tipo = tipo;
    }
    
    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public int getScorej1() {
        return scorej1;
    }

    public void setScorej1(int scorej1) {
        this.scorej1 = scorej1;
    }

    public int getScorej2() {
        return scorej2;
    }

    public void setScorej2(int scorej2) {
        this.scorej2 = scorej2;
    }
    
    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    public ArrayList<Ronda> getRondas() {
        return Rondas;
    }

    public void setRondas(ArrayList<Ronda> Rondas) {
        this.Rondas = Rondas;
    }

    public int getNroRonda() {
        return Rondas.size()+1;
    }

    public int getAlMejorDe() {
        return alMejorDe;
    }

    public void setAlMejorDe(int alMejorDe) {
        this.alMejorDe = alMejorDe;
    }

    @Override
    public String toString() {
        return "Partida{" + "IdPartida=" + IdPartida + ", tipo=" + tipo + ", jugador1=" + jugador1 + ", jugador2=" + jugador2 + ", scorej1=" + scorej1 + ", scorej2=" + scorej2 + ", ganador=" + ganador + ", Rondas=" + Rondas + ", alMejorDe=" + alMejorDe + '}';
    }
    
    
    
}
