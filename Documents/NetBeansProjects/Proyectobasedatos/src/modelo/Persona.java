/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Diego
 */
abstract class Persona {
    
    private String dpi, nombre1, nombre2, apellido1, apellido2, direccion, telcasa, telmovil, salariobase, bonificacion;

    public Persona(){}
    
    public Persona(String dpi, String nombre1, String nombre2, String apellido1, String apellido2, String direccion, String telcasa, String telmovil, String salariobase, String bonificacion) {
        this.dpi = dpi;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telcasa = telcasa;
        this.telmovil = telmovil;
        this.salariobase = salariobase;
        this.bonificacion = bonificacion;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelcasa() {
        return telcasa;
    }

    public void setTelcasa(String telcasa) {
        this.telcasa = telcasa;
    }

    public String getTelmovil() {
        return telmovil;
    }

    public void setTelmovil(String telmovil) {
        this.telmovil = telmovil;
    }

    public String getSalariobase() {
        return salariobase;
    }

    public void setSalariobase(String salariobase) {
        this.salariobase = salariobase;
    }

    public String getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(String bonificacion) {
        this.bonificacion = bonificacion;
    }
    
    
    protected void agregar(){}
    protected void actualizar(){}
    protected void eliminar(){}
 
    
    
}
