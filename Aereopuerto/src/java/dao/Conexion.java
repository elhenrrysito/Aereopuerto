/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author henrr
 */
public class Conexion {
     public Connection con;
    public Statement state;
    private String jbdc = "jdbc:mysql://localhost:3306/aereopuerto?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private String username = "admin";
    private String password = "Zxcvbnm,";
    
//creamos metodo para conectarnos a la BBDD
    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(jbdc, username, password);
            state = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
     public  int ultimoId(String tabla) throws SQLException {
        conectar();
        int ultimoId=0;
        ResultSet result = state.executeQuery("SELECT id FROM " + tabla + " order by id desc limit 1;");
        
         while (result.next()) {
            ultimoId = (int) result.getObject(1);
        }
        return ultimoId;
    }
}
