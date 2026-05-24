/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio6;

/**
 *
 * @author Yucra
 */
// Clase ColaPrioridad
public class ColaPrioridad {
    private int[] cola;
    private int tamaño;

    public ColaPrioridad(int capacidad) {
        cola = new int[capacidad];
        tamaño = 0;
    }

    // Enqueue con prioridad
    public void encolar(int dato) {
        if (tamaño == cola.length) {
            System.out.println("La cola está llena.");
            return;
        }

        int i;

        for (i = tamaño - 1; i >= 0 && cola[i] > dato; i--) {
            cola[i + 1] = cola[i];
        }

        cola[i + 1] = dato;
        tamaño++;

        System.out.println("Elemento agregado: " + dato);
    }

    // Dequeue
    public int desencolar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return -1;
        }

        int dato = cola[0];

        for (int i = 0; i < tamaño - 1; i++) {
            cola[i] = cola[i + 1];
        }

        tamaño--;

        return dato;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }

        System.out.println("Elementos de la cola:");

        for (int i = 0; i < tamaño; i++) {
            System.out.print(cola[i] + " ");
        }

        System.out.println();
    }
}