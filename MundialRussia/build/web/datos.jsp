<%-- 
    Document   : datos
    Created on : May 6, 2018
    Author     : natica
--%>

<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ResultSet obtengoU = (ResultSet)session.getAttribute("actual"); %>
<% ResultSet obtengoT = (ResultSet)session.getAttribute("tex"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BD</title>
    </head>
    <body>
         <img src="imagenes/russia.jpg" width="50%" > 
        <h1>Usuarios</h1>
        <table>
            <tr>
                <th>ID</th><th>nombre</th><th>documento</th><th>correo</th><th>password</th><th>estadios</th>
            </tr>
                <%while (obtengoU.next()){ %>
                    <tr>
                        <td><%= obtengoU.getString("id") %></td>
                        <td><%= obtengoU.getString("nombre") %></td>
                        <td><%= obtengoU.getString("documento") %></td>
                        <td><%= obtengoU.getString("correo") %></td>
                        <td><%= obtengoU.getString("password") %></td>
                        <td><%= obtengoU.getString("Estadios") %></td>
                        
                    </tr>
                <% }%>
               
                <tr>
            </tr>
        </table>
                
                <br>
                <br>
        <h1>Estadios</h1>
        <table>
            <tr>
                <th>ID</th><th>nombre</th><th>ciudad</th><th>capacidad</th>
            </tr>
                <%while (obtengoT.next()){ %>
                    <tr>
                        <td><%= obtengoT.getString("id") %></td>
                        <td><%= obtengoT.getString("nombre") %></td>
                        <td><%= obtengoT.getString("ciudad") %></td>
                        <td><%= obtengoT.getString("capacidad") %></td>
                    </tr>
                <% }%>
               
                <tr>
            </tr>
        </table>    
        <p>&copy; 2018 Mundial Russia 2018</p> 
    </body>
</html>
