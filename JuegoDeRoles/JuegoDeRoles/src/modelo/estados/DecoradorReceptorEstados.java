package modelo.estados;

import interfaces.Combatiente;
import interfaces.IVistaCombate;

public class DecoradorReceptorEstados implements Combatiente {

    private final Combatiente base;
    private final IVistaCombate vista;

    public DecoradorReceptorEstados(Combatiente base, IVistaCombate vista) {
        this.base = base;
        this.vista = vista;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        if (RegistroEstados.puedeMoverse(this)) {
            base.atacar(objetivo);
        } else {
            vista.mostrarMensaje(base.getNombre() + " está incapacitado y pierde su turno!");
        }
        RegistroEstados.procesarFinDeTurno(this, vista);
    }

    @Override
    public void defender(int danoEntrante) { base.defender(danoEntrante); }

    @Override
    public boolean estaVivo() { return base.estaVivo(); }

    @Override
    public String getNombre() { return base.getNombre(); }

    @Override
    public int getHpActual() { return base.getHpActual(); }

    @Override
    public int getManaActual() { return base.getManaActual(); }

    @Override
    public int getCooldown() { return base.getCooldown(); }
}