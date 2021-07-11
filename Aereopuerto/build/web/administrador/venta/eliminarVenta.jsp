<%-- 
    Document   : eliminarVenta
    Created on : 27-may-2021, 21:48:25
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
        <title>Eliminar Venta</title>
    </head>
    <body>
        <%
            String codigo = request.getParameter("codigo_venta");
            VentaDAO ventaDAO = new VentaDAO();

            Venta venta = ventaDAO.buscar(codigo);

        %>
        <!-- AGREGAR VENTA -->
        <div class="container w-50 bg-white rounded shadow mt-4 mb-4">
            <div class="row align-items-stretch">
                <div class="col bg">
                    <div class="text-end">
                        <img src="../../img/trade.png" alt="airplane" width="64">
                    </div>
                    <h1 class="text-center mb-4">Eliminar Venta</h1>
                    <form class="row g-3" action="../../ControladorVenta" method="POST">

                        <div class="col-md-6">
                            <label for="codigo_venta" class="form-label">Codigo Venta</label>
                            <input type="text" class="form-control" name="codigo_venta" value="<%=venta.getCodigo()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="pasaporte_pasajero" class="form-label">Pasaporte Pasajero</label>
                            <input type="text" class="form-control" name="pasaporte_pasajero" value="<%=venta.getPasajero().getPasaporte()%>">
                        </div>
                        
                        <div class="col-md-6">
                            <label for="numero_vuelo" class="form-label">Numero Vuelo</label>
                            <input type="text" class="form-control" name="numero_vuelo" value="<%=venta.getBoleto().getNumeroVuelo()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="destino_vuelo" class="form-label">Destino</label>
                            <input type="text" class="form-control" name="destino_vuelo" value="<%=venta.getBoleto().getDestino()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="precio_boleto" class="form-label">Precio</label>
                            <input type="text" class="form-control" name="total" value="<%=venta.getBoleto().getPrecio()%>">
                        </div>

                        <div class="col-md-6">
                            <label for="fecha_venta" class="form-label">Fecha Venta</label>
                            <input type="date" class="form-control" name="fecha_venta" value="<%=venta.getBoleto().getFechaVuelo()%>">
                        </div>
                        <div class="col-12 mb-4">
                            <button type="submit" name="opcion" value="Eliminar" class="btn btn-primary offset-3 w-50">Eliminar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
