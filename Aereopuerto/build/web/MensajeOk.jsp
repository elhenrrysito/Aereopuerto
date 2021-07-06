<%-- 
    Document   : MensajeOk
    Created on : May 22, 2021, 5:30:38 PM
    Author     : henrry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Bien!</title>
    </head>
    <body>
                <%
            String texto = request.getParameter("texto");
            String retorno = request.getParameter("retorno");
        %>
        
        

        <div class="container w-50 bg-white rounded shadow mt-4 mb-4">
            <div class="row align-items-stretch">
                <div class="col bg">
                    <div class="text-end">
                        <img src="img/bien.png" alt="usuario" width="64">
                    </div>
                    <div class="col-md-6">
                        <h1>Bien!</h1>
                        <h2><%=texto%></h2>
                    </div>  
                    <div class="col-md-12">
                        <a href=<%=retorno%> class="btn btn-primary offset-3 w-50">Volver</a>
                    </div>  
                </div>
            </div>
        </div>
    </body>
</html>
