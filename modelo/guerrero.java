package modelo;
// guerrero.java — ya no implements Combatiente, lo hereda de Personaje
public class guerrero extends Personaje {
    private int fuerza;
    private int armaduraBase;

    public guerrero(String nombre, int fuerza, int armaduraBase,
                    Inventario inventario) {
        super(inventario);
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.armaduraBase = armaduraBase;
        this.hpMaximo = 100;
        this.hpActual = 100;
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
        objetivo.defender(dano);
    }

    @Override
    public void defender(int danoEntrante) {
        int danoFinal = Math.max(0, danoEntrante - calcularDefensa());
        recibirDanoFinal(danoFinal);
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