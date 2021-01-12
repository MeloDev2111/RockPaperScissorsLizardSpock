
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
        System.out.println("//////////////////////////");
        System.out.println("\tTURNO DE:\t"+nombre);
        System.out.println("//////////////////////////");
    }
    
    @Override
    public OpcionesJugada getJugada() {
        this.menuJugadas();
        return validar.inJugada();
    }
    
    
    private void menuJugadas(){
        System.out.println("\tJUGADAS POSIBLES:");
        System.out.println("++++++++++++++++++++++++");
        System.out.println("ROCK        (R)");
        System.out.println("PAPER       (P)");
        System.out.println("SCISSORS    (S)");
        System.out.println("LIZARD      (L)");
        System.out.println("SPOCK       (V)");
        System.out.println("++++++++++++++++++++++++");
        System.out.println("Ingrese el caracter correspondiente");
        System.out.println("-----------------------------------");
    }

    @Override
    public String getTipoVista() {
        return "Consola";
    }
}
