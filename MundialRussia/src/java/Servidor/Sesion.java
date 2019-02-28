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
@WebServlet(name = "Sesion", urlPatterns = {"/Sesion"})
public class Sesion extends HttpServlet {

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
        out.println("<title>Servlet Registro</title>");

        AccesoBd sesion = new AccesoBd();
        Usuario i = new Usuario();
        int num=0;
        int bien = 0;
        try {
            String campo1 = request.getParameter("id");
            String campo2 = request.getParameter("pass");
            try{
                num = Integer.parseInt(campo1);
            }catch(NumberFormatException exp){
                bien=2;
            }
            
            i.setId(num);
            i.setPassword(campo2);
            try {
                ResultSet comprueba = sesion.iniciaSesion(i);   // Validacion de ID y Pass
                ResultSet comprueba2 = sesion.getEstadios();      // Obtengo la DB de los estadios
                while (comprueba.next()) {

                    if (comprueba.getInt("id") == num && comprueba.getString("password").equals(campo2)) {
                        ResultSet usuario = sesion.getUsuarioById(num);
                        request.getSession().setAttribute("cliente", usuario);
                        request.getSession().setAttribute("Boleteria", comprueba2);
                        response.sendRedirect("menu.jsp");
                        bien = 1;
                        
                    } 
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
            }

            // ACA SE MANEJA EL ERROR
            if (bien == 0) {                            
             
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Inicio</title>"); 
                out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
                out.println("<link href='csscatalogo.css' rel='stylesheet' type='text/css'>");
                out.println("</head>");
                out.println("<body>");
                out.println(" <img src=\"error.png\"> ");
                out.println("<h1>El Id de usuario o la contraseña son incorrectos, por favor revise.</h1>");
                out.println("<a href=\"index.jsp\" >Volver</a>");
            
           
            out.println("</body>");
            out.println("</html>");
             

            }
            if(bien==2){
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Inicio</title>"); 
                out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
                out.println("<link href='csscatalogo.css' rel='stylesheet' type='text/css'>");
                out.println("</head>");
                out.println("<body>");         
                out.println(" <img src=\"error.png\"> ");
                out.println("<h1>El ID de usuario debe ser un numero que la plataforma le proporciono.</h1>");
                out.println("<a href=\"index.jsp\" >Volver</a>");
            
           
                out.println("</body>");
                out.println("</html>");
            }

        }  finally {
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
