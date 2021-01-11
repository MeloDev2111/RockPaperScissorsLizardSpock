package MVP_Pasiva.Presentador;

import MVP_Pasiva.Vista.IVJugada;
import MVP_Pasiva.Vista.IVMenu;
import MVP_Pasiva.Vista.IVPartida;
import MVP_Pasiva.Vista.VJugadaSwing;
import MVP_Pasiva.Vista.VMenuSwing;
import Modelo.Partida;
import Modelo.Ronda;
import Perisistencia.Ficheros.ServicioFicheros;

public class PresentadorPartida {
    private IVPartida vista;
    private Partida mPartida;
    
    private ServicioFicheros servicio = new ServicioFicheros();

    public PresentadorPartida(IVPartida vista, Partida mPartida) {
        this.vista = vista;
        this.mPartida = mPartida;
    }
    
    //Actualizar Info
    public void ActualizarInformacion(){
        vista.setTituloPartida(mPartida.getIdPartida(), mPartida.getTipo().toString());
        vista.setnombreJugadores(mPartida.getJugador1().getNombreJugador(),
                                    mPartida.getJugador2().getNombreJugador());
        if (mPartida.getGanador()!=null) {
            vista.setSalida(mPartida.getScorej1(), mPartida.getScorej2(), mPartida.getGanador().getNombreJugador());
        }else{
            vista.setSalida(mPartida.getScorej1(), mPartida.getScorej2(), null);
        }
         
    }
    //Botones
    public void iniciarRonda(){
        IVJugada vistaJugada = new VJugadaSwing();
        Ronda ronda = new Ronda(this.mPartida.getNroRonda());
        PresentadorJugada presetandorJugada = new PresentadorJugada(vistaJugada,
                mPartida,ronda);
        vistaJugada.setPresentador(presetandorJugada);
        
        switch (mPartida.getTipo()) {
            case JvJ:
                vistaJugada.iniciar();
                break;
            case JvB:
                vistaJugada.iniciar();   
                break;
            case BvB:
                presetandorJugada.RegistrarJugada();//PROBANDO ENLACE!!
                presetandorJugada.mostrarSiguienteVista();
                break;
        }
        this.vista.cerrar();
    }
    
    public void salirMenu(){
        IVMenu vistaMenu = new VMenuSwing();
        Partida partidaNva = new Partida();
        PresentadorMenu presentadorMenu = new PresentadorMenu(vistaMenu, partidaNva);
        vistaMenu.setPresentador(presentadorMenu);
        vistaMenu.iniciar();
        this.vista.cerrar();
    }
    
    public void guardarPartida(){
        servicio.guardarPartida(mPartida);
    }
    
}
