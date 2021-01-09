/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.ConexionesBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author josue
 */
public class Conexion {
    private Connection con;
    //JDBC driver y url
    private final String JDBC_Driver;
    private final String url;
    
    //Credenciales
    private final String user;
    private final String pass;
    private final String descripcion;
    
    public Conexion(String JDBC_Driver, String url, String user, 
            String pass, String descripcion) {
        this.JDBC_Driver = JDBC_Driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.descripcion =descripcion;
    }
    
    
    public void conectar() {
        try {
            Class.forName(JDBC_Driver);
            con = DriverManager.getConnection(url, user, pass);//"con" tipo Connection de clase conexion

            if (con != null) {
//                    System.out.println("CONECTADO");
            }
            
        } catch (ClassNotFoundException | SQLException e) {
                System.out.println("No se pudo conectar a la "
                        + "base de datos");
                e.printStackTrace();
        }
    }
    
    
    public void cerrar() throws SQLException{
        if (con!=null) {
            if(!con.isClosed()){
                con.close();
//                System.out.println("CONEXION CERRADA");
            }
        }
    }

    
    public void descripcion() {
        System.out.println(descripcion);
    }
    
    
    public Connection getConnection() {
        return con;
    }
}
