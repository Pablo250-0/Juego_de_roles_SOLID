package vista;

import Interfaces.*;

public class VistaConsola implements IVistaCombate {

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void mostrarEstado(Combatiente c1, Combatiente c2) {
        System.out.println("--- Estado ---");
        System.out.println(c1.getNombre() + " HP: " + c1.getHpActual());
        System.out.println(c2.getNombre() + " HP: " + c2.getHpActual());
    }
}