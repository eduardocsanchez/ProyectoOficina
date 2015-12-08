<%-- 
    Document   : registration
    Created on : 8/12/2015, 01:19:24 PM
    Author     : Eduardo
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Oficina Registration Form</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Oficina Form</h2>
  
    <form:form method="POST" modelAttribute="oficina">
        <form:input type="hidden" path="idcontacto" id="idcontacto"/>
        <table>
            <tr>
                <td><label for="nombre_contacto">Nombre: </label> </td>
                <td><form:input path="nombre_contacto" id="nombre_contacto"/></td>
                <td><form:errors path="nombre_contacto" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="fecha_dealta">Fecha de Alta: </label> </td>
                <td><form:input path="fecha_dealta" id="fecha_dealta"/></td>
                <td><form:errors path="fecha_dealta" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="correo_oficina">Correo: </label> </td>
                <td><form:input path="correo_oficina" id="correo_oficina"/></td>
                <td><form:errors path="correo_oficina" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="direcion">Direccion </label> </td>
                <td><form:input path="direcion" id="direcion"/></td>
                <td><form:errors path="direcion" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="tel_oficina">Telefono </label> </td>
                <td><form:input path="tel_oficina" id="tel_oficina"/></td>
                <td><form:errors path="tel_oficina" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Actualizar"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Registrar"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/list' />">List of All Oficinas</a>
</body>
</html>