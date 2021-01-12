/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import MVC.Controlador.Controlador;
import MVP_Pasiva.Presentador.PresentadorMenu;
import MVP_Pasiva.Vista.IVMenu;
import MVP_Pasiva.Vista.Validacion;
import MVP_Pasiva.Vista.VMenuConsola;
import MVP_Pasiva.Vista.VMenuSwing;
import Modelo.Partida;

/**
 *
 * @author eddyf
 */
public class Main {
    public static void main(String[] args) {

    //MVP VISTA PASIVA ---- SWING
        Partida p1 = new Partida();
        IVMenu vistaS = new VMenuSwing();
        PresentadorMenu pMenuS = new PresentadorMenu(vistaS, p1);
        vistaS.setPresentador(pMenuS);
        vistaS.iniciar();
    
    //MVP VISTA PASIVA ---- CONSOLA
//        Partida p2 = new Partida();
//        IVMenu vistaC = new VMenuConsola();
//        PresentadorMenu pMenuC = new PresentadorMenu(vistaC, p2);
//        vistaC.setPresentador(pMenuC);
//        vistaC.iniciar();
    
    //MVC ------------ CONSOLA
//        Controlador controlador = new Controlador();
//        controlador.controlar();
    
    }
}