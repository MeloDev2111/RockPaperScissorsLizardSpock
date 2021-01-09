/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.ConexionesBuilder;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josue
 */
public class Pruebas {
    public static void main(String[] args) {
        BuilderConexion builder = new BuilderConexionCleverCloud();
        BuilderConexion builder2 = new BuilderConexionMySql();
        
        Conexion conexion = builder.crearConexion();
        Conexion conexion2 = builder2.crearConexion();
        
//        System.out.println("HOLA");
//        conexion.conectar();
//        conexion.descripcion();
        System.out.println("HOLA");
        conexion2.conectar();
        conexion2.descripcion();
        
//        IUsuariosDAO dao = new DAOUsuariosImpl();
////        
//        Usuario user = new Usuario("U003", "VASVASMAN", "1234", "Administrador");
//        Usuario user = new Usuario("U004", "LaBOA", "6969", "Administrador");
//        
//        try {
//            dao.registrar(user);
//        } catch (Exception ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        user = new Usuario("U003", "VASVASMAN", "1234", "Recepcionista");
//        try {
//            dao.actualizar(user);
//        } catch (Exception ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        try {
//            dao.eliminar(user);
//        } catch (Exception ex) {
//            System.out.println("ELIMINADO");
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        try {
//            List<Usuario> usuarios = dao.listar();
//            for (Usuario usuario : usuarios) {
//                usuario.imprimir();
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
    }
}
