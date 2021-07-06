<%-- 
    Document   : insertarVenta
    Created on : 27-may-2021, 19:50:43
    Author     : henrr
--%>

<%@page import="dao.PasajeroDAO"%>
<%@page import="modelo.Pasajero"%>
<%@page import="dao.BoletoDAO"%>
<%@page import="modelo.Boleto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Insertar Venta</title>
    </head>
    <body>
        <%
            String numeroVuelo = request.getParameter("numero_vuelo");

            Boleto boleto = BoletoDAO.buscar(numeroVuelo);

        %>
        <!-- AGREGAR VENTA -->
        <div class="container w-50 bg-white rounded shadow mt-4 mb-4">
            <div class="row align-items-stretch">
                <div class="col bg">
                    <div class="text-end">
                        <img src="../../img/trade.png" alt="airplane" width="64">
                    </div>
                    <h1 class="text-center mb-4">Insertar Venta</h1>
                    <form class="row g-3" action="../../ControladorVenta" method="POST">
                        <div class="col-md-6">
                            <label for="codigo_venta" class="form-label">Codigo Venta</label>
                            <input type="text" class="form-control" name="codigo_venta">
                        </div>
                        <div class="col-md-6">
                            <label for="codigo_venta" class="form-label">Fecha Venta</label>
                            <input type="date" class="form-control" name="fecha_venta">
                        </div>
                        <div class="col-md-6">
                            <label for="pasaporte_pasajero" class="form-label">Seleccionar pasajero</label>
                            <select class="form-select" name="pasaporte_pasajero" aria-label="Default select example">
                                <option selected>Open this select menu</option>
                                <%                                
                                    for (Pasajero obj : PasajeroDAO.obtenerDatos()) {
                                        out.println("<option value='" + obj.getPasaporte() + "'>" + obj.getPasaporte() + "</option>");
                                    }
                                %> 
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="numero_vuelo" class="form-label">Numero Vuelo</label>
                            <input type="text" class="form-control" name="numero_vuelo" value="<%=boleto.getNumeroVuelo()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="destino_vuelo" class="form-label">Destino</label>
                            <input type="text" class="form-control" name="destino_vuelo" value="<%=boleto.getDestino()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="precio_boleto" class="form-label">Precio</label>
                            <input type="text" class="form-control" name="total" value="<%=boleto.getPrecio()%>">
                        </div>

                        <div class="col-md-6">
                            <label for="fecha_vuelo" class="form-label">Fecha vuelo</label>
                            <input type="date" class="form-control" name="fecha_vuelo" value="<%=boleto.getFechaVuelo()%>">
                        </div>
                        <div class="col-12 mb-4">
                            <button type="submit" name="opcion" value="Grabar" class="btn btn-primary offset-3 w-50">Grabar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
