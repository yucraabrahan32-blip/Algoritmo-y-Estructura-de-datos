package Arboles;

public class ArbolGeneralCategorias {
    private NodoGeneral raiz;

    public ArbolGeneralCategorias(String categoriaRaiz) {
        this.raiz = new NodoGeneral(categoriaRaiz);
    }

    public NodoGeneral getRaiz() {
        return raiz;
    }

    // Método público para añadir una subcategoría a un padre específico
    public void agregarCategoria(NodoGeneral padre, String nuevaCategoria) {
        if (padre != null) {
            NodoGeneral nuevoHijo = new NodoGeneral(nuevaCategoria);
            padre.hijos.add(nuevoHijo);
        }
    }

    // Busca un nodo por su nombre para poder añadirle hijos más tarde
    public NodoGeneral buscarNodo(NodoGeneral actual, String nombreBuscar) {
        if (actual == null) return null;
        if (actual.nombreCategoria.equalsIgnoreCase(nombreBuscar)) return actual;

        for (NodoGeneral hijo : actual.hijos) {
            NodoGeneral encontrado = buscarNodo(hijo, nombreBuscar);
            if (encontrado != null) return encontrado;
        }
        return null;
    }

    // Método público para imprimir de forma gráfica la jerarquía de categorías
    public void mostrarEstructura() {
        mostrarEstructuraRec(raiz, "");
    }

    // Recorrido PreOrden con formato visual de ramas
    private void mostrarEstructuraRec(NodoGeneral actual, String tabulacion) {
        if (actual == null) return;
        
        System.out.println(tabulacion + "└── " + actual.nombreCategoria);
        
        for (NodoGeneral hijo : actual.hijos) {
            mostrarEstructuraRec(hijo, tabulacion + "    ");
        }
    }
}
