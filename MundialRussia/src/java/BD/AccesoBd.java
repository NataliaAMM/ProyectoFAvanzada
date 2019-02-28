/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Logica.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @Estudiantes
 */
public class AccesoBd {

    Conexion cn;

    public AccesoBd() {

        cn = new Conexion();

    }

    /**
     * Muestra dato en especifico de la DB
     */
    public ResultSet getUsuarioById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConectar().prepareStatement("SELECT id, "
                + " nombre, "
                + " documento, "
                + " correo, "
                + " password, "
                + " Estadios "
                + " FROM Usuario "
                + " WHERE id = ? ");
        pstm.setInt(1, id);

        ResultSet respuesta = pstm.executeQuery();

        return respuesta;
    }
    
    
    public ResultSet getUsuarioBynombre(String nombre) throws SQLException {
        PreparedStatement pstm = cn.getConectar().prepareStatement("SELECT id, "
                + " nombre, "
                + " documento, "
                + " correo, "
                + " password, "
                + " Estadios "
                + " FROM Usuario "
                + " WHERE nombre = ? ");
        pstm.setString(1, nombre);

        ResultSet respuesta = pstm.executeQuery();

        return respuesta;
    }

        /**
     * Muestra los usuarios de la DB
     */
    public ResultSet getUsuarios() throws SQLException {
        PreparedStatement pstm = cn.getConectar().prepareStatement("SELECT id, "
                + " nombre, "
                + " documento,"
                + " correo,"
                + " password,"
                + " Estadios"
                + " FROM Usuario "
                + " ORDER BY id ");

        ResultSet respuesta = pstm.executeQuery();
        return respuesta;
    }

    /**
     * verifica inicio de sesion de la DB
     */
    public ResultSet iniciaSesion(Usuario u) throws SQLException {
        PreparedStatement pstm = cn.getConectar().prepareStatement("SELECT id, "
                + " nombre, "
                + " documento,"
                + " correo,"
                + " password,"
                + " Estadios"
                + " FROM Usuario "
                + " WHERE id = ? and password = ? ");
        pstm.setInt(1, u.getId());
        pstm.setString(2, u.getPassword());

        ResultSet respuesta = pstm.executeQuery();
        return respuesta;
    }

    public void insertarUsuario(Usuario u) {
        try {
            PreparedStatement pstm = cn.getConectar().prepareStatement("insert into Usuario (nombre, "
                    + " documento,"
                    + " correo,"
                    + " password,"
                    + " Estadios) "
                    + " values(?,?,?,?,?)");
            pstm.setString(1, u.getNombre());
            pstm.setString(2, u.getDocumento());
            pstm.setString(3, u.getCorreo());
            pstm.setString(4, u.getPassword());
            pstm.setString(5, u.getEstadio());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void actualizarEstadio(Usuario u) {
        try {
            PreparedStatement pstm = cn.getConectar().prepareStatement("UPDATE Usuario set Estadios = ? "
                    + "WHERE id = ?");

            pstm.setString(1, u.getEstadio());
            pstm.setInt(2, u.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    /**
     * Muestra los estadios de la DB
     */
    public ResultSet getEstadios() throws SQLException {
        PreparedStatement pstm = cn.getConectar().prepareStatement("SELECT id, "
                + " nombre, "
                + " ciudad,"
                + " capacidad"
                + " FROM Estadio "
                + " ORDER BY id");

        ResultSet respuesta = pstm.executeQuery();
        return respuesta;
    }
    
    
     public ResultSet getEstadiosById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConectar().prepareStatement("SELECT id, "
                + " nombre, "
                + " ciudad,"
                + " capacidad"
                + " FROM Estadio "
                + " WHERE id = ? ");
        pstm.setInt(1, id);

        ResultSet respuesta = pstm.executeQuery();

        return respuesta;
      
    }
     
     
    public String getMensaje() {
        return cn.getMensaje();
    }
}
