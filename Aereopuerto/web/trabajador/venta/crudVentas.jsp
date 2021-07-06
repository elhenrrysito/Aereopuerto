<%-- 
    Document   : crudVentas
    Created on : 25-may-2021, 10:55:52
    Author     : henrr
--%>

<%@page import="dao.BoletoDAO"%>
<%@page import="modelo.Boleto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar venta</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    </head>
    <body>


        <!-- AGREGAR VENTA -->
        <div class="container mt-4 w-75">
            <table class="table rounded shadow table-hover align-items-stretch">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Numero Vuelo</th>
                        <th scope="col">Aereolinea</th>
                        <th scope="col">Fecha Vuelo</th>
                        <th scope="col">Hora Vuelo</th>
                        <th scope="col">Destino</th>
                        <th scope="col">Agregar Venta</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int contador = 1;
                        for (Boleto obj : BoletoDAO.obtenerDatos()) {
                            out.println("<tr>");
                            out.println("<th scope='row'>" + contador);
                            out.println("<td>" + obj.getNumeroVuelo());
                            out.println("<td>" + obj.getAereolinea());
                            out.println("<td>" + obj.getFechaVuelo());
                            out.println("<td>" + obj.getHoraVuelo());
                            out.println("<td>" + obj.getDestino());
                            out.println("<td><a href=../trabajador/venta/insertarVenta.jsp?numero_vuelo=" + obj.getNumeroVuelo() + " id='eliminar_vent'>Agregar venta</a></td>");
                            out.println("<tr>");
                            contador++;
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
