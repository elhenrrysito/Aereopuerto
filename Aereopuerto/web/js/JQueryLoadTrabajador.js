
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Jquery load para distintas paginas
$(document).ready(function () {
   
    // pasajero
    $("#insertar_pasajeros").click(function (event) {
        $("#cargarPagina").load('pasajero/insertarPasajero.jsp');
    });
    
    $("#listar_pasajeros").click(function (event) {
        $("#cargarPagina").load('pasajero/listarPasajero.jsp');
    });
    
    $("#insertar_boletos").click(function (event) {
        $("#cargarPagina").load('boleto/insertarBoleto.jsp');
    });
    
    $("#listar_boletos").click(function (event) {
        $("#cargarPagina").load('boleto/listarBoleto.jsp');
    });
    
    $("#insertar_ventas").click(function (event) {
        $("#cargarPagina").load('venta/crudVentas.jsp');
    });
    
    $("#listar_ventas").click(function (event) {
        $("#cargarPagina").load('venta/listarVenta.jsp');
    });
    
    // venta por fecha
    $("#venta_fecha").click(function (event) {
        $("#cargarPagina").load('venta/buscadorVenta.jsp');
    });

});
