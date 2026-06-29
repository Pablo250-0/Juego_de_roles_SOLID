package modelo.personajes;

import interfaces.Combatiente;
import interfaces.IVistaCombate;

public class Guerrero extends Personajes {

    private int fuerza;
    private int armaduraBase;

    public Guerrero(String nombre, int fuerza, int armaduraBase, int hpBase) {
        super(nombre, hpBase, 60);
        this.fuerza = fuerza;
        this.armaduraBase = armaduraBase;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        objetivo.defender(fuerza * 2);
    }

    @Override
    public void defender(int danioEntrante) {
        int danoFinal = Math.max(0, danioEntrante - armaduraBase);
        recibirDano(danoFinal);
    }

    @Override
    public int getCostoMana() {
        return 30;
    }

    @Override
    public int getCooldownMaximo() {
        return 2;
    }

    @Override
    protected void ejecutarHabilidadEspecial(Combatiente objetivo, IVistaCombate vista) {
        int dano = fuerza * 3;
        vista.mostrarMensaje(nombre + " usa ¡GOLPE DEVASTADOR! causando " + dano + " de daño.");
        objetivo.defender(dano);
    }

    @Override
    protected void aplicarMejoraNivel() {
        this.fuerza += 5;
        this.armaduraBase += 3;
        this.hpMaximo += 20;
        this.manaMaximo += 10;
        this.hpActual = this.hpMaximo;
        this.manaActual = this.manaMaximo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getArmaduraBase() {
        return armaduraBase;
    }

    public void setArmaduraBase(int a) {
        this.armaduraBase = a;
    }

    @Override
    public String toString() {
        return "Guerrero [" + nombre + "] | Nivel: " + nivel
                + " | Vida: " + hpActual + "/" + hpMaximo
                + " | Maná: " + manaActual + "/" + manaMaximo
                + " | Fuerza: " + fuerza
                + " | Armadura: " + armaduraBase
                + " | Cooldown: " + cooldownHabilidad;
    }
}
