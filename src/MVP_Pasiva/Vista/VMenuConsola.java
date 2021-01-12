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
            op=validar.inIntPositivo();
            switch (op) {
                case 1:
                    presentador.iniciarPartidaJvJ();
                    op=5;
                    break;
                case 2:
                    presentador.iniciarPartidaJvB();
                    op=5;
                    break;
                case 3:
                    presentador.iniciarPartidaBvB();
                    op=5;
                    break;  
                case 4:
                    cerrar();
                    presentador.mostrarMenuCargarPartidas();
                    break;
                case 5:
                    System.out.println("HASTA LA PROXIMA!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("OPCIONES ENTRE 1 Y 5");
                    break;
            }
        }while(op!=5);
        System.out.println("RECIEN SALGO");
    }
    
    private void menu() {
        System.out.println("<-------------MENU------------->");
        System.out.println("1.- Jugador   VS   Jugador");
        System.out.println("2.- Jugador   VS   BOT");
        System.out.println("3.- BOT       VS   BOT");
        System.out.println("4.- Cargar Partida");
        System.out.println("5.- Salir");
        System.out.println("Elija una opción");
    }

    @Override
    public void cerrar() {
        System.out.println("Saliendo de menu Principal .....");
    }


    @Override
    public String getnombreJugador() {
        System.out.println("Ingrese el nombre del Jugador");
        return validar.inString();
//        return validar.inNombreJugadorOptionPane("Ingrese el Nombre del Jugador");
    }

    @Override
    public int getPuntosMaximos() {
        System.out.println("Ingrese el nro de puntos necesarios para ganar:");
        return validar.inIntPositivo();
//        return validar.inPtosMaximosOptionPane("Ingrese Puntos necesarios para ganar");
    }

    @Override
    public String getTipoVista() {
        return "Consola";
    }
    
}
