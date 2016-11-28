/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee_t05_organigrama;

/**
 *
 * @author angel
 */
public class ArbolBinario {
    private Nodo raiz;
    private int num_nodos;
    private int alt;

    public ArbolBinario() {
        raiz = null;
        num_nodos = 0;
        alt = 0;
    }

    //Metodo para insertar un dato en el arbol...no acepta repetidos :)
    public void insertar(String dato) {
        if (existe(dato)) {
            return;
        }
        Nodo nuevo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo anterior = null;
            Nodo tmp = raiz;
            while (tmp != null) {
                anterior = tmp;
                if (dato.compareToIgnoreCase( tmp.getDato())<0) {
                    tmp = tmp.getIzq();
                } else {
                    tmp = tmp.getDer();
                }
            }
            if (dato.compareToIgnoreCase(anterior.getDato())<0) {
                anterior.setIzq(nuevo);
            } else {
                anterior.setDer(nuevo);
            }
        }
        num_nodos++;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getNumNodos() {
        return num_nodos;
    }

    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(String dato) {
        Nodo aux = raiz;
        while (aux != null) {
            if (dato.compareToIgnoreCase(aux.getDato())==0) {
                return true;
            } else {
                if (dato.compareToIgnoreCase(aux.getDato()) > 0) {
                    aux = aux.getDer();
                } else {
                    aux = aux.getIzq();
                }
            }
        }
        return false;
    }

    private void altura(Nodo aux, int nivel) {
        if (aux != null) {
            altura(aux.getIzq(), nivel + 1);
            alt = nivel;
            altura(aux.getDer(), nivel + 1);
        }
    }

    //Devuleve la altura del arbol
    public int getAltura() {
        altura(raiz, 1);
        return alt;
    }
}
