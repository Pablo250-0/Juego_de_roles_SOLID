/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.estados;

import interfaces.Combatiente;
import interfaces.IVistaCombate;

/**
 *
 * @author ASUS
 */
public class EstadoCongelado implements IEstadoAlterado {

    private int turnosRestantes;

    public EstadoCongelado(int turnos) {
        this.turnosRestantes = turnos;
    }

    @Override
    public String getNombre() {
        return "Congelado";
    }

    @Override
    public boolean estaActivo() {
        return turnosRestantes > 0;
    }

    @Override
    public void disminuirDuracion() {
        turnosRestantes--;
    }

    @Override
    public boolean permiteAtacar() {
        return false; // ¡Impide el ataque!
    } 

    @Override
    public void aplicarEfectoPorTurno(Combatiente afectado, IVistaCombate vista) {
        vista.mostrarMensaje(afectado.getNombre() + " sigue congelado por "
                + turnosRestantes + " turno(s) más.");
    }
}
