<%-- 
    Document   : index
    Created on : May 19, 2021, 7:50:11 PM
    Author     : henrry
--%>

<%@page import="dao.VentaDAO"%>
<%@page import="dao.BoletoDAO"%>
<%@page import="dao.PasajeroDAO"%>
<%@page import="dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

        <title>Bienvenido!</title>
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
/*
            if (UsuarioDAO.getSW() == 0 && PasajeroDAO.getSW() == 0 && BoletoDAO.getSW() == 0 && VentaDAO.getSW()== 0) {
                //cargar usuarios
                UsuarioDAO.llenar();
                PasajeroDAO.llenar();
                BoletoDAO.llenar();
                VentaDAO.llenar();
      
                //DocenteDAO.llenar();

                System.out.println("cantidad de usuarios=" + UsuarioDAO.obtenerDatos().size());
            }
            */
            

        %>
        
        <div class="container w-75 bg-primary mt-5 rounded shadow">
            <div class="row align-items-stretch">
                <div class="col bg d-none d-lg-block col-md-5 col-lg-5 col-xl-6 rounded">

                </div>
                <div class="col bg-white p-5 rounded-end">
                    <div class="text-end">
                        <img src="img/airplane-outline.svg" alt="airplane" width="48">
                    </div>
                    <h2 class="fw-bold text-center py-5">Bienvenido</h2>
                    <!-- LOGIN -->

                    <form action="ControladorLogin" method="POST">
                        <div class="mb-4">
                            <label for="usuario" class="form-label">Usuario</label>
                            <input type="text" class="form-control" name="usuario" id="">
                        </div>
                        <div class="mb-4">
                            <label for="password" class="form-label">Clave</label>
                            <input type="password" class="form-control" name="clave" id="">
                        </div>
                        
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary" name="opcion">Iniciar Sesión</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>


        
    </body>
</html>