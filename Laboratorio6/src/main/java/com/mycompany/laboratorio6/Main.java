/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laboratorio6;

import java.util.Scanner;

/**
 *
 * @author Yucra
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== COLA CIRCULAR =====");

        System.out.print("Ingrese capacidad de la cola circular: ");
        int capacidad = sc.nextInt();

        ColaCircular colaCircular = new ColaCircular(capacidad);

        System.out.print("¿Cuántos datos desea ingresar?: ");
        int n1 = sc.nextInt();

        for (int i = 0; i < n1; i++) {
            System.out.print("Ingrese dato: ");
            int dato = sc.nextInt();
            colaCircular.encolar(dato);
        }

        colaCircular.mostrar();

        System.out.println("Elemento eliminado: " + colaCircular.desencolar());

        colaCircular.mostrar();


        System.out.println("\n===== COLA LISTA ENLAZADA =====");

        ColaLista colaLista = new ColaLista();

        System.out.print("¿Cuántos datos desea ingresar?: ");
        int n2 = sc.nextInt();

        for (int i = 0; i < n2; i++) {
            System.out.print("Ingrese dato: ");
            int dato = sc.nextInt();
            colaLista.encolar(dato);
        }

        colaLista.mostrar();

        System.out.println("Elemento eliminado: " + colaLista.desencolar());

        colaLista.mostrar();


        System.out.println("\n===== COLA PRIORIDAD =====");

        System.out.print("Ingrese capacidad de la cola prioridad: ");
        int cap = sc.nextInt();

        ColaPrioridad colaPrioridad = new ColaPrioridad(cap);

        System.out.print("¿Cuántos datos desea ingresar?: ");
        int n3 = sc.nextInt();

        for (int i = 0; i < n3; i++) {
            System.out.print("Ingrese dato: ");
            int dato = sc.nextInt();
            colaPrioridad.encolar(dato);
        }

        colaPrioridad.mostrar();

        System.out.println("Elemento eliminado: " + colaPrioridad.desencolar());

        colaPrioridad.mostrar();

        sc.close();
    }
}