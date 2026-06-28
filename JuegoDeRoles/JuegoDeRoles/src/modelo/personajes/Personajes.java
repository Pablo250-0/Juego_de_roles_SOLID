/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.personajes;

import interfaces.Combatiente;
import interfaces.IVistaCombate;

/**
 *
 * @author ASUS
 */
public abstract class Personajes implements Combatiente {

    protected String nombre;
    protected int nivel;
    protected int hpMaximo;
    protected int hpActual;
    protected int experiencia;
    protected int experienciaRequerida;

    public Personajes(String nombre, int hpBase) {
        this.nombre = nombre;
        this.nivel = 1;
        this.hpMaximo = hpBase;
        this.hpActual = hpBase;
        this.experiencia = 0;
        this.experienciaRequerida = 100;
    }
    // --- IMPLEMENTACIÓN DE MÉTODOS COMUNES DE LA INTERFAZ ---

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public int getHpActual() {
        return this.hpActual;
    }

    @Override
    public boolean estaVivo() {
        return this.hpActual > 0;
    }

    // Método centralizado y protegido para evitar que otras clases manipulen la vida
    protected void recibirDano(int danoFinal) {
        this.hpActual = Math.max(0, this.hpActual - danoFinal);
    }

    // Progresión (SRP: El personaje gestiona su propia XP)
    public void ganarExperiencia(int xp, IVistaCombate vista) {
        this.experiencia += xp;
        vista.mostrarMensaje(this.nombre + " obtuvo " + xp + " puntos de experiencia.");
        verificarSubidaNivel(vista);
    }

    private void verificarSubidaNivel(IVistaCombate vista) {
        while (this.experiencia >= this.experienciaRequerida) {
            this.nivel++;
            this.experiencia -= this.experienciaRequerida;
            this.experienciaRequerida += 50;
            aplicarMejoraNivel(); // Llama a la lógica de la clase hija
            vista.mostrarMensaje("¡NUEVO NIVEL! " + this.nombre + " alcanzó el nivel " + this.nivel);
        }
    }

    @Override
    public abstract void atacar(Combatiente objetivo);

    @Override
    public abstract void defender(int danoEntrante);

    // Este no es de la interfaz, pero es obligatorio para que las clases hijas mejoren sus stats
    protected abstract void aplicarMejoraNivel();
}
