/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

import Modelo.Reserva;

public class ColaPrioridad {

    private Reserva[] cola;
    private int cantidad;

    public ColaPrioridad(int capacidad) {
        cola = new Reserva[capacidad];
        cantidad = 0;
    }

    public boolean enqueue(Reserva reserva) {

        if (cantidad == cola.length) return false;

        int i = cantidad - 1;

        while (i >= 0 && cola[i].getPrioridad() < reserva.getPrioridad()) {
            cola[i + 1] = cola[i];
            i--;
        }

        cola[i + 1] = reserva;
        cantidad++;

        return true;
    }

    public Reserva dequeue() {

        if (cantidad == 0) return null;

        Reserva r = cola[0];

        for (int i = 0; i < cantidad - 1; i++) {
            cola[i] = cola[i + 1];
        }

        cantidad--;

        return r;
    }

    public void mostrar() {

        for (int i = 0; i < cantidad; i++) {
            System.out.println(cola[i]);
        }
    }
}