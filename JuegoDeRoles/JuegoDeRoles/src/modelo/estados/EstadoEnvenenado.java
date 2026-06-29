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
public class EstadoEnvenenado implements IEstadoAlterado {

    private int turnosRestantes;
    private final int danoPorTurno = 5;

    public EstadoEnvenenado(int turnos) {
        this.turnosRestantes = turnos;
    }

    @Override
    public String getNombre() {
        return "Envenenado";
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
        return true;
    } // Puede atacar, el veneno no inmoviliza

    @Override
    public void aplicarEfectoPorTurno(Combatiente afectado, IVistaCombate vista) {
        vista.mostrarMensaje("El veneno consume a " + afectado.getNombre()
                + " perdiendo " + danoPorTurno + " HP");
        afectado.defender(danoPorTurno);
    }
}
