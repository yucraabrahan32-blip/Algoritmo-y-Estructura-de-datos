package Arboles;
import java.util.ArrayList;

public class NodoGeneral {
    public String nombreCategoria;
    public ArrayList<NodoGeneral> hijos; 

    public NodoGeneral(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.hijos = new ArrayList<>();
    }
}
