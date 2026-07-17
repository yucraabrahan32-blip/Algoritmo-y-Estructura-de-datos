package Arboles;
import Modelo.Libro;

public class ArbolBinarioLibros {
    private NodoBinario raiz;

    public ArbolBinarioLibros() {
        this.raiz = null;
    }

    public void insertar(Libro nuevoLibro) {
        raiz = insertarRec(raiz, nuevoLibro);
    }

    private NodoBinario insertarRec(NodoBinario actual, Libro nuevoLibro) {
        if (actual == null) {
            return new NodoBinario(nuevoLibro);
        }

        int comparacion = nuevoLibro.getTitulo().compareToIgnoreCase(actual.libro.getTitulo());

        if (comparacion < 0) {
            actual.izquierdo = insertarRec(actual.izquierdo, nuevoLibro);
        } else if (comparacion > 0) {
            actual.derecho = insertarRec(actual.derecho, nuevoLibro);
        }
        
        return actual;
    }

    public Libro buscar(String tituloBuscado) {
        return buscarRec(raiz, tituloBuscado);
    }

    private Libro buscarRec(NodoBinario actual, String tituloBuscado) {
        if (actual == null) {
            return null; 
        }

        int comparacion = tituloBuscado.compareToIgnoreCase(actual.libro.getTitulo());

        if (comparacion == 0) {
            return actual.libro; 
        }

        return comparacion < 0 
            ? buscarRec(actual.izquierdo, tituloBuscado) 
            : buscarRec(actual.derecho, tituloBuscado);
    }

    // Recorrido InOrden para mostrar los libros ordenados alfabéticamente
    public void mostrarInOrden() {
        mostrarInOrdenRec(raiz);
    }

    private void mostrarInOrdenRec(NodoBinario actual) {
        if (actual != null) {
            mostrarInOrdenRec(actual.izquierdo);
            // Imprime el título (puedes cambiarlo para que muestre más atributos de tu clase Libro)
            System.out.println("[Libro] " + actual.libro.getTitulo()); 
            mostrarInOrdenRec(actual.derecho);
        }
    }
}
