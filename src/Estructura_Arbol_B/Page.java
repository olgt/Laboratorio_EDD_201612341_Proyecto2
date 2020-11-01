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
public class Page {
    private int max;
    private Page paginaPadre;
    private Key[] llaves;
    
    public Page(int max){
        this.max = max;
        this.llaves = new Key[max];
        paginaPadre = null;
    }
    
    public void put(int i, Key llave){
        this.llaves[i]=llave;
    }
    
    public Key get(int i){
        return this.llaves[i];
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the paginaPadre
     */
    public Page getPaginaPadre() {
        return paginaPadre;
    }

    /**
     * @param paginaPadre the paginaPadre to set
     */
    public void setPaginaPadre(Page paginaPadre) {
        this.paginaPadre = paginaPadre;
    }

    /**
     * @return the llaves
     */
    public Key[] getLlaves() {
        return llaves;
    }

    /**
     * @param llaves the llaves to set
     */
    public void setLlaves(Key[] llaves) {
        this.llaves = llaves;
    }
     
}
