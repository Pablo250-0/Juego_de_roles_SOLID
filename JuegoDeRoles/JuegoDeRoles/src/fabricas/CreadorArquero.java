/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import interfaces.Combatiente;
import modelo.personajes.Arquero;

/**
 *
 * @author ASUS
 */
public class CreadorArquero implements ICreadorPersonaje {

    @Override
    public String getNombreClaseMenu() {
        return "Arquero";
    }

    @Override
    public boolean requiereSubMenu() {
        return false; // El Arquero no necesita elegir nada adicional, a diferencia del Mago
    }

    @Override
    public String[] getOpcionesSubMenu() {
        return new String[0]; // no aplica, pero se implementa por contrato de la interfaz
    }

    @Override
    public Combatiente crear(String nombreJugador, int opcionSubMenu) {
        // flechas iniciales = 15, puntería inicial = 10, armadura inicial = 8, HP base = 90
        return new Arquero(15, 10, 8, nombreJugador, 90);
    }

}
