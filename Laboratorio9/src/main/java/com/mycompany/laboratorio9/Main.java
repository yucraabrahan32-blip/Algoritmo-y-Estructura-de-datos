package com.mycompany.laboratorio9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ListaDoblementeEnlazadaCircular lista =
                new ListaDoblementeEnlazadaCircular();

        int opcion;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Insertar");
            System.out.println("2. Mostrar");
            System.out.println("3. Eliminar");
            System.out.println("4. Salir");
            System.out.print("Ingrese opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese dato: ");
                    int dato = sc.nextInt();

                    lista.insertar(dato);

                    break;

                case 2:

                    lista.mostrar();

                    break;

                case 3:

                    System.out.print("Ingrese dato a eliminar: ");
                    int eliminar = sc.nextInt();

                    lista.eliminar(eliminar);

                    break;

                case 4:

                    System.out.println("Programa finalizado");
                    break;

                default:

                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 4);

        sc.close();
    }
}