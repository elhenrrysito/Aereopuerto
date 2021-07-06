/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.PasajeroDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pasajero;
import modelo.Usuario;

/**
 *
 * @author henrr
 */
public class ControladorPasajero extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        String pasaporte = "", nacionalidad = "", nombre = "", apellidoPaterno = "", apellidoMaterno = "", correo = "", telefono = "", opcion = "";
        PasajeroDAO pasajeroDAO = new PasajeroDAO();

        pasaporte = request.getParameter("pasaporte_pasajero");
        nacionalidad = request.getParameter("nacionalidad_pasajero");
        nombre = request.getParameter("nombre");
        apellidoPaterno = request.getParameter("apellido_paterno");
        apellidoMaterno = request.getParameter("apellido_materno");
        correo = (request.getParameter("correo"));
        telefono = (request.getParameter("telefono"));
        opcion = (request.getParameter("opcion"));

        if (opcion.equals("Grabar")) {

            if (pasaporte.isEmpty() || nacionalidad.isEmpty() || apellidoPaterno.isEmpty()
                    || apellidoMaterno.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {

                response.sendRedirect("MensajeError.jsp?texto=Error! los campos"
                        + " no deben estar vacios.&retorno=administrador/form_admin.jsp");
            } else {
                Pasajero pasajero = new Pasajero(pasaporte, nacionalidad, nombre, apellidoPaterno, apellidoMaterno, correo, telefono);

                if (pasajeroDAO.insertar(pasajero)) {
                    response.sendRedirect("MensajeOk.jsp?texto=Datos grabados exitosamente&retorno=administrador/form_admin.jsp");
                } else {
                    response.sendRedirect("MensajeError.jsp?texto=Error, datos no grabados&retorno=administrador/form_admin.jsp");
                }
            }

        }

        if (opcion.equals("Actualizar")) {
            if (pasaporte.isEmpty() || nacionalidad.isEmpty() || apellidoPaterno.isEmpty()
                    || apellidoMaterno.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {

                response.sendRedirect("MensajeError.jsp?texto=Error! los campos"
                        + " no deben estar vacios.&retorno=administrador/form_admin.jsp");
            } else {
                Pasajero pasajero = new Pasajero(pasaporte, nacionalidad, nombre, apellidoPaterno, apellidoMaterno, correo, telefono);

                if (pasajeroDAO.modificar(pasajero)) {
                    response.sendRedirect("MensajeOk.jsp?texto=Datos actualizados exitosamente&retorno=administrador/form_admin.jsp");
                } else {
                    response.sendRedirect("MensajeError.jsp?texto=Error, datos no actualizados&retorno=administrador/form_admin.jsp");
                }
            }
        }

        if (opcion.equals("Eliminar")) {
            // modificar para buscar por pasaporte
            Pasajero pasajero = pasajeroDAO.buscar(pasaporte);
            if (pasajeroDAO.eliminar(pasajero.getPasaporte())) {

                response.sendRedirect("MensajeOk.jsp?texto=Datos eliminados exitosamente&retorno=administrador/form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no eliminados&retorno=administrador/form_admin.jsp");
            }
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorPasajero</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPasajero at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(ControladorPasajero.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorPasajero.class.getName()).log(Level.SEVERE, null, ex);
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
