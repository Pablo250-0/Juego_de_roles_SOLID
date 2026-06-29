package modelo.personajes;

import interfaces.Combatiente;

public class Guerrero extends Personajes {
    private int fuerza;
    private int armaduraBase;

    public Guerrero(String nombre, int fuerza, int armaduraBase, int hpBase) {
        super(nombre, hpBase);
        this.fuerza = fuerza;
        this.armaduraBase = armaduraBase;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        objetivo.defender(fuerza * 2);
    }

    @Override
    public void defender(int danoEntrante) {
        int danoFinal = Math.max(0, danoEntrante - armaduraBase);
        recibirDano(danoFinal);
    }

    @Override
    protected void aplicarMejoraNivel() {
        this.fuerza += 5;
        this.armaduraBase += 3;
        this.hpMaximo += 20;
        this.hpActual = this.hpMaximo;
    }

    public int getFuerza() { return fuerza; }
    public void setFuerza(int fuerza) { this.fuerza = fuerza; }
    public int getArmaduraBase() { return armaduraBase; }
    public void setArmaduraBase(int a) { this.armaduraBase = a; }
}