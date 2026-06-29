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
public class DecoradorReceptorEstados implements Combatiente {

    private final Combatiente base;
    private final IVistaCombate vista;

    public DecoradorReceptorEstados(Combatiente base, IVistaCombate vista) {
        this.base = base;
        this.vista = vista;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        // Preguntamos al registro si estamos congelados
        if (RegistroEstados.puedeMoverse(this)) {
            base.atacar(objetivo); // Atacamos normal
        } else {
            vista.mostrarMensaje(base.getNombre() + " está incapacitado y pierde su turno!");
        }
        // Al final de nuestro turno, el registro nos aplica el veneno
        RegistroEstados.procesarFinDeTurno(this, vista);
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
