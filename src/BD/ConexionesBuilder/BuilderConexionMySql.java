/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.ConexionesBuilder;

/**
 *
 * @author josue
 */
public class BuilderConexionMySql extends BuilderConexion{
       
    //JDBC driver y url
    private final String JDBC_Driver="com.mysql.cj.jdbc.Driver";//"org.postgresql.Driver"
    //com.mysql.jdbc.Driver //org.gjt.mm.mysql.Driver
    //private final String url="jdbc:mysql://localhost:3306/login";
    private final String url="jdbc:mysql://localhost/PiedraPapelTijeraBD";
    //Credenciales
    private final String user="root";
    private final String pass="Asdfmovie1234567";
//    private final String descripcion="CONECTADO A localhost mediante XAMPP";
    private final String descripcion="CONECTADO A localhost mediante Mysql";
    @Override
    public Conexion crearConexion() {
        return new Conexion(JDBC_Driver, url, user, pass, descripcion);
    }
}
