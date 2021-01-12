
package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.PresentadorPartida;


public class VPartidaConsola implements IVPartida {
    private PresentadorPartida presentador;
    private Validacion validar = new Validacion();
    private boolean partidafinalizada=false;
    
    @Override
    public void setPresentador(PresentadorPartida p) {
        presentador = p;
    }
    
    @Override
    public void iniciar() {
        presentador.ActualizarInformacion();
        int op;
        if (!partidafinalizada) {
            do{
                menu();
                op=validar.inIntPositivo();
                switch (op) {
                    case 1:
                        presentador.iniciarRonda();
                        op=3;
                        break;
                    case 2:
                        presentador.guardarPartida();
                        break;
                    case 3:
                        presentador.salirMenu();
                        break;  
                    default:
                        System.out.println("OPCIONES ENTRE 1 Y 3");
                        break;
                }
            }while(op!=3);
        }else{
            do{
                menuRestringido();
                op=validar.inIntPositivo();
                switch (op) {
                    case 1:
                        presentador.guardarPartida();
                        break;
                    case 2:
                        presentador.salirMenu();
                        break;
                    default:
                        System.out.println("OPCIONES ENTRE 1 Y 2");
                        break;
                }
            }while(op!=2);
        }
    }
    
    @Override
    public void cerrar() {
        System.out.println("SALIENDO DE VISTA PARTIDA");
    }
    @Override
    public void setSalida(int scoreJ1, int scoreJ2, String nombreGanador) {
        System.out.println("ScoreJ1\t\tScoreJ2");
        System.out.print(scoreJ1+"\t\t");
        System.out.println(scoreJ2);

        
        if (nombreGanador!=null) {
            System.out.println("*************************************");
            System.out.println("EL GANADOR ES :" + nombreGanador);
            partidafinalizada=true;
            System.out.println("*************************************");
        }
        
    }

    @Override
    public void setnombreJugadores(String nombreJ1, String nombreJ2) {
        System.out.print(nombreJ1+"\t\t");
        System.out.println(nombreJ2);
        System.out.println("-------------------------------------");
    }

    @Override
    public void setTituloPartida(String idPartida, String Modo) {
        System.out.println("=====================================");
        System.out.println("\tPARTIDA #"+idPartida+" ("+Modo+" mode)");
        System.out.println("=====================================");
    }
    
    private void menu(){
        System.out.println("-------------------------------------");
        System.out.println("\tMenu - VistaPartida");
        System.out.println("1.- Iniciar Ronda");
        System.out.println("2.- Guardar Partida");
        System.out.println("3.- Salir al Menu");
        System.out.println("Elija una opción");
        System.out.println("-------------------------------------");
    }
    
    private void menuRestringido(){
        System.out.println("-------------------------------------");
        System.out.println("\tMenuRestringido - VistaPartida");
        System.out.println("1.- Guardar Partida");
        System.out.println("2.- Salir al Menu");
        System.out.println("Elija una opción");
        System.out.println("-------------------------------------");
    }

    @Override
    public String getTipoVista() {
        return "Consola";
    }
}
