/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;
import Modelo.Prestamo;

public class NodoSimple {

    private Prestamo dato;
    private NodoSimple siguiente;

    public NodoSimple(Prestamo dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Prestamo getDato() {
        return dato;
    }

    public void setDato(Prestamo dato) {
        this.dato = dato;
    }

    public NodoSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple siguiente) {
        this.siguiente = siguiente;
    }
}