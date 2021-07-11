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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ControladorVenta extends HttpServlet {

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
            throws ServletException, IOException, SQLException {

        String codigo = "", fecha = "", opcion = "", pasaporte = "", nacionalidad = "", numeroVuelo = "";
        int cantidad = 0, total = 0;
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        VentaDAO ventaDAO = new VentaDAO();
        BoletoDAO boletoDAO = new BoletoDAO();
        codigo = request.getParameter("codigo_venta");
        total = Integer.parseInt(request.getParameter("total"));
        pasaporte = request.getParameter("pasaporte_pasajero");
        nacionalidad = request.getParameter("nacionalidad_pasajero");
        numeroVuelo = request.getParameter("numero_vuelo");
        opcion = request.getParameter("opcion");
        
        if(opcion.equals("Grabar")) {
            if(codigo.isEmpty() || total == 0 || pasaporte.isEmpty() 
                    || numeroVuelo.isEmpty()) {
                response.sendRedirect("MensajeError.jsp?texto=Error! los campos"
                        + " no deben estar vacios.&retorno=administrador/form_admin.jsp");
            } else {
                int id = Integer.parseInt(request.getParameter("boleto_id"));
              
                Pasajero pasajero = pasajeroDAO.buscar(pasaporte);
                Boleto boleto = boletoDAO.buscar(id);
                Venta venta = new Venta(codigo, fecha, total, pasajero, boleto);
            }
        }
        
        if(opcion.equals("Actualizar")) {
          
            if(total == 0 || pasaporte.isEmpty() || nacionalidad.isEmpty() 
                    || numeroVuelo.isEmpty()) {
                response.sendRedirect("MensajeError.jsp?texto=Error! los campos"
                        + " no deben estar vacios.&retorno=administrador/form_admin.jsp");
            } else {
                int id = Integer.parseInt(request.getParameter("boleto_id"));
                
                Pasajero pasajero = pasajeroDAO.buscar(pasaporte);
                Boleto boleto = boletoDAO.buscar(id);
                Venta venta = new Venta(codigo, fecha, total, pasajero, boleto);
                if(ventaDAO.modificar(venta)) {
                    response.sendRedirect("MensajeOk.jsp?texto=Bien! datos actualizados...&retorno=administrador/form_admin.jsp");
                } else {
                    response.sendRedirect("MensajeError.jsp?texto=Error! datos NO actualizados...&retorno=administrador/form_admin.jsp");
                }
                
            }
        }
        
        if(opcion.equals("Eliminar")) {
            if(ventaDAO.eliminar(codigo)) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos eliminados exitosamente&retorno=administrador/form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no eliminados&retorno=administrador/form_admin.jsp");
            }
        }

        /*
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

        if (opcion.equals("Grabar")) {
            Venta venta = new Venta(codigo, fecha, total, pasajero, boleto);

            if (VentaDAO.grabar(venta) == true) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos grabados exitosamente&retorno=administrador/form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no grabados&retorno=administrador/form_admin.jsp");
            }
        }

        if (opcion.equals("Actualizar")) {
            Venta venta = new Venta(codigo, fecha, total, pasajero, boleto);

            if (VentaDAO.modificar(venta) == true) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos modificados exitosamente&retorno=administrador/form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no modificados&retorno=administrador/form_admin.jsp");
            }
        }

        if (opcion.equals("Eliminar")) {
            Venta venta = new Venta(codigo, fecha, total, pasajero, boleto);

            if (VentaDAO.eliminar(venta.getCodigo()) == true) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos eliminados exitosamente&retorno=administrador/form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no eliminados &retorno=administrador/form_admin.jsp");
            }
        }

        if (opcion.equals("buscar_fecha")) {
            Venta venta = VentaDAO.buscarFecha(fecha);
            if (venta != null) {
                response.sendRedirect("administrador/venta/listarVentasFecha.jsp?fecha_venta=" + venta.getFecha() + "&retorno=../form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=No hay ventas para esta fecha&retorno=administrador/form_admin.jsp");
            }
        }
         */
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorVenta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorVenta at " + request.getContextPath() + "</h1>");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
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
