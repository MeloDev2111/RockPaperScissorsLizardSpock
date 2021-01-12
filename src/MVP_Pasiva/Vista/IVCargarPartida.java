package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.PresentadorCargarPartida;

public interface IVCargarPartida {
    public void setPresentador(PresentadorCargarPartida p);
    public void iniciar();
    public void cerrar();
    public void setListaPartidas(Object[][] listaPartidas);
    public String getPartidaSeleccionada();
    public String getTipoVista();
}
