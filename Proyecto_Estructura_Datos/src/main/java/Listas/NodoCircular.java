/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

import Modelo.Usuario;

public class NodoCircular {

    private Usuario dato;
    private NodoCircular siguiente;

    public NodoCircular(Usuario dato) {
        this.dato = dato;
        this.siguiente = this;
    }

    public Usuario getDato() {
        return dato;
    }

    public NodoCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircular siguiente) {
        this.siguiente = siguiente;
    }
            
}
