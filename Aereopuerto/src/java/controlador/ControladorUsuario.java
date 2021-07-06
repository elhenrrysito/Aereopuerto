/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author henrry
 */
public class ControladorUsuario extends HttpServlet {

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

         ArrayList<Usuario> alUsuarios=new ArrayList<>();
         UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        
        String rut = "";
        String nombre = "";
        String apellidoP = "";
        String apellidoM = "";
        int idTipoUsuario = 0;
        String user="";
        String clave="";
        String opcion = "";

        opcion = request.getParameter("opcion");

        if (opcion.equals("Grabar")) {
            rut = request.getParameter("rut");
            nombre = request.getParameter("nombre");
            apellidoP = request.getParameter("apellido_paterno");
            apellidoM = request.getParameter("apellido_materno");
            idTipoUsuario = Integer.parseInt(request.getParameter("tipo_usuario"));
            user=request.getParameter("username");
            clave=request.getParameter("password");
            
            if (rut.isEmpty() || nombre.isEmpty() || apellidoP.isEmpty()
                || apellidoM.isEmpty() || user.isEmpty() || clave.isEmpty()) {

                response.sendRedirect("MensajeError.jsp?texto=Error! los campos"
                        + " no deben estar vacios.&retorno=administrador/form_admin.jsp");
            } else {
                Usuario usuario = new Usuario(rut, nombre, apellidoP, apellidoM, idTipoUsuario,user,clave);

                if (usuarioDAO.agregar(usuario) == true) {
                    response.sendRedirect("MensajeOk.jsp?texto=Bien! datos grabados...&retorno=administrador/form_admin.jsp");
                } else {
                    response.sendRedirect("MensajeError.jsp?texto=Error! datos NO grabados...&retorno=administrador/form_admin.jsp");
                }
            }
        }

        if (opcion.equals("Editar")) {
             response.sendRedirect("UsuarioMostrar.jsp");
        }
        
         if (opcion.equals("Eliminar")) {
            rut = request.getParameter("rut");

            if (usuarioDAO.eliminar(rut) ) {
                response.sendRedirect("MensajeOk.jsp?texto=Bien! datos eliminados...&retorno=administrador/form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error! rut no existe...&retorno=administrador/form_admin.jsp");
            }
        }
        
        if (opcion.equals("Actualizar")) {
            rut = request.getParameter("rut");
            nombre = request.getParameter("nombre");
            apellidoP = request.getParameter("apellido_paterno");
            apellidoM = request.getParameter("apellido_materno");
            idTipoUsuario = Integer.parseInt(request.getParameter("tipo_usuario"));
            user=request.getParameter("username");
            clave=request.getParameter("password");
            
            if (rut.isEmpty() || nombre.isEmpty() || apellidoP.isEmpty()
                    || apellidoM.isEmpty()|| user.isEmpty() || clave.isEmpty() ) {              
                 
                //ver donde enviar exactamente
                response.sendRedirect("MensajeError.jsp?texto=Error! los campos"
                        + " no deben estar vacios.&retorno=administrador/form_admin.jsp");
            } else {
                Usuario usuario = new Usuario(rut, nombre, apellidoP, apellidoM, idTipoUsuario,user,clave);
                System.out.println(usuario.getNombre());
                System.out.println(usuario.getApellidoMaterno());
                System.out.println(usuario.getApellidoPaterno());
                System.out.println(usuario.getTipoUsuario());
                System.out.println(usuario.getRut());
                System.out.println(usuario.getUsername());
                System.out.println(usuario.getPassword());
                if (usuarioDAO.modificar(usuario) == true) {
                    response.sendRedirect("MensajeOk.jsp?texto=Bien! datos actualizados...&retorno=administrador/form_admin.jsp");
                } else {
                    response.sendRedirect("MensajeError.jsp?texto"
                            + "=Error! datos NO actualizados...&retorno=administrador/form_admin.jsp");
                }
            }
        }
        /*
        String rut = "", nombre, apellidoPaterno, apellidoMaterno, foto, username, password, opcion = "";
        int tipoUsuario = 0, estado = 0;

        rut = request.getParameter("rut");
        nombre = request.getParameter("nombre");
        apellidoPaterno = request.getParameter("apellido_paterno");
        apellidoMaterno = request.getParameter("apellido_materno");
        tipoUsuario = Integer.parseInt(request.getParameter("tipo_usuario"));
        estado = Integer.parseInt(request.getParameter("estado"));
        foto = request.getParameter("foto");
        username = request.getParameter("username");
        password = request.getParameter("clave");
        opcion = request.getParameter("opcion");

        if (opcion.equals("Grabar")) {
            Usuario usuario = new Usuario(rut, nombre, apellidoPaterno, apellidoMaterno, tipoUsuario, foto, username, password, estado);
            if (UsuarioDAO.grabar(usuario) == true) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos grabados exitosamente&retorno=administrador/form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no grabados&retorno=administrador/form_admin.jsp");
            }
        }

        if (opcion.equals("Actualizar")) {
            Usuario usuario = new Usuario(rut, nombre, apellidoPaterno, apellidoMaterno, tipoUsuario, foto, username, password, estado);
            if (UsuarioDAO.modificar(usuario) == true) {
                response.sendRedirect("MensajeOk.jsp?texto=Datos modificados exitosamente&retorno=administrador/form_admin.jsp");
            } else {
                response.sendRedirect("MensajeError.jsp?texto=Error, datos no modificados&retorno=administrador/form_admin.jsp");
            }
        }

        if (opcion.equals("Eliminar")) {
            if(UsuarioDAO.eliminar(rut) == true) {
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
            out.println("<title>Servlet ControladorUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorUsuario at " + request.getContextPath() + "</h1>");
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
