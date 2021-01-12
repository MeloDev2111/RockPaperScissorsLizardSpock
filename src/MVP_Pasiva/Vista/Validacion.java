package MVP_Pasiva.Vista;

import Modelo.OpcionesJugada;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Validacion {
    private Scanner in = new Scanner(System.in);

    public double inDouble(){
        double entrada = 0.0;
        boolean valido = false;
        do {
            in = new Scanner(System.in);//MODI
            try {
                entrada = in.nextDouble();
                valido = true;
            }catch (Exception e){
                this.mostrarError("Double");//MODIFICACION
            }
        }while (!valido);
        return entrada;
    }
    public int inIntPositivo(){
        int entrada = 0;
        boolean valido = false;
        do {
            in = new Scanner(System.in);//MODI
            try {
                entrada = in.nextInt();
                if (entrada<=0){
                    this.mostrarErrorOptionPane("Debe ingresar un valor numerico mayor a 0");
                }else{
                    valido = true;
                }
            }catch (Exception e){
                this.mostrarError("Entero");
            }
            
        }while (!valido);
        return entrada;
    }
    public char inChar(){
        char entrada = ' ';
        boolean valido = false;
                
        do {
            in = new Scanner(System.in);//MODI
            String input = in.next();
            if (input.length() != 1) {
                this.mostrarError("caracter");
            }else{
                entrada = input.charAt(0);
                valido = true;
            }
        }while (!valido);
        return entrada;
    }
    
    public String inString(){
        String entrada = "";
        boolean valido = false;
                
        do {
            in = new Scanner(System.in);//MODI
            String input = in.next();
            if ("".equals(input)) {
                this.mostrarError("Debe ingresar un valor");
            }else{
                entrada = input;
                valido = true;
            }
        }while (!valido);
        
        return entrada;
    }
    
    
    public String inNombreJugadorOptionPane(String titulo){
        String entrada = "";
        boolean valido = false;
        do {
            String input = JOptionPane.showInputDialog(titulo,"Guest01");
            if ("".equals(input)){
                this.mostrarErrorOptionPane("Debe ingresar un valor");
            }else{
                entrada = input;
                valido = true;
            }
        }while (!valido);
        return entrada;
    }
    
    public int inPtosMaximosOptionPane(String titulo){
        int entrada = -1;
        boolean valido = false;
        do {
            String input = JOptionPane.showInputDialog(titulo,"3");
            entrada = Integer.valueOf(input);
            if (entrada<=0){
                this.mostrarErrorOptionPane("Debe ingresar un valor numerico mayor a 0");
            }else{
                valido = true;
            }
        }while (!valido);
        return entrada;
    }
    
    public OpcionesJugada inJugada(){
        OpcionesJugada jugada = null;
        boolean valido = false;
        do {
            String entrada = in.next();
            if (entrada.length() != 1) {
                this.mostrarError("caracter");
            }else {
                for (OpcionesJugada j:OpcionesJugada.values()) {
                    if (j.getCaracter()==entrada.charAt(0)){
                        jugada = j;
                    }
                }

                if (jugada==null) {
                    this.mostrarError("R, P, S, L o V");
                }
            }

            if (jugada!=null) {
                valido = true;
            }

        } while (!valido);

        return jugada;
    }

    private void mostrarError(String formato){
        System.out.println("Error de Formato.. "+
                "Ingrese un valor con formato: " + formato + "\n" );
    }
    private void mostrarErrorOptionPane(String formato){
        JOptionPane.showMessageDialog(null,
        formato,
        "ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
