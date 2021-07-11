/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.BoletoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Boleto;

/**
 *
 * @author henrr
 */
public class ControladorBoleto extends HttpServlet {

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

        String numeroVuelo = "", aereolinea = "", fechaVuelo = "", horaVuelo = "", destino = "", opcion = "";
        int precio = 0;
        int id;
        BoletoDAO boletoDAO = new BoletoDAO();


        numeroVuelo = request.getParameter("numero_vuelo");
        aereolinea = request.getParameter("aereolinea");
        fechaVuelo = request.getParameter("fecha_vuelo");
        horaVuelo = request.getParameter("hora_vuelo");
        destino = request.getParameter("destino");
        precio = Integer.parseInt(request.getParameter("precio_boleto"));
        opcion = request.getParameter("opcion");

        if (opcion.equals("Grabar")) {
            if (numeroVuelo.isEmpty() || aereolinea.isEmpty() || fechaVuelo.isEmpty()
                    || horaVuelo.isEmpty() || destino.isEmpty() || precio == 0) {
                response.sendRedirect("MensajeError.jsp?texto=Error! los campos"
                        + " no deben estar vacios.&retorno=administrador/form_admin.jsp");
            } else {
                Boleto boleto = new Boleto(numeroVuelo, aereolinea, fechaVuelo, horaVuelo, destino, precio);
                if (boletoDAO.insertar(boleto)) {
                    response.sendRedirect("MensajeOk.jsp?texto=Bien! datos grabados...&retorno=administrador/form_admin.jsp");
                } else {
                    response.sendRedirect("MensajeError.jsp?texto=Error! datos NO grabados...&retorno=administrador/form_admin.jsp");
                }
            }
        }
        
        if (opcion.equals("Actualizar")) {
            id = Integer.parseInt(request.getParameter("boleto_id"));
            if (numeroVuelo.isEmpty() || aereolinea.isEmpty() || fechaVuelo.isEmpty()
                    || horaVuelo.isEmpty() || destino.isEmpty() || precio == 0) {
                response.sendRedirect("MensajeError.jsp?texto=Error! los campos"
                        + " no deben estar vacios.&retorno=administrador/form_admin.jsp");
            } else {
                Boleto boleto = new Boleto(numeroVuelo, aereolinea, fechaVuelo, horaVuelo, destino, precio);
                if (boletoDAO.modificar(boleto)) {
                    response.sendRedirect("MensajeOk.jsp?texto=Bien! datos actualizados...&retorno=administrador/form_admin.jsp");
                } else {
                    response.sendRedirect("MensajeError.jsp?texto=Error! datos NO actualizados...&retorno=administrador/form_admin.jsp");
                }
            }
        }
        
        if(opcion.equals("Eliminar")) {
            id = Integer.parseInt(request.getParameter("boleto_id"));
            // modificar para buscar por codigo
            if(boletoDAO.eliminar(id)) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos eliminados exitosamente&retorno=administrador/form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no eliminados&retorno=administrador/form_admin.jsp");
            }
        }

            /*
        // Insertar boleto
        if(opcion.equals("Grabar")) {
            Boleto boleto = new Boleto(numeroVuelo, aereolinea, fechaVuelo, horaVuelo, destino, precio);
            if(BoletoDAO.grabar(boleto) == true) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos grabados exitosamente&retorno=administrador/form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no grabados&retorno=administrador/form_admin.jsp");
            }
        }
        
        if(opcion.equals("Actualizar")) {
            Boleto boleto = new Boleto(numeroVuelo, aereolinea, fechaVuelo, horaVuelo, destino, precio);
            if(BoletoDAO.modificar(boleto) == true) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos modificados exitosamente&retorno=administrador/form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no modificados&retorno=administrador/form_admin.jsp");
            }
        }
        
        if(opcion.equals("Eliminar")) {
            Boleto boleto = new Boleto(numeroVuelo, aereolinea, fechaVuelo, horaVuelo, destino, precio);
            if(BoletoDAO.eliminar(boleto.getNumeroVuelo()) == true) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos eliminados exitosamente&retorno=administrador/form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no eliminados&retorno=administrador/form_admin.jsp");
            }
        }
        
        
             */
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ControladorBoleto</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet ControladorBoleto at " + request.getContextPath() + "</h1>");
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
