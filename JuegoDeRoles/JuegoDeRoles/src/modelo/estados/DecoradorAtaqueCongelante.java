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
public class DecoradorAtaqueCongelante implements Combatiente {

    private final Combatiente base;
    private final IVistaCombate vista;

    public DecoradorAtaqueCongelante(Combatiente base, IVistaCombate vista) {
        this.base = base;
        this.vista = vista;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        // El personaje base hace su ataque normal y genera su daño
        base.atacar(objetivo);
        // Inyectamos el estado alterado en el objetivo usando nuestro Registro Global
        // Aplicamos 1 turno de congelación al objetivo
        RegistroEstados.aplicarEstado(objetivo, new EstadoCongelado(1), vista);
    }

    // --- DELEGACIÓN ABSOLUTA A LA CLASE BASE ---
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
