package MVP_Pasiva.Presentador;

import MVP_Pasiva.Vista.IVCargarPartida;
import MVP_Pasiva.Vista.IVMenu;
import MVP_Pasiva.Vista.IVPartida;
import MVP_Pasiva.Vista.VMenuSwing;
import MVP_Pasiva.Vista.VPartidaConsola;
import MVP_Pasiva.Vista.VPartidaSwing;
import Modelo.Partida;
import Perisistencia.Ficheros.OperacionesIndex;
import Perisistencia.Ficheros.ServicioGuardadoFichero;


public class PresentadorCargarPartida {
    private IVCargarPartida vista;
    private Partida mPartida;
    
    private OperacionesIndex index = new OperacionesIndex();
    private ServicioGuardadoFichero servicioFicheros = new ServicioGuardadoFichero();
    private IVPartida vistaPartida;

    public PresentadorCargarPartida(IVCargarPartida vista, Partida mPartida) {
        this.vista = vista;
        this.mPartida = mPartida;
    }
    
    public void mostrarPartidas(){
        vista.setListaPartidas(index.getIndexPartidas());
    }
    
    public void cargarPartida(){
        mPartida = servicioFicheros.cargarPartida(vista.getPartidaSeleccionada());
        mostrarVistaPartida();
    }
    
    public void salirMenu(){
        IVMenu vistaMenu = new VMenuSwing();
        Partida partidaNva = new Partida();
        PresentadorMenu presentadorMenu = new PresentadorMenu(vistaMenu, partidaNva);
        vistaMenu.setPresentador(presentadorMenu);
        vistaMenu.iniciar();
        this.vista.cerrar();
    }
    
        private void mostrarVistaPartida(){
        switch (vista.getClass().toString()) {
            case "class MVP_Pasiva.Vista.VCargarPartidaConsola":
                this.vistaPartida = new VPartidaConsola();
                break;
            case "class MVP_Pasiva.Vista.VCargarPartidaSwing":
                this.vistaPartida = new VPartidaSwing();
                break;
            default:
                System.out.println("REVISAR EL NOMBRE DE LAS VISTAS derivadas de IVPartida");
                break;
        }
        PresentadorPartida presentadorPartida = new PresentadorPartida(this.vistaPartida, this.mPartida);
        vistaPartida.setPresentador(presentadorPartida);
        vistaPartida.iniciar();
        this.vista.cerrar();
    }
    
}
