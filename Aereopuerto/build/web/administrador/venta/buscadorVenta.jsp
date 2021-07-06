<%-- 
    Document   : buscadorVenta
    Created on : 28-may-2021, 12:45:36
    Author     : henrr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscador Por Fecha</title>
    </head>
    <body>
        <div class="container w-50 bg-white rounded shadow mt-4 mb-4">
            <div class="row align-items-stretch">
                <div class="col bg">
                    <div class="text-end">
                        <img src="../img/trade.png" alt="airplane" width="64">
                    </div>
                    <h1 class="text-center mb-4">Buscador Fecha</h1>
                    <form class="row g-3" action="../ControladorVenta" method="POST">
                        <div class="col-md-6">
                            <label for="fecha_venta" class="form-label">Fecha Venta</label>
                            <input type="date" class="form-control" name="fecha_venta">
                        </div>
                       
                        <div class="col-12 mb-4">
                            <button type="submit" name="opcion" value="buscar_fecha" class="btn btn-primary offset-3 w-50">Buscar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
