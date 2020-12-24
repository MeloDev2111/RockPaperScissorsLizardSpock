package MVP_Pasiva.Presentador;

import MVP_Pasiva.Vista.IVMenu;
import MVP_Pasiva.Vista.IVPartida;
import MVP_Pasiva.Vista.VPartidaConsola;
import MVP_Pasiva.Vista.VPartidaSwing;
import Modelo.Partida;
import Modelo.TiposPartida;

public class PresentadorMenu {
    private IVMenu vista;
    private Partida mPartida;
    
    private IVPartida vistaPartida;
    
    public PresentadorMenu(IVMenu vista, Partida mPartida) {
        this.vista = vista;
        this.mPartida = mPartida;
    }
    
    //ALTERNATIVA DE COLOCAR UN PARAMETRO TIPO DE VISTA, PARA evitar el getClass()
    public void iniciarPartidaJvJ(){
        mPartida.setTipo(TiposPartida.JvJ);
        //INICIAR VISTA PARTIDA - MODO JVJ
        mostrarVistaPartida();
    }
    
    public void iniciarPartidaJvB(){
        mPartida.setTipo(TiposPartida.JvB);
        //INICIAR VISTA PARTIDA - MODO JVB
        mostrarVistaPartida();
    }
    
    public void iniciarPartidaBvB(){
        mPartida.setTipo(TiposPartida.BvB);
        //INICIAR VISTA PARTIDA - MODO BVB
        mostrarVistaPartida();
    }
    
    public void mostrarMenuCargarPartidas(){
        
    }
    
    public void mostrarCreditos(){
        
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
