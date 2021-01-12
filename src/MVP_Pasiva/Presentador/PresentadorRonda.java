package MVP_Pasiva.Presentador;

import MVP_Pasiva.Vista.IVPartida;
import MVP_Pasiva.Vista.IVRonda;
import MVP_Pasiva.Vista.VPartidaConsola;
import MVP_Pasiva.Vista.VPartidaSwing;
import Modelo.Partida;
import Modelo.Ronda;
import Modelo.ServicioPartida;

public class PresentadorRonda {
    private IVRonda vista;
    private Partida mPartida;
    private Ronda mRonda;
    
    private ServicioPartida servicioPartida = new ServicioPartida();
    private IVPartida vistaPartida;
    
    public PresentadorRonda(IVRonda vista, Partida mPartida, Ronda mRonda) {
        this.vista = vista;
        this.mPartida = mPartida;
        this.mRonda = mRonda;
    }
    
    public void mostrarDatos(){
        vista.setNroRonda(mRonda.getNumeroRonda());
        vista.setNombreJugadores(mPartida.getJugador1().getNombreJugador()
                            , mPartida.getJugador2().getNombreJugador());
        vista.setJugadas(mRonda.getJugada_Jugador1().getJugada_Seleccionada().name(),
                mRonda.getJugada_Jugador2().getJugada_Seleccionada().name());
        
        if (mRonda.getGanadorRonda()!=null) {
           vista.setSalida(mRonda.getGanadorRonda().getNombreJugador());
        }else{
           vista.setSalida("EMPATE");
        }
    }
    
    public void agregarRonda(){
        mPartida.agregarRonda(mRonda);
        mPartida = servicioPartida.evaluarGanador(mPartida);
    }
    
    public void mostrarVistaPartida(){
        establecetTiposVistas();
        PresentadorPartida presentadorPartida = new PresentadorPartida(vistaPartida, this.mPartida);
        vistaPartida.setPresentador(presentadorPartida);
        vistaPartida.iniciar();
        this.vista.cerrar();
    }
    
    private void establecetTiposVistas(){
        switch (vista.getTipoVista()) {
            case "Consola":
                this.vistaPartida = new VPartidaConsola();
                break;
            case "Swing":
                this.vistaPartida = new VPartidaSwing();
                break;
            default:
                System.out.println("REVISAR EL GET TIPO DE VISTAS implementadas de IVPartida");
                throw new AssertionError();
        }
    }
}
