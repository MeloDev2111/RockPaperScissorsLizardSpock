package MVP_Pasiva.Vista;

import MVP_Pasiva.Presentador.PresentadorRonda;

public interface IVRonda {
    public void setPresentador(PresentadorRonda p);
    public void iniciar();
    public void cerrar();
    public void setNroRonda(int NroRonda);
    public void setNombreJugadores(String nombreJ1, String nombreJ2);
    public void setJugadas(String OpJugadaJ1, String OpJugadaJ2);
    public void setSalida(String nombreGanador);
    public String getTipoVista();
}
