<%-- 
    Document   : selecao
    Created on : 27/06/2017, 19:46:11
    Author     : alunoces
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Seleção de Arquivos</h1>
        <form action="resultado" enctype="multipart/form-data" method="POST" >
            Selecione o arquivo: <input type="file" name="arquivo"><p>
                
            Selecione a estrutura: <select name="est">
                <c:forEach var="k" items="${est}">
                    <option>${k}</option>
                     
                    </c:forEach>  
                
                
            </select>
            
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
