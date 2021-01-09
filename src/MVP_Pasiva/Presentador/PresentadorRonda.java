package MVP_Pasiva.Presentador;

import MVP_Pasiva.Vista.IVPartida;
import MVP_Pasiva.Vista.IVRonda;
import MVP_Pasiva.Vista.VPartidaSwing;
import Modelo.Partida;
import Modelo.Ronda;

public class PresentadorRonda {
    IVRonda vista;
    Partida mPartida;
    Ronda mRonda;
    
    public PresentadorRonda(IVRonda vista, Partida mPartida, Ronda mRonda) {
        this.vista = vista;
        this.mPartida = mPartida;
        this.mRonda = mRonda;
    }
    
    public void mostrarDatos(){
        vista.setNroRonda(mRonda.getNumeroRonda());
        vista.setNombreJugadores(mPartida.getJugador1().getNombreJugador()
                            , mPartida.getJugador2().getNombreJugador());
        vista.setJugadas(mRonda.getJugada_Jugador1().getJugada_Seleccionada().toString(),
                mRonda.getJugada_Jugador2().getJugada_Seleccionada().toString());
        
        if (mRonda.getGanadorRonda()!=null) {
           vista.setSalida(mRonda.getGanadorRonda().getNombreJugador());
        }else{
           vista.setSalida("EMPATE");
        }
    }
    
    public void agregarRonda(){
        mPartida.agregarRonda(mRonda);
        mPartida.evaluarGanadorPartida();
    }
    
    public void mostrarVistaPartida(){
        IVPartida vistaPartida = new VPartidaSwing();
        PresentadorPartida presentadorPartida = new PresentadorPartida(vistaPartida, this.mPartida);
        vistaPartida.setPresentador(presentadorPartida);
        vistaPartida.iniciar();
        this.vista.cerrar();
    }
    
}
