<%-- 
    Document   : fin_sesion
    Created on : 29-04-2021, 20:29:09
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Fin sesión</title>
        <style>
            body {
                background: #ffe259;
                background: linear-gradient(to right, #ffa751, #ffe259);
            }

            .bg {
                background-image: url('img/airport.jpg');
                background-position: center center;
            }
        </style>
    </head>
    <body>
        <%
            HttpSession misession = (HttpSession) request.getSession();
            System.out.println("Sesión finalizada");
            misession.invalidate(); //borra todos los objetos de la sesión actual

        %>
        <div class="container w-75 bg-primary mt-5 rounded shadow">
            <div class="row align-items-stretch">
                <div class="col bg d-none d-lg-block col-md-5 col-lg-5 col-xl-6 rounded">

                </div>
                <div class="col bg-white p-5 rounded-end">
                    <div class="text-end">
                        <img src="img/airplane-outline.svg" alt="airplane" width="48">
                    </div>
                    <h2 class="fw-bold text-center py-5">Fin de la sesión</h2>
                    <!-- LOGIN -->

                    <div class="d-grid">
                        <a href="index.jsp" class="btn btn-primary">Ir al Login</a>
                    </div>

                </div>
            </div>
        </div>
        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>


    </body>
</html>
