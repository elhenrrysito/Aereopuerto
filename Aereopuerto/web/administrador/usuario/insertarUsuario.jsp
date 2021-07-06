<%-- 
    Document   : agregarUsuario
    Created on : May 22, 2021, 7:59:51 PM
    Author     : henrry
--%>

<%@page import="dao.UsuarioDAO"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <!--<script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script> -->
    </head>
    <body>
        <!-- AGREGAR USUARIO -->
        <div class="container w-50 bg-white rounded shadow mt-4 mb-4">
            <div class="row align-items-stretch">
                <div class="col bg">
                    <div class="text-end">
                        <img src="../img/users2.png" alt="airplane" width="64">
                    </div>
                    <h1 class="text-center mb-4">Insertar Usuario</h1>
                    <form class="row g-3" action="../ControladorUsuario" method="POST">
                        <div class="col-md-6">
                            <label for="rut" class="form-label">RUT</label>
                            <input type="text" class="form-control" name="rut">
                        </div>
                        <div class="col-md-6">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="nombre" id="nombre">
                        </div>
                        <div class="col-md-6">
                            <label for="ap_paterno" class="form-label">Apellido Paterno</label>
                            <input type="text" class="form-control" name="apellido_paterno">
                        </div>
                        <div class="col-md-6">
                            <label for="apellido_materno" class="form-label">Apellido Materno</label>
                            <input type="text" class="form-control" name="apellido_materno" id="apellido_materno">
                        </div>
                        <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                            <input type="radio" class="btn-check" name="tipo_usuario" value="1" id="btnradio1" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio1">Administrador</label>

                            <input type="radio" class="btn-check" name="tipo_usuario" value="2" id="btnradio2" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio2">Trabajador</label>

                            <input type="radio" class="btn-check" name="tipo_usuario" value="3" id="btnradio3" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio3">Secretaria</label>
                        </div>
                        <div class="col-md-6">
                            <label for="username" class="form-label">Username</label>
                            <input type="text" class="form-control" name="username">
                        </div>
                        <div class="col-md-6">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" name="password" id="password">
                        </div>
                        <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                            <input type="radio" class="btn-check" name="estado" value="1" id="btnradio4" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio4">Activo</label>

                            <input type="radio" class="btn-check" name="estado" value="2" id="btnradio5" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio5">Inactivo</label>

                            <input type="radio" class="btn-check" name="estado" value="3" id="btnradio6" autocomplete="off">
                            <label class="btn btn-outline-primary" for="btnradio6">Eliminado</label>
                        </div>
                        <div class="col-12 mb-4">
                            <button type="submit" name="opcion" value="Grabar" class="btn btn-primary offset-3 w-50">Añadir</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script> -->
    </body>
</html>
