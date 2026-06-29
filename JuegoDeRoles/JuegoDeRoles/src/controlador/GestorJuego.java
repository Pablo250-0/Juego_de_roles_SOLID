package controlador;

import fabricas.ICreadorPersonaje;
import interfaces.Combatiente;
import interfaces.IVistaCombate;
import java.util.List;
import java.util.Scanner;

public class GestorJuego {

    private final IVistaCombate vista;
    private final Combate motor;
    private final List<ICreadorPersonaje> clasesDisponibles;
    private final Scanner scanner;

    public GestorJuego(IVistaCombate vista, Combate motor, List<ICreadorPersonaje> clasesDisponibles) {
        this.vista = vista;
        this.motor = motor;
        this.clasesDisponibles = clasesDisponibles;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        vista.mostrarMensaje("===================================");
        vista.mostrarMensaje("    BIENVENIDO AL JUEGO DE ROL     ");
        vista.mostrarMensaje("===================================");

        Combatiente p1 = configurarJugador("JUGADOR 1");
        Combatiente p2 = configurarJugador("JUGADOR 2");

        vista.mostrarMensaje("\nPreparando el escenario de batalla...");
        motor.iniciarBatalla(p1, p2);
    }

    private Combatiente configurarJugador(String titulo) {
        vista.mostrarMensaje("\n--- " + titulo + " ---");
        vista.mostrarMensaje("Ingrese el nombre de su personaje:");
        String nombre = scanner.nextLine();

        vista.mostrarMensaje("Elija su clase base:");
        for (int i = 0; i < clasesDisponibles.size(); i++) {
            vista.mostrarMensaje((i + 1) + ". " + clasesDisponibles.get(i).getNombreClaseMenu());
        }
        int opcionClase = Integer.parseInt(scanner.nextLine()) - 1;
        ICreadorPersonaje creadorElegido = clasesDisponibles.get(opcionClase);

        int opcionSubMenu = 0;
        if (creadorElegido.requiereSubMenu()) {
            vista.mostrarMensaje("Elija la especialidad para su " + creadorElegido.getNombreClaseMenu() + ":");
            String[] opcionesExtra = creadorElegido.getOpcionesSubMenu();
            for (int i = 0; i < opcionesExtra.length; i++) {
                vista.mostrarMensaje((i + 1) + ". " + opcionesExtra[i]);
            }
            opcionSubMenu = Integer.parseInt(scanner.nextLine()) - 1;
        }

        return creadorElegido.crear(nombre, opcionSubMenu);
    }
}
