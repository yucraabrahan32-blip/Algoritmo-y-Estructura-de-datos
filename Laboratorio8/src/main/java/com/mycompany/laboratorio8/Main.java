package com.mycompany.laboratorio8;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Lista lista1 = new Lista();
        Lista lista2 = new Lista();

        int n;
        int valor;

        // INGRESO MANUAL LISTA 1
        System.out.print("Cantidad de elementos para Lista 1: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Ingrese valor: ");
            valor = sc.nextInt();

            lista1.insertar(valor);
        }

        System.out.println("\nLista 1 original:");
        lista1.mostrar();

        // Invertir lista
        lista1.invertir();

        System.out.println("\nLista 1 invertida:");
        lista1.mostrar();

        // Detectar ciclo
        if (lista1.detectarCiclo()) {
            System.out.println("\nLa lista tiene ciclo.");
        } else {
            System.out.println("\nLa lista NO tiene ciclo.");
        }

        // INGRESO MANUAL LISTA 2
        System.out.print("\nCantidad de elementos para Lista 2: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Ingrese valor: ");
            valor = sc.nextInt();

            lista2.insertar(valor);
        }

        System.out.println("\nLista 2:");
        lista2.mostrar();

        // Fusionar listas
        Lista fusionada = Lista.fusionar(lista1, lista2);

        System.out.println("\nLista fusionada:");
        fusionada.mostrar();

        sc.close();
    }
}