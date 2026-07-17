/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

import Modelo.Libro;

public class PilaEstatica {

    private Libro[] pila;
    private int tope;

    public PilaEstatica(int capacidad) {
        pila = new Libro[capacidad];
        tope = -1;
    }

    // =====================
    // PUSH (insertar)
    // =====================
    public boolean push(Libro libro) {

        if (tope == pila.length - 1) {
            System.out.println("Pila llena");
            return false;
        }

        pila[++tope] = libro;
        return true;
    }

    // =====================
    // POP (eliminar)
    // =====================
    public Libro pop() {

        if (tope == -1) {
            System.out.println("Pila vacía");
            return null;
        }

        return pila[tope--];
    }

    // =====================
    // PEEK (ver cima)
    // =====================
    public Libro peek() {

        if (tope == -1) return null;

        return pila[tope];
    }

    // =====================
    // MOSTRAR
    // =====================
    public void mostrar() {

        for (int i = tope; i >= 0; i--) {
            System.out.println(pila[i]);
        }
    }

    // =====================
    // VACÍA
    // =====================
    public boolean estaVacia() {
        return tope == -1;
    }

    // =====================
    // LLENA
    // =====================
    public boolean estaLlena() {
        return tope == pila.length - 1;
    }
}