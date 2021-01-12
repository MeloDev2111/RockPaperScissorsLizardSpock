package MVP_Pasiva.Presentador;

import MVP_Pasiva.Vista.IVCargarPartida;
import MVP_Pasiva.Vista.IVMenu;
import MVP_Pasiva.Vista.IVPartida;
import MVP_Pasiva.Vista.VMenuConsola;
import MVP_Pasiva.Vista.VMenuSwing;
import MVP_Pasiva.Vista.VPartidaConsola;
import MVP_Pasiva.Vista.VPartidaSwing;
import Modelo.Partida;
import Perisistencia.Ficheros.OperacionesIndex;
import Perisistencia.Ficheros.ServicioFicheros;


public class PresentadorCargarPartida {
    private IVCargarPartida vista;
    private Partida mPartida;
    
    private OperacionesIndex index = new OperacionesIndex();
    private ServicioFicheros servicioFicheros = new ServicioFicheros();
    private IVPartida vistaPartida;
    private IVMenu vistaMenu;
    
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
        establecetTiposVistas();
        Partida partidaNva = new Partida();
        PresentadorMenu presentadorMenu = new PresentadorMenu(vistaMenu, partidaNva);
        vistaMenu.setPresentador(presentadorMenu);
        vistaMenu.iniciar();
        this.vista.cerrar();
    }
    
        private void mostrarVistaPartida(){
        establecetTiposVistas();
        PresentadorPartida presentadorPartida = new PresentadorPartida(this.vistaPartida, this.mPartida);
        vistaPartida.setPresentador(presentadorPartida);
        vistaPartida.iniciar();
        this.vista.cerrar();
    }
        
        private void establecetTiposVistas(){
        switch (vista.getTipoVista()) {
            case "Consola":
                this.vistaPartida = new VPartidaConsola();
                this.vistaMenu = new VMenuConsola();
                break;
            case "Swing":
                this.vistaPartida = new VPartidaSwing();
                this.vistaMenu = new VMenuSwing();
                break;
            default:
                System.out.println("REVISAR EL GET TIPO DE VISTAS implementadas de IVPartida");
                throw new AssertionError();
        }
    }
    
}
