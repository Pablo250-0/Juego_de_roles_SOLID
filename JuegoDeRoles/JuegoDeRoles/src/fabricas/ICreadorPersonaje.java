package fabricas;

import interfaces.Combatiente;

public interface ICreadorPersonaje {

    String getNombreClaseMenu();

    boolean requiereSubMenu();

    String[] getOpcionesSubMenu();

    Combatiente crear(String nombreJugador, int opcionSubMenu);
}
