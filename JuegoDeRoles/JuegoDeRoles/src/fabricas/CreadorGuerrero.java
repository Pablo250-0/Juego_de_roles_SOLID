package fabricas;

import interfaces.Combatiente;
import modelo.items.Arma;
import modelo.items.Armadura;
import modelo.items.Inventario;
import modelo.personajes.Guerrero;

// Fabrica que crea un Guerrero con inventario y equipamiento inicial
public class CreadorGuerrero implements ICreadorPersonaje {

    // Nombre que aparece en el menu de seleccion
    @Override
    public String getNombreClaseMenu() { return "Guerrero"; }

    // El guerrero no necesita submenu de especialidad
    @Override
    public boolean requiereSubMenu() { return false; }

    // No hay opciones de submenu para el guerrero
    @Override
    public String[] getOpcionesSubMenu() { return new String[0]; }

    // Crea el guerrero con inventario e items base inyectados
    @Override
    public Combatiente crear(String nombreJugador, int opcionSubMenu) {
        Inventario inventario = new Inventario();
        Arma espada = new Arma("Espada de Hierro", 10);
        Armadura peto = new Armadura("Peto de Cuero", 5);
        inventario.agregar(espada);
        inventario.agregar(peto);
        inventario.equipar(espada);
        return new Guerrero(nombreJugador, 20, 10, 100, inventario);
    }
}
