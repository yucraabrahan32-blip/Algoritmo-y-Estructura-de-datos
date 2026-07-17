/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

import Modelo.Prestamo;

public class ListaSimplePrestamos {

    private NodoSimple cabeza;

    public ListaSimplePrestamos() {
        cabeza = null;
    }

    // INSERTAR AL FINAL
            public void insertar(Prestamo prestamo) {

                NodoSimple nuevo = new NodoSimple(prestamo);

                if (cabeza == null) {
                    cabeza = nuevo;
                    return;
                }

                NodoSimple actual = cabeza;

                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }

                actual.setSiguiente(nuevo);
            }
            public void mostrar() {

            if (cabeza == null) {
                System.out.println("Lista vacía.");
                return;
            }

            NodoSimple actual = cabeza;

            while (actual != null) {

                System.out.println(actual.getDato());

                actual = actual.getSiguiente();
            }
        }
            public Prestamo buscar(String codigoLibro) {

            NodoSimple actual = cabeza;

            while (actual != null) {

                if (actual.getDato()
                          .getLibro()
                          .getCodigo()
                          .equals(codigoLibro)) {

                    return actual.getDato();
                }

                actual = actual.getSiguiente();
            }

            return null;
        }
            public boolean eliminar(String codigoLibro) {

            if (cabeza == null) {
                return false;
            }

            if (cabeza.getDato()
                      .getLibro()
                      .getCodigo()
                      .equals(codigoLibro)) {

                cabeza = cabeza.getSiguiente();
                return true;
            }

            NodoSimple actual = cabeza;

            while (actual.getSiguiente() != null) {

                if (actual.getSiguiente()
                          .getDato()
                          .getLibro()
                          .getCodigo()
                          .equals(codigoLibro)) {

                    actual.setSiguiente(
                        actual.getSiguiente().getSiguiente()
                    );

                    return true;
                }

                actual = actual.getSiguiente();
            }

            return false;
        }
            public void ordenarPorTitulo() {

            if (cabeza == null) {
                return;
            }

            boolean intercambio;

            do {

                intercambio = false;

                NodoSimple actual = cabeza;

                while (actual.getSiguiente() != null) {

                    String titulo1 =
                        actual.getDato()
                              .getLibro()
                              .getTitulo();

                    String titulo2 =
                        actual.getSiguiente()
                              .getDato()
                              .getLibro()
                              .getTitulo();

                    if (titulo1.compareToIgnoreCase(titulo2) > 0) {

                        Prestamo temp = actual.getDato();

                        actual.setDato(
                            actual.getSiguiente().getDato()
                        );

                        actual.getSiguiente().setDato(temp);

                        intercambio = true;
                    }

                    actual = actual.getSiguiente();
                }

            } while (intercambio);
        }
    
}

