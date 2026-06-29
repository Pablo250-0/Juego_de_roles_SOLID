/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.personajes;

import interfaces.Combatiente;

/**
 *
 * @author ASUS
 */
public class Arquero extends Personajes {

    private int flechas;
    private int punteria;
    private int armadura;

    public Arquero(int flechas, int punteria, int armadura, String nombre, int hpBase) {
        super(nombre, hpBase);
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
            danoGenerado = punteria; //  usamos punteria como base de dano
        } else {
            System.out.println(nombre + " se quedó sin flechas.");
            danoGenerado = punteria / 2;
        }

        objetivo.defender(danoGenerado);
    }

    @Override
    public void defender(int danoEntrante) {
        // La armadura del arquero absorbe parte del daño entrante, igual que
        // la barrera mágica hace con el Mago.
        int danoFinal = Math.max(0, danoEntrante - this.armadura);
        recibirDano(danoFinal);
    }

    @Override
    protected void aplicarMejoraNivel() {
        // Crecimiento de estadísticas exclusivo del Arquero
        this.punteria += 5;
        this.flechas += 10;
        this.armadura += 3;
        this.hpMaximo += 15;

        // Curación al subir de nivel (mismo criterio que el Mago)
        this.hpActual = this.hpMaximo;
    }

    @Override
    public String toString() {
        return "Arquero [" + nombre + "] | Nivel: " + nivel
                + " | Vida: " + hpActual + "/" + hpMaximo
                + " | Flechas: " + flechas
                + " | Puntería: " + punteria
                + " | Armadura: " + armadura;
    }

}
