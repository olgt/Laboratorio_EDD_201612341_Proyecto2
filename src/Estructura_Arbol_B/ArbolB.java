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
public class ArbolB<T extends Comparable<T>, V> {
    private int k; //Grado de Arbol
    private Page raiz;

    public ArbolB(int k) {
        this.k = k;
        this.raiz = new Page(k);
    }
    
    public void insertar(T llave, V valor){
        Key newKey = new Key(llave, valor);
        
        if(this.raiz.get(0) == null){
            this.raiz.put(0, newKey);
        } 
        else if(this.raiz.get(0).getIzquierda() == null){
            
            int lugarInsertado = -1;
            Page node = this.raiz;
            
            for(int i = 0; i< k; i++){
                if(node.get(i)==null){
                    node.put(i, newKey);
                    lugarInsertado = i;
                }
                if(lugarInsertado != -1){
                    if(lugarInsertado==k-1){
                        int middle=node.getMax() / 2;
                        Key llaveCentral = node.get(middle);
                        Page derecho = new Page(k);
                        Page izquierdo = new Page(k);
                        int indiceIzquierdo = 0;  int indiceDerecho = 0;
                        
                        for(int j = 0; j < node.getMax(); j++){
                            if(node.get(j).compareTo(llaveCentral.getKey())<0){
                                izquierdo.put(indiceIzquierdo, node.get(j));
                                indiceIzquierdo++;
                                node.put(j,null);
                            } else if(node.get(j).compareTo(llaveCentral.getKey())>0){
                                derecho.put(indiceDerecho,node.get(j));
                                indiceDerecho++;
                                node.put(j,null);
                            }
                        }
                        node.put(middle,null);
                        this.raiz=node;
                        this.raiz.put(0, llaveCentral);
                        izquierdo.setPaginaPadre(this.raiz);
                        derecho.setPaginaPadre(this.raiz);
                        llaveCentral.setIzquierda(izquierdo);
                        llaveCentral.setDerecha(derecho);
                        break;
                    } else{
                        break;
                    }
                }
            }
        } else if(this.raiz.get(0).getIzquierda()!=null){
            Page node = this.raiz;
            while(node.get(0).getIzquierda() != null){
                int loop = 0;
                for(int i = 0; i < node.getMax(); i++){
                    if(node.get(i)!=null){
                        if(node.get(i).compareTo(newKey.getKey())>0){
                            node = node.get(i).getIzquierda();
                            break;
                        }
                    } else {
                        node = node.get(i-1).getDerecha();
                        break;
                    }
                }
                if(loop==node.getMax()){
                    node=node.get(loop-1).getDerecha();
                }
            }
            int indiceColocado = colocarNodo(node, newKey);
            if(indiceColocado == k-1){
                while(node.getPaginaPadre()!=null){
                    int indiceMedio = node.getMax()/2;
                    Key llaveCentral = node.get(indiceMedio);
                    Page izquierdo = new Page(k);
                    Page derecho = new Page(k);
                    int indiceIzquierdo = 0, indiceDerecho = 0;
                    for(int i = 0; i<k; i++){
                        if(node.get(i).compareTo(llaveCentral.getKey())<0){
                            izquierdo.put(indiceIzquierdo, node.get(i));
                            indiceIzquierdo++;
                            node.put(i,null);
                        } else if(node.get(i).compareTo(llaveCentral.getKey())>0){
                            derecho.put(indiceDerecho,node.get(i));
                            indiceDerecho++;
                            node.put(i,null);
                        }
                    }
                    node.put(indiceMedio, null);
                    llaveCentral.setIzquierda(izquierdo);
                    llaveCentral.setDerecha(derecho);
                    node=node.getPaginaPadre();
                    izquierdo.setPaginaPadre(node);
                    derecho.setPaginaPadre(node);
                    
                    for(int i = 0; i<k; i++){
                        if(izquierdo.get(i)!=null){
                            if(izquierdo.get(i).getIzquierda()!=null){
                                izquierdo.get(i).getIzquierda().setPaginaPadre(izquierdo);
                                
                            }
                            if(izquierdo.get(i).getDerecha()!=null){
                                izquierdo.get(i).getDerecha().setPaginaPadre(izquierdo);
                            }
                        }
                    }
                    for(int i = 0; i< k; i++){
                        if(derecho.get(i)!=null){
                            if(derecho.get(i).getIzquierda()!=null){
                                derecho.get(i).getIzquierda().setPaginaPadre(derecho);
                            }
                            if(derecho.get(i).getDerecha()!=null){
                                derecho.get(i).getDerecha().setPaginaPadre(derecho);
                            }
                        }
                    }
                    int lugarColocado = colocarNodo(node, llaveCentral);
                    if(lugarColocado == k-1){
                        if(node.getPaginaPadre()==null){
                            int indiceCentralRaiz = k/2;
                            Key llaveCentralRaiz = node.get(indiceCentralRaiz);
                            Page izquierdoRaiz = new Page(k);
                            Page derechaRaiz = new Page(k);
                            int indiceDerechoRaiz=0, indiceIzquierdoRaiz = 0;
                            for(int i = 0; i<k; i++){
                                if(node.get(i).compareTo(llaveCentralRaiz.getKey())<0){
                                    izquierdoRaiz.put(indiceIzquierdoRaiz, node.get(i));
                                    indiceIzquierdo++;
                                    node.put(i,null);
                                } else if (node.get(i).compareTo(llaveCentralRaiz.getKey())>0){
                                    derechaRaiz.put(indiceDerechoRaiz, node.get(i));
                                    indiceDerechoRaiz++;
                                    node.put(i,null);
                                }
                            }
                            node.put(indiceCentralRaiz, null);
                            node.put(0,llaveCentralRaiz);
                            for(int i =0; i<k; i++){
                                if(izquierdoRaiz.get(i)!=null){
                                    izquierdoRaiz.get(i).getIzquierda().setPaginaPadre(izquierdoRaiz);
                                    izquierdoRaiz.get(i).getDerecha().setPaginaPadre(izquierdoRaiz);
                                }
                            }
                            for(int i = 0; i<k; i++){
                                if(derechaRaiz.get(i)!=null){
                                    derechaRaiz.get(i).getIzquierda().setPaginaPadre(derechaRaiz);
                                    derechaRaiz.get(i).getDerecha().setPaginaPadre(derechaRaiz);
                                }
                            }
                            llaveCentralRaiz.setIzquierda(izquierdoRaiz);
                            llaveCentralRaiz.setDerecha(derechaRaiz);
                            izquierdoRaiz.setPaginaPadre(node);
                            this.raiz = node;
                        }
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }
    }
    
    private int colocarNodo(Page node, Key newKey){
        int index = -1;
        for(int i = 0; i< k; i++){
            if(node.get(i) == null){
                boolean placed = false;
                for(int j = i-1; j>=0; j--){
                    if(node.get(j).compareTo(newKey.getKey())>0){
                        node.put(j+1, node.get(j));
                    }
                    else {
                        node.put(j+1, newKey);
                        node.get(j).setDerecha(newKey.getIzquierda());
                        if(j+2<k && node.get(j+2)!= null){
                            node.get(j+2).setIzquierda(newKey.getDerecha());
                        }
                        placed = true;
                        break;
                    }
                }
                if(placed ==false){
                    node.put(0, newKey);
                    node.get(1).setIzquierda(newKey.getDerecha());
                }
                index = i;
                break;
            }
        }
        return index;
    }   
}
        
