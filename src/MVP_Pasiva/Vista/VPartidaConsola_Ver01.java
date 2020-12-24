package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.Presentador_Version_01;
import Modelo.Jugador;
import Modelo.OpcionesJugada;
import Modelo.TiposPartida;

public class VPartidaConsola_Ver01 implements IVPartida_Ver01{
    private Presentador_Version_01 presenter;
    private Validacion validar = new Validacion();
    
    @Override
    public void setPresentador(Presentador_Version_01 p) {
        this.presenter = p;
    }

    @Override
    public void iniciar() {
        presenter.establecerTipoPartida();
        presenter.establecerPuntosMximos();
        presenter.registrarJugador();
        presenter.jugar();
    }
    
    @Override
    public TiposPartida getTipoPartida() {
        int op;
        do{
            menu();
            op=validar.inInt();
            switch (op) {
                case 1:
                    return TiposPartida.JvJ;
                case 2:
                    return TiposPartida.JvB;
                case 3:
                    System.out.println("HASTA LA PROXIMA!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("OPCIONES ENTRE 1 Y 3");
                    break;
            }
        }while(op!=3);
        return null;
    }

    @Override
    public int getPuntosMaximos() {
        System.out.println("INGRESE EL NUMERO DE PUNTOS REQUERIDOS PARA GANAR: ");
        return validar.inInt();
    }
    @Override
    public String getnombreJugador() {
        System.out.println("Ingrese Nombre del Jugador");
        String nombre = validar.inNombreJugadorOptionPane("Ingrese el Nombre del Jugador");
        return nombre;
    }

    @Override
    public OpcionesJugada getJugada(Jugador j) {
        switch (j.getTipo()) {
            case PERSONA:
                System.out.println("INGRESE SU JUGADA "+j.getNombreJugador());
                return validar.inJugada();
            case BOT:
        }
        return null;
    }

    @Override
    public void setSalida(String nombreJugador) {
        System.out.println("EL GANADOR ES "+nombreJugador);
    }

    private void menu() {
        System.out.println("<-------------MENU------------->");
        System.out.println("1.- 2 Jugadores");
        System.out.println("2.- Contra un BOT");
        System.out.println("3.- Salir");
        System.out.println("Elija una opción");
    }
}
