<%-- 
    Document   : asignar
    Created on : Mayo 28, 2018
    Author     : natica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <img src="imagenes/russia.jpg" width="50%" > 
        Asignacion de Estadio
        
        <form action="ActualizaU" method="get">
            
            Nombre del Estadio
            <input type="text" name="nuevoL"> 
            <br>
            <br>
            Su ID:
            <input type="text" name="nuevoID"> 
            <button type="submit"> Cambio </button> 
       </form>
        
        <p>&copy; 2018 Mundial Russia 2018</p> 
    </body>
</html>
