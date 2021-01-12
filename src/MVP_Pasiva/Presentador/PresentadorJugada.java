package MVP_Pasiva.Presentador;

import MVP_Pasiva.Vista.IVJugada;
import MVP_Pasiva.Vista.IVRonda;
import MVP_Pasiva.Vista.VJugadaConsola;
import MVP_Pasiva.Vista.VJugadaSwing;
import MVP_Pasiva.Vista.VRondaConsola;
import MVP_Pasiva.Vista.VRondaSwing;
import Modelo.Jugada;
import Modelo.Partida;
import Modelo.Ronda;
import Modelo.ServicioRonda;
import Modelo.ServicioJugadaBOT;

public class PresentadorJugada {
    private IVJugada vista;
    private Partida mPartida;
    private Ronda mRonda;
    
    private ServicioJugadaBOT servicio = new ServicioJugadaBOT();
    private ServicioRonda servicioRonda = new ServicioRonda();
    private IVRonda vistaRonda;
    private IVJugada vistaJugada;    
    
    public PresentadorJugada(IVJugada vista, Partida mPartida, Ronda mRonda) {
        this.vista = vista;
        this.mPartida = mPartida;
         this.mRonda = mRonda;
    }
    
    public void setJugador(){
        if (mRonda.getJugada_Jugador1()==null) {
            vista.setNombreJugador(mPartida.getJugador1().getNombreJugador());
        }else if(mRonda.getJugada_Jugador2()==null){
            vista.setNombreJugador(mPartida.getJugador2().getNombreJugador());
        }else{
            System.out.println("WTF ESTO NO DEBE PASAR");
        }
    }
    
    public void RegistrarJugada(){
        switch (mPartida.getTipo()) {
            case JvJ:
                if (mRonda.getJugada_Jugador1()==null) {
                    Jugada jugadaJ1 = new Jugada();
                    jugadaJ1.setJugador(mPartida.getJugador1());
                    jugadaJ1.setJugada_Seleccionada(vista.getJugada());

                    mRonda.setJugada_Jugador1(jugadaJ1);
                    
                }else if(mRonda.getJugada_Jugador2()==null){
                    Jugada jugadaJ2 = new Jugada();
                    jugadaJ2.setJugador(mPartida.getJugador2());
                    jugadaJ2.setJugada_Seleccionada(vista.getJugada());
                    
                    mRonda.setJugada_Jugador2(jugadaJ2);
                    
                }else{
                    System.out.println("EL TRUQUITO FALLO EN RegistrarJugada - JVJ-PresentadoJugada");
                }
                
                break;
            case JvB:
                if (mRonda.getJugada_Jugador1()==null) {
                    Jugada jugadaJ1 = new Jugada();
                    jugadaJ1.setJugador(mPartida.getJugador1());
                    jugadaJ1.setJugada_Seleccionada(vista.getJugada());
                    
                    mRonda.setJugada_Jugador1(jugadaJ1);
                    
                }else if(mRonda.getJugada_Jugador2()==null){
                    Jugada jugadaJ2 = new Jugada();
                    jugadaJ2.setJugador(mPartida.getJugador2());
                    
                    jugadaJ2 = servicio.jugar(jugadaJ2);
                    
                    mRonda.setJugada_Jugador2(jugadaJ2);
                    
                }else{
                    System.out.println("EL TRUQUITO FALLO EN RegistrarJugada - JVB-PresentadoJugada");
                }
                break;
            case BvB:
                
                Jugada jugadaJ1 = new Jugada();
                jugadaJ1.setJugador(mPartida.getJugador1());
                
                jugadaJ1 = servicio.jugar(jugadaJ1);
                
                Jugada jugadaJ2 = new Jugada();
                jugadaJ2.setJugador(mPartida.getJugador2());
                
                jugadaJ2 = servicio.jugar(jugadaJ2);
                    
                mRonda.setJugada_Jugador1(jugadaJ1);
                mRonda.setJugada_Jugador2(jugadaJ2);
        }
    }
    
    public void mostrarSiguienteVista(){
        
        if (mRonda.getJugada_Jugador1()!=null && mRonda.getJugada_Jugador2()!=null){
            
            mRonda = servicioRonda.evaluarGanador(mRonda);
            //MOSTRAR VISTA RONDA CON EL RESULTADO
            mostrarVistaRonda();
        }
        
        switch (mPartida.getTipo()) {
            case JvJ:
                if (mRonda.getJugada_Jugador1()==null || mRonda.getJugada_Jugador2()==null){
                    mostrarVistaJugada();
                }
                
                break;
            case JvB:
                if (mRonda.getJugada_Jugador1()==null || mRonda.getJugada_Jugador2()==null){
                    establecetTiposVistas();
                    PresentadorJugada presetandorJugada = new PresentadorJugada(vistaJugada, mPartida,mRonda);
                    vistaJugada.setPresentador(presetandorJugada);
                    
                    //SOLO EJECUTAR EL METODO REGISTRA JUGADA Y ABRIR EL VISTA RONDA
                    presetandorJugada.RegistrarJugada();
                    presetandorJugada.mostrarSiguienteVista();
                    this.vista.cerrar();
                }
                break;
            case BvB:
                if (mRonda.getJugada_Jugador1()==null || mRonda.getJugada_Jugador2()==null){
                    //SOLO EJECUTAR EL METODO REGISTRA JUGADA Y ABRIR EL VISTA RONDA
                    RegistrarJugada();
                    mostrarSiguienteVista();
                }
                break;
        }
        
    }
    private void mostrarVistaRonda(){
        establecetTiposVistas();
        PresentadorRonda presentadorRonda = new PresentadorRonda(vistaRonda, mPartida, mRonda);
        vistaRonda.setPresentador(presentadorRonda);
        vistaRonda.iniciar();
        this.vista.cerrar();
    }
    private void mostrarVistaJugada(){
        establecetTiposVistas();
        PresentadorJugada presetandorJugada = new PresentadorJugada(vistaJugada, mPartida,mRonda);
        vistaJugada.setPresentador(presetandorJugada);
        vistaJugada.iniciar();
        this.vista.cerrar();
    }
    
    private void establecetTiposVistas(){
        switch (vista.getTipoVista()) {
            case "Consola":
                this.vistaJugada = new VJugadaConsola();
                this.vistaRonda = new VRondaConsola();
                break;
            case "Swing":
                this.vistaJugada = new VJugadaSwing();
                this.vistaRonda = new VRondaSwing();
                break;
            default:
                System.out.println("REVISAR EL GET TIPO DE VISTAS implementadas de IVJugada y IVRonda");
                throw new AssertionError();
        }
    }
}
