<%-- 
    Document   : ModificarPasajero
    Created on : 24-may-2021, 22:15:00
    Author     : henrr
--%>

<%@page import="dao.PasajeroDAO"%>
<%@page import="modelo.Pasajero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Pasajero</title>
        <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            String pasaporte = request.getParameter("pasaporte_pasajero");
            PasajeroDAO pasajeroDAO = new PasajeroDAO();
            Pasajero pasajero = pasajeroDAO.buscar(pasaporte);

        %>
        <div class="container w-50 bg-white rounded shadow mt-4 mb-4">
            <div class="row align-items-stretch">
                <div class="col bg">
                    <div class="text-end">
                        <img src="../../img/users2.png" alt="usuario" width="64">
                    </div>
                    <h1 class="text-center mb-4">Modificar Pasajero</h1>
                    <form class="row g-3" action="../../ControladorPasajero" method="POST">
                        <div class="col-md-6">
                            <label for="pasaporte" class="form-label">Pasaporte</label>
                            <input type="text" class="form-control" name="pasaporte_pasajero" value="<%=pasajero.getPasaporte()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="nacionalidad_pasajero" class="form-label">Pasaporte</label>
                            <input type="text" class="form-control" name="nacionalidad_pasajero" value="<%=pasajero.getNacionalidad()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="nombre" value="<%=pasajero.getNombre()%>" id="nombre">
                        </div>
                        <div class="col-md-6">
                            <label for="ap_paterno" class="form-label">Apellido Paterno</label>
                            <input type="text" class="form-control" name="apellido_paterno" value="<%=pasajero.getApellidoPaterno()%>">
                        </div>
                        <div class="col-md-6">
                            <label for="apellido_materno" class="form-label">Apellido Materno</label>
                            <input type="text" class="form-control" name="apellido_materno" value="<%=pasajero.getApellidoPaterno()%>" id="apellido_materno">
                        </div>
                        <div class="col-6">
                            <label for="email" class="form-label">Correo</label>
                            <input type="email" class="form-control" id="inputAddress" name="correo" value="<%=pasajero.getCorreo()%>">
                        </div> 
                        <div class="col-6">
                            <label for="email" class="form-label">Correo</label>
                            <input type="text" class="form-control" id="inputAddress" name="telefono" value="<%=pasajero.getTelefono()%>">
                        </div> 
                        <div class="col-12 mb-4">
                            <button type="submit" name="opcion" value="Actualizar" class="btn btn-primary offset-3 w-50">Modificar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
