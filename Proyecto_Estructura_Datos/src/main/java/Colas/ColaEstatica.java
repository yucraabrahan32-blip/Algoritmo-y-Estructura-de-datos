/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

import Modelo.Usuario;

public class ColaEstatica {

    private Usuario[] cola;
    private int frente;
    private int fin;
    private int cantidad;

    public ColaEstatica(int capacidad) {
        cola = new Usuario[capacidad];
        frente = 0;
        fin = -1;
        cantidad = 0;
    }

    // ENQUEUE
    public boolean enqueue(Usuario usuario) {

        if (cantidad == cola.length) {
            System.out.println("Cola llena");
            return false;
        }

        fin = (fin + 1) % cola.length;
        cola[fin] = usuario;
        cantidad++;

        return true;
    }

    // DEQUEUE
    public Usuario dequeue() {

        if (cantidad == 0) {
            System.out.println("Cola vacía");
            return null;
        }

        Usuario u = cola[frente];
        frente = (frente + 1) % cola.length;
        cantidad--;

        return u;
    }

    // FRONT
    public Usuario frente() {

        if (cantidad == 0) return null;

        return cola[frente];
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public boolean estaLlena() {
        return cantidad == cola.length;
    }

    public void mostrar() {

        for (int i = 0; i < cantidad; i++) {
            System.out.println(cola[(frente + i) % cola.length]);
        }
    }
}