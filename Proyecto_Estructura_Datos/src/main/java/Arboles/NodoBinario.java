package Arboles;
import Modelo.Libro;

public class NodoBinario {
    public Libro libro;
    public NodoBinario izquierdo;
    public NodoBinario derecho;

    public NodoBinario(Libro libro) {
        this.libro = libro;
        this.izquierdo = null;
        this.derecho = null;
    }
}
