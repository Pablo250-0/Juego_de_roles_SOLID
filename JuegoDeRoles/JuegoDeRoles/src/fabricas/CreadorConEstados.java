/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import interfaces.Combatiente;
import interfaces.IVistaCombate;
import modelo.estados.DecoradorAtaqueCongelante;
import modelo.estados.DecoradorReceptorEstados;
import modelo.estados.DecoradorAtaqueVenenoso;
import modelo.estados.DecoradorAtaqueAturdidor;

/**
 *
 * @author ASUS
 */
public class CreadorConEstados implements ICreadorPersonaje {

    private final ICreadorPersonaje creadorOriginal;
    private final IVistaCombate vista;

    public CreadorConEstados(ICreadorPersonaje creadorOriginal, IVistaCombate vista) {
        this.creadorOriginal = creadorOriginal;
        this.vista = vista;
    }

    @Override
    public String getNombreClaseMenu() {
        return creadorOriginal.getNombreClaseMenu();
    }

    @Override
    public boolean requiereSubMenu() {
        return creadorOriginal.requiereSubMenu();
    }

    @Override
    public String[] getOpcionesSubMenu() {
        return creadorOriginal.getOpcionesSubMenu();
    }

    @Override
    public Combatiente crear(String nombreJugador, int opcionSubMenu) {

        // Creamos al personaje
        Combatiente personaje = creadorOriginal.crear(nombreJugador, opcionSubMenu);

        // CAPA DEFENSIVA: Todos pueden sufrir estados
        personaje = new DecoradorReceptorEstados(personaje, vista);

        // CAPA OFENSIVA: Le damos su habilidad especial según la clase
        String nombreClase = creadorOriginal.getNombreClaseMenu();

        if (nombreClase.equals("Mago")) {
            personaje = new DecoradorAtaqueCongelante(personaje, vista);
        } else if (nombreClase.equals("Arquero")) {
            personaje = new DecoradorAtaqueVenenoso(personaje, vista);
        } else if (nombreClase.equals("Guerrero")) {
            personaje = new DecoradorAtaqueAturdidor(personaje, vista);
        }

        return personaje;
    }
}
