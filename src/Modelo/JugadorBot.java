package Modelo;

public class JugadorBot extends Jugador{

    public JugadorBot(String nombreJugador) {
        super(nombreJugador);
        this.setTipo(TiposJugador.BOT);
    }
    
    @Override
    public OpcionesJugada jugar() {
        System.out.println("PROCESANDO....");
        int indiceRandom=(int)( Math.random()*(OpcionesJugada.values().length-1) );
        return OpcionesJugada.values()[indiceRandom];
    }
    
}
