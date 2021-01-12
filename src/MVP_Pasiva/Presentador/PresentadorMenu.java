package MVP_Pasiva.Presentador;

import MVP_Pasiva.Vista.IVCargarPartida;
import MVP_Pasiva.Vista.IVMenu;
import MVP_Pasiva.Vista.IVPartida;
import MVP_Pasiva.Vista.VCargarPartidaConsola;
import MVP_Pasiva.Vista.VCargarPartidaSwing;
import MVP_Pasiva.Vista.VPartidaConsola;
import MVP_Pasiva.Vista.VPartidaSwing;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.TiposJugador;
import Modelo.TiposPartida;
import Perisistencia.Ficheros.OperacionesIndex;

public class PresentadorMenu {
    private IVMenu vista;
    private Partida mPartida;
    
    private OperacionesIndex index = new OperacionesIndex();
    private IVPartida vistaPartida;
    private IVCargarPartida vistaCargar;
    
    public PresentadorMenu(IVMenu vista, Partida mPartida) {
        this.vista = vista;
        this.mPartida = mPartida;
    }
    
    //ALTERNATIVA DE COLOCAR UN PARAMETRO TIPO DE VISTA, PARA evitar el getClass()
    public void iniciarPartidaJvJ(){
        mPartida.setTipo(TiposPartida.JvJ);
        //INICIAR VISTA PARTIDA - MODO JVJ
        crearPartida();
        mostrarVistaPartida();
    }
    
    public void iniciarPartidaJvB(){
        mPartida.setTipo(TiposPartida.JvB);
        //INICIAR VISTA PARTIDA - MODO JVB
        crearPartida();
        mostrarVistaPartida();
    }
    
    public void iniciarPartidaBvB(){
        mPartida.setTipo(TiposPartida.BvB);
        //INICIAR VISTA PARTIDA - MODO BVB
        crearPartida();
        mostrarVistaPartida();
    }
    
    public void mostrarMenuCargarPartidas(){
        establecetTiposVistas();
        Partida partidaporCargar = new Partida();
        
        PresentadorCargarPartida presentadorCargar = new 
            PresentadorCargarPartida(vistaCargar, mPartida);
        
        vistaCargar.setPresentador(presentadorCargar);
        vistaCargar.iniciar();
        this.vista.cerrar();
    }
    
    public void crearPartida(){
        this.establecerPuntosMaximos();
        this.registrarJugadores();
        this.establecerTitulo();
    }
    
    private void establecerTitulo(){
        mPartida.setIdPartida(String.valueOf(index.getidNuevaPartida()));
    }
    
    private void establecerPuntosMaximos(){
        mPartida.setAlMejorDe(vista.getPuntosMaximos());
    }
    
    private void registrarJugadores(){
        
        switch (mPartida.getTipo()) {
            case JvJ:
                mPartida.setJugador1( new Jugador(vista.getnombreJugador(),
                                TiposJugador.PERSONA) );  
                
                mPartida.setJugador2( new Jugador(vista.getnombreJugador(),
                                TiposJugador.PERSONA) );
                break;
            case JvB:
                mPartida.setJugador1( new Jugador(vista.getnombreJugador(),
                                TiposJugador.PERSONA) );
                
                mPartida.setJugador2( new Jugador("PablitoBOT", 
                                TiposJugador.BOT));    
                break;
            case BvB:
                mPartida.setJugador1( new Jugador("DayanBOT",
                                TiposJugador.BOT));
                mPartida.setJugador2( new Jugador("BuenardoBOT",
                                TiposJugador.BOT));    
                break;    
        }
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
                this.vistaCargar = new VCargarPartidaConsola();
                break;
            case "Swing":
                this.vistaPartida = new VPartidaSwing();
                this.vistaCargar = new VCargarPartidaSwing();
                break;
            default:
                System.out.println("REVISAR  EL GET TIPO DE VISTAS implementadas de IVJugada y IVMenu");
                throw new AssertionError();
        }
    }
    
}
