/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

import Modelo.Libro;

public class NodoPila {

    private Libro dato;
    private NodoPila siguiente;

    public NodoPila(Libro dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Libro getDato() {
        return dato;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
}