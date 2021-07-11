<%-- 
    Document   : listarVenta
    Created on : 27-may-2021, 21:28:17
    Author     : henrr
--%>

<%@page import="dao.VentaDAO"%>
<%@page import="modelo.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Listar Ventas</title>
    </head>
    <body>
        <div class="container mt-4 w-75">
            <table class="table rounded shadow table-hover align-items-stretch">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Codigo Venta</th>
                        <th scope="col">Fecha Venta</th>
                        <th scope="col">Pasaporte</th>
                        <th scope="col">Nombre y Apellidos</th>
                        <th scope="col">Nacionalidad</th>
                        <th scope="col">Numero Vuelo</th>
                        <th scope="col">Destino Vuelo</th>
                        <th scope="col">Fecha Vuelo</th>
                        <th scope="col">Hora Vuelo</th>
                        <th scope="col">Total</th>
                        <th scope="col">Eliminar</th>
                        <th scope="col">Modificar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int contador = 1;
                        VentaDAO ventaDAO = new VentaDAO();
                        for (Venta obj : ventaDAO.listarVentas()) {
                            out.println("<tr>");
                            out.println("<th scope='row'>" + contador);
                            out.println("<td>" + obj.getCodigo());
                            out.println("<td>" + obj.getFecha());
                            out.println("<td>" + obj.getPasajero().getPasaporte());
                            out.println("<td>" + obj.getPasajero().getNombre() + " " + obj.getPasajero().getApellidoMaterno() + " " + obj.getPasajero().getApellidoPaterno());
                            out.println("<td>" + obj.getPasajero().getNacionalidad());
                            out.println("<td>" + obj.getBoleto().getNumeroVuelo());
                            out.println("<td>" + obj.getBoleto().getDestino());
                            out.println("<td>" + obj.getBoleto().getFechaVuelo());
                            out.println("<td>" + obj.getBoleto().getHoraVuelo());
                            out.println("<td>" + obj.getTotal());
                            out.println("<td><a href=../administrador/venta/eliminarVenta.jsp?codigo_venta=" + obj.getCodigo() + " id='eliminar_pasajero'>Eliminar</a></td>");
                            out.println("<td><a href=../administrador/venta/modificarVenta.jsp?codigo_venta=" + obj.getCodigo() + "&boleto_id=" + obj.getBoleto().getId() + " id='modificar_pasajero'>Modificar</a></td>");
                            out.println("<tr>");
                            contador++;
                        }
                    %>
                </tbody>
            </table>
            <div class="col-md-12">
                <a href="../form_admin.jsp" class="btn btn-primary offset-3 w-50" ></a>
            </div
        </div>
    </body>
</html>
