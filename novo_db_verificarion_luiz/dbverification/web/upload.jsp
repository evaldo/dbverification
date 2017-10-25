<%-- 
    Document   : upload
    Created on : 22/10/2017, 15:08:26
    Author     : luiz.rodrigues
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="UploadFileServlet" method="post" enctype="multipart/form-data">
            <input type="file" name="uploadedFile" />
            <input type="submit" value="Upload"/>
        </form>
    </body>
</html>
