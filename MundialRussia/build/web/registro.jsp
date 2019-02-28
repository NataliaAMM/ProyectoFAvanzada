<%-- 
    Document   : registro
    Created on : 18/05/2018
    Author     : Natica
--%>

<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ResultSet obtengoP = (ResultSet)session.getAttribute("Usuario"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='csscatalogo.css' rel='stylesheet' type='text/css'>
        <title>Registro</title>
    </head>
    <body>
        <img src="imagenes/russia.jpg" width="50%" > 
        <h1>Datos</h1>
        
        Recuerde su id y su contraseña para ingresar
        <table align="center" class="Estadios">
            <tr>
                <th>id</th><th>nombre</th><th>documento</th><th>correo</th><th>password</th><th>estadios</th>
            </tr>
            <%while (obtengoP.next()) {%>
            <tr>
                <td><%= obtengoP.getInt("id")%></td>
                <td><%= obtengoP.getString("nombre")%></td>
                <td><%= obtengoP.getString("documento")%></td>
                <td><%= obtengoP.getString("correo")%></td>
                <td><%= obtengoP.getString("password")%></td>
                <td><%= obtengoP.getString("Estadios")%></td>

            </tr>
            <% }%>

        </table>


        <br>
        <br>
        <form method="GET" action="Inicio">

            <button type="submit"> Volver </button> 
        </form>           
        <p>&copy; 2018 Mundial Russia 2018</p> 
    </body>
</html>
