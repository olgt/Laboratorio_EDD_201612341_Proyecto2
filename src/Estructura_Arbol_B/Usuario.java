/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura_Arbol_B;

public class Usuario {

    private int id;
    private String nombre;
    private String usuario;
    private String correo;
    private String contraseña;
    private String telefono;
    private String rol;
    private String lugarActual;
    private boolean disponible;
    private ArbolB viajes;
    private ArbolB facturas;

    
    public Usuario(int id, String nombre, String usuario, String correo, String contraseña, String telefono, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.rol = rol;
        this.disponible = true;
        viajes = new ArbolB(5);
        facturas = new ArbolB(5);
    }
    
    public ArbolB getFacturas(){
        return this.facturas;
    }            
    
    public ArbolB getViajes(){
        return this.viajes;
    }            
        /**
     * @return the lugarActual
     */
    public String getLugarActual() {
        return lugarActual;
    }

    /**
     * @param lugarActual the lugarActual to set
     */
    public void setLugarActual(String lugarActual) {
        this.lugarActual = lugarActual;
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean getDisponible(){
        return this.disponible;
    }
    
    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }
}
