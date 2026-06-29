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
public class EstadoAturdido implements IEstadoAlterado {

    private int turnosRestantes;

    public EstadoAturdido(int turnos) {
        this.turnosRestantes = turnos;
    }

    @Override
    public String getNombre() {
        return "Aturdido";
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
        return false; // Impide atacar
    }

    @Override
    public void aplicarEfectoPorTurno(Combatiente afectado, IVistaCombate vista) {
        vista.mostrarMensaje(afectado.getNombre() + " está viendo estrellas por "
                + turnosRestantes + " turno(s) más");
    }
}
