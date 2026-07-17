/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

import Modelo.Prestamo;

public class NodoDoble {

    private Prestamo dato;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    public NodoDoble(Prestamo dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Prestamo getDato() {
        return dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}