<%-- 
    Document   : nuevo
    Created on : 8/10/2021, 12:09:08 a. m.
    Author     : Nelson Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AsistHorarioCBA</title>
    </head>
    <body>
        <h2>Nuevo registro de instructor</h2>
        <form action= "InstructoresController?accion=insertar" method = "POST" autocomplete = "off">
            <p>
                Número de CC: 
                <input id = "numeroCC" name = "NumCC" type = "text" />
            </p>
            <p>
                Nombre: 
                <input id = "nombre" name = "nombre" type = "text" />
            </p>
            <p>
                Apellido: 
                <input id = "apellido" name = "apellido" type = "text" />
            </p>
            <p>
                Perfil: 
                <input id = "perfil" name = "perfil" type = "text" />
            </p>
            <button id = "guardar" name = "guardar" type = "submit">Guardar</button>
        </form>
    </body>
</html>
