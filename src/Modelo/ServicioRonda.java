package Modelo;

public class ServicioRonda {
    public Ronda evaluarGanador(Ronda r){
        Logica logica = new Logica();
        Jugada jugada_Ganadora =
                logica.analizar(r.getJugada_Jugador1(),r.getJugada_Jugador2());
        
        if (jugada_Ganadora != null) {
            r.setGanadorRonda(jugada_Ganadora.getJugador());
        }
        
        return r;
    }
}
