package MVC.Controlador;

import MVC.Vista.Vista;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Ronda;
import Modelo.ServicioPartida;
import Modelo.ServicioRonda;
import Modelo.TiposJugador;

public class Controlador {
    private Vista vista;
    private Partida partida;    
    
    public Controlador(){
        partida = new Partida();
        vista = new Vista(partida);       
    }

    public void controlar(){
        vista.mostrarIngreso();
        asignarJugadores();
        vista.establecerPuntos(); 
        iniciarJuego();
    }
    
    public void asignarJugadores(){        
        switch (partida.getTipo()) {
            case JvJ:
                vista.registrarJugador(1);
                vista.registrarJugador(2);
                break;
            case JvB:
                vista.registrarJugador(1);
                partida.setJugador2( new Jugador("BuenardoBOT",TiposJugador.BOT));
                break;   
            case BvB:
                partida.setJugador1( new Jugador("DayanBOT",TiposJugador.BOT));
                partida.setJugador2( new Jugador("BuenardoBOT",TiposJugador.BOT));    
                break;    
        }
    }
    
    public void iniciarJuego(){
        ServicioPartida sp = new ServicioPartida();
        ServicioRonda sr = new ServicioRonda();
        int i=0;
        do{
            System.out.println("Partida al mejor de :"+partida.getAlMejorDe());
            realizarRonda(i);
            sr.evaluarGanador(partida.getRondas().get(i));
            vista.mostrarGanadorRonda(i);
            sp.evaluarGanador(partida);
            i++;
        }while(partida.getGanador()==null);
        vista.mostrarGanadorPartida();
    }
    
    public void realizarRonda(int r){
        Ronda ronda = new Ronda(r+1);
        System.out.println("Ronda N°"+(r+1)+":");
        ronda.setJugada_Jugador1(vista.realizarJugada(1));                
        ronda.setJugada_Jugador2(vista.realizarJugada(2));      
        partida.agregarRonda(ronda);
        vista.mostrarJugadas(r);
    }
    
}