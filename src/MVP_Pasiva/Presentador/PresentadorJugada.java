package MVP_Pasiva.Presentador;

import MVP_Pasiva.Vista.IVJugada;
import MVP_Pasiva.Vista.IVRonda;
import MVP_Pasiva.Vista.VJugadaSwing;
import MVP_Pasiva.Vista.VRondaSwing;
import Modelo.Jugada;
import Modelo.Partida;
import Modelo.Ronda;

public class PresentadorJugada {
    IVJugada vista;
    Partida mPartida;
    Ronda mRonda;
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
                    Jugada jugadaJ1 = new Jugada(mPartida.getJugador1(),
                            vista.getJugada());
                    mRonda.setJugada_Jugador1(jugadaJ1);
                }else if(mRonda.getJugada_Jugador2()==null){
                    Jugada jugadaJ2 = new Jugada(mPartida.getJugador2(),
                            vista.getJugada());
                    mRonda.setJugada_Jugador2(jugadaJ2);
                }else{
                    System.out.println("WTF ESTO YA NO PASA");
                }
                
                break;
            case JvB:
                if (mRonda.getJugada_Jugador1()==null) {
                    Jugada jugadaJ1 = new Jugada(mPartida.getJugador1(),
                            vista.getJugada());
                    mRonda.setJugada_Jugador1(jugadaJ1);
                }else if(mRonda.getJugada_Jugador2()==null){
                    Jugada jugadaJ2 = new Jugada(mPartida.getJugador2(),
                           mPartida.getJugador2().jugar());
                    
                    mRonda.setJugada_Jugador2(jugadaJ2);
                }else{
                    System.out.println("WTF ESTO YA NO PASA");
                }
                break;
            case BvB:
                Jugada jugadaJ1 = new Jugada(mPartida.getJugador1(),
                           mPartida.getJugador1().jugar());
                Jugada jugadaJ2 = new Jugada(mPartida.getJugador2(),
                           mPartida.getJugador2().jugar());
                    
                mRonda.setJugada_Jugador1(jugadaJ1);
                mRonda.setJugada_Jugador2(jugadaJ2);
        }
    }
    
    public void mostrarSiguienteVista(){
        
        if (mRonda.getJugada_Jugador1()!=null && mRonda.getJugada_Jugador2()!=null){
            mRonda.evaluarGanadorRonda();
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
                    IVJugada vistaJugada = new VJugadaSwing();//GETCLASS()!!!!!!!
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
        IVRonda vistaRonda = new VRondaSwing();
        PresentadorRonda presentadorRonda = new PresentadorRonda(vistaRonda, mPartida, mRonda);
        vistaRonda.setPresentador(presentadorRonda);
        vistaRonda.iniciar();
        this.vista.cerrar();
    }
    private void mostrarVistaJugada(){
        IVJugada vistaJugada = new VJugadaSwing();//GETCLASS()!!!!!!!
        PresentadorJugada presetandorJugada = new PresentadorJugada(vistaJugada, mPartida,mRonda);
        vistaJugada.setPresentador(presetandorJugada);
        vistaJugada.iniciar();
        this.vista.cerrar();
    }
}
