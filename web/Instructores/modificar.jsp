<%-- 
    Document   : modificar
    Created on : 8/10/2021, 12:09:29 a. m.
    Author     : Nelson Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Modificar registro de instructor</h2>
        <form action= "InstructorController?accion=actualizar" method = "POST" autocomplete = "off">
            <input id = "id" name = "id" type = "hidden" value = "<c:out value = "${instructor.id}"/>"/>
            <p>
                Numero de CC: 
                <input id = "num" name = "num" type = "text" value = "<c:out value = "${instructor.num}"/>"/>
            </p>
            <p>
                Nombre: 
                <input id = "nombre" name = "nombre" type = "text" value = "<c:out value = "${instructor.nombre}"/>"/>
            </p>
            <p>
                Apellido: 
                <input id = "apellido" name = "apellido" type = "text" value = "<c:out value = "${instructor.apellido}"/>"/>
            </p>
            <p>
                Perfil: 
                <input id = "perfil" name = "perfil" type = "text" value = "<c:out value = "${instructor.perfil}"/>"/>
            </p>
            <button id = "guardar" name = "guardar" type = "submit">Guardar</button>
        </form>
    </body>
</html>
