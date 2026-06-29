package modelo.personajes;

import interfaces.Combatiente;
import modelo.items.Inventario;

// Personaje guerrero que usa inventario para calcular sus stats de combate
public class Guerrero extends Personajes {
    private int fuerza;
    private int armaduraBase;
    private final Inventario inventario;

    // Constructor que recibe stats base e inventario inyectado
    public Guerrero(String nombre, int fuerza, int armaduraBase,
                    int hpBase, Inventario inventario) {
        super(nombre, hpBase);
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

    // Delega el daño calculado al defensor sin conocer su tipo concreto
    @Override
    public void atacar(Combatiente objetivo) {
        objetivo.defender(calcularAtaque());
    }

    // Aplica el daño restando la defensa calculada
    @Override
    public void defender(int danoEntrante) {
        int danoFinal = Math.max(0, danoEntrante - calcularDefensa());
        recibirDano(danoFinal);
    }

    // Mejora los stats del guerrero al subir de nivel
    @Override
    protected void aplicarMejoraNivel() {
        this.fuerza += 5;
        this.armaduraBase += 3;
        this.hpMaximo += 20;
        this.hpActual = this.hpMaximo;
    }

    // Getters y setters de stats
    public Inventario getInventario() { return inventario; }
    public int getFuerza() { return fuerza; }
    public void setFuerza(int fuerza) { this.fuerza = fuerza; }
    public int getArmaduraBase() { return armaduraBase; }
    public void setArmaduraBase(int a) { this.armaduraBase = a; }
}