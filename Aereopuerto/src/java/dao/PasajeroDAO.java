/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Pasajero;

/**
 *
 * @author henrr
 */
public class PasajeroDAO extends Conexion {
    
    private static ArrayList<Pasajero> alPasajeros = new ArrayList<>(); // ignorar
    private static int sw = 0; // ignorar

    public PasajeroDAO() { // importante
        super();
    }

    public static int getSW() { // ignorar
        return sw;
    }
    
    public boolean insertar(Pasajero pasajero) {
        boolean estado = false;
        
        try {
            super.conectar();
            
            int filas = super.state.executeUpdate("INSERT INTO pasajeros VALUES ('" + pasajero.getPasaporte() 
                    + "', '" + pasajero.getNacionalidad() + "', '" + pasajero.getNombre() 
                    + "', '" + pasajero.getApellidoPaterno() 
                    + "', '" + pasajero.getApellidoMaterno() 
                    + "', '" + pasajero.getCorreo() + "', '" + pasajero.getTelefono() + "');");
            con.close();
            if(filas > 0) {
               estado = true;
           }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return estado;
    }
    
    public Pasajero buscar(String pasaporte) throws SQLException {
        super.conectar();
        Pasajero pasajero = new Pasajero();
        
        ResultSet result = state.executeQuery("SELECT * FROM pasajeros WHERE pasaporte = '" + pasaporte + "';");
        while(result.next()) {
            pasajero.setPasaporte((String) result.getObject(1));
            pasajero.setNacionalidad((String) result.getObject(2));
            pasajero.setNombre((String) result.getObject(3));
            pasajero.setApellidoPaterno((String) result.getObject(4));
            pasajero.setApellidoMaterno((String) result.getObject(5));
            pasajero.setCorreo((String) result.getObject(6));
            pasajero.setTelefono((String) result.getObject(7));
        }
        return pasajero;
    }
    
    public ArrayList<Pasajero> listarPasajero() throws SQLException, Exception {
        super.conectar();
        ResultSet result = state.executeQuery("SELECT * FROM pasajeros");
        ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();
        
        while(result.next()) {
            Pasajero pasajero = new Pasajero();
            pasajero.setPasaporte((String) result.getObject(1));
            pasajero.setNacionalidad((String) result.getObject(2));
            pasajero.setNombre((String) result.getObject(3));
            pasajero.setApellidoPaterno((String) result.getObject(4));
            pasajero.setApellidoMaterno((String) result.getObject(5));
            pasajero.setCorreo((String) result.getObject(6));
            pasajero.setTelefono((String) result.getObject(7));
            
            pasajeros.add(pasajero);
        }
        return pasajeros;
    }
    
    public boolean modificar(Pasajero pasajero) {
        boolean estado = false;
        try {
            super.conectar();
            int filas = super.state.executeUpdate("UPDATE pasajeros set nacionalidad='" + pasajero.getNacionalidad() + "', nombre='" + pasajero.getNombre() 
                    + "', apellido_paterno='" + pasajero.getApellidoPaterno() 
                    + "', apellido_materno='" + pasajero.getApellidoMaterno() 
                    + "', correo='" + pasajero.getCorreo() + "', telefono='" + pasajero.getTelefono() + "' where pasaporte='" + pasajero.getPasaporte()+ "';");
            con.close();
            if(filas>0) {
                estado = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return estado;
    }
    
    public boolean eliminar(String pasaporte) {
        boolean estado = false;
        
        try {
            super.conectar();
            int filas = state.executeUpdate("DELETE FROM pasajeros WHERE pasaporte='" + pasaporte + "';");
            con.close();
            if(filas > 0) {
                estado = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return estado;
    }
    
    
    // IGNORAR TODO LO QUE VIENE ACA ABAJO

    // Grabar pasajero
    /*
    public static boolean grabar(Pasajero pasajero) {
        boolean estado = false;
        if (pasajero != null && buscar(pasajero.getPasaporte()) == null) {
            alPasajeros.add(pasajero);
            estado = true;
        }
        return estado;
    }

    // Buscar pasajero
    public static Pasajero buscar(String pasaporte) {
        Pasajero objeto = null;

        for (Pasajero pasajeroB : alPasajeros) {
            if (pasaporte.equals(pasajeroB.getPasaporte())) {
                objeto = pasajeroB;
                break;
            }
        }
        return objeto;
    }

    // Eliminar pasajero
    public static boolean eliminar(String pasaporte) {
        boolean estado = false;

        for (Pasajero pasajeroB : alPasajeros) {
            if (pasaporte.equals(pasajeroB.getPasaporte())) {
                alPasajeros.remove(pasajeroB);
                estado = true;
                break;
            }
        }
        return estado;
    }

    // Modificar pasajero
/*    public static boolean modificar(Pasajero pasajero) {
        boolean estado = false;
        int i = 0;

        for (Pasajero pasajeroB : alPasajeros) {
            if (pasajero.getPasaporte().equals(pasajeroB.getPasaporte())) {
                alPasajeros.set(i, pasajero);
                estado = true;
                break;
            }
        }
        return estado;
    }

    
    
    // Listar
    public static ArrayList<Pasajero> obtenerDatos() {
        return alPasajeros;
    }
    
    public static void llenar() {
        alPasajeros.add(new Pasajero("122354789", "venezolana", "Henrry", "Mejia", "Meneses", "henrry.mejia@gmail.com", "+56967181991"));
        alPasajeros.add(new Pasajero("125478663", "uruguaya", "Daniel", "Suarez", "Colmena", "dsuarez@gmail.com", "+16547895322"));
        alPasajeros.add(new Pasajero("15478642", "francesa", "Paris", "Hilton", "Del Campo", "parishilton@gmail.com", "+12547963254"));
        alPasajeros.add(new Pasajero("33524123", "chilena", "Aquiles", "Bailo", "Canton", "abailocanton", "+569541235964"));
        alPasajeros.add(new Pasajero("352457896", "canadiense", "Alejandra", "McLoren", "Cambridge", "amcloren@gmail.com", "+15653215876"));
        alPasajeros.add(new Pasajero("445218568", "colombiana", "Daniel", "Del", "Prado", "ddelprado@gmail.com", "+5731254896"));
        alPasajeros.add(new Pasajero("125478663", "china", "Xiong", "Kao", "Fu", "xkaofu@gmail.com", "+865721546213"));
        alPasajeros.add(new Pasajero("225659832", "Holandesa", "Marc", "Trenor", "Indalo", "marctrenor@gmail.com", "+2458896324788"));
        alPasajeros.add(new Pasajero("856799234", "tailandesa", "Kiomi", "Xinxao", "Xu", "kiomixu@gmail.com", "+2325454832"));
        alPasajeros.add(new Pasajero("352457896", "mexicana", "Daniela", "Perez", "Suarez", "dperez@gmail.com", "+55235687724"));
        sw=1;
    }
*/
    
}
