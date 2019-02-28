<%-- 
    Document   : perfil
    Created on : May 28, 2018
    Author     : Estudiantes
--%>


<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ResultSet obtengoP = (ResultSet) session.getAttribute("cliente"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='csscatalogo.css' rel='stylesheet' type='text/css'>
        <title>Mi perfil</title>
    </head>
    <body>
         <img src="imagenes/russia.jpg" width="50%" > 
        <h1>Mi perfil</h1>

        <table align="center" class="Estadios">
            <tr>
                <th>ID</th><th>nombre</th><th>documento</th><th>correo</th><th>password</th><th>Estadios</th>
            </tr>
            <%while (obtengoP.next()) {%>
            <tr>
                <td><%= obtengoP.getInt("id")%></td>
                <td><%= obtengoP.getString("nombre")%></td>
                <td><%= obtengoP.getString("documento")%></td>
                <td><%= obtengoP.getString("correo")%></td>
                <td><%= obtengoP.getString("password")%></td>
                <td><%= obtengoP.getString("Estadios")%></td>
                    <% session.setAttribute("varia", obtengoP.getInt("id")); %>
                     <% session.setAttribute("name", obtengoP.getString("nombre")); %> 
            </tr>
            <% }%>

        </table>


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
