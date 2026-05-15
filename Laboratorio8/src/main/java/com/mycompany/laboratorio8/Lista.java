package com.mycompany.laboratorio8;
public class Lista {

    private Nodo cabeza;

    public Lista() {
        cabeza = null;
    }

    // Insertar al final
    public void insertar(int valor) {

        Nodo nuevo = new Nodo(valor);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo temp = cabeza;

        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }

        temp.siguiente = nuevo;
    }

    // Mostrar lista
    public void mostrar() {

        Nodo temp = cabeza;

        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }

        System.out.println("NULL");
    }

    // Invertir lista
    public void invertir() {

        Nodo anterior = null;
        Nodo actual = cabeza;
        Nodo siguiente;

        while (actual != null) {

            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }

        cabeza = anterior;
    }

    // Detectar ciclo con Floyd
    public boolean detectarCiclo() {

        Nodo lento = cabeza;
        Nodo rapido = cabeza;

        while (rapido != null && rapido.siguiente != null) {

            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;

            if (lento == rapido) {
                return true;
            }
        }

        return false;
    }

    // Obtener cabeza
    public Nodo obtenerCabeza() {
        return cabeza;
    }

    // Fusionar listas ordenadas
    public static Lista fusionar(Lista l1, Lista l2) {

        Lista resultado = new Lista();

        Nodo a = l1.obtenerCabeza();
        Nodo b = l2.obtenerCabeza();

        while (a != null && b != null) {

            if (a.dato < b.dato) {
                resultado.insertar(a.dato);
                a = a.siguiente;
            } else {
                resultado.insertar(b.dato);
                b = b.siguiente;
            }
        }

        while (a != null) {
            resultado.insertar(a.dato);
            a = a.siguiente;
        }

        while (b != null) {
            resultado.insertar(b.dato);
            b = b.siguiente;
        }

        return resultado;
    }
}