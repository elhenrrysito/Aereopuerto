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
public class Boleto {
    private int id;
    private String numeroVuelo;
    private String aereolinea;
    private String fechaVuelo;
    private String horaVuelo;
    private String destino;
    private int precio;

    public Boleto() {
    }

    public Boleto(String numeroVuelo, String aereolinea, String fechaVuelo, String horaVuelo, String destino, int precio) {
        this.numeroVuelo = numeroVuelo;
        this.aereolinea = aereolinea;
        this.fechaVuelo = fechaVuelo;
        this.horaVuelo = horaVuelo;
        this.destino = destino;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getAereolinea() {
        return aereolinea;
    }

    public void setAereolinea(String aereolinea) {
        this.aereolinea = aereolinea;
    }

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public String getHoraVuelo() {
        return horaVuelo;
    }

    public void setHoraVuelo(String horaVuelo) {
        this.horaVuelo = horaVuelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Boleto{" + "numeroVuelo=" + numeroVuelo + ", aereolinea=" + aereolinea + ", fechaVuelo=" + fechaVuelo + ", horaVuelo=" + horaVuelo + ", destino=" + destino + ", precio=" + precio + '}';
    }
 
    
}
  