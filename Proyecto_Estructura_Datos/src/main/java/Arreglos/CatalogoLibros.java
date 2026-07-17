    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package Arreglos;

    import Modelo.Libro;

    public class CatalogoLibros {

        private Libro[] libros;
        private int cantidad;

        public CatalogoLibros(int capacidad) {
            libros = new Libro[capacidad];
            cantidad = 0;
        }

        // INSERTAR
        public boolean insertarLibro(Libro libro) {

            if (cantidad >= libros.length) {
                return false;
            }

            libros[cantidad] = libro;
            cantidad++;

            return true;
        }

        // BUSCAR POR CÓDIGO
        public Libro buscarLibro(String codigo) {

            for (int i = 0; i < cantidad; i++) {

                if (libros[i].getCodigo().equals(codigo)) {
                    return libros[i];
                }

            }

            return null;
        }

        // ACTUALIZAR
        public boolean actualizarLibro(String codigo,
                                       String nuevoTitulo,
                                       String nuevoAutor,
                                       int nuevoAnio) {

            Libro libro = buscarLibro(codigo);

            if (libro != null) {

                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setAnioPublicacion(nuevoAnio);

                return true;
            }

            return false;
        }

        // ELIMINAR
        public boolean eliminarLibro(String codigo) {

            for (int i = 0; i < cantidad; i++) {

                if (libros[i].getCodigo().equals(codigo)) {

                    for (int j = i; j < cantidad - 1; j++) {
                        libros[j] = libros[j + 1];
                    }

                    libros[cantidad - 1] = null;
                    cantidad--;

                    return true;
                }
            }

            return false;
        }

        // RECORRER
        public void mostrarLibros() {

            if (cantidad == 0) {
                System.out.println("No hay libros registrados.");
                return;
            }

            for (int i = 0; i < cantidad; i++) {
                System.out.println(libros[i]);
            }
        }

        // OBTENER CANTIDAD
        public int getCantidad() {
            return cantidad;
        }

        // OBTENER ARREGLO
        public Libro[] getLibros() {
            return libros;
        }
    }
