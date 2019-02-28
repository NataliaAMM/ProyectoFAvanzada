<%-- 
    Document   : devoluciones
    Created on : May 15, 2018
    Author     : jorgito
--%>

<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ResultSet obtengoC = (ResultSet)session.getAttribute("cliente"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='csscatalogo.css' rel='stylesheet' type='text/css'>
        <title>Devoluciones</title>
    </head>
    <body>
         <img src="imagenes/russia.jpg" width="50%" > 
         <table align="right" class="usuario">
            <tr>
                <th>Usuario</th> <th>Id</th> <th>Estadio</th>
            </tr>
            <%while (obtengoC.next()) {%>
            <tr>
                <td><%= obtengoC.getString("nombre")%></td>
                <td><%= obtengoC.getInt("id")%></td>
                <td><%= obtengoC.getString("Estadios")%></td>
                <% session.setAttribute("client", obtengoC.getInt("id")); %> 
            </tr>
            <% }%>
        </table>  
        
        
        
        <br>
        <br>
        <h1>¿esta seguro que quiere devolver su boleta que sale en la esquina sup derecha?</h1>
        
         <form method="GET" action="Devolucion">

            <button type="submit"> Si, devolver </button> 
        </form>   
        
        
        <br>
        <br>
        
      <form method="GET" action="Conector">

            <button type="submit"> Volver </button> 
        </form>           

        
        
        <br>
        <br>
         <form method="GET" action="Cerrar">

            <button type="submit"> Cerrar sesión </button> 
        </form>   
        <p>&copy; 2018 Mundial Russia 2018</p> 
    </body>
</html>
