/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author henrry
 */
public class UsuarioDAO extends Conexion {

    private static Usuario usuario;
    private static ArrayList<Usuario> alUsuarios = new ArrayList<>(); // ignorar
    private static int sw = 0; // ignorar

    public static int getSW() {
        return sw;
    }

    public UsuarioDAO() {
        super();
    }

    public boolean agregar(Usuario usuario) {
        boolean estado = false;

        try {
            super.conectar();
            String query = "insert into usuarios values('" + usuario.getRut() + "','"
                    + usuario.getNombre() + "','"
                    + usuario.getApellidoPaterno() + "','"
                    + usuario.getApellidoMaterno() + "',"
                    + usuario.getTipoUsuario() + ",'"
                    + usuario.getUsername() + "','"
                    + usuario.getPassword() + "')";

            int filas = super.state.executeUpdate(query);
            if (filas > 0) {
                estado = true; //agregado
            }
        } catch (Exception e) {
            System.out.println("UsuarioDAO agregar:" + e.getMessage());
        }
        return estado;
    }

    public Usuario buscar(String rut) {
        Usuario usuario = null;

        try {
            super.conectar();
            String query = "select * from usuarios where rut='" + rut + "';";
            ResultSet rs = state.executeQuery(query);
            String nombre = "";
            String apellidoP = "";
            String apellidoM = "";
            int idTipoUsuario = 0;
            String user = "";
            String clave = "";
            while (rs.next()) {
                //System.out.println("Entró al while");
                //rut = rs.getString("rut");
                nombre = rs.getString("nombre");
                apellidoP = rs.getString("apellido_paterno");
                apellidoM = rs.getString("apellido_materno");
                idTipoUsuario = rs.getInt("tipo_usuario");
                user = rs.getString("username");
                clave = rs.getString("password");
                usuario = new Usuario(rut, nombre, apellidoP, apellidoM, idTipoUsuario, user, clave);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error:  UsuarioDAO buscar:" + e.getMessage());
        }

        return usuario;
    }

    public Usuario login(String username, String password) {
        Usuario usuario = new Usuario();
        super.conectar();
        try {

            String query = "select * from usuarios where username='" + username + "' and "
                    + "password='" + password + "'";
            ResultSet result = state.executeQuery(query);
   
            while (result.next()) {
                //System.out.println("Entró al while");
              usuario.setRut((String) result.getObject(1));
              usuario.setNombre((String) result.getObject(2));
              usuario.setApellidoPaterno((String) result.getObject(3));
              usuario.setApellidoMaterno((String) result.getObject(4));
              usuario.setTipoUsuario((int) result.getObject(5));
              usuario.setUsername((String) result.getObject(6));
              usuario.setPassword((String) result.getObject(7));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error:  UsuarioDAO login:" + e.getMessage());
        }

        return usuario;
    }

    public boolean modificar(Usuario usuario) {
        boolean estado = false;

        try {
            super.conectar();
            String query = "update usuarios set nombre='" + usuario.getNombre() + "', "
                    + "apellido_paterno='" + usuario.getApellidoPaterno() + "', "
                    + "apellido_materno='" + usuario.getApellidoMaterno() + "', "
                    + "tipo_usuario=" + usuario.getTipoUsuario() + ", "
                    + "username='" + usuario.getUsername() + "', "
                    + "password='" + usuario.getPassword() + "'  "
                    + " where rut='" + usuario.getRut() + "'";

            int filas = super.state.executeUpdate(query);
            if (filas > 0) {
                estado = true;  //Modificado
            }
        } catch (Exception e) {
            System.out.println("Error:  UsuarioDAO modificar:" + e.getMessage());
        }

        return estado;
    }

    public boolean eliminar(String rut) {
        boolean estado = false; //NO eliminado
        try {
            super.conectar();
            String query = "delete from usuarios where rut='" + rut + "'";

            int filas = state.executeUpdate(query);
            if (filas > 0) {
                estado = true; //eliminado...
            }
        } catch (Exception e) {
            System.out.println("Error:  UsuarioDAO eliminar:" + e.getMessage());
        }

        return estado;
    }
    
    public ArrayList<Usuario> obtenerDatos() {
       
        alUsuarios.clear();
            try {
                super.conectar();
                String query = "select * from usuarios";

                ResultSet rs = state.executeQuery(query);

                String rut = "";
                String nombre = "";
                String apellidoP = "";
                String apellidoM = "";
                int idTipoUsuario = 0;
                String usuario = "";
                String clave = "";

                while (rs.next()) {
                    //System.out.println("Entró al while");
                    rut = rs.getString("rut");
                    nombre = rs.getString("nombre");
                    apellidoP = rs.getString("apellido_paterno");
                    apellidoM = rs.getString("apellido_materno");
                    idTipoUsuario = rs.getInt("tipo_usuario");
                    usuario = rs.getString("username");
                    clave = rs.getString("password");

                    Usuario obj = new Usuario(rut, nombre, apellidoP, apellidoM,
                            idTipoUsuario, usuario, clave);
                    //System.out.println("Usuario: "+obj.toString());
                    alUsuarios.add(obj);
                }
                con.close();
            } catch (Exception e) {
                System.out.println("Error:  UsuarioDAO obtenerDatos:" + e.getMessage());
            }
        
        return alUsuarios;
    }

    //CRUD
    /*
    
    public static Usuario login(String user, String pass)
    {
       Usuario usuario = null;
       
       for(Usuario obj : alUsuarios)
       {
          if(obj.getUsername().equals(user) && obj.getPassword().equals(pass))
          {
             usuario = obj;
             break;
          }       
       }
       
       return usuario;
    }
    
    public static boolean grabar(Usuario usuario) {
        boolean estado = false;
        if (usuario != null && buscar(usuario.getRut()) == null) {
            alUsuarios.add(usuario);
            estado = true;
        }
        return estado;
    }

    
    public static Usuario buscar(String rut) {
        Usuario objeto = null;

        for (Usuario usuario : alUsuarios) {
            if (rut.equals(usuario.getRut())) {
                objeto = usuario;
                break;
            }
        }
        return objeto;
    }
    
    public static boolean modificar(Usuario usuario) {
        boolean estado = false;
        int i = 0;

        for (Usuario obj : alUsuarios) {
            if (usuario.getRut().equals(obj.getRut())) {
                alUsuarios.set(i, usuario);
                estado = true;
                break;
            }
        }
        return estado;
    }
    
    public static boolean eliminar(String rut) {
        boolean estado = false;

        for (Usuario obj : alUsuarios) {
            if (rut.equals(obj.getRut())) {
                alUsuarios.remove(obj);
                estado = true;
                break;
            }
        }
        return estado;
    }
    
    
    public static ArrayList<Usuario> obtenerDatos()
    {
        return alUsuarios;
    }
    
    
    public static void llenar()
    {
       alUsuarios.add(new Usuario("1-1","Charbel","Pinto","Salvador",2,"foto5.jpg",
                                  "cpinto","123",1));
       alUsuarios.add(new Usuario("2-2","Alejandra","Suarez","Fonseca",3,"foto2.jpg",
                                  "asuarez","123",1));
       alUsuarios.add(new Usuario("3-3","Henrry","Mejia","Meneses",1,"foto4.jpeg",
                                  "hmejia","123",1));
       alUsuarios.add(new Usuario("4-4","Sonia","Meneses","Morales",2,"foto3.jpg",
                                  "smeneses","123",2));
       alUsuarios.add(new Usuario("5-5","Ramon","Perez","Gonzales",3,"foto6.jpg",
                                  "rperez","123",3));
       sw=1;
       
    }
     */
}
