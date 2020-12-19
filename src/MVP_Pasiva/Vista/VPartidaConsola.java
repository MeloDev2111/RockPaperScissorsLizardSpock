/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.Presentador;
import Modelo.Jugador;
import Modelo.OpcionesJugada;

/**
 *
 * @author eddyf
 */
public class VPartidaConsola implements IVPartida{
    private Presentador presenter;
    private Validacion validar = new Validacion();
    
    @Override
    public void setPresentador(Presentador p) {
        this.presenter = p;
    }

    @Override
    public void iniciar() {
        int op;
        do{
            menu();
            op=validar.inInt();
            switch (op) {
                case 1:
                    
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("HASTA LA PROXIMA!");
                    break;
                default:
                    System.out.println("OPCIONES ENTRE 1 Y 3");
                    break;
            }
        }while(op!=3);
    }

    @Override
    public String getnombreJugador() {
        System.out.println("Ingrese Nombre del Jugador");
        return validar.inStringOptionPane();
    }

    @Override
    public OpcionesJugada getJugada(Jugador j) {
        switch (j.getTipo()) {
            case PERSONA:
                System.out.println("INGRESE SU JUGADA");
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
