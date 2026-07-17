/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

import Modelo.Reserva;

public class ColaDinamica {

    private NodoCola frente;
    private NodoCola fin;

    public ColaDinamica() {
        frente = null;
        fin = null;
    }

    // ENQUEUE
    public void enqueue(Reserva reserva) {

        NodoCola nuevo = new NodoCola(reserva);

        if (fin == null) {
            frente = fin = nuevo;
            return;
        }

        fin.setSiguiente(nuevo);
        fin = nuevo;
    }

    // DEQUEUE
    public Reserva dequeue() {

        if (frente == null) {
            System.out.println("Cola vacía");
            return null;
        }

        Reserva dato = frente.getDato();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        return dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrar() {

        NodoCola actual = frente;

        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }
}