<%--- 
    Document   : index
    Created on : May 28, 2018
    Author     : jorgito.
--%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='indexprueba.css' rel='stylesheet' type='text/css'>
        <title>Inicio</title>
        
    </head>

    <body >
        
     
         <img src="imagenes/russia.jpg" width="30%" >
        <center> <div class="n"><p>    
        <b><font color="#000000" face="georgia" size="4"><marquee width="400" scrollamount="5" bgcolor="#EBEDEF">La fiebre del mundial nos contagia: Bienvenidos a Rusia</marquee>    
         </font></b></p><center>
        
        <h1>
            Russia 2018
        </h1>   
        <br>
        <table align="center">
            <tr>
                <td>
                    <p>Iniciar Sesion</p>
                </td>
                <td>
                    <p>Registrarse</p>
                </td>
            </tr>
        </table>
        <table align="center">     
            <tr>
                <td>
                    <form name action="Sesion" method="GET">
                        <table align="center">
                            <tr>
                                <td>
                                    Usuario
                                </td> 

                                <td>
                                    <input type="text" name="id" id="id" required>
                                </td> 
                            </tr>
                            <tr>
                                <td>
                                    Contraseña
                                </td> 
                                <td>
                                    <input type="password" name="pass" id="pass" required>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <button type="submit">Entrar </button>
                                </td>
                            </tr>
                        </table> 
                    </form>    
                </td>    
                <td>
                    <form name="form2" action="Insertar" method="GET">
                        <table align="center">
                            <tr>
                                <td>
                                    Nombre
                                </td> 

                                <td>
                                    <input type="text" name="nombre" id="nombre" required>
                                </td> 
                            </tr>
                            <tr>
                                <td>
                                    Documento
                                </td> 
                                <td>
                                    <input type="text" name="documento" id="documento" required>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Correo
                                </td> 
                                <td>
                                    <input type="text" name="correo" id="correo" required>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Contraseña
                                </td> 
                                <td>
                                    <input type="password" name="contrasena" id="contrasena" required>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <button type="submit">Registro</button>
                                </td>
                            </tr>
                        </table>          
                    </form>
                </td>        
            </tr>
        </table> 
        
        <br><br>
        
       
        
        
    
        <p>&copy; 2018 Mundial Russia 2018</p> 

    </body>
</html>
