/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura_Tabla_Hash;

/**
 *
 * @author Oscar
 */
public class NodeLugar {

    private int id;
    private String categoria;
    private String nombre;
    private double lat;
    private double lon;
    private int ascii;

    public NodeLugar(int id, String categoria, String nombre, double lat, double lon) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.lat = lat;
        this.lon = lon;
        this.ascii = ascii(nombre);
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
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return the lon
     */
    public double getLon() {
        return lon;
    }

    /**
     * @param lon the lon to set
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getAscii() {
        return this.ascii;
    }

    public void setAscii() {
        this.ascii = ascii(this.nombre);
    }

    public int ascii(String nombre) {
        int valorAscii = 0;
        
        char[] letters = nombre.toCharArray();
        for (char ch : letters){
            valorAscii =+ (byte) ch;
        }
        System.out.println(valorAscii);
        return valorAscii;
    }

}
