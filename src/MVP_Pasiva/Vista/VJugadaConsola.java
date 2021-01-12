
package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.PresentadorJugada;
import Modelo.OpcionesJugada;



public class VJugadaConsola implements IVJugada {
    private PresentadorJugada presentador;
    private Validacion validar = new Validacion();
    
    @Override
    public void setPresentador(PresentadorJugada p) {
        presentador = p;
    }
    
    @Override
    public void iniciar() {
        presentador.setJugador();
        presentador.RegistrarJugada();
        presentador.mostrarSiguienteVista();
    }
    
    
    
    @Override
    public void cerrar() {
        System.out.println("SALIENDO DE VISTA JUGADA");
    }
    
    @Override
    public void setNombreJugador(String nombre) {
        System.out.println("/////////////////////////////////////");
        System.out.println("\tTURNO DE:\t"+nombre);
        System.out.println("/////////////////////////////////////");
    }
    
    @Override
    public OpcionesJugada getJugada() {
        this.menuJugadas();
        return validar.inJugada();
    }
    
    
    private void menuJugadas(){
        System.out.println("\tJUGADAS POSIBLES:");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("ROCK        \t\t(R)");
        System.out.println("PAPER       \t\t(P)");
        System.out.println("SCISSORS    \t\t(S)");
        System.out.println("LIZARD      \t\t(L)");
        System.out.println("SPOCK       \t\t(V)");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("Ingrese el caracter correspondiente");
        System.out.println("-----------------------------------");
    }

    @Override
    public String getTipoVista() {
        return "Consola";
    }
}
