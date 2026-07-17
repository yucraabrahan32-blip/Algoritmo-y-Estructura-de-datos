package Arreglos;

import Modelo.Libro;

public class EstanteriaBiblioteca {
    // La matriz almacena objetos de tipo Libro en filas y columnas
    private Libro[][] estantes;
    private int filas;
    private int columnas;

    // Constructor: defines cuántos pasillos (filas) y niveles (columnas) tiene
    public EstanteriaBiblioteca(int pasillos, int niveles) {
        this.filas = pasillos;
        this.columnas = niveles;
        this.estantes = new Libro[pasillos][niveles]; // Aquí se crea la matriz
    }

    // UBICAR UN LIBRO EN LA MATRIZ
    public boolean ubicarLibro(int pasillo, int nivel, Libro libro) {
        // Validar que la posición exista dentro de los límites de la matriz
        if (pasillo >= 0 && pasillo < filas && nivel >= 0 && nivel < columnas) {
            estantes[pasillo][nivel] = libro;
            return true;
        }
        return false; // Posición inválida
    }

    // MOSTRAR LA MATRIZ EN CONSOLA
    public void mostrarEstanteria() {
        System.out.println("\n--- MAPA DE LA ESTANTERÍA (MATRIZ) ---");
        for (int i = 0; i < filas; i++) {
            System.out.print("Pasillo " + i + ": ");
            for (int j = 0; j < columnas; j++) {
                if (estantes[i][j] == null) {
                    System.out.print("[ Vacío ]\t");
                } else {
                    // Muestra el título del libro en esa celda
                    System.out.print("[" + estantes[i][j].getTitulo() + "]\t");
                }
            }
            System.out.println(); // Salto de línea para la siguiente fila
        }
    }
}
