/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import BD.AccesoBd;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Estudiantes
 */
@WebServlet(name = "Insertar", urlPatterns = {"/Insertar"})
public class Insertar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Usuario u = new Usuario();
        AccesoBd acBD = new AccesoBd();
        try {
           
            u.setNombre(request.getParameter("nombre"));
            u.setDocumento(request.getParameter("documento"));
            u.setCorreo(request.getParameter("correo"));
            u.setPassword(request.getParameter("contrasena"));
            u.setEstadio("Ninguno");
            
            acBD.insertarUsuario(u);
            
            ResultSet nuevo = acBD.getUsuarioBynombre(u.getNombre());  
            request.getSession().setAttribute("Usuario", nuevo);
            
            response.sendRedirect("registro.jsp");
            
           // response.sendRedirect("Inicio");
            
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(Insertar.class.getName()).log(Level.SEVERE, null, ex);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Inicio</title>"); 
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<link href='csscatalogo.css' rel='stylesheet' type='text/css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Su id es:</h1>" );              // mostrar el id
            out.println("<a href=\"index.jsp\" >Volver</a>");
            
           
            out.println("</body>");
            out.println("</html>");
        }finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
