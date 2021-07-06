/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author henrry
 */
public class ControladorLogin extends HttpServlet {

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
        
        String usuario,clave="";
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        usuario = request.getParameter("usuario");
        clave   = request.getParameter("clave");
        
        
        Usuario user=usuarioDAO.login(usuario, clave);
        
        //System.out.println("Usuario="+user.toString());
        
        
        if( user != null)            
        {
            //http://dis.um.es/~lopezquesada/documentos/IES_1213/IAW/curso/UT5/ActividadesAlumnos/12/sesiones.html#
            HttpSession miSession= request.getSession(true);
            miSession.setAttribute("usuario",user);

            //terminar las soluciones posibles cambiar por un switch
            
            switch(user.getTipoUsuario())
            {
                case 1:{
                          System.out.println("El usuario es 1..."); 
                          response.sendRedirect("administrador/form_admin.jsp"); 
                          break;
                       }
                case 2:{
                          System.out.println("El usuario es 2..."); 
                          response.sendRedirect("trabajador/form_trabajador.jsp");                
                          break;
                       }
                case 3:{
                          System.out.println("El usuario es 3...");
                          response.sendRedirect("secretaria/form_secretaria.jsp");
                          break;
                       }
                default:{
                           response.sendRedirect("index.jsp");
                        }
                                    
            }
        }
        else
        {
           
           response.sendRedirect("MensajeError.jsp?texto=Error, usuario o clase no corresponden&"
                                 + "retorno=index.jsp");
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorLogin at " + request.getContextPath() + "</h1>");
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
