/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author nata2018
 */

import java.sql.*;

public class Conexion {

    static String base = "russia";     // nombre de la base de datos
    static String login = "root";
    static String password = "NATA2018";
    static String url = "jdbc:mysql://localhost/"+base;
    static String mensaje = "";
    
    Connection conectar = null;
    
    /**
     * Constructor de la clase
     */
    public Conexion() {
        try{
                    Class.forName("com.mysql.jdbc.Driver");
                conectar = DriverManager.getConnection(url,login,password);         // esto lo obtiene el getConexion del preparedStatement

                if (conectar!=null){
                        System.out.println("Conexión a base de datos "+base+" OK");
                }
        }catch(SQLException e){
                mensaje = e.getMessage();
        }catch(ClassNotFoundException e){
                mensaje = e.getMessage();
        }
    }

    public static String getMensaje() {
        return mensaje;
    }

    public static void setMensaje(String mensaje) {
        Conexion.mensaje = mensaje;
    }

    
    
    
    /**
     * Permite obtener la conexion para otras clases
     */
    
    public Connection getConectar() {
        return conectar;
    }
        
    /**
     * Desconecta la base de datos
     */
    
     public void desconectar(){
        conectar= null;
    }
    
}
