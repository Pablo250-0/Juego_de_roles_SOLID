package fabricas;

import interfaces.Combatiente;
import modelo.personajes.Guerrero;

public class CreadorGuerrero implements ICreadorPersonaje {

    @Override
    public String getNombreClaseMenu() {
        return "Guerrero";
    }

    @Override
    public boolean requiereSubMenu() {
        return false;
    }

    @Override
    public String[] getOpcionesSubMenu() {
        return new String[0];
    }

    @Override
    public Combatiente crear(String nombreJugador, int opcionSubMenu) {
        return new Guerrero(nombreJugador, 20, 10, 100);
    }
}
