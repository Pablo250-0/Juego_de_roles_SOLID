package modelo.personajes;

import interfaces.Combatiente;
import interfaces.IVistaCombate;
import modelo.magia.IEspecialidadMagica;

public class Mago extends Personajes {

    private int poderMagico;
    private int barreraMagica;
    private IEspecialidadMagica especialidad;

    public Mago(int poderMagico, int barreraMagica, IEspecialidadMagica especialidad, String nombre, int hpBase) {
        super(nombre, hpBase, 80);
        this.poderMagico = poderMagico;
        this.barreraMagica = barreraMagica;
        this.especialidad = especialidad;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        int danoGenerado = this.especialidad.calcularDanoElemental(this.poderMagico);
        objetivo.defender(danoGenerado);
    }

    @Override
    public void defender(int danioEntrante) {
        int danoFinal = Math.max(0, danioEntrante - this.barreraMagica);
        recibirDano(danoFinal);
    }

    @Override
    public int getCostoMana() {
        return 40;
    }

    @Override
    public int getCooldownMaximo() {
        return 3;
    }

    @Override
    protected void ejecutarHabilidadEspecial(Combatiente objetivo, IVistaCombate vista) {
        int dano = this.especialidad.calcularDanoElemental(this.poderMagico * 2);
        vista.mostrarMensaje(nombre + " usa ¡EXPLOSIÓN ELEMENTAL de " + especialidad.getNombreElemento()
                + "! " + especialidad.obtenerEfectoVisual() + " causando " + dano + " de daño.");
        objetivo.defender(dano);
    }

    @Override
    protected void aplicarMejoraNivel() {
        this.poderMagico += 15;
        this.barreraMagica += 5;
        this.hpMaximo += 20;
        this.manaMaximo += 15;
        this.hpActual = this.hpMaximo;
        this.manaActual = this.manaMaximo;
    }

    public IEspecialidadMagica getEspecialidad() {
        return this.especialidad;
    }

    @Override
    public String toString() {
        return "Mago [" + nombre + "] | Nivel: " + nivel
                + " | Vida: " + hpActual + "/" + hpMaximo
                + " | Maná: " + manaActual + "/" + manaMaximo
                + " | Poder Mágico: " + poderMagico
                + " | Barrera: " + barreraMagica
                + " | Especialidad: " + especialidad.getNombreElemento()
                + " | Cooldown: " + cooldownHabilidad;
    }
}
