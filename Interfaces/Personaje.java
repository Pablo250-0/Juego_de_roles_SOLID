package Interfaces;
import modelo.*;

public abstract class Personaje implements Combatiente {
    protected String nombre;
    protected int nivel;
    protected int hpMaximo;
    protected int hpActual;
    protected int experiencia;
    protected int experienciaRequerida;
    protected Inventario inventario;

    public Personaje(Inventario inventario) {
        this.inventario = inventario;
        this.nivel = 1;
        this.experiencia = 0;
        this.experienciaRequerida = 100;
    }

    public String getNombre() { return nombre; }
    public int getHpActual() { return hpActual; }
    public int getHpMaximo() { return hpMaximo; }
    public boolean estaVivo() { return hpActual > 0; }
    public Inventario getInventario() { return inventario; }

    public void setHpMaximo(int hpMaximo) { this.hpMaximo = hpMaximo; }
    public void setHpActual(int hpActual) { this.hpActual = hpActual; }

    public void recibirDanoFinal(int dano) {
        hpActual = Math.max(0, hpActual - dano);
    }

    public void ganarExperiencia(int xp, IVistaCombate vista) {
        experiencia += xp;
        vista.mostrarMensaje(nombre + " ganó " + xp + " XP.");
        verificarSubidaNivel(vista);
    }

    public void verificarSubidaNivel(IVistaCombate vista) {
        if (experiencia >= experienciaRequerida) {
            nivel++;
            experiencia = 0;
            experienciaRequerida += 50;
            aplicarMejoraNivel();
            vista.mostrarMensaje(nombre + " subió al nivel " + nivel + "!");
        }
    }

    public abstract int calcularAtaque();
    public abstract int calcularDefensa();
    protected abstract void aplicarMejoraNivel();
}