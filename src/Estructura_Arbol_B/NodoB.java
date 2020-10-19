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
public class NodoB {
    int[] claves; // An array of keys
    int orden; // Maximo numero de hijos
    NodoB[] hijos; // An array of child pointers
    int numeroClaves; // Current number of keys
    boolean leaf; // Is true when node is leaf. Otherwise false
 
    // Constructor
    NodoB(int orden, boolean leaf) {
        this.orden = orden;
        this.leaf = leaf;
        this.claves = new int[orden-1];
        this.hijos = new NodoB[orden];
        this.numeroClaves = 0;
    }
 
    // A function to traverse all nodes in a subtree rooted with this node
    public void traverse() {
 
        // There are n keys and n+1 children, travers through n keys
        // and first n children
        int i = 0;
        for (i = 0; i < this.numeroClaves; i++) {
 
            // If this is not leaf, then before printing key[i],
            // traverse the subtree rooted with child C[i].
            if (this.leaf == false) {
                hijos[i].traverse();
            }
            System.out.print(claves[i] + " ");
        }
 
        // Print the subtree rooted with last child
        if (leaf == false)
            hijos[i].traverse();
    }
 
    // A function to search a key in the subtree rooted with this node.
    NodoB search(int k) { // returns NULL if k is not present.
 
        // Find the first key greater than or equal to k
        int i = 0;
        while (i < numeroClaves && k > claves[i])
            i++;
 
        // If the found key is equal to k, return this node
        if (claves[i] == k)
            return this;
 
        // If the key is not found here and this is a leaf node
        if (leaf == true)
            return null;
 
        // Go to the appropriate child
        return hijos[i].search(k);
 
    }
}
