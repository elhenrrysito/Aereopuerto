/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Boleto;
import modelo.Pasajero;
import modelo.Venta;

/**
 *
 * @author henrr
 */
public class VentaDAO extends Conexion {

    private static ArrayList<Venta> alVentas = new ArrayList<>();
    private static ArrayList<Venta> alVentasFecha = new ArrayList<>();
    private static int sw = 0;

    public VentaDAO() {
        super();
    }

    public boolean insertar(Venta venta) {
        boolean estado = false;
        
        try {
            super.conectar();
            
            int filas = super.state.executeUpdate("INSERT INTO ventas VALUES ('" + venta.getCodigo() 
                    + "', '" + venta.getFecha() + "', '" + venta.getTotal() + "', '" + venta.getPasajero().getPasaporte()
                    + "', " + venta.getBoleto().getId() + ");");
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return estado;
    }
    
    public Venta buscar(String codigo) throws SQLException {
        super.conectar();
        Venta venta = new Venta();
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        BoletoDAO boletoDAO = new BoletoDAO();
        
        ResultSet result = state.executeQuery("SELECT * FROM ventas WHERE codigo = '" + codigo + "';");
        while(result.next()) {
            venta.setCodigo((String) result.getObject(1));
            venta.setFecha((String) result.getObject(2));
            venta.setTotal((int) result.getObject(3));
            Pasajero pasajero = pasajeroDAO.buscar((String) result.getObject(4));
            venta.setPasajero(pasajero);
            Boleto boleto = boletoDAO.buscar((int) result.getObject(5));
            venta.setBoleto(boleto);
        }
        return venta;
    }
    
    public ArrayList<Venta> listarVentas() throws SQLException, Exception {
        super.conectar();
        ResultSet result = state.executeQuery("SELECT * FROM ventas");
        ArrayList<Venta> ventas = new ArrayList<Venta>();
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        BoletoDAO boletoDAO = new BoletoDAO();
        
        while(result.next()) {
            Venta venta = new Venta();
            venta.setCodigo((String) result.getObject(1));
            venta.setFecha((String) result.getObject(2));
            venta.setTotal((int) result.getObject(3));
            Pasajero pasajero = pasajeroDAO.buscar((String) result.getObject(4));
            venta.setPasajero(pasajero);
            Boleto boleto = boletoDAO.buscar((int) result.getObject(5));
            venta.setBoleto(boleto);
            
            ventas.add(venta);
        }
        return ventas;
    }
    
    public boolean modificar(Venta venta) {
        boolean estado = false;
        try {
            super.conectar();
            int filas = super.state.executeUpdate("UPDATE ventas SET fecha='" + venta.getFecha() + "', total='" + venta.getTotal() 
                    + "', total=" + venta.getTotal() 
                    + ", pasajero_pasaporte='" + venta.getPasajero().getPasaporte()
                    + "', boleto_id=" + venta.getBoleto().getId() + " where codigo=" + venta.getCodigo()+ ";");
            con.close();
            if(filas > 0) {
                estado = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return estado;
    }
    
    public boolean eliminar(String codigo) {
        boolean estado = false;
        
        try {
            super.conectar();
            int filas = state.executeUpdate("DELETE FROM ventas WHERE codigo='" + codigo + "';");
            if(filas > 0) {
                estado = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return estado;
    }
    
    
    public static int getSW() {
        return sw;
    }

    /*
    public boolean insertar(Venta venta) {
        boolean estado = false;
        
        try {
            super.conectar();
            
            int fi
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<Venta> getAlVentasFecha() {
        return alVentasFecha;
    }

    public static void setAlVentasFecha(ArrayList<Venta> alVentasFecha) {
        VentaDAO.alVentasFecha = alVentasFecha;
    }

    
    
    // Grabar venta
    public static boolean grabar(Venta venta) {
        boolean estado = false;
        if (venta != null && buscar(venta.getCodigo()) == null) {
            alVentas.add(venta);
            estado = true;
        }
        return estado;
    }

    // Buscar venta
    public static Venta buscar(String codigo) {
        Venta objeto = null;

        for (Venta venta : alVentas) {
            if (codigo.equals(venta.getCodigo())) {
                objeto = venta;
                break;
            }
        }
        return objeto;
    }
    
    // Buscar por fecha
    public static Venta buscarFecha(String fecha) {
        Venta objeto = null;

        for (Venta venta : alVentas) {
            if (fecha.equals(venta.getFecha())) {
                objeto = venta;
                alVentasFecha.add(venta);
                break;
            }
        }
        return objeto;
    }

    // Eliminar venta
    public static boolean eliminar(String codigo) {
        boolean estado = false;

        for (Venta venta : alVentas) {
            if (codigo.equals(venta.getCodigo())) {
                alVentas.remove(venta);
                estado = true;
                break;
            }
        }
        return estado;
    }

    // Modificar venta
    public static boolean modificar(Venta venta) {
        boolean estado = false;
        int i = 0;

        for (Venta obj : alVentas) {
            if (venta.getCodigo().equals(obj.getCodigo())) {
                alVentas.set(i, venta);
                estado = true;
                break;
            }
        }
        return estado;
    }

    // Listar
    public static ArrayList<Venta> obtenerDatos() {
        return alVentas;
    }

    public static ArrayList<Venta> obtenerDatosFecha() {
        return alVentasFecha;
    }
    
    public static void llenar() {
        Pasajero pasajeroUno = new Pasajero("122354789", "venezolana", "Henrry", "Mejia", "Meneses", "henrry.mejia@gmail.com", "+56967181991");
        Pasajero pasajeroDos = new Pasajero("125478663", "uruguaya", "Daniel", "Suarez", "Colmena", "dsuarez@gmail.com", "+16547895322");
        Pasajero pasajeroTres = new Pasajero("15478642", "francesa", "Paris", "Hilton", "Del Campo", "parishilton@gmail.com", "+12547963254");
        Pasajero pasajeroCuatro = new Pasajero("33524123", "chilena", "Aquiles", "Bailo", "Canton", "abailocanton", "+569541235964");
        Pasajero pasajeroCinco = new Pasajero("352457896", "canadiense", "Alejandra", "McLoren", "Cambridge", "amcloren@gmail.com", "+15653215876");
        Pasajero pasajeroSeis = new Pasajero("445218568", "colombiana", "Daniel", "Del", "Prado", "ddelprado@gmail.com", "+5731254896");
        Pasajero pasajeroSiete = new Pasajero("125478663", "china", "Xiong", "Kao", "Fu", "xkaofu@gmail.com", "+865721546213");
        Pasajero pasajeroOcho = new Pasajero("225659832", "Holandesa", "Marc", "Trenor", "Indalo", "marctrenor@gmail.com", "+2458896324788");
        Pasajero pasajeroNueve = new Pasajero("856799234", "tailandesa", "Kiomi", "Xinxao", "Xu", "kiomixu@gmail.com", "+2325454832");
        Pasajero pasajeroDiez = new Pasajero("352457896", "mexicana", "Daniela", "Perez", "Suarez", "dperez@gmail.com", "+55235687724");

        Boleto boletoUno = new Boleto("E01", "AirFrance", "2021-12-12", "11:00", "Francia", 250000);
        Boleto boletoDos = new Boleto("H02", "Emirates", "2022-05-01", "17:00", "Dubai", 1100000);
        Boleto boletoTres = new Boleto("K03", "CanadaFly", "2021-06-08", "03:00", "Canada", 180000);
        Boleto boletoCuatro = new Boleto("L04", "LatamAir", "2021-09-05", "16:00", "Mexico", 120000);
        Boleto boletoCinco = new Boleto("P05", "FlyFine", "2021-11-18", "18:30", "Belgica", 273500);
        Boleto boletoSeis = new Boleto("X06", "American Airlines", "2021-12-18", "13:30", "Colombia", 125000);
        Boleto boletoSiete = new Boleto("A07", "Copa Airlines", "2021-09-12", "07:00", "Estados Unidos", 244350);
        Boleto boletoOcho = new Boleto("T08", "Avianca", "2021-10-01", "06:30", "Japon", 780000);
        Boleto boletoNueve = new Boleto("F09", "Air Berlin", "2021-12-22", "08:00", "Alemania", 750000);
        Boleto boletoDiez = new Boleto("S10", "Caribbean Airlines", "2021-06-06", "16:15", "Puerto Rico", 275860);

        alVentas.add(new Venta("E01", "2021-05-20", boletoUno.getPrecio(), pasajeroUno, boletoUno));
        alVentas.add(new Venta("E02", "2021-05-21", boletoDos.getPrecio(), pasajeroDos, boletoDos));
        alVentas.add(new Venta("E03", "2021-05-22", boletoTres.getPrecio(), pasajeroTres, boletoTres));
        alVentas.add(new Venta("E04", "2021-05-23", boletoCuatro.getPrecio(), pasajeroCuatro, boletoCuatro));
        alVentas.add(new Venta("E05", "2021-05-24", boletoCinco.getPrecio(), pasajeroCinco, boletoCinco));
        alVentas.add(new Venta("E06", "2021-05-25", boletoSeis.getPrecio(), pasajeroSeis, boletoSeis));
        alVentas.add(new Venta("E07", "2021-05-26", boletoSiete.getPrecio(), pasajeroSiete, boletoSiete));
        alVentas.add(new Venta("E08", "2021-05-27", boletoOcho.getPrecio(), pasajeroOcho, boletoOcho));
        alVentas.add(new Venta("E09", "2021-05-28", boletoNueve.getPrecio(), pasajeroNueve, boletoNueve));
        alVentas.add(new Venta("E10", "2021-05-29", boletoDiez.getPrecio(), pasajeroDiez, boletoDiez));
        sw = 1;
    }
*/
}
