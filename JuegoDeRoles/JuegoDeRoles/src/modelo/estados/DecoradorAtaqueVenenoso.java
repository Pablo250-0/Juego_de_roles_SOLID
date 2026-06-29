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
public class DecoradorAtaqueVenenoso implements Combatiente {

    private final Combatiente base;
    private final IVistaCombate vista;

    public DecoradorAtaqueVenenoso(Combatiente base, IVistaCombate vista) {
        this.base = base;
        this.vista = vista;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        base.atacar(objetivo); // Ataque normal de flecha
        // Aplica veneno por 3 turnos al objetivo
        RegistroEstados.aplicarEstado(objetivo, new EstadoEnvenenado(3), vista);
    }

    @Override
    public void defender(int danoEntrante) {
        base.defender(danoEntrante);
    }

    @Override
    public boolean estaVivo() {
        return base.estaVivo();
    }

    @Override
    public String getNombre() {
        return base.getNombre();
    }

    @Override
    public int getHpActual() {
        return base.getHpActual();
    }
}
