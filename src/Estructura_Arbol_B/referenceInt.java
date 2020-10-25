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
public class referenceInt {
    public Integer value; 
  
    referenceInt(Integer value) 
    { 
  
        // Using wrapper class 
        // so as to wrap integer value 
        // in mutable object 
        // which can be changed or modified 
        this.value = value; 
    } 
  
    @Override
    public String toString() 
    { 
        return String.valueOf(value); 
    } 
}
