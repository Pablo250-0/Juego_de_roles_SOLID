package fabricas;

import interfaces.Combatiente;
import modelo.personajes.Arquero;

public class CreadorArquero implements ICreadorPersonaje {

    @Override
    public String getNombreClaseMenu() {
        return "Arquero";
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
        return new Arquero(15, 10, 8, nombreJugador, 90);
    }
}
