package modelo.personajes;

import interfaces.Combatiente;
import interfaces.IVistaCombate;

public class Arquero extends Personajes {

    private int flechas;
    private int punteria;
    private int armadura;

    public Arquero(int flechas, int punteria, int armadura, String nombre, int hpBase) {
        super(nombre, hpBase, 50);
        this.flechas = flechas;
        this.punteria = punteria;
        this.armadura = armadura;
    }

    public int getFlechas() {
        return flechas;
    }

    public void setFlechas(int flechas) {
        this.flechas = flechas;
    }

    public int getPunteria() {
        return punteria;
    }

    public void setPunteria(int punteria) {
        this.punteria = punteria;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        int danoGenerado;
        if (flechas > 0) {
            flechas--;
            danoGenerado = punteria;
        } else {
            System.out.println(nombre + " se quedó sin flechas.");
            danoGenerado = punteria / 2;
        }
        objetivo.defender(danoGenerado);
    }

    @Override
    public void defender(int danioEntrante) {
        int danoFinal = Math.max(0, danioEntrante - this.armadura);
        recibirDano(danoFinal);
    }

    @Override
    public int getCostoMana() {
        return 25;
    }

    @Override
    public int getCooldownMaximo() {
        return 2;
    }

    @Override
    protected void ejecutarHabilidadEspecial(Combatiente objetivo, IVistaCombate vista) {
        if (flechas >= 3) {
            flechas -= 3;
            int dano = punteria * 3;
            vista.mostrarMensaje(nombre + " usa ¡LLUVIA DE FLECHAS! disparando 3 flechas por " + dano + " de daño total.");
            objetivo.defender(dano);
        } else {
            int danoReducido = punteria * Math.max(1, flechas);
            vista.mostrarMensaje(nombre + " usa LLUVIA DE FLECHAS con pocas flechas (" + flechas + "), causando " + danoReducido + " de daño.");
            flechas = 0;
            objetivo.defender(danoReducido);
        }
    }

    @Override
    protected void aplicarMejoraNivel() {
        this.punteria += 5;
        this.flechas += 10;
        this.armadura += 3;
        this.hpMaximo += 15;
        this.manaMaximo += 10;
        this.hpActual = this.hpMaximo;
        this.manaActual = this.manaMaximo;
    }

    @Override
    public String toString() {
        return "Arquero [" + nombre + "] | Nivel: " + nivel
                + " | Vida: " + hpActual + "/" + hpMaximo
                + " | Maná: " + manaActual + "/" + manaMaximo
                + " | Flechas: " + flechas
                + " | Puntería: " + punteria
                + " | Armadura: " + armadura
                + " | Cooldown: " + cooldownHabilidad;
    }
}
