package modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Objeto> items = new ArrayList<>();
    private Objeto equipado = null;

    public void agregar(Objeto obj) {
        items.add(obj);
        System.out.println(obj.getNombre() + " agregado al inventario.");
    }

    public void equipar(Objeto obj) {
        if (items.contains(obj)) {
            equipado = obj;
            System.out.println(obj.getNombre() + " equipado.");
        } else {
            System.out.println("El objeto no está en el inventario.");
        }
    }

    public void desequipar() {
        if (equipado != null) {
            System.out.println(equipado.getNombre() + " desequipado.");
            equipado = null;
        }
    }

    public Objeto getEquipado() { return equipado; }

    public List<Objeto> getItems() { return items; }

    public void mostrarInventario() {
        System.out.println("--- Inventario ---");
        if (items.isEmpty()) {
            System.out.println("Vacío.");
        } else {
            for (Objeto obj : items) {
                String estado = (obj == equipado) ? " [EQUIPADO]" : "";
                System.out.println("- " + obj.getNombre() + estado);
            }
        }
    }
}