package com.mycompany.proyecto_estructura_datos;

import java.util.Scanner;
import Arreglos.CatalogoLibros;
import Colas.ColaEstatica;
import Colas.ColaPrioridad;
import Listas.ListaSimplePrestamos;
import Listas.ListaDobleHistorial;
import Listas.ListaCircularTurnos;
import Modelo.Libro;
import Modelo.Prestamo;
import Modelo.Reserva;
import Modelo.Usuario;
import Pilas.PilaEstatica;

// === NUEVAS IMPORTACIONES DE ÁRBOLES ===
import Arboles.ArbolBinarioLibros;
import Arboles.ArbolGeneralCategorias;
import Arboles.NodoGeneral;

public class Proyecto_Estructura_Datos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CatalogoLibros catalogo = new CatalogoLibros(20);
        ListaSimplePrestamos lista = new ListaSimplePrestamos();
        ColaEstatica cola = new ColaEstatica(20);
        PilaEstatica pila = new PilaEstatica(20);
        ColaPrioridad cp = new ColaPrioridad(20);

        ListaDobleHistorial historial = new ListaDobleHistorial();
        ListaCircularTurnos turnos = new ListaCircularTurnos();

        // === INSTANCIAS DE LOS NUEVOS ÁRBOLES ===
        ArbolBinarioLibros arbolLibros = new ArbolBinarioLibros();
        ArbolGeneralCategorias arbolCategorias = new ArbolGeneralCategorias("Biblioteca Central");

        int filasMatriz = 5;
        int columnasMatriz = 4;
        Libro[][] matrizEstanteria = new Libro[filasMatriz][columnasMatriz];

        int opcion;

        do {
            System.out.println("\n===== SISTEMA BIBLIOTECA =====");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Registrar préstamo");
            System.out.println("4. Mostrar préstamos");
            System.out.println("5. Agregar usuario a cola");
            System.out.println("6. Atender usuario (cola)");
            System.out.println("7. Push pila libros");
            System.out.println("8. Mostrar pila");
            System.out.println("9. Cola prioridad (reserva)");
            System.out.println("10. Mostrar Historial (Lista Doble)");
            System.out.println("11. Pasar Siguiente Turno (Circular)");
            System.out.println("12. Ubicar libro en Estantería (Matriz)");
            System.out.println("13. Mostrar Mapa de Estantería (Matriz)");
            
            // === NUEVAS OPCIONES DEL MENÚ ===
            System.out.println("14. [Árbol Binario] Buscar libro por Título (Rápido)");
            System.out.println("15. [Árbol Binario] Mostrar catálogo ordenado A-Z");
            System.out.println("16. [Árbol General] Agregar Subcategoría temática");
            System.out.println("17. [Árbol General] Mostrar Jerarquía de Categorías");
            System.out.println("18. Salir");

            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Código: ");
                    String c = sc.nextLine();
                    
                    System.out.print("Título: ");
                    String t = sc.nextLine();
                    
                    System.out.print("Autor: ");
                    String a = sc.nextLine();
                    
                    System.out.print("Año: ");
                    int anio = sc.nextInt();
                    sc.nextLine();
                    
                    Libro nuevoLibro = new Libro(c, t, a, anio);
                    catalogo.insertarLibro(nuevoLibro);
                    
                    // === SE AGREGA AL ÁRBOL BINARIO AL MISMO TIEMPO ===
                    arbolLibros.insertar(nuevoLibro);
                    
                    System.out.println("Libro agregado.");
                    break;

                case 2:
                    catalogo.mostrarLibros();
                    break;

                case 3:
                    System.out.print("Código libro: ");
                    String cod = sc.nextLine();
                    
                    Libro libro = catalogo.buscarLibro(cod);
                    
                    if (libro == null) {
                        System.out.println("Libro no encontrado");
                        break;
                    }
                    
                    System.out.print("Código usuario: ");
                    String cu = sc.nextLine();
                    
                    System.out.print("Nombre usuario: ");
                    String nom = sc.nextLine();
                    
                    Usuario u = new Usuario(cu, nom, "Alumno");
                    
                    Prestamo p = new Prestamo(libro, u, "hoy", "pendiente");
                    
                    lista.insertar(p);
                    historial.insertar(p);
                    
                    System.out.println("Préstamo registrado");
                    break;

                case 4:
                    lista.mostrar();
                    break;

                case 5:
                    System.out.print("Código usuario: ");
                    String cu2 = sc.nextLine();
                    
                    System.out.print("Nombre: ");
                    String nom2 = sc.nextLine();
                    
                    cola.enqueue(new Usuario(cu2, nom2, "Alumno"));
                    
                    System.out.println("Usuario en cola");
                    break;

                case 6:
                    Usuario atendido = cola.dequeue();
                    
                    if (atendido != null) {
                        System.out.println("Atendido: " + atendido);
                    }
                    break;

                case 7:
                    System.out.print("Código libro: ");
                    String cb = sc.nextLine();
                    
                    Libro lb = catalogo.buscarLibro(cb);
                    
                    if (lb != null) {
                        pila.push(lb);
                        System.out.println("Agregado a pila");
                    }
                    break;

                case 8:
                    pila.mostrar();
                    break;

                case 9:
                    System.out.print("Código libro: ");
                    String cr = sc.nextLine();
                    
                    Libro lbr = catalogo.buscarLibro(cr);
                    
                    if (lbr == null) break;
                    
                    System.out.print("Código usuario: ");
                    String cu3 = sc.nextLine();
                    
                    System.out.print("Nombre usuario: ");
                    String nom3 = sc.nextLine();
                    
                    System.out.print("Prioridad (1-3): ");
                    int pr = sc.nextInt();
                    sc.nextLine();
                    
                    cp.enqueue(new Reserva(lbr, new Usuario(cu3, nom3, "Alumno"), pr));
                    
                    System.out.println("Reserva agregada");
                    break;

                case 10:
                    System.out.println("\n--- HISTORIAL DE MOVIMIENTOS (De primero a último) ---");
                    if (historial == null) { // Nota: Ajustar según validación original de tu lista doble si da vacío
                        System.out.println("Historial vacío.");
                    } else {
                        historial.mostrarAdelante();
                    }
                    break;

                case 11:
                    System.out.println("\n--- GESTIÓN DE TURNOS ROTATIVOS ---");
                    turnos.mostrar();
                    break;

                case 12:
                    System.out.print("Ingrese el código del libro a ubicar: ");
                    String codMatriz = sc.nextLine();
                    
                    Libro libroEncontrado = catalogo.buscarLibro(codMatriz);
                    
                    if (libroEncontrado != null) {
                        System.out.print("Ingrese número de Pasillo (Fila 0 a " + (filasMatriz - 1) + "): ");
                        int fila = sc.nextInt();
                        System.out.print("Ingrese número de Estante (Columna 0 a " + (columnasMatriz - 1) + "): ");
                        int col = sc.nextInt();
                        sc.nextLine(); // Limpiar buffer
                        
                        if (fila >= 0 && fila < filasMatriz && col >= 0 && col < columnasMatriz) {
                            matrizEstanteria[fila][col] = libroEncontrado;
                            System.out.println("Libro '" + libroEncontrado.getTitulo() + "' ubicado en el estante con éxito!");
                        } else {
                            System.out.println("Error: Posición fuera de los límites de la estantería.");
                        }
                    } else {
                        System.out.println("Error: El libro no existe en el catálogo general.");
                    }
                    break;

                case 13:
                    System.out.println("\n--- MAPA BIDIMENSIONAL DE LA ESTANTERÍA (MATRIZ) ---");
                    for (int i = 0; i < filasMatriz; i++) {
                        System.out.print("Pasillo " + (i + 1) + " -> ");
                        for (int j = 0; j < columnasMatriz; j++) {
                            if (matrizEstanteria[i][j] == null) {
                                System.out.print("[ Vacío ]\t");
                            } else {
                                System.out.print("[" + matrizEstanteria[i][j].getTitulo() + "]\t");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 14:
                    System.out.print("Ingrese el título del libro a buscar: ");
                    String titBuscado = sc.nextLine();
                    Libro encontrado = arbolLibros.buscar(titBuscado);
                    if (encontrado != null) {
                        System.out.println("¡Encontrado en Árbol Binario! -> " + encontrado.getTitulo() + " (Autor: " + encontrado.getAutor() + ")");
                    } else {
                        System.out.println("El libro no se encuentra registrado en el árbol.");
                    }
                    break;

                case 15:
                    System.out.println("\n--- LIBROS ORDENADOS ALFABÉTICAMENTE (INORDEN) ---");
                    arbolLibros.mostrarInOrden();
                    break;

                case 16:
                    System.out.print("¿A qué categoría padre quiere añadir la subcategoría?: ");
                    String padreNombre = sc.nextLine();
                    NodoGeneral nodoPadre = arbolCategorias.buscarNodo(arbolCategorias.getRaiz(), padreNombre);
                    
                    if (nodoPadre != null) {
                        System.out.print("Ingrese el nombre de la nueva subcategoría: ");
                        String nuevaSub = sc.nextLine();
                        arbolCategorias.agregarCategoria(nodoPadre, nuevaSub);
                        System.out.println("¡Categoría añadida con éxito!");
                    } else {
                        System.out.println("La categoría '" + padreNombre + "' no existe.");
                    }
                    break;

                case 17:
                    System.out.println("\n--- MAPA JERÁRQUICO DE LA BIBLIOTECA (ÁRBOL GENERAL) ---");
                    arbolCategorias.mostrarEstructura();
                    break;

                case 18:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }

        } while (opcion != 18);

        sc.close();
    }
}

                    