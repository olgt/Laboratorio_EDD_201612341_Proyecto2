/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura_Arbol_B;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Oscar
 */
public class Viaje {
    
    private int id;
    private String nombreInicio;
    private String nombreFinal;
    private LocalDate fecha;
    
    public Viaje(int id, String nombreInicio, String nombreFinal, LocalDate fecha){
        this.fecha = fecha;
        this.id = id;
        this.nombreFinal = nombreFinal;
        this.nombreInicio = nombreInicio;
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
     * @return the nombreInicio
     */
    public String getNombreInicio() {
        return nombreInicio;
    }

    /**
     * @param nombreInicio the nombreInicio to set
     */
    public void setNombreInicio(String nombreInicio) {
        this.nombreInicio = nombreInicio;
    }

    /**
     * @return the nombreFinal
     */
    public String getNombreFinal() {
        return nombreFinal;
    }

    /**
     * @param nombreFinal the nombreFinal to set
     */
    public void setNombreFinal(String nombreFinal) {
        this.nombreFinal = nombreFinal;
    }

    /**
     * @return the fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }    

    
}
