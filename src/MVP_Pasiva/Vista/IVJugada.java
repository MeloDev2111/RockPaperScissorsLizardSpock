package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.PresentadorJugada;
import Modelo.OpcionesJugada;

public interface IVJugada {
    public void setPresentador(PresentadorJugada p);
    public OpcionesJugada getJugada();
    public void setNombreJugador(String nombre);
    public void iniciar();
    public void cerrar();
    public String getTipoVista();
}
