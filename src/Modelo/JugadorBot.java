package Modelo;

public class JugadorBot extends Jugador{

    public JugadorBot() {
        super("BuenardoBOT", TiposJugador.BOT);
    }
    
    public JugadorBot(String nombreJugador) {
        super(nombreJugador, TiposJugador.BOT);
    }
    
    @Override
    public OpcionesJugada jugar() {
        System.out.println("EL BOT ESTA PROCESANDO....");
        int indiceRandom=(int)( Math.random()*(OpcionesJugada.values().length-1) );
        return OpcionesJugada.values()[indiceRandom];
    }
    
}
