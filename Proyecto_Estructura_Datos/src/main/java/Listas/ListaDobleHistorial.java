/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

import Modelo.Prestamo;

public class ListaDobleHistorial {

    private NodoDoble cabeza;
    private NodoDoble cola;

    public ListaDobleHistorial() {
        cabeza = null;
        cola = null;
    }
        public void insertar(Prestamo prestamo) {

        NodoDoble nuevo = new NodoDoble(prestamo);

        if (cabeza == null) {
            cabeza = cola = nuevo;
            return;
        }

        cola.setSiguiente(nuevo);
        nuevo.setAnterior(cola);
        cola = nuevo;
    }
            public void mostrarAdelante() {

        NodoDoble actual = cabeza;

        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }
                public void mostrarAtras() {

        NodoDoble actual = cola;

        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getAnterior();
        }
    }
                
}