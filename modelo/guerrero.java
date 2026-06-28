package modelo;
import Interfaces.*;
public class guerrero extends Personaje implements Combatiente {
    private int fuerza;
    private int armaduraBase;
    private GuerreroNivel sistemaNivel;

    public guerrero(String nombre, int fuerza, int armaduraBase,
                    Inventario inventario, GuerreroNivel sistemaNivel) {
        super(inventario);            // ← fix del error
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.armaduraBase = armaduraBase;
        this.hpMaximo = 100;
        this.hpActual = 100;
        this.sistemaNivel = sistemaNivel;
    }

    @Override
    public int calcularAtaque() {
        int bonus = inventario.getEquipado() != null
                ? inventario.getEquipado().getBonusAtaque() : 0;
        return fuerza * 2 + bonus;
    }

    @Override
    public int calcularDefensa() {
        int bonus = inventario.getEquipado() != null
                ? inventario.getEquipado().getBonusDefensa() : 0;
        return armaduraBase + bonus;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        int dano = calcularAtaque();
        System.out.println(nombre + " ataca con " + dano + " de daño!");
        objetivo.defender(dano);
    }

    @Override
    public void defender(int danoEntrante) {
        int danoFinal = Math.max(0, danoEntrante - calcularDefensa());
        System.out.println(nombre + " recibe " + danoFinal + " de daño real.");
        recibirDanoFinal(danoFinal);
    }

    @Override
    protected void aplicarMejoraNivel() {
        sistemaNivel.aplicarMejora(this);
    }

    // Getters y setters
    public int getFuerza() { return fuerza; }
    public void setFuerza(int fuerza) { this.fuerza = fuerza; }
    public int getArmaduraBase() { return armaduraBase; }
    public void setArmaduraBase(int armaduraBase) { this.armaduraBase = armaduraBase; }
}