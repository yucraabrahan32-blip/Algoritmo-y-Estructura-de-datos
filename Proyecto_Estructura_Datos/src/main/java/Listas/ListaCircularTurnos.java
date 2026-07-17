/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

import Modelo.Usuario;

public class ListaCircularTurnos {

    private NodoCircular actual;

    public ListaCircularTurnos() {
        actual = null;
    }
        public void insertar(Usuario usuario) {

        NodoCircular nuevo = new NodoCircular(usuario);

        if (actual == null) {
            actual = nuevo;
            return;
        }

        NodoCircular temp = actual;

        while (temp.getSiguiente() != actual) {
            temp = temp.getSiguiente();
        }

        temp.setSiguiente(nuevo);
        nuevo.setSiguiente(actual);
    }
            public void avanzar() {

        if (actual != null) {
            actual = actual.getSiguiente();
        }
    }
                public void mostrar() {

        if (actual == null) return;

        NodoCircular temp = actual;

        do {
            System.out.println(temp.getDato());
            temp = temp.getSiguiente();
        } while (temp != actual);
    }
}