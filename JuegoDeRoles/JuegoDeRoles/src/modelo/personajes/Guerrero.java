package modelo.personajes;

import interfaces.Combatiente;
import interfaces.IVistaCombate;
import modelo.items.Inventario;

// Personaje guerrero que usa inventario para calcular sus stats de combate
public class Guerrero extends Personajes {

    private int fuerza;
    private int armaduraBase;
    private final Inventario inventario;

    // Constructor que recibe stats base e inventario inyectado
    public Guerrero(String nombre, int fuerza, int armaduraBase,
                    int hpBase, Inventario inventario) {
        super(nombre, hpBase, 60);
        this.fuerza = fuerza;
        this.armaduraBase = armaduraBase;
        this.inventario = inventario;
    }

    // Calcula el ataque sumando fuerza base y bonus del arma equipada
    public int calcularAtaque() {
        int bonus = inventario.getEquipado() != null
                ? inventario.getEquipado().getBonusAtaque() : 0;
        return fuerza * 2 + bonus;
    }

    // Calcula la defensa sumando armadura base y bonus de la armadura equipada
    public int calcularDefensa() {
        int bonus = inventario.getEquipado() != null
                ? inventario.getEquipado().getBonusDefensa() : 0;
        return armaduraBase + bonus;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        objetivo.defender(calcularAtaque());
    }

    @Override
    public void defender(int danoEntrante) {
        int danoFinal = Math.max(0, danoEntrante - calcularDefensa());
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

    public Inventario getInventario() { return inventario; }
    public int getFuerza() { return fuerza; }
    public void setFuerza(int fuerza) { this.fuerza = fuerza; }
    public int getArmaduraBase() { return armaduraBase; }
    public void setArmaduraBase(int a) { this.armaduraBase = a; }

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