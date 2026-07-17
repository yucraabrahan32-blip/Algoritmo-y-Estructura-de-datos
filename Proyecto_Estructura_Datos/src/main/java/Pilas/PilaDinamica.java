/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

import Modelo.Libro;

public class PilaDinamica {

    private NodoPila cima;

    public PilaDinamica() {
        cima = null;
    }

    // =====================
    // PUSH
    // =====================
    public void push(Libro libro) {

        NodoPila nuevo = new NodoPila(libro);

        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    // =====================
    // POP
    // =====================
    public Libro pop() {

        if (cima == null) {
            System.out.println("Pila vacía");
            return null;
        }

        Libro dato = cima.getDato();
        cima = cima.getSiguiente();

        return dato;
    }

    // =====================
    // PEEK
    // =====================
    public Libro peek() {

        if (cima == null) return null;

        return cima.getDato();
    }

    // =====================
    // MOSTRAR
    // =====================
    public void mostrar() {

        NodoPila actual = cima;

        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    // =====================
    // VACÍA
    // =====================
    public boolean estaVacia() {
        return cima == null;
    }
}