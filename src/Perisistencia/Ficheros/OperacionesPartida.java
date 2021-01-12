package Perisistencia.Ficheros;

import Modelo.Jugada;
import Modelo.Jugador;
import Modelo.OpcionesJugada;
import Modelo.Partida;
import Modelo.Ronda;
import Modelo.ServicioPartida;
import Modelo.ServicioRonda;
import Modelo.TiposJugador;
import Modelo.TiposPartida;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OperacionesPartida extends operaciones{
    ServicioRonda servicioRonda = new ServicioRonda();
    ServicioPartida servicioPartida = new ServicioPartida();
    public OperacionesPartida(String dir) {
        super(dir);
    }
    
    public void guardar(Partida p){
        try{
            LimpiarFichero();
            WriteAppendLine(p.getIdPartida());
            WriteAppendLine( String.valueOf(p.getAlMejorDe()) );
            WriteAppendLine(p.getTipo().name());
            WriteAppendLine(p.getJugador1().getNombreJugador());
            WriteAppendLine(p.getJugador1().getTipo().name());
            WriteAppendLine(p.getJugador2().getNombreJugador());
            WriteAppendLine(p.getJugador2().getTipo().name());

            for (Ronda ronda : p.getRondas()) {
                WriteAppendLine( ronda.getJugada_Jugador1()
                        .getJugada_Seleccionada().name() );

                WriteAppendLine( ronda.getJugada_Jugador2()
                        .getJugada_Seleccionada().name());
            }
            System.out.println("¡¡PARTIDA GUARDADA!!");
        }catch(Exception e){
            System.out.println("ERROR AL GUARDAR PARTIDA");
        }
        
    }
    
    public Partida getPartida(){
        Partida p1 = null;
        ArrayList<Ronda> rondas = new ArrayList<>();
        int nroRonda=1;
        Ronda r = new Ronda(nroRonda);
        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador();
        Jugada jugada_j1=new Jugada();
        Jugada jugada_j2=new Jugada();
        
        try{
            int j=-1;
            
            p1 = new Partida();
            //REFACTORIZAR
            br = new BufferedReader( new FileReader(this.dir));
            Line = br.readLine();
            
            for (int i = 0; i < 7; i++) {
                switch (i) {
                    case 0:
                        p1.setIdPartida(Line);
                        break;
                    case 1:
                        p1.setAlMejorDe( Integer.valueOf(Line) );
                        break;
                    case 2:
                        p1.setTipo(TiposPartida.valueOf(Line));
                        break;
                    case 3:
                        j1.setNombreJugador(Line);
                        break;
                    case 4:
                        j1.setTipo(TiposJugador.valueOf(Line));
                        break;
                    case 5:
                        j2.setNombreJugador(Line);
                        break;
                    case 6:
                        j2.setTipo(TiposJugador.valueOf(Line));
                        j++;
                        break;    
                }
                Line = br.readLine();
            }
            p1.setJugador1(j1);
            p1.setJugador2(j2);

            jugada_j1.setJugador(j1);
            jugada_j2.setJugador(j2);
            
            while (Line!=null) {
                switch (j) {
                    case 0:
                        jugada_j1.setJugada_Seleccionada(OpcionesJugada.valueOf(Line));
                        break;
                    case 1:
                        jugada_j2.setJugada_Seleccionada(OpcionesJugada.valueOf(Line));
                        nroRonda++;
                        break;
                }
                if (j==1) {
                    r.setJugada_Jugador1(jugada_j1);
                    r.setJugada_Jugador2(jugada_j2);
                    
                    r = servicioRonda.evaluarGanador(r);
                    
                    p1.agregarRonda(r);
                    r= new Ronda(nroRonda);
                    j=-1;
                }
                j++;
                Line = br.readLine();
            }
            
    }catch(IOException | NumberFormatException e){
        System.out.println("Error");
    }
        
        p1 = servicioPartida.evaluarGanador(p1);
       
        return p1;
    }
}
