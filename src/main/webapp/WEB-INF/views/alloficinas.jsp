<%-- 
    Document   : alloficinas
    Created on : 8/12/2015, 01:16:44 PM
    Author     : Eduardo
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Oficinas Enrollments</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Oficinas</h2>  
    <table>
        <tr>
            <td>NOMBRE</td>
            <td>CORREO</td>
            <td>FECHA DE ALTA</td>
            <td>DIRECCION</td>
            <td>TELEFONO</td>
            <td colspan="2">Opciones</td>
        </tr>
        <c:forEach items="${oficinas}" var="oficina">
            <tr>
            <td>${oficina.nombre_contacto}</td>
            <td>${oficina.correo_oficina}</td>
            <td>${oficina.fecha_dealta}</td>
            <td>${oficina.direcion}</td>
            <td>${oficina.tel_oficina}</td>
            <td><a href="<c:url value='/edit-${oficina.idcontacto}-oficina' />">${oficina.idcontacto}</a></td>
            <td><a href="<c:url value='/delete-${oficina.idcontacto}-oficina' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Add New Oficina</a>
</body>
</html>
