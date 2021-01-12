package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.PresentadorRonda;

public class VRondaConsola implements IVRonda {
    private PresentadorRonda presentador;
    private Validacion validar = new Validacion();

    @Override
    public void setPresentador(PresentadorRonda p) {
        presentador = p;
    }

    @Override
    public void iniciar() {
        presentador.mostrarDatos();
        presentador.agregarRonda();
        presentador.mostrarVistaPartida();
    }

    @Override
    public void cerrar() {
        System.out.println("SALIENDO DE VISTA RONDA");
    }

    @Override
    public void setNroRonda(int NroRonda) {
        System.out.println("/////////////////////////////////////");
        System.out.println("\t\tRONDA Nº: "+NroRonda);
        System.out.println("/////////////////////////////////////");
    }

    @Override
    public void setNombreJugadores(String nombreJ1, String nombreJ2) {
        System.out.print("\t"+nombreJ1+"\t\t");
        System.out.println(nombreJ2);
        System.out.println("-------------------------------------");
    }

    @Override
    public void setJugadas(String OpJugadaJ1, String OpJugadaJ2) {
        System.out.print("\t"+OpJugadaJ1+"\t VS \t");
        System.out.println(OpJugadaJ2);
    }   

    @Override
    public void setSalida(String nombreGanador) {
        System.out.println("");
        System.out.println("GANADOR DE LA RONDA: "+nombreGanador);
        System.out.println("-------------------------------------");
    }

    @Override
    public String getTipoVista() {
        return "Consola";
    }
    
    
}
