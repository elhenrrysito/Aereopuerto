<%-- 
    Document   : Modificar
    Created on : May 22, 2021, 6:03:36 PM
    Author     : henrry
--%>

<%@page import="dao.UsuarioDAO"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            String rut = request.getParameter("rut");
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.buscar(rut);
        %>
        <div class="container w-50 bg-white rounded shadow">
            <div class="row align-items-stretch">
                <div class="col bg">
                    <div class="text-end">
                        <img src="../../img/users2.png" alt="airplane" width="64">
                    </div>
                    <h1 class="text-center mb-4">Modificar Usuario</h1>
                    <form class="row g-3" action="../../ControladorUsuario" method="POST">
                        <div class="col-md-6">
                            <label for="rut" class="form-label">RUT</label>
                            <input type="text" class="form-control" name="rut" value="<%=usuario.getRut()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="nombre" value="<%=usuario.getNombre()%>" id="nombre">
                        </div>
                        <div class="col-md-6">
                            <label for="ap_paterno" class="form-label">Apellido Paterno</label>
                            <input type="text" class="form-control" value="<%=usuario.getApellidoPaterno()%>" name="apellido_paterno">
                        </div>
                        <div class="col-md-6">
                            <label for="apellido_materno" class="form-label">Apellido Materno</label>
                            <input type="text" class="form-control" value="<%=usuario.getApellidoMaterno()%>" name="apellido_materno" id="apellido_materno">
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
                            <input type="text" class="form-control" name="username" value="<%=usuario.getUsername()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" name="password" id="password" value="<%=usuario.getPassword()%>">
                        </div>
                        <div class="col-6 mb-4">
                            <button type="submit" name="opcion" value="Actualizar" class="btn btn-primary offset-3 w-50">Modificar</button>
                        </div>
                        <div class="col-6 mb-4">
                            <a href="javascript: history.go(-1)" class="btn btn-primary w-50 go-back">Volver</a>
                        </div>
                        
                    </form>
                        
                </div>
            </div>
        </div>
    </body>
</html>
