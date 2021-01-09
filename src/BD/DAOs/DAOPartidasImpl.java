/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD.DAOs;

import BD.ConexionesBuilder.BuilderConexion;
import BD.ConexionesBuilder.BuilderConexionCleverCloud;
import BD.ConexionesBuilder.Conexion;
import Modelo.Partida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class DAOPartidasImpl implements IPartidasDAO {
    BuilderConexion builder = new BuilderConexionCleverCloud();
    Conexion conexion = builder.crearConexion();
    
    //Connection con = conexion.getConnection();//enlace dinamico?? // probando //FALLO
    //PORQUE? PQ es un atributo, y no lo actualizaba; perecita actualizar metodo get nomas
//    
//    public void registrar(Partida partida) throws Exception{
//        String sql ="INSERT INTO Partida VALUES(?,?,?,?)";
//        try {
//            this.conexion.conectar();
//            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);//Codigo sql
//            st.setString(1, usuario.getIdUsuario());//replace ? con el item, segun el indice 1
//            st.setString(2, usuario.getNombreCuenta());// replace ? número 2 con el nombre
//            st.setString(3, usuario.getContraseña());
//            st.setString(4, usuario.getTipoCuenta());
//            st.executeUpdate();//Ejectura codigo sql cuando este tiene parametros
//            
//        } catch (Exception e) {
//            System.out.println("error");
//            System.out.println(e.getMessage());
//        } finally{
//            this.conexion.cerrar();
//        }
//    }
    
//    @Override
//    public void registrar(Usuario usuario) throws Exception{
//        String sql ="INSERT INTO Usuarios VALUES(?,?,?,?)";
//        try {
//            this.conexion.conectar();
//            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);//Codigo sql
//            st.setString(1, usuario.getIdUsuario());//replace ? con el item, segun el indice 1
//            st.setString(2, usuario.getNombreCuenta());// replace ? número 2 con el nombre
//            st.setString(3, usuario.getContraseña());
//            st.setString(4, usuario.getTipoCuenta());
//            st.executeUpdate();//Ejectura codigo sql cuando este tiene parametros
//            
//        } catch (Exception e) {
//            System.out.println("error");
//            System.out.println(e.getMessage());
//        } finally{
//            this.conexion.cerrar();
//        }
//    }
//
//    @Override
//    public List<Usuario> listar() throws Exception{
//        String sql ="SELECT * FROM Usuarios";
//        List<Usuario> lista =null;
//        try {
//            this.conexion.conectar();
//            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);
//            
//            lista = new ArrayList();
//            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
//            
//            while (rs.next()) {
//                Usuario usuario = new Usuario();
//                usuario.setIdUsuario(rs.getString("idUsuario"));//parametro del nombre de la columna en la bd
//                usuario.setNombreCuenta(rs.getString("nombreCuenta"));
//                usuario.setContraseña(rs.getString("contraseña"));
//                usuario.setTipoCuenta(rs.getString("tipoCuenta"));
//                lista.add(usuario);
//            }
//            rs.close();
//            st.close();
//            
//            
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally{
//            this.conexion.cerrar();
//        }
//        
//        return lista;
//    }
//
//    @Override
//    public void actualizar(Usuario usuario) throws Exception{
//        String sql ="UPDATE Usuarios set nombreCuenta=?, contraseña=?,tipoCuenta=? where idUsuario=? ";
//        try {
//            this.conexion.conectar();
//            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);
//            st.setString(1, usuario.getNombreCuenta());
//            st.setString(2, usuario.getContraseña());
//            st.setString(3, usuario.getTipoCuenta());
//            st.setString(4, usuario.getIdUsuario());
//            
//            st.executeUpdate();
//            
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally{
//            this.conexion.cerrar();
//        }
//    }
//
//    @Override
//    public void eliminar(Usuario usuario) throws Exception{
//        String sql ="DELETE FROM Usuarios WHERE idUsuario=?";
//        try {
//            this.conexion.conectar();
//            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);
//            st.setString(1, usuario.getIdUsuario());
//            st.executeUpdate();
//            
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally{
//            this.conexion.cerrar();
//        }
//    }
//
//    @Override
//    public Usuario buscarUsuario(String idUsuario) throws Exception {
//        
//        Usuario usuario = new Usuario();
//        
//        String sql ="SELECT * FROM Usuarios WHERE idUsuario = ?";
//        try {
//            this.conexion.conectar();
//            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);
//            st.setString(1, idUsuario);
//            
//            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
//            while (rs.next()) {
//                usuario.setIdUsuario(rs.getString("idUsuario"));
//                usuario.setNombreCuenta(rs.getString("nombreCuenta"));
//                usuario.setContraseña(rs.getString("contraseña"));
//                usuario.setTipoCuenta(rs.getString("tipoCuenta"));
//            }
//            
//            rs.close();
//            st.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally{
//            this.conexion.cerrar();
//        }
//        
//        return usuario;
//    }
//    
//    @Override
//    public String buscarID(Usuario user) throws Exception {
//        
//        Usuario usuario = new Usuario();
//        
//        String sql ="SELECT * FROM Usuarios WHERE nombreCuenta=? AND contraseña=?";
//        try {
//            this.conexion.conectar();
//            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);
//            st.setString(1, user.getNombreCuenta());
//            st.setString(2, user.getContraseña());
//            
//            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO?
//            while (rs.next()) {
//                usuario.setIdUsuario(rs.getString("idUsuario"));
//                usuario.setNombreCuenta(rs.getString("nombreCuenta"));
//                usuario.setContraseña(rs.getString("contraseña"));
//                usuario.setTipoCuenta(rs.getString("tipoCuenta"));
//            }
//            
//            rs.close();
//            st.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally{
//            this.conexion.cerrar();
//        }
//        
//        if (usuario!=new Usuario()) {
//            return usuario.getIdUsuario();
//        }else{
//            return null;
//        }
//        
//    }
}
