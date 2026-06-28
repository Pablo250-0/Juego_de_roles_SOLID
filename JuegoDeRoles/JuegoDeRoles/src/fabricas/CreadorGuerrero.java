package fabricas;
import interfaces.Combatiente;
import modelo.items.Arma;
import modelo.items.Armadura;
import modelo.items.Inventario;
import modelo.personajes.Guerrero; 

public class CreadorGuerrero implements ICreadorPersonaje {

    @Override
    public String getNombreClaseMenu() {
        return "Guerrero";
    }

    @Override
    public boolean requiereSubMenu() {
        return false;   // el guerrero no necesita elegir especialidad
    }

    @Override
    public String[] getOpcionesSubMenu() {
        return new String[0];
    }

    @Override
    public Combatiente crear(String nombreJugador, int opcionSubMenu) {
        Inventario inventario = new Inventario();

        // Equipamiento inicial del guerrero
        Arma espada = new Arma("Espada de Hierro", 10);
        Armadura peto = new Armadura("Peto de Cuero", 5);

        inventario.agregar(espada);
        inventario.agregar(peto);
        inventario.equipar(espada);     // equipa el arma por defecto

        return new Guerrero(nombreJugador, 20, 10, 100, inventario);
    }
}