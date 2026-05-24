package com.mycompany.laboratorio9;

public class ListaDoblementeEnlazadaCircular {

    Nodo inicio = null;

    // Insertar al final
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);

        // Si la lista está vacía
        if (inicio == null) {
            inicio = nuevo;
            inicio.siguiente = inicio;
            inicio.anterior = inicio;
        } else {
            Nodo ultimo = inicio.anterior;

            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;

            nuevo.siguiente = inicio;
            inicio.anterior = nuevo;
        }
    }

    // Mostrar la lista
    public void mostrar() {
        if (inicio == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo aux = inicio;

        System.out.println("Recorrido de la lista:");

        do {
            System.out.print(aux.dato + " ");
            aux = aux.siguiente;
        } while (aux != inicio);

        System.out.println();
    }

    // Eliminar un dato
    public void eliminar(int dato) {

        if (inicio == null) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo actual = inicio;

        do {

            if (actual.dato == dato) {

                // Caso: un solo nodo
                if (actual.siguiente == actual) {
                    inicio = null;
                }

                // Caso: eliminar inicio
                else if (actual == inicio) {

                    Nodo ultimo = inicio.anterior;

                    inicio = inicio.siguiente;

                    ultimo.siguiente = inicio;
                    inicio.anterior = ultimo;
                }

                // Caso: cualquier otro nodo
                else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }

                System.out.println("Dato eliminado");
                return;
            }

            actual = actual.siguiente;

        } while (actual != inicio);

        System.out.println("Dato no encontrado");
    }
}