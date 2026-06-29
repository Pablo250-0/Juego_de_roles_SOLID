/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.estados;

import interfaces.Combatiente;
import interfaces.IVistaCombate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DecoradorEstados implements Combatiente {

    private final Combatiente personajeBase;
    private final List<IEstadoAlterado> estadosActivos;
    private final IVistaCombate vista;

    public DecoradorEstados(Combatiente personajeBase, IVistaCombate vista) {
        this.personajeBase = personajeBase;
        this.estadosActivos = new ArrayList<>();
        this.vista = vista;
    }

    public void agregarEstado(IEstadoAlterado estado) {
        estadosActivos.add(estado);
        vista.mostrarMensaje(personajeBase.getNombre() + " ha sido afectado por: " + estado.getNombre());
    }

    @Override
    public void atacar(Combatiente objetivo) {
        boolean puedeMoverse = true;

        // Revisamos si algún estado le impide atacar
        for (IEstadoAlterado estado : estadosActivos) {
            if (!estado.permiteAtacar()) {
                puedeMoverse = false;
                vista.mostrarMensaje(personajeBase.getNombre() + " está incapacitado y pierde su turno!");
            }
        }
        // Si nada se lo impide, ataca normalmente
        if (puedeMoverse) {
            personajeBase.atacar(objetivo);
        }

        // Al final del turno, sufre daños continuos (ej. veneno)
        procesarEstados();
    }

    private void procesarEstados() {
        List<IEstadoAlterado> aEliminar = new ArrayList<>();
        for (IEstadoAlterado estado : estadosActivos) {
            estado.aplicarEfectoPorTurno(personajeBase, vista);
            estado.disminuirDuracion();
            if (!estado.estaActivo()) {
                aEliminar.add(estado);
                vista.mostrarMensaje("El efecto de " + estado.getNombre()
                        + " ha terminado en " + personajeBase.getNombre());
            }
        }
        estadosActivos.removeAll(aEliminar);
    }

    @Override
    public void defender(int danoEntrante) {
        personajeBase.defender(danoEntrante);
    }

    @Override
    public boolean estaVivo() {
        return personajeBase.estaVivo();
    }

    @Override
    public String getNombre() {
        return personajeBase.getNombre();
    }

    @Override
    public int getHpActual() {
        return personajeBase.getHpActual();
    }

}
