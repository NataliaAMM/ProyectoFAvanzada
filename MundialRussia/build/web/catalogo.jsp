<%-- 
    Document   : catalogo
    Created on : May 19, 2018
    Author     : santiaguito
--%>

<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ResultSet obtengoC = (ResultSet)session.getAttribute("cliente"); %>
<% ResultSet obtengoL = (ResultSet)session.getAttribute("Boleteria"); %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='csscatalogo.css' rel='stylesheet' type='text/css'>
        <title>Catalogo</title>
    </head>
    <body>
        <img src="imagenes/russia.jpg" width="50%" > 
        <table align="center" class="usuario">
            <tr>
                <th>Usuario</th> <th>ID</th>
            </tr>
                <%while (obtengoC.next()){ %>
                    <tr>
                        <td><%= obtengoC.getString("nombre") %></td>
                        <% session.setAttribute("user", obtengoC.getString("nombre")); %>          
                    
                    <td><%= obtengoC.getInt("id") %></td>
                     <% session.setAttribute("mio", obtengoC.getInt("id")); %> 
            </tr>
            <% }%>
        </table>  
        <br>        
        
        <h1>Catalogo</h1>
        <table>
            <div>
                <iframe src="//graphics.afpforum.com/builds/20171215-fifa2018-stadiums/#/es/luzhniki" 
                    width="100%" height="960" frameborder="no"></iframe>
            </div>
        </table>
        <br><br>
       <form method="GET" action="Reservas">
            <table align="center" class="Estadios">
                
                <tr>
                    <th>ID</th><th>nombre</th><th>ciudad</th><th>capacidad</th>

                </tr>
                    <%while (obtengoL.next()){ %>
                        <tr>

                            <td><%= obtengoL.getInt("id") %></td>
                            <td><%= obtengoL.getString("nombre") %></td>
                            <td><%= obtengoL.getString("ciudad") %></td>
                            <td><%= obtengoL.getString("capacidad") %></td>
                           
                            <td><button name="Reserva" value="<%= obtengoL.getString("nombre") %>" type="submit">Reserva </button></td>

                        </tr>
                    <% }%>

                    <tr>
                </tr>
            </table>
        </form>        
                
                  <br>
        <br>
     
         <form method="GET" action="Conector">

            <button type="submit"> Volver </button> 
        </form>           
            
        <p>&copy; 2018 Mundial Russia 2018</p> 
    </body>
</html>

