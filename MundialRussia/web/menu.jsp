<%-- 
    Document   : menu
    Created on : May 18, 2018
    Author     : jorgito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='cssmenu.css' rel='stylesheet' type='text/css'>
        <title>Menu</title>
    </head>
    
    <body>
        <img src="imagenes/russia.jpg" width="50%" > 
        <h1>Russia 2018</h1>
        <table align="center">
            <tr>
                <td>
                    <a href="catalogo.jsp" >Comprar boletas</a>
                </td>
                <td>
                    <img src="imagenes/boletas.jpg">
                </td>
            </tr>
            <tr>
                <td>
                    <a href="devoluciones.jsp" >Realizar Devoluciones</a>
                </td>
                <td>
                    <img src="imagenes/cancelar.jpg">
                </td>
            </tr>
            <tr>
                <td>
                    <a href="perfil.jsp" >Perfil de Usuario</a>
                </td>
                <td>
                    <img src="imagenes/perfil.png">
                </td>
            </tr>
        </table>


        <br>
        <br>
        <form method="GET" action="Cerrar">

            <button type="submit"> Cerrar sesión </button> 
        </form>   

        
    <p>&copy; 2018 Mundial Russia 2018</p> 
    </body>
</html>


