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
public class BuilderConexionCleverCloud extends BuilderConexion{
        
    //JDBC driver y url
    private final String JDBC_Driver="com.mysql.cj.jdbc.Driver";
    //"org.postgresql.Driver"
    //com.mysql.jdbc.Driver //org.gjt.mm.mysql.Driver
    private final String url="jdbc:mysql://bcdowmndczbp2bqo00vl-mysql.services."
            + "clever-cloud.com:3306/bcdowmndczbp2bqo00vl";
    //bcdowmndczbp2bqo00vl-mysql.services.clever-cloud.com:3306/bcdowmndczbp2bqo00vl;
    
    //Credenciales
    private final String user="u2esulfbqc7a3v5d";
    private final String pass="I0BpDDIZsiYsb47d52Cd";

    private final String descripcion="CONECTADO A CLEVER CLOUD";
    
    @Override
    public Conexion crearConexion() {
        return new Conexion(JDBC_Driver, url, user, pass, descripcion);
    }
}
