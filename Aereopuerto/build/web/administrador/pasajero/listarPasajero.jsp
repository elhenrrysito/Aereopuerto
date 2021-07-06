<%-- 
    Document   : listarPasajero
    Created on : 26-may-2021, 19:16:24
    Author     : henrr
--%>

<%@page import="dao.PasajeroDAO"%>
<%@page import="modelo.Pasajero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
       <div class="container mt-4 w-75">
            <table class="table rounded shadow table-hover align-items-stretch">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Pasaporte</th>
                        <th scope="col">Nacionalidad</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido Paterno</th>
                        <th scope="col">Apellido Materno</th>
                        <th scope="col">Correo</th>
                        <th scope="col">Telefono</th>
                        <th scope="col">Eliminar</th>
                        <th scope="col">Modificar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int contador = 1;
                        PasajeroDAO pasajeroDAO = new PasajeroDAO();
                        for (Pasajero obj : pasajeroDAO.listarPasajero()) {
                            out.println("<tr>");
                            out.println("<th scope='row'>" + contador);
                            out.println("<td>" + obj.getPasaporte());
                            out.println("<td>" + obj.getNacionalidad());
                            out.println("<td>" + obj.getNombre());
                            out.println("<td>" + obj.getApellidoPaterno());
                            out.println("<td>" + obj.getApellidoMaterno());
                            out.println("<td>" + obj.getCorreo());
                            out.println("<td>" + obj.getTelefono());
                            out.println("<td><a href=../administrador/pasajero/EliminarPasajero.jsp?pasaporte_pasajero=" + obj.getPasaporte()+ " id='eliminar_pasajero'>Eliminar</a></td>");
                            out.println("<td><a href=../administrador/pasajero/ModificarPasajero.jsp?pasaporte_pasajero=" + obj.getPasaporte()+ " id='modificar_pasajero'>Modificar</a></td>");
                            out.println("<tr>");
                            contador++;
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
