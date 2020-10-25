/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura_Arbol_B;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Oscar
 */
public class ArbolB<T extends Comparable<T>, V> {

    private int k; //Grado de Arbol
    private Page raiz;
    private int numeroNodo;

    public Page getRaiz() {
        return this.raiz;
    }

    public ArbolB(int k) {
        this.k = k;
        this.raiz = new Page(k);
    }

    public void insertar(T llave, V valor) {
        Key newKey = new Key(llave, valor);
        if (this.raiz.get(0) == null) {
            this.raiz.put(0, newKey);
        } else if (this.raiz.get(0).getIzquierda() == null) {
            int lugarInsertado = -1;
            Page node = this.raiz;

            for (int i = 0; i < k; i++) {
                if (node.get(i) == null) {
                    //node.put(i, newKey);
                    //lugarInsertado = i;
                    lugarInsertado = colocarNodo(this.raiz, newKey);
                }
                if (lugarInsertado != -1) {
                    if (lugarInsertado == k - 1) {
                        int middle = node.getMax() / 2;
                        Key llaveCentral = node.get(middle);
                        Page derecho = new Page(k);
                        Page izquierdo = new Page(k);
                        int indiceIzquierdo = 0;
                        int indiceDerecho = 0;

                        for (int j = 0; j < node.getMax(); j++) {
                            if (node.get(j).compareTo(llaveCentral.getKey()) < 0) {
                                izquierdo.put(indiceIzquierdo, node.get(j));
                                indiceIzquierdo++;
                                node.put(j, null);
                            } else if (node.get(j).compareTo(llaveCentral.getKey()) > 0) {
                                derecho.put(indiceDerecho, node.get(j));
                                indiceDerecho++;
                                node.put(j, null);
                            }
                        }
                        node.put(middle, null);
                        this.raiz = node;
                        this.raiz.put(0, llaveCentral);
                        izquierdo.setPaginaPadre(this.raiz);
                        derecho.setPaginaPadre(this.raiz);
                        llaveCentral.setIzquierda(izquierdo);
                        llaveCentral.setDerecha(derecho);
                        break;
                    } else {
                        break;
                    }
                }
            }
        } else if (this.raiz.get(0).getIzquierda() != null) {
            Page node = this.raiz;
            while (node.get(0).getIzquierda() != null) {
                int loop = 0;
                for (int i = 0; i < node.getMax(); i++) {
                    if (node.get(i) != null) {
                        if (node.get(i).compareTo(newKey.getKey()) > 0) {
                            node = node.get(i).getIzquierda();
                            break;
                        }
                    } else {
                        node = node.get(i - 1).getDerecha();
                        break;
                    }
                }
                if (loop == node.getMax()) {
                    node = node.get(loop - 1).getDerecha();
                }
            }
            int indiceColocado = colocarNodo(node, newKey);
            if (indiceColocado == k - 1) {
                while (node.getPaginaPadre() != null) {
                    int indiceMedio = node.getMax() / 2;
                    Key llaveCentral = node.get(indiceMedio);
                    Page izquierdo = new Page(k);
                    Page derecho = new Page(k);
                    int indiceIzquierdo = 0, indiceDerecho = 0;
                    for (int i = 0; i < k; i++) {
                        if (node.get(i).compareTo(llaveCentral.getKey()) < 0) {
                            izquierdo.put(indiceIzquierdo, node.get(i));
                            indiceIzquierdo++;
                            node.put(i, null);
                        } else if (node.get(i).compareTo(llaveCentral.getKey()) > 0) {
                            derecho.put(indiceDerecho, node.get(i));
                            indiceDerecho++;
                            node.put(i, null);
                        }
                    }
                    node.put(indiceMedio, null);
                    llaveCentral.setIzquierda(izquierdo);
                    llaveCentral.setDerecha(derecho);
                    node = node.getPaginaPadre();
                    izquierdo.setPaginaPadre(node);
                    derecho.setPaginaPadre(node);

                    for (int i = 0; i < k; i++) {
                        if (izquierdo.get(i) != null) {
                            if (izquierdo.get(i).getIzquierda() != null) {
                                izquierdo.get(i).getIzquierda().setPaginaPadre(izquierdo);

                            }
                            if (izquierdo.get(i).getDerecha() != null) {
                                izquierdo.get(i).getDerecha().setPaginaPadre(izquierdo);
                            }
                        }
                    }
                    for (int i = 0; i < k; i++) {
                        if (derecho.get(i) != null) {
                            if (derecho.get(i).getIzquierda() != null) {
                                derecho.get(i).getIzquierda().setPaginaPadre(derecho);
                            }
                            if (derecho.get(i).getDerecha() != null) {
                                derecho.get(i).getDerecha().setPaginaPadre(derecho);
                            }
                        }
                    }
                    int lugarColocado = colocarNodo(node, llaveCentral);
                    if (lugarColocado == k - 1) {
                        if (node.getPaginaPadre() == null) {
                            int indiceCentralRaiz = k / 2;
                            Key llaveCentralRaiz = node.get(indiceCentralRaiz);
                            Page izquierdoRaiz = new Page(k);
                            Page derechaRaiz = new Page(k);
                            int indiceDerechoRaiz = 0, indiceIzquierdoRaiz = 0;
                            for (int i = 0; i < k; i++) {
                                if (node.get(i).compareTo(llaveCentralRaiz.getKey()) < 0) {
                                    izquierdoRaiz.put(indiceIzquierdoRaiz, node.get(i));
                                    indiceIzquierdoRaiz++;
                                    node.put(i, null);
                                } else if (node.get(i).compareTo(llaveCentralRaiz.getKey()) > 0) {
                                    derechaRaiz.put(indiceDerechoRaiz, node.get(i));
                                    indiceDerechoRaiz++;
                                    node.put(i, null);
                                }
                            }
                            node.put(indiceCentralRaiz, null);
                            node.put(0, llaveCentralRaiz);
                            for (int i = 0; i < k; i++) {
                                if (izquierdoRaiz.get(i) != null) {
                                    izquierdoRaiz.get(i).getIzquierda().setPaginaPadre(izquierdoRaiz);
                                    izquierdoRaiz.get(i).getDerecha().setPaginaPadre(izquierdoRaiz);
                                }
                            }
                            for (int i = 0; i < k; i++) {
                                if (derechaRaiz.get(i) != null) {
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

    public Usuario encontrarUsuarioJson(int id, Page pagina) {
        Usuario actual = null;

        Page paginaActual = pagina;
        Key[] llaves = paginaActual.getLlaves();
        int[] arrayValores = llenarArray(llaves);
        int numeroPaginaActual = this.numeroNodo;

        for (int i = 0; i < k; i++) {
            Key llaveActual = llaves[i];

            if (llaveActual != null && llaveActual.getKey().compareTo(id) > 0) {
                if (llaveActual.getDerecha() != null) {

                    actual = encontrarUsuarioJson(id, llaveActual.getDerecha());
                    return actual;
                }
            } else if (llaveActual != null && llaveActual.getKey().compareTo(id) < 0) {
                if (llaveActual.getIzquierda() != null) {

                    actual = encontrarUsuarioJson(id, llaveActual.getIzquierda());
                    return actual;
                }
            } else if (llaveActual != null && llaveActual.getKey().compareTo(id) == 0) {
                actual = (Usuario) llaveActual.getValor();
                return actual;
            }
        }

        if (actual != null) {
            System.out.println(actual.getNombre());
        } else {
            System.out.println("null, not found");
        }
        return actual;

    }

    public Usuario encontrarUsuario(String nombreUsuario, Page pagina) {
        Usuario actual = null;

        Page paginaActual = pagina;
        Key[] llaves = paginaActual.getLlaves();
        //int[] arrayValores = llenarArray(llaves);

        for (int i = 0; i < k; i++) {
            Key llaveActual = llaves[i];
            if (llaveActual != null) {
                actual = (Usuario) llaveActual.getValor();
                String nombreUsuarioActual = actual.getUsuario();

                if (nombreUsuarioActual.equals(nombreUsuario)) {
                    return actual;
                } else if (llaveActual.getDerecha() != null) {
                    actual = encontrarUsuario(nombreUsuario, llaveActual.getDerecha());
                    return actual;
                } else if (llaveActual.getIzquierda() != null) {
                    actual = encontrarUsuario(nombreUsuario, llaveActual.getIzquierda());
                    return actual;
                }
            }
        }

        return actual;
    }

    private int colocarNodo(Page node, Key newKey) {
        int index = -1;
        for (int i = 0; i < k; i++) {
            if (node.get(i) == null) {
                boolean placed = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (node.get(j).compareTo(newKey.getKey()) > 0) {
                        node.put(j + 1, node.get(j));
                    } else {
                        node.put(j + 1, newKey);
                        node.get(j).setDerecha(newKey.getIzquierda());
                        if (j + 2 < k && node.get(j + 2) != null) {
                            node.get(j + 2).setIzquierda(newKey.getDerecha());
                        }
                        placed = true;
                        break;
                    }
                }
                if (placed == false) {
                    node.put(0, newKey);
                    node.get(1).setIzquierda(newKey.getDerecha());
                }
                index = i;
                break;
            }
        }
        return index;
    }

    public void imprimirArbol(Page pagina, int numeroPagina) {
        Key[] llaves = pagina.getLlaves();

        for (int i = 0; i < 5; i++) {
            if (llaves[i] != null) {
                System.out.println(llaves[i].getValor());
            }
        }
    }

    public void graficarArbol(String nombre) {
        this.numeroNodo = 0;
        int numeroPagina = this.numeroNodo;

        try {
            FileWriter myWriter = new FileWriter("graficas\\arbol" + nombre + ".gv");
            myWriter.write("digraph g {" + "\n");
            myWriter.write("splines = false;\n");
            myWriter.write("node [shape = record,height=.1]; \n");

            graficarPaginas(myWriter, this.raiz, numeroPagina);

            myWriter.write("}");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "dot -Tpdf graficas\\arbol" + nombre + ".gv -o graficas\\arbol" + nombre + ".pdf");
            ProcessBuilder builder2 = new ProcessBuilder("cmd.exe", "/c", "graficas\\arbol" + nombre + ".pdf");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            Process open = builder2.start();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int getLastIndex(Page pagina) {
        int lastIndex = 0;
        Usuario actual;

        Page paginaActual = pagina;
        Key[] llaves = paginaActual.getLlaves();

        for (int i = 0; i < k; i++) {
            Key llaveActual = llaves[i];
            Key llaveSiguiente=null;
            
            if (i != k - 1) {
                llaveSiguiente = llaves[i + 1];
            }

            if ((llaveSiguiente == null || i == k - 1) && llaveActual != ull) {
                actual = (Usuario) llaveActual.getValor();
                lastIndex = actual.getId();
                if (llaveActual.getDerecha() != null) {
                    lastIndex = getLastIndex(llaveActual.getDerecha());
                    return lastIndex;
                }
            }
        }
        return lastIndex;
    }

    private void graficarPaginas(FileWriter myWriter, Page pagina, int numeroPagina) {

        Page paginaActual = pagina;
        Key[] llaves = paginaActual.getLlaves();
        int[] arrayValores = llenarArray(llaves);
        int numeroPaginaActual = this.numeroNodo;

        try {
            myWriter.write("node" + numeroPagina + "[label = "
                    + "\"<f01> | <f1>" + arrayValores[0] + "| <f12> |"
                    + "<f2>" + arrayValores[1] + "| <f23> |"
                    + "<f3>" + arrayValores[2] + "| <f34> |"
                    + "<f4>" + arrayValores[3] + "| <f45> |"
                    + "<f5>" + arrayValores[4] + "| <f50>"
                    + "\"]; \n");

            if (llaves[0] != null && llaves[0].getIzquierda() != null) {
                int numeroPaginaSigueinte = numeroPaginaActual + 1;

                myWriter.write("\"node" + numeroPaginaActual + "\":" + claveSwitchIzquierda(0) + " -> \"node" + numeroPaginaSigueinte + "\":" + "f1" + "; \n");
                this.numeroNodo = this.numeroNodo + +1;

                graficarPaginas(myWriter, llaves[0].getIzquierda(), this.numeroNodo);
            }

            for (int i = 0; i < k; i++) {
                Key llaveActual = llaves[i];
                if (llaveActual != null) {
                    if (llaveActual.getDerecha() != null) {
                        int numeroPaginaSigueinte = this.numeroNodo + 1;

                        myWriter.write("\"node" + numeroPaginaActual + "\":" + claveSwitchDerecha(i) + " -> \"node" + numeroPaginaSigueinte + "\":" + "f1" + "; \n");
                        this.numeroNodo = this.numeroNodo + +1;

                        graficarPaginas(myWriter, llaveActual.getDerecha(), this.numeroNodo);
                    }
                }
            }
            System.out.println("Successfully wrote page.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void agregarPrimerIzquierdo(FileWriter myWriter, Page pagina, int numeroPagina) {
        Page paginaActual = pagina;
        Key[] llaves = paginaActual.getLlaves();
        int[] arrayValores = llenarArray(llaves);
        int numeroPaginaActual = numeroPagina;

    }

    private int[] llenarArray(Key[] llaves) {

        int[] arrayValores = new int[5];

        for (int i = 0; i < llaves.length; i++) {
            if (llaves[i] == null) {
                arrayValores[i] = -1;
            } else {
                arrayValores[i] = (int) llaves[i].getKey();
            }
        }

        return arrayValores;
    }

    private String claveSwitchIzquierda(int posArray) {
        String codigo = "";
        switch (posArray) {
            case 0:
                codigo = "f01";
                break;
            case 1:
                codigo = "f12";
                break;
            case 2:
                codigo = "f23";
                break;
            case 3:
                codigo = "f34";
                break;
            case 4:
                codigo = "f45";
                break;
        }
        return codigo;
    }

    private String claveSwitchDerecha(int posArray) {
        String codigo = "";
        switch (posArray) {
            case 0:
                codigo = "f12";
                break;
            case 1:
                codigo = "f23";
                break;
            case 2:
                codigo = "f34";
                break;
            case 3:
                codigo = "f45";
                break;
            case 4:
                codigo = "f50";
                break;
        }
        return codigo;
    }

}
