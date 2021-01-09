package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.PresentadorMenu;

public class VMenuConsola implements IVMenu{
    private PresentadorMenu presentador;
    private Validacion validar = new Validacion();
    
    @Override
    public void setPresentador(PresentadorMenu p) {
        this.presentador = p;
    }

    @Override
    public void iniciar() {
       int op;
        do{
            menu();
            op=validar.inInt();
            switch (op) {
                case 1:
                    presentador.iniciarPartidaJvJ();
                    break;
                case 2:
                    presentador.iniciarPartidaJvB();
                    break;
                case 3:
                    presentador.iniciarPartidaBvB();
                    break;  
                case 4:
                    presentador.mostrarMenuCargarPartidas();
                    break;
                case 5:
                    presentador.mostrarCreditos();
                    break;
                case 6:
                    System.out.println("HASTA LA PROXIMA!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("OPCIONES ENTRE 1 Y 6");
                    break;
            }
        }while(op!=6);
    }
    
    private void menu() {
        System.out.println("<-------------MENU------------->");
        System.out.println("1.- 2 Jugadores");
        System.out.println("2.- Jugador contra BOT");
        System.out.println("3.- BOT Contra BOT");
        System.out.println("4.- Cargar Partida");
        System.out.println("5.- Creditos");
        System.out.println("6.- Salir");
        System.out.println("Elija una opción");
    }

    @Override
    public void cerrar() {
        System.out.println("Saliendo de menu Principal .....");
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
    
}
