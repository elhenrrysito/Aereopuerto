/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author henrry
 */
public class Venta {
    private String codigo;
    private String fecha;
    private int total;
    private Pasajero pasajero;
    private Boleto boleto;

    public Venta() {
    }

    public Venta(String codigo, String fecha, int total, Pasajero pasajero, Boleto boleto) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
        this.pasajero = pasajero;
        this.boleto = boleto;
    }

 
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    @Override
    public String toString() {
        return "Venta{" + "codigo=" + codigo + ", fecha=" + fecha + ", total=" + total + ", pasajero=" + pasajero + ", boleto=" + boleto + '}';
    }

 
    
  
    
    
}
