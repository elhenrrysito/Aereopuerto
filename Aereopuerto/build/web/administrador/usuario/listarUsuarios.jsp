<%-- 
    Document   : listarUsuarios
    Created on : 26-may-2021, 19:17:02
    Author     : henrr
--%>
<%@page import="modelo.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuarios</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    </head>
    <body>
        
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
                        <th scope="col">Eliminar</th>
                        <th scope="col">Modificar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int contador = 1;
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        for (Usuario obj : usuarioDAO.obtenerDatos()) {
                            out.println("<tr>");
                            out.println("<th scope='row'>" + contador);
                            out.println("<td>" + obj.getRut());
                            out.println("<td>" + obj.getNombre());
                            out.println("<td>" + obj.getApellidoPaterno());
                            out.println("<td>" + obj.getApellidoMaterno());
                            out.println("<td>" + obj.getTipoUsuario());
                            out.println("<td>" + obj.getUsername());
                            out.println("<td>" + obj.getPassword());
                            out.println("<td><a href=../administrador/usuario/EliminarUsuario.jsp?rut=" + obj.getRut() + " id='eliminar_usuario'>Eliminar</a></td>");
                            out.println("<td><a href=../administrador/usuario/ModificarUsuario.jsp?rut=" + obj.getRut() + " id='modificar_usuario'>Modificar</a></td>");
                            out.println("<tr>");
                            contador++;
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
