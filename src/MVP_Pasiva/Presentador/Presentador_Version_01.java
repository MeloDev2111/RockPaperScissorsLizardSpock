package MVP_Pasiva.Presentador;

import Modelo.Jugada;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Ronda;
import MVP_Pasiva.Vista.IVPartida_Ver01;
import Modelo.ServicioJugadaBOT;

public class Presentador_Version_01 {
    private IVPartida_Ver01 vista;
    private Ronda ronda;
    private Partida mPartida;
    ServicioJugadaBOT servicio = new ServicioJugadaBOT();
    Jugador j1;
    Jugador j2;
    
    public Presentador_Version_01(IVPartida_Ver01 vista, Partida mPartida) {
        this.vista = vista;
        this.mPartida = mPartida;
    }
    
    
    public void establecerTipoPartida(){
        mPartida.setTipo(vista.getTipoPartida());
    }
    
    public void establecerPuntosMximos(){
        mPartida.setAlMejorDe(vista.getPuntosMaximos());
    }
    
    public void registrarJugador(){
//            switch (mPartida.getTipo()) {
//                case JvJ:
//                    j1 = new Jugador();
//                    j1.setNombreJugador(vista.getnombreJugador());
//                    mPartida.setJugador1( j1 );
//                    
//                    j2 = new Jugador();
//                    j2.setNombreJugador(vista.getnombreJugador());
//                    
//                    mPartida.setJugador2( j2 );
//                    break;
//                case JvB:
//                    j1 = new Jugador();
//                    j1.setNombreJugador(vista.getnombreJugador());
//                    mPartida.setJugador1( j1 );
//                    
//                    j2 = new Jugador();
//                    j2.setNombreJugador("PablitoBOT");
//                    mPartida.setJugador2( j2 );
//                     
//                    break;
//            }
    }
    
    public void jugar(){
        int nroRonda=1;
        do{
            Jugador j1 = mPartida.getJugador1();
            Jugador j2 = mPartida.getJugador2();
            Jugada jugada_j1 = new Jugada(j1, vista.getJugada(j1));
            Jugada jugada_j2=null;
            switch (mPartida.getTipo()) {
                case JvJ:
                    jugada_j2 = new Jugada(j2, vista.getJugada(j2));
                    break;
                case JvB:;
                    jugada_j2=new Jugada();
                    jugada_j2.setJugador(j2);
                    jugada_j2= servicio.jugar(jugada_j2);
                
//                    jugada_j2 = new Jugada(j2, j2.jugar());
                    break;    
            }
//            ronda = new Ronda(nroRonda,jugada_j1,jugada_j2);
            ronda.evaluarGanadorRonda();
            mPartida.agregarRonda(ronda);
            mPartida.evaluarGanadorPartida();
        }while (!mPartida.existeGanador());
        
        System.out.println("EL GANADOR ES: "+
                mPartida.getGanador().getNombreJugador());
    } 
}
  