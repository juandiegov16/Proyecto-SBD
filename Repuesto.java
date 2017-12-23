/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobasededatos;

/**
 *
 * @author Harold
 */
public class Repuesto {
    
    private String serial;
    private int cantidad;
    private String descripcion;
    private double valor;
    private String frecuenciaUso;
    
    public Repuesto(){
        
    }

    public Repuesto(String serial, int cantidad, String descripcion, double valor, String frecuenciaUso) {
        this.serial = serial;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.valor = valor;
        this.frecuenciaUso = frecuenciaUso;
    }
    
    

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFrecuenciaUso() {
        return frecuenciaUso;
    }

    public void setFrecuenciaUso(String frecuenciaUso) {
        this.frecuenciaUso = frecuenciaUso;
    }
    
    
    
}
