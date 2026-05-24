/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio6;

/**
 *
 * @author Yucra
 */

// Clase ColaCircular usando arreglos circulares
public class ColaCircular {
    private int[] cola;
    private int frente;
    private int fin;
    private int tamaño;
    private int capacidad;

    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        cola = new int[capacidad];
        frente = 0;
        fin = -1;
        tamaño = 0;
    }

    // Enqueue
    public void encolar(int dato) {
        if (estaLlena()) {
            System.out.println("La cola está llena.");
            return;
        }

        fin = (fin + 1) % capacidad;
        cola[fin] = dato;
        tamaño++;

        System.out.println("Elemento agregado: " + dato);
    }

    // Dequeue
    public int desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return -1;
        }

        int dato = cola[frente];
        frente = (frente + 1) % capacidad;
        tamaño--;

        return dato;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public boolean estaLlena() {
        return tamaño == capacidad;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }

        System.out.println("Elementos de la cola:");

        for (int i = 0; i < tamaño; i++) {
            int indice = (frente + i) % capacidad;
            System.out.print(cola[indice] + " ");
        }

        System.out.println();
    }
}