package MVP_Pasiva.Presentador;

import MVP_Pasiva.Vista.IVMenu;
import MVP_Pasiva.Vista.IVPartida;
import MVP_Pasiva.Vista.VPartidaConsola;
import MVP_Pasiva.Vista.VPartidaSwing;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.TiposPartida;

public class PresentadorMenu {
    private IVMenu vista;
    private Partida mPartida;
    Jugador j1;
    Jugador j2;
    
    private IVPartida vistaPartida;
    
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
        
    }
    
    public void mostrarCreditos(){
        
    }
    
    public void crearPartida(){
        this.establecerPuntosMaximos();
        this.registrarJugadores();
        this.establecerTitulo();
    }
    
    private void establecerTitulo(){
        mPartida.setIdPartida("00001");
        //METODOS QUE DETERMINA EL ID DE LA PARTIDA
        //SERVICIO FICHEROS IMPLEMENTAR
    }
    
    private void establecerPuntosMaximos(){
        mPartida.setAlMejorDe(vista.getPuntosMaximos());
    }
    
    private void registrarJugadores(){
                    
        switch (mPartida.getTipo()) {
            case JvJ:
                j1 = new Jugador();
                j1.setNombreJugador(vista.getnombreJugador());
                mPartida.setJugador1(j1);
                
                j2 = new Jugador();
                j2.setNombreJugador(vista.getnombreJugador());
                mPartida.setJugador2(j2);
                
                break;
            case JvB:
                j1 = new Jugador();
                j1.setNombreJugador(vista.getnombreJugador());
                mPartida.setJugador1(j1);
                
                j2 = new Jugador();
                j2.setNombreJugador("PablitoBOT");
                mPartida.setJugador2(j2);  
                break;
            case BvB:
                j1 = new Jugador();
                j1.setNombreJugador("DayanBOT");
                mPartida.setJugador1(j1);    
                
                
                j2 = new Jugador();
                j2.setNombreJugador("BuenardoBOT");
                mPartida.setJugador2(j2);    
                break;    
        }
    }
    
    private void mostrarVistaPartida(){
        switch (vista.getClass().toString()) {
            case "class MVP_Pasiva.Vista.VMenuConsola":
                this.vistaPartida = new VPartidaConsola();
                break;
            case "class MVP_Pasiva.Vista.VMenuSwing":
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
