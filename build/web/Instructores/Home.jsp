<%-- 
    Document   : Home
    Created on : 8/10/2021, 12:08:40 a. m.
    Author     : Nelson Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AsistHorarioCBA</title>
    </head>
    <body>
        <h1>Instructores</h1>
        
        <a href="InstructoresController?accion=nuevo">Agregar instructor</a>
        <br /><br />
        <table border = "1" width = "80%">
            <thead>
                <tr>
                    <th>NUMERO CC</th>
                    <th>NOMBRE</th>
                    <th>APELLIDOS</th>
                    <th>PERFIL</th>
                    <th></th>
                    <th></th>
                </tr>
            <tbody>
                <c:forEach var = "instructor" items = "${lista}">
                    <tr>
                        <td><c:out value = "${instructor.num}"/></td>
                        <td><c:out value = "${instructor.nombre}"/></td>
                        <td><c:out value = "${instructor.apellido}"/></td>
                        <td><c:out value = "${instructor.perfil}"/></td>
                        <td><a href="InstructoresController?accion=modificar&id=<c:out value = "${instructor.id}"/>">Modificar</a></td>
                        
                        <td><a href="InstructoresController?accion=eliminar&id=<c:out value = "${instructor.id}"/>">Eliminar</a></td>
                        
                    </tr>
                </c:forEach>
            </tbody>
            </thead>
        
            
        </table>
    </body>
</html>
