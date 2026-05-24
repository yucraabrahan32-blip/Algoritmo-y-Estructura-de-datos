/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio6;

/**
 *
 * @author Yucra
 */
// Clase ColaLista usando listas enlazadas
public class ColaLista {
    private Nodo frente;
    private Nodo fin;

    public ColaLista() {
        frente = null;
        fin = null;
    }

    // Enqueue
    public void encolar(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }

        System.out.println("Elemento agregado: " + dato);
    }

    // Dequeue
    public int desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return -1;
        }

        int dato = frente.dato;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }

        Nodo actual = frente;

        System.out.println("Elementos de la cola:");

        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }

        System.out.println();
    }
}