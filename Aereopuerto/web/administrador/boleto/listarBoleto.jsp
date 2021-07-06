<%-- 
    Document   : listarBoletos
    Created on : 27-may-2021, 11:22:30
    Author     : henrr
--%>

<%@page import="dao.BoletoDAO"%>
<%@page import="modelo.Boleto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Listar Boletos</title>
    </head>
    <body>
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
                        <th scope="col">Precio</th>
                        <th scope="col">Eliminar</th>
                        <th scope="col">Modificar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int contador = 1;
                        BoletoDAO boletoDAO = new BoletoDAO();
                        for (Boleto obj : boletoDAO.listarBoletos()) {
                            out.println("<tr>");
                            out.println("<th scope='row'>" + contador);
                            out.println("<td>" + obj.getNumeroVuelo());
                            out.println("<td>" + obj.getAereolinea());
                            out.println("<td>" + obj.getFechaVuelo());
                            out.println("<td>" + obj.getHoraVuelo());
                            out.println("<td>" + obj.getDestino());
                            out.println("<td> $" + obj.getPrecio());
                            out.println("<td><a href=../administrador/boleto/eliminarBoleto.jsp?id_boleto=" + obj.getId()+ " id='eliminar_pasajero'>Eliminar</a></td>");
                            out.println("<td><a href=../administrador/boleto/modificarBoleto.jsp?id_boleto=" + obj.getId()+ " id='modificar_pasajero'>Modificar</a></td>");
                            out.println("<tr>");
                            contador++;
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
