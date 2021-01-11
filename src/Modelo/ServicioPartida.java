package Modelo;

public class ServicioPartida {
    public Partida evaluarGanador(Partida p){
        int scorej1=0;
        int scorej2=0;
        for (Ronda ronda : p.getRondas()) {
            Jugador ganadorRonda = ronda.getGanadorRonda();
            if (ganadorRonda==p.getJugador1()) {
                scorej1++;
            }
            if (ganadorRonda==p.getJugador2()) {
                scorej2++;
            }
        }
        if (scorej1>=p.getAlMejorDe()) {
            p.setGanador(p.getJugador1());
        }
        if (scorej2>=p.getAlMejorDe()) {
            p.setGanador(p.getJugador2());
        }
        
        p.setScorej1(scorej1);
        p.setScorej2(scorej2);
        
        return p;
    }
}
