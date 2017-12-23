package Datos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Cliente {
    String nombrecliente, direccion, cedula,telefono;
    
    public Cliente(String cedula,String nombrecliente,String direccion, String telefono){
        this.cedula=cedula;
        this.nombrecliente= nombrecliente;
        this.direccion=direccion;
        this.telefono=telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String toString(){
        String message = "Cedula : " +getCedula()+" - Nombre Cliente: "+getNombrecliente()+" - Direccion: "+getDireccion()+" - Telefono: "+getTelefono();       
        return message;   
    }
    
    
    
}
