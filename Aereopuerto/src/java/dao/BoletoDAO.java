/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Boleto;

/**
 *
 * @author henrr
 */
public class BoletoDAO extends Conexion {
    
    private static ArrayList<Boleto> alBoletos = new ArrayList<>();
    private static int sw = 0;

    public BoletoDAO() {
        super();
    }
    
    public boolean insertar(Boleto boleto) {
        boolean estado = false;
        
        try {
            super.conectar();
            
            int id = super.ultimoId("boletos");
            id++;
            int filas = super.state.executeUpdate("INSERT INTO boletos VALUES ("+id+", '" + boleto.getNumeroVuelo()
                    + "', '" + boleto.getAereolinea() + "', '" + boleto.getFechaVuelo() 
                    + "', '" + boleto.getHoraVuelo() + "', '" + boleto.getDestino() + "', " + boleto.getPrecio() + ");");
            con.close();
            if(filas>0) {
                estado = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return estado;
    }

    public Boleto buscar(int id) throws SQLException {
        super.conectar();
        Boleto boleto = new Boleto();
        
        ResultSet result = state.executeQuery("SELECT * FROM boletos where id='" + id + "';");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        while(result.next()) {
           boleto.setId((int) result.getObject(1));
            boleto.setNumeroVuelo((String) result.getObject(2));
            boleto.setAereolinea((String) result.getObject(3));
            
            String strDate = dateFormat.format((Date) result.getObject(4));
            boleto.setFechaVuelo(strDate);
            String strTime = timeFormat.format((Date) result.getObject(5));
            boleto.setHoraVuelo(strTime);
            boleto.setDestino((String) result.getObject(6));
            boleto.setPrecio((int) result.getObject(7));
        }
        return boleto;
    }
    
    public ArrayList<Boleto> listarBoletos() throws SQLException, Exception {
        super.conectar();
        ResultSet result = state.executeQuery("SELECT * FROM boletos");
        ArrayList<Boleto> boletos = new ArrayList<Boleto>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        
        while(result.next()) {
            Boleto boleto = new Boleto();
            boleto.setId((int) result.getObject(1));
            boleto.setNumeroVuelo((String) result.getObject(2));
            boleto.setAereolinea((String) result.getObject(3));
            
            String strDate = dateFormat.format((Date) result.getObject(4));
            boleto.setFechaVuelo(strDate);
            String strTime = timeFormat.format((Date) result.getObject(5));
            boleto.setHoraVuelo(strTime);
            boleto.setDestino((String) result.getObject(6));
            boleto.setPrecio((int) result.getObject(7));
            
            boletos.add(boleto);
        }
        return boletos;
    }
    
    public boolean modificar(Boleto boleto) {
        boolean estado = false;
        try {
            super.conectar();
            int filas = super.state.executeUpdate("UPDATE boletos set numero_vuelo='" + boleto.getNumeroVuelo() 
                    + "', aereolinea= '" + boleto.getAereolinea() + "', fecha_vuelo='" + boleto.getFechaVuelo() 
                    + "', hora_vuelo='" + boleto.getHoraVuelo() + "', destino='" + boleto.getDestino() 
                    + "', precio=" + boleto.getPrecio() + " where id=" + boleto.getId() + ";");
            if(filas > 0) {
                estado = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return estado;
    }
    
    public boolean eliminar(int id) {
        boolean estado = false;
        
        try {
            super.conectar();
            int filas = state.executeUpdate("DELETE FROM boletos where id=" + id + ";");
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
    // Grabar boleto
    public static boolean grabar(Boleto boleto) {
        boolean estado = false;
        if (boleto != null && buscar(boleto.getNumeroVuelo()) == null) {
            alBoletos.add(boleto);
            estado = true;
        }
        return estado;
    }
    
    // Buscar boleto
    public static Boleto buscar(String numeroVuelo) {
        Boleto objeto = null;

        for (Boleto boleto : alBoletos) {
            if (numeroVuelo.equals(boleto.getNumeroVuelo())) {
                objeto = boleto;
                break;
            }
        }
        return objeto;
    }
    
    // Eliminar Boletos
    public static boolean eliminar(String numeroVuelo) {
        boolean estado = false;

        for (Boleto boleto : alBoletos) {
            if (numeroVuelo.equals(boleto.getNumeroVuelo())) {
                alBoletos.remove(boleto);
                estado = true;
                break;
            }
        }
        return estado;
    }
    
    // Modificar boletos
    public static boolean modificar(Boleto boleto) {
        boolean estado = false;
        int i = 0;

        for (Boleto obj : alBoletos) {
            if (boleto.getNumeroVuelo().equals(obj.getNumeroVuelo())) {
                alBoletos.set(i, boleto);
                estado = true;
                break;
            }
        }
        return estado;
    } 
    
     // Listar
    public static ArrayList<Boleto> obtenerDatos() {
        return alBoletos;
    }
    
    public static void llenar() {
        alBoletos.add(new Boleto("E01", "AirFrance", "2021-12-12", "11:00", "Francia", 250000));
        alBoletos.add(new Boleto("H02", "Emirates", "2022-05-01", "17:00", "Dubai", 1100000));
        alBoletos.add(new Boleto("K03", "CanadaFly", "2021-06-08", "03:00", "Canada", 180000));
        alBoletos.add(new Boleto("L04", "LatamAir", "2021-09-05", "16:00", "Mexico", 120000));
        alBoletos.add(new Boleto("P05", "FlyFine", "2021-11-18", "18:30", "Belgica", 273500));
        alBoletos.add(new Boleto("X06", "American Airlines", "2021-12-18", "13:30", "Colombia", 125000));
        alBoletos.add(new Boleto("A07", "Copa Airlines", "2021-09-12", "07:00", "Estados Unidos", 244350));
        alBoletos.add(new Boleto("T08", "Avianca", "2021-10-01", "06:30", "Japon", 780000));
        alBoletos.add(new Boleto("F09", "Air Berlin", "2021-12-22", "08:00", "Alemania", 750000));
        alBoletos.add(new Boleto("S10", "Caribbean Airlines", "2021-06-06", "16:15", "Puerto Rico", 275860));
        alBoletos.add(new Boleto("O11", "China Southern Airlines", "2021-07-20", "17:35", "China", 854300));
        alBoletos.add(new Boleto("Y11", "Ryanair", "2021-10-18", "18:45", "Irlanda", 570543));
        alBoletos.add(new Boleto("G12", "Air India", "2021-07-06", "04:00", "India", 784320));
        alBoletos.add(new Boleto("L13", "Air Panamá", "2021-08-22", "05:35", "Panamá", 312000));
        alBoletos.add(new Boleto("K14", "British Airways", "2021-10-14", "23:55", "Reino Unido", 480000));
        alBoletos.add(new Boleto("V15", "Brussels Airways", "2021-11-24", "20:47", "Tailandia", 632000));
        sw=1;
    }
*/
}
