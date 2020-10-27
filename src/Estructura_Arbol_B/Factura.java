/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura_Arbol_B;

/**
 *
 * @author Oscar
 */

import java.util.Date;

public class Factura{
    private int id;
    private int id_usuario;
    private int id_conductor;
    private int id_viaje;
    private Date fecha;
    private double monto;

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
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the id_conductor
     */
    public int getId_conductor() {
        return id_conductor;
    }

    /**
     * @param id_conductor the id_conductor to set
     */
    public void setId_conductor(int id_conductor) {
        this.id_conductor = id_conductor;
    }

    /**
     * @return the id_viaje
     */
    public int getId_viaje() {
        return id_viaje;
    }

    /**
     * @param id_viaje the id_viaje to set
     */
    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }
}
