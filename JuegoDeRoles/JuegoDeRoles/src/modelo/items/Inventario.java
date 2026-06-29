package modelo.items;

import java.util.ArrayList;
import java.util.List;

// Gestiona la lista de objetos y el equipamiento activo del personaje
public class Inventario {
    private final List<Objeto> items = new ArrayList<>();
    private Objeto equipado = null;

    // Agrega un objeto a la lista del inventario
    public void agregar(Objeto obj) {
        items.add(obj);
    }

    // Equipa un objeto si existe en el inventario
    public void equipar(Objeto obj) {
        if (items.contains(obj)) {
            equipado = obj;
        }
    }

    // Desequipa el objeto activo
    public void desequipar() {
        equipado = null;
    }

    // Retorna el objeto actualmente equipado
    public Objeto getEquipado() { return equipado; }

    // Retorna la lista completa de objetos
    public List<Objeto> getItems() { return items; }
}