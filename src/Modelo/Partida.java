package Modelo;

import java.util.ArrayList;

public class Partida {
    private String IdPartida;
    private TiposPartida tipo;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador ganador;
    ArrayList<Ronda> Rondas = new ArrayList();
    private int alMejorDe=3;
    
    public void agregarRonda(Ronda r){
        Rondas.add(r);
    }
    public void evaluarGanadorPartida(){
        int scorej1=0;
        int scorej2=0;
        for (Ronda ronda : Rondas) {
            Jugador ganadorRonda = ronda.getGanadorRonda();
            if (ganadorRonda==this.jugador1) {
                scorej1++;
            }
            if (ganadorRonda==this.jugador2) {
                scorej2++;
            }
        }
        if (scorej1==this.alMejorDe) {
            this.ganador=this.jugador1;
        }
        if (scorej2==this.alMejorDe) {
            this.ganador=jugador2;
        }
        System.out.println("score J1: " + scorej1);
        System.out.println("score J2: " + scorej2);
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

    public int getAlMejorDe() {
        return alMejorDe;
    }

    public void setAlMejorDe(int alMejorDe) {
        this.alMejorDe = alMejorDe;
    }
    
    
    
}
