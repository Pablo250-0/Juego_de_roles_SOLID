package modelo.personajes;

import interfaces.Combatiente;
import modelo.items.Inventario;

public class Guerrero extends Personajes {

    private int fuerza;
    private int armaduraBase;
    private final Inventario inventario;

    public Guerrero(String nombre, int fuerza, int armaduraBase,
                    int hpBase, Inventario inventario) {
        super(nombre, hpBase);          // sigue el mismo patron que Mago
        this.fuerza = fuerza;
        this.armaduraBase = armaduraBase;
        this.inventario = inventario;
    }

    // Calcula ataque base + bonus del arma equipada
    public int calcularAtaque() {
        int bonus = inventario.getEquipado() != null
                ? inventario.getEquipado().getBonusAtaque() : 0;
        return fuerza * 2 + bonus;
    }

    // Calcula defensa base + bonus de armadura equipada
    public int calcularDefensa() {
        int bonus = inventario.getEquipado() != null
                ? inventario.getEquipado().getBonusDefensa() : 0;
        return armaduraBase + bonus;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        // igual que Mago.atacar() — delega el calculo, no lo hardcodea
        objetivo.defender(calcularAtaque());
    }

    @Override
    public void defender(int danoEntrante) {
        int danoFinal = Math.max(0, danoEntrante - calcularDefensa());
        recibirDano(danoFinal);         // metodo del padre, igual que Mago
    }

    @Override
    protected void aplicarMejoraNivel() {
        this.fuerza += 5;
        this.armaduraBase += 3;
        this.hpMaximo += 20;
        this.hpActual = this.hpMaximo;
    }

    public Inventario getInventario() { return inventario; }

    // Getters y setters para GuerreroNivel si se necesitan
    public int getFuerza() { return fuerza; }
    public void setFuerza(int fuerza) { this.fuerza = fuerza; }
    public int getArmaduraBase() { return armaduraBase; }
    public void setArmaduraBase(int armaduraBase) { this.armaduraBase = armaduraBase; }
}