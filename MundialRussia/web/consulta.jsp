<%-- 
    Document   : consulta
    Created on : May 27, 2018
    Author     : santiaguito
---%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ResultSet logrado = (ResultSet)session.getAttribute("access"); %>
<a href="consulta.jsp"></a>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <img src="imagenes/banner.jpg" width="100%" > 
        <h1>Consulta </h1>
        
        <table>
            <tr>
                <th>codigo</th><th>nombre</th><th>documento</th><th>correo</th><th>contraseña</th>
            </tr>
                <%while (logrado.next()){ %>
                    <tr>
                        <td><%= logrado.getString("id") %></td>
                       
                        <td><%= logrado.getString("nombre") %></td>
                        <td><%= logrado.getString("documento") %></td>
                        <td><%= logrado.getString("correo") %></td>
                        <td><%= logrado.getString("password") %></td>
                        
                    </tr>
                <% }%>
               
                <tr>
            </tr>
        </table>
                
     <p>&copy; 2018 Mundial Russia 2018</p>  
    </body>
</html>
