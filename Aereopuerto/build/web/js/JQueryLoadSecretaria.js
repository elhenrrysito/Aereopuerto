/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
   
    // venta por fecha
    $("#venta_fecha").click(function (event) {
        $("#cargarPagina").load('venta/buscadorVenta.jsp');
    });
   
});