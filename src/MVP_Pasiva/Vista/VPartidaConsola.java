
package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.PresentadorPartida;


public class VPartidaConsola implements IVPartida {
    private PresentadorPartida presentador;
    private Validacion validar = new Validacion();
    
    @Override
    public void setPresentador(PresentadorPartida p) {
        presentador = p;
    }

    @Override
    public void iniciar() {
        //DATOS NECESARIOS 
        presentador.establecerPuntosMaximos();
        presentador.registrarJugadores();
        presentador.establecerTitulo();
        //cargar datos
        mostrar();
    }
    
    @Override
    public void mostrar() {
        presentador.ActualizarInformacion();
    }
    
    @Override
    public void cerrar() {
        System.out.println("SALIENDO DE VISTA PARTIDA");
    }

    @Override
    public String getnombreJugador() {
//        return validar.inString();
        return validar.inNombreJugadorOptionPane("Ingrese el Nombre del Jugador");
    }

    @Override
    public int getPuntosMaximos() {
//        return validar.inInt();
        return validar.inPtosMaximosOptionPane("Ingrese Puntos necesarios para ganar");
    }

    @Override
    public void setSalida(int scoreJ1, int scoreJ2, String nombreGanador) {
        System.out.println("Score J1: "+ scoreJ1);
        System.out.println("Score J2: "+ scoreJ2);
        if (nombreGanador!=null) {
            System.out.println("EL GANADOR ES :" + nombreGanador);
        }
    }

    @Override
    public void setnombreJugadores(String nombreJ1, String nombreJ2) {
        System.out.println("Jugador 1: " + nombreJ1);
        System.out.println("Jugador 2: " + nombreJ2);
    }

    @Override
    public void setTituloPartida(String idPartida, String Modo) {
        System.out.println("PARTIDA #"+idPartida+" ("+Modo+" mode)");
    }

}
