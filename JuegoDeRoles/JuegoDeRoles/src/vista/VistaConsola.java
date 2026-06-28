/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import interfaces.Combatiente;
import interfaces.IVistaCombate;

/**
 *
 * @author ASUS
 */
public class VistaConsola implements IVistaCombate {

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);

    }

    @Override
    public void mostrarEstado(Combatiente c1, Combatiente c2) {
        System.out.println("  ESTADO: " + c1.getNombre() + " (HP: " + c1.getHpActual() + ") | "
                + c2.getNombre() + " (HP: " + c2.getHpActual() + ")");

    }

}
