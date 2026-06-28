package modelo;

import java.util.ArrayList;
import java.util.List;

// Inventario.java — sin ningún System.out.println
public class Inventario {
    private List<Objeto> items = new ArrayList<>();
    private Objeto equipado = null;

    public void agregar(Objeto obj) {
        items.add(obj);
    }

    public void equipar(Objeto obj) {
        if (items.contains(obj)) {
            equipado = obj;
        }
    }

    public void desequipar() {
        equipado = null;
    }

    public Objeto getEquipado() { return equipado; }
    public List<Objeto> getItems() { return items; }
}