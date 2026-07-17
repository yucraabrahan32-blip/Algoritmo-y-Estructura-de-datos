/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

import Modelo.Reserva;

public class NodoCola {

    private Reserva dato;
    private NodoCola siguiente;

    public NodoCola(Reserva dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Reserva getDato() {
        return dato;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
}