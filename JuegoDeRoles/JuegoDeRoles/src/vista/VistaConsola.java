package vista;

import interfaces.Combatiente;
import interfaces.IVistaCombate;

public class VistaConsola implements IVistaCombate {

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void mostrarEstado(Combatiente c1, Combatiente c2) {
        System.out.println("  ESTADO: "
                + c1.getNombre()
                + " (HP: " + c1.getHpActual()
                + " | Maná: " + c1.getManaActual()
                + " | CD: " + c1.getCooldown() + ")"
                + "  VS  "
                + c2.getNombre()
                + " (HP: " + c2.getHpActual()
                + " | Maná: " + c2.getManaActual()
                + " | CD: " + c2.getCooldown() + ")");
    }
}
