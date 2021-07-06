<%-- 
    Document   : modificarBoleto
    Created on : 27-may-2021, 12:53:06
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
        <title>Modificar Boleto</title>
    </head>
    <body>
        <%
            Long idBoleto = Long.parseLong(request.getParameter("id_boleto"));
            BoletoDAO boletoDAO = new BoletoDAO();
            Boleto boleto = boletoDAO.buscar(idBoleto);

        %>
        <div class="container w-50 bg-white rounded shadow mt-4 mb-4">
            <div class="row align-items-stretch">
                <div class="col bg">
                    <div class="text-end">
                        <img src="../../img/boleto.png" alt="usuario" width="64">
                    </div>
                    <h1 class="text-center mb-4">Modificar Boleto</h1>
                    <form class="row g-3" action="../../ControladorBoleto" method="POST">
                        <div class="col-md-6">
                            <label for="id_boleto" class="form-label">ID</label>
                            <input type="text" class="form-control" name="id_boleto" value="<%=boleto.getId()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="numero_vuelo" class="form-label">Numero Vuelo</label>
                            <input type="text" class="form-control" name="numero_vuelo" value="<%=boleto.getNumeroVuelo()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="aereolinea" class="form-label">Aereolinea</label>
                            <input type="text" class="form-control" name="aereolinea" value="<%=boleto.getAereolinea()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="fecha_vuelo" class="form-label">Fecha Vuelo</label>
                            <input type="date" class="form-control" name="fecha_vuelo" id="nombre" value="<%=boleto.getFechaVuelo()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="hora_vuelo" class="form-label">Hora Vuelo</label>
                            <input type="time" class="form-control" name="hora_vuelo" value="<%=boleto.getHoraVuelo()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="destino" class="form-label">Destino</label>
                            <input type="text" class="form-control" name="destino" value="<%=boleto.getDestino()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="precio_boleto" class="form-label">Precio</label>
                            <input type="text" class="form-control" name="precio_boleto" value="<%=boleto.getPrecio()%>">
                        </div>
                        <div class="col-12 mb-4">
                            <button type="submit" name="opcion" value="Actualizar" class="btn btn-primary offset-3 w-50">Actualizar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
</html>
