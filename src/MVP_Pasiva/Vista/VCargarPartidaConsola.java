package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.PresentadorCargarPartida;


public class VCargarPartidaConsola implements IVCargarPartida{
    private PresentadorCargarPartida presentador;
    private Validacion validar = new Validacion();
    private Object[][] listaLocal;
    private int id;
    @Override
    public void setPresentador(PresentadorCargarPartida p) {
        presentador = p;
    }

    @Override
    public void iniciar() {
        presentador.mostrarPartidas();
        int op;
        do{
            menu();
            op=validar.inIntPositivo();
            switch (op) {
                case 1:
                    System.out.println("INGRESE EL idPartida");
                    this.id = validar.inIntPositivo();
                    if (exists(id)) {
                        presentador.cargarPartida();
                        op=3;
                    }else{
                        System.out.println("Id NO VALIDO");
                    }
                    break;
                case 2:
                    presentador.salirMenu();
                    break;
                default:
                    System.out.println("OPCIONES 1 o 2");
                    break;
            }
        }while(op!=2);
    }

    @Override
    public void cerrar() {
        System.out.println("SALIENDO DE VISTA CARGAR PARTIDA");
    }

    @Override
    public void setListaPartidas(Object[][] listaPartidas) {
        this.listaLocal=listaPartidas;
        System.out.println("==========================================================");
        System.out.println("\t\t\tLISTA DE PARTIDAS");
        System.out.println("==========================================================");
        System.out.println("id\t.sReq\ttipo\tJugador 1  VS  Jugador 2");
        for (Object[] fila : listaPartidas) {
            System.out.println("----------------------------------------------------------");
            System.out.print( fila[0].toString()+"\t" );
            System.out.print( fila[1].toString()+"\t" );
            System.out.print( fila[2].toString()+"\t" );
            System.out.print( fila[3].toString()+"\tVS\t" );
            System.out.println( fila[5].toString() );        
        }
        System.out.println("==========================================================");
    }

    @Override
    public String getPartidaSeleccionada() {
        return String.valueOf(id);
    }

    @Override
    public String getTipoVista() {
        return "Consola";
    }
    
    private boolean exists(int i){
        for (Object[] fila : listaLocal) {
            if ( fila[0].toString().equals(String.valueOf(id)) ) {
                return true;
            }
        }
        return false;
    }
    
    private void menu(){
        System.out.println("-------------------------------------");
        System.out.println("\tMenu - VistaCargarPartida");
        System.out.println("1.- Cargar Partida");
        System.out.println("2.- Salir al Menu");
        System.out.println("Elija una opción");
        System.out.println("-------------------------------------");
    }
    
}
