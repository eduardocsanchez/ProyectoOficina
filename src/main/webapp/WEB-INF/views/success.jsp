<%-- 
    Document   : success
    Created on : 8/12/2015, 01:23:58 PM
    Author     : Eduardo
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Confirmation Page</title>
</head>
<body>
    message : ${success}
    <br/>
    <br/>
    Go back to <a href="<c:url value='/list' />">List of All Oficinas</a>
     
</body>
 
</html>