
import java.util.Scanner;

public class ListaEnlazada {

    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    Nodo cabeza;

    public void insertar(int valor) {

        Nodo nuevo = new Nodo(valor);

        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public void eliminar(int valor) {

        if (cabeza == null) {
            System.out.println("vacia");
            return;
        }

        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual != null && actual.dato != valor) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println(" no encontrado");
            return;
        }

        if (anterior == null) {
            cabeza = actual.siguiente;
        } else {
            anterior.siguiente = actual.siguiente;
        }

        System.out.println(" eliminado");
    }

    public void mostrar() {

        if (cabeza == null) {
            System.out.println("lista vacía");
            return;
        }

        Nodo temp = cabeza;

        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Mostrar");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese número: ");
                    int num = sc.nextInt();

                    lista.insertar(num);
                    break;

                case 2:
                    System.out.print("Ingrese número a eliminar: ");
                    int eliminar = sc.nextInt();

                    lista.eliminar(eliminar);
                    break;

                case 3:
                    System.out.println("Contenido de la lista:");
                    lista.mostrar();
                    break;

                case 4:
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 4);

        sc.close();
    }
}