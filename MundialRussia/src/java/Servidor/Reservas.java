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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Estudiantes
 */
@WebServlet(name = "Reservas", urlPatterns = {"/Reservas"})
public class Reservas extends HttpServlet {

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
        AccesoBd u = new AccesoBd();
        try  {
            HttpSession miSesion= request.getSession();    // Recupero los datos del Jsp que obtuve con session.setAttribute
           
            int cc = (int) miSesion.getAttribute("mio");  // mismo nombre que el dato del jsp
            
            ResultSet usuario = u.getUsuarioById(cc);
            
            request.getSession().setAttribute("reservo", usuario); 
            
            String nuevo = request.getParameter("Reserva");
            
            Usuario usu = new Usuario();
            usu.setEstadio(nuevo);
            usu.setId(cc);
            u.actualizarEstadio(usu);
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Inicio</title>"); 
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<link href='csscatalogo.css' rel='stylesheet' type='text/css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Reserva exitosa. Su cuenta se cerrara por seguridad.</h1>");
            out.println("<a href=\"index.jsp\" >Continuar</a>");
            out.println("</body>");
            out.println("</html>");
            
            //response.sendRedirect("index.jsp");
            
        }
        catch (SQLException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        }        finally{
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
