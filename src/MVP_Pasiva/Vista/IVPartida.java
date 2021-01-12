package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.PresentadorPartida;

public interface IVPartida {
    public void setPresentador(PresentadorPartida p);
    public void iniciar();
    public void cerrar();
    public void setTituloPartida(String idPartida, String Modo);
    public void setnombreJugadores(String nombreJ1, String nombreJ2);
    public void setSalida(int scoreJ1, int scoreJ2, String nombreGanador);
    public String getTipoVista();
}
