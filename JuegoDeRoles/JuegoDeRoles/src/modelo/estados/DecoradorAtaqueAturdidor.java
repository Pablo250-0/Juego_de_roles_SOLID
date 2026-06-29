package modelo.estados;

import interfaces.Combatiente;
import interfaces.IVistaCombate;

public class DecoradorAtaqueAturdidor implements Combatiente {

    private final Combatiente base;
    private final IVistaCombate vista;

    public DecoradorAtaqueAturdidor(Combatiente base, IVistaCombate vista) {
        this.base = base;
        this.vista = vista;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        base.atacar(objetivo);
        RegistroEstados.aplicarEstado(objetivo, new EstadoAturdido(1), vista);
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