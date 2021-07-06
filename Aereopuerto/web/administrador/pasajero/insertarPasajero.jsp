<%-- 
    Document   : crudPasajero
    Created on : 24-may-2021, 12:15:22
    Author     : henrr
--%>

<%@page import="dao.PasajeroDAO"%>
<%@page import="modelo.Pasajero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    </head>
    <body>
        <div class="container w-50 bg-white rounded shadow mt-4 mb-4">
            <div class="row align-items-stretch">
                <div class="col bg">
                    <div class="text-end">
                        <img src="../img/users2.png" alt="usuario" width="64">
                    </div>
                    <h1 class="text-center mb-4">Insertar Pasajero</h1>
                    <form class="row g-3" action="../ControladorPasajero" method="POST">
                        <div class="col-md-6">
                            <label for="pasaporte_pasajero" class="form-label">Pasaporte</label>
                            <input type="text" class="form-control" name="pasaporte_pasajero" placeholder="12345678-9">
                        </div>
                        <div class="col-md-6">
                            <label for="nacionalidad" class="form-label">Nacionalidad</label>
                            <input type="text" class="form-control" name="nacionalidad_pasajero">
                        </div>
                        <div class="col-md-6">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="nombre" id="nombre">
                        </div>
                        <div class="col-md-6">
                            <label for="ap_paterno" class="form-label">Apellido Paterno</label>
                            <input type="text" class="form-control" name="apellido_paterno">
                        </div>
                        <div class="col-md-6">
                            <label for="apellido_materno" class="form-label">Apellido Materno</label>
                            <input type="text" class="form-control" name="apellido_materno" id="apellido_materno">
                        </div>
                        <div class="col-6">
                            <label for="email" class="form-label">Correo</label>
                            <input type="email" class="form-control" id="inputAddress" name="correo" placeholder="tucorreo@dominio.com">
                        </div> 
                        <div class="col-12">
                            <label for="email" class="form-label">Telefono</label>
                            <input type="text" class="form-control" id="inputAddress" name="telefono" placeholder="+123456789">
                        </div> 
                        <div class="col-12 mb-4">
                            <button type="submit" name="opcion" value="Grabar" class="btn btn-primary offset-3 w-50">Añadir</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
       
        
    </body>
</html>
