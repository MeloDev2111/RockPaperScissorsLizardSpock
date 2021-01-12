package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.PresentadorMenu;

public interface IVMenu {
    public void setPresentador(PresentadorMenu p);
    public void iniciar();
    public void cerrar();
    public String getnombreJugador();
    public int getPuntosMaximos();
    public String getTipoVista();
}
