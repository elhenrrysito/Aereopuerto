<%-- 
    Document   : crud_usuario
    Created on : May 21, 2021, 8:52:45 PM
    Author     : henrry
--%>

<%@page import="dao.UsuarioDAO"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuarios</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="js/script.js"></script>
    </head>
    <body>
        

        <!-- LISTAR USUARIOS --->
        <div class="container mt-4 w-75">
            <table class="table rounded shadow table-hover align-items-stretch">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">RUT</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido Paterno</th>
                        <th scope="col">Apellido Materno</th>
                        <th scope="col">Tipo Usuario</th>
                        <th scope="col">Username</th>
                        <th scope="col">Password</th>
                        <th scope="col">Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int contador = 1;
                        for (Usuario obj : UsuarioDAO.obtenerDatos()) {
                            out.println("<tr>");
                            out.println("<th scope='row'>" + contador);
                            out.println("<td>" + obj.getRut());
                            out.println("<td>" + obj.getNombre());
                            out.println("<td>" + obj.getApellidoPaterno());
                            out.println("<td>" + obj.getApellidoMaterno());
                            out.println("<td>" + obj.getTipoUsuario());
                            out.println("<td>" + obj.getUsername());
                            out.println("<td>" + obj.getPassword());
                            out.println("<td>" + obj.getEstado());
                            out.println("<a href=Eliminar.jsp?rut=" + obj.getRut() + " class='eliminar'>Eliminar</a>");
                            out.println("<a href=Modificar.jsp?rut=" + obj.getRut() + " class='modificar'>Modificar</a>");
                            out.println("<tr>");
                            contador++;
                        }
                    %>
                </tbody>
            </table>
        </div>
                
        



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    </body>
</html>
