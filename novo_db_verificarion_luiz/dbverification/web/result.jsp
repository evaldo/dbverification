<%-- 
    Document   : upload
    Created on : 22/10/2017, 15:08:26
    Author     : luiz.rodrigues
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <th>
                    <td><b>Invalid Object:</b></td>
                    <td><b>Problematic Word:</b></td>
                    <td><b>Type:</b></td>
                </th>
            </thead>
            <tbody>
                <c:forEach items="${invalidObjects}" var="invalidObject">
                 <tr>
                   <td>${invalidObject.getObjectName()}</td>
                   <td>${invalidObject.getWrongWord()}</td>
                   <td>${invalidObject.getObjectInstanceType()}</td>
                 </tr>
                </c:forEach>
             </tbody>
        </table>
    </body>
</html>
