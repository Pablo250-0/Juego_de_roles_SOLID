/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import interfaces.Combatiente;

/**
 *
 * @author ASUS
 */
public interface ICreadorPersonaje {

    // El nombre principal (ej. "Mago", "Guerrero")
    String getNombreClaseMenu();

    // ¿Esta clase necesita que el usuario elija algo más?
    boolean requiereSubMenu();

    // Si requiere sub-menú, devuelve la lista de opciones (ej. "Fuego", "Agua")
    String[] getOpcionesSubMenu();

    // Crea el personaje recibiendo el nombre y la opción extra que eligió el usuario
    Combatiente crear(String nombreJugador, int opcionSubMenu);

}
