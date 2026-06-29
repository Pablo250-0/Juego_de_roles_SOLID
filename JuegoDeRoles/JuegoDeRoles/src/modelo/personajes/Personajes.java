package modelo.personajes;

import interfaces.Combatiente;
import interfaces.IVistaCombate;

public abstract class Personajes implements Combatiente {

    protected String nombre;
    protected int nivel;
    protected int hpMaximo;
    protected int hpActual;
    protected int experiencia;
    protected int experienciaRequerida;

    protected int manaMaximo;
    protected int manaActual;

    protected int cooldownHabilidad;

    public Personajes(String nombre, int hpBase, int manaBase) {
        this.nombre = nombre;
        this.nivel = 1;
        this.hpMaximo = hpBase;
        this.hpActual = hpBase;
        this.manaMaximo = manaBase;
        this.manaActual = manaBase;
        this.cooldownHabilidad = 0;
        this.experiencia = 0;
        this.experienciaRequerida = 100;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public int getHpActual() {
        return this.hpActual;
    }

    @Override
    public boolean estaVivo() {
        return this.hpActual > 0;
    }

    @Override
    public int getManaActual() {
        return this.manaActual;
    }

    @Override
    public int getCooldown() {
        return this.cooldownHabilidad;
    }

    public boolean usarHabilidadEspecial(Combatiente objetivo, IVistaCombate vista) {
        if (cooldownHabilidad > 0) {
            vista.mostrarMensaje("  [" + nombre + "] Habilidad en cooldown (" + cooldownHabilidad + " turnos restantes). Ataque normal.");
            return false;
        }
        if (manaActual < getCostoMana()) {
            vista.mostrarMensaje("  [" + nombre + "] Maná insuficiente (" + manaActual + "/" + getCostoMana() + "). Ataque normal.");
            return false;
        }
        manaActual -= getCostoMana();
        cooldownHabilidad = getCooldownMaximo();
        ejecutarHabilidadEspecial(objetivo, vista);
        return true;
    }

    public void reducirCooldown() {
        if (cooldownHabilidad > 0) {
            cooldownHabilidad--;
        }
    }

    public void recuperarMana(int cantidad) {
        manaActual = Math.min(manaMaximo, manaActual + cantidad);
    }

    protected void recibirDano(int danoFinal) {
        this.hpActual = Math.max(0, this.hpActual - danoFinal);
    }

    public void ganarExperiencia(int xp, IVistaCombate vista) {
        this.experiencia += xp;
        vista.mostrarMensaje(this.nombre + " obtuvo " + xp + " puntos de experiencia.");
        verificarSubidaNivel(vista);
    }

    private void verificarSubidaNivel(IVistaCombate vista) {
        while (this.experiencia >= this.experienciaRequerida) {
            this.nivel++;
            this.experiencia -= this.experienciaRequerida;
            this.experienciaRequerida += 50;
            aplicarMejoraNivel();
            vista.mostrarMensaje("¡NUEVO NIVEL! " + this.nombre + " alcanzó el nivel " + this.nivel);
        }
    }

    @Override
    public abstract void atacar(Combatiente objetivo);

    @Override
    public abstract void defender(int danioEntrante);

    protected abstract void aplicarMejoraNivel();

    public abstract int getCostoMana();

    public abstract int getCooldownMaximo();

    protected abstract void ejecutarHabilidadEspecial(Combatiente objetivo, IVistaCombate vista);
}
