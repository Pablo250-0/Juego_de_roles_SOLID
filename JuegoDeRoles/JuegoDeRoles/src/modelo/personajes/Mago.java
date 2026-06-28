/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.personajes;

import interfaces.Combatiente;
import modelo.magia.IEspecialidadMagica;

/**
 *
 * @author ASUS
 */
public class Mago extends Personajes {

    private int poderMagico;
    private int barreraMagica;
    private IEspecialidadMagica especialidad;

    public Mago(int poderMagico, int barreraMagica, IEspecialidadMagica especialidad, String nombre, int hpBase) {
        super(nombre, hpBase);
        this.poderMagico = poderMagico;
        this.barreraMagica = barreraMagica;
        this.especialidad = especialidad;
    }

    @Override
    public void atacar(Combatiente objetivo) {
        // Delegamos el cálculo del daño al elemento mágico
        // El mago no necesita saber si es fuego o agua, la interfaz lo resuelve
        int danoGenerado = this.especialidad.calcularDanoElemental(this.poderMagico);

        // Aplicamos el daño al objetivo
        // no nos importa si el objetivo es un Guerrero o un Monstruo.
        objetivo.defender(danoGenerado);

    }

    @Override
    public void defender(int danoEntrante) {
        // La barrera mágica del mago absorbe parte del daño entrante.
        int danoFinal = Math.max(0, danoEntrante - this.barreraMagica);

        // Usamos el método centralizado de la clase padre Personajes para alterar el HP.
        recibirDano(danoFinal);

    }

    @Override
    protected void aplicarMejoraNivel() {
        // Crecimiento de estadísticas exclusivo del Mago
        this.poderMagico += 15;     // El mago prioriza el daño mágico
        this.barreraMagica += 5;    // Mejora ligeramente su defensa
        this.hpMaximo += 20;        // Aumenta su vida base

        // Curación al subir de nivel (mecánica clásica de RPG)
        this.hpActual = this.hpMaximo;
    }

    // Este getter será vital para que la VistaConsola pueda imprimir qué tipo de magia usó.
    public IEspecialidadMagica getEspecialidad() {
        return this.especialidad;
    }

}
