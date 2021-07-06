/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BoletoDAO;
import dao.PasajeroDAO;
import dao.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Boleto;
import modelo.Pasajero;
import modelo.Venta;

/**
 *
 * @author henrr
 */
public class ControladorVentaTrabajador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*
        String codigo = "", fecha = "", opcion = "", pasaporte = "", nacionalidad = "", numeroVuelo = "";
        int total = 0;
        
        opcion = request.getParameter("opcion");
        fecha = request.getParameter("fecha_venta");
        if (!opcion.equals("buscar_fecha")) {
            codigo = request.getParameter("codigo_venta");
            total = Integer.parseInt(request.getParameter("total"));
            pasaporte = request.getParameter("pasaporte_pasajero");
            nacionalidad = request.getParameter("nacionalidad_pasajero");
            numeroVuelo = request.getParameter("numero_vuelo");
            opcion = request.getParameter("opcion");
        }

        Pasajero pasajero = PasajeroDAO.buscar(pasaporte);
        Boleto boleto = BoletoDAO.buscar(numeroVuelo);
        
        if(opcion.equals("Grabar")) {
            Venta venta = new Venta(codigo, fecha, total, pasajero, boleto);
            
            if(VentaDAO.grabar(venta) == true) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos grabados exitosamente&retorno=trabajador/form_trabajador.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no grabados&retorno=trabajador/form_trabajador.jsp");
            }
        }
        
        if(opcion.equals("Actualizar")) {
            Venta venta = new Venta(codigo, fecha, total, pasajero, boleto);
            
            if(VentaDAO.modificar(venta) == true) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos modificados exitosamente&retorno=trabajador/form_trabajador.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no modificados&retorno=trabajador/form_trabajador.jsp");
            }
        }
        
        if(opcion.equals("Eliminar")) {
            Venta venta = new Venta(codigo, fecha, total, pasajero, boleto);
            
            if(VentaDAO.eliminar(venta.getCodigo()) == true) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos eliminados exitosamente&retorno=trabajador/form_trabajador.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no eliminados &retorno=trabajador/form_trabajador.jsp");
            }
        }
        
        if(opcion.equals("buscar_fecha")) {
            Venta venta = VentaDAO.buscarFecha(fecha);
            if(venta != null) {
                response.sendRedirect("trabajador/venta/listarVentasFecha.jsp?fecha_venta=" + venta.getFecha() + "&retorno=trabajador/form_trabajador.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=No hay ventas para esta fecha&retorno=trabajador/form_trabajador.jsp");
            }
        }
        
        */
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorVentaTrabajador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorVentaTrabajador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
