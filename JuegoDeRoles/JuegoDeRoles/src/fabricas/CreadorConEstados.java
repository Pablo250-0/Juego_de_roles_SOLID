/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import interfaces.Combatiente;
import interfaces.IVistaCombate;
import modelo.estados.DecoradorEstados;


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
        // crea al personaje puro (Mago, Arquero o Guerrero)
        Combatiente personajeBase = creadorOriginal.crear(nombreJugador, opcionSubMenu);

        // Lo envolvemos en nuestra armadura de estados
        DecoradorEstados personajeDecorado = new DecoradorEstados(personajeBase, vista);
        return personajeDecorado;
    }
}
