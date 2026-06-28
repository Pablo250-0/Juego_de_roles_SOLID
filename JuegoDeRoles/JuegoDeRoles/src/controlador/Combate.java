/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import interfaces.Combatiente;
import interfaces.IVistaCombate;

/**
 *
 * @author ASUS
 */
public class Combate {

    // la clase combate no sabe COMO se imprime, solo sabe a QUIEN mandarle 
    // el texto
    private final IVistaCombate vista;

    public Combate(IVistaCombate vista) {
        this.vista = vista;
    }

    public void iniciarBatalla(Combatiente p1, Combatiente p2) {
        vista.mostrarMensaje("===================================");
        vista.mostrarMensaje("       LA BATALLA COMIENZA          ");
        vista.mostrarMensaje("===================================");
        vista.mostrarMensaje(p1.getNombre() + "VS" + p2.getNombre());
        vista.mostrarMensaje("------------------------------------");

        int turno = 1;

        // bucle de combate: Continua mientras AMBOS esten vivos
        while (p1.estaVivo() && p2.estaVivo()) {
            vista.mostrarMensaje("\n-- RONDA " + turno + " --");
            vista.mostrarEstado(p1, p2);

            // turno del personaje 1
            ejecutarTurno(p1, p2);
            // verificamos si el personaje 2 esta vivo
            if (!p2.estaVivo()) {
                break;
            }
            ejecutarTurno(p2, p1);
            turno++;
        }
        // la batalla termino, evaluamos al ganador
        evaluarGanador(p1, p2);

    }

    private void ejecutarTurno(Combatiente atacante, Combatiente defensor) {
        vista.mostrarMensaje(atacante.getNombre() + " lanza su ataque contra "
                + defensor.getNombre());

        atacante.atacar(defensor);

        // mostramos como quedo la vida del defensor tra el ataque
        vista.mostrarMensaje("La salud de " + defensor.getNombre() + " baja a "
                + defensor.getHpActual() + "HP");

    }
    private void evaluarGanador(Combatiente p1, Combatiente p2){
    Combatiente ganador = p1.estaVivo() ? p1 : p2;
    Combatiente perdedor = p1.estaVivo() ? p2 : p1;
    
    vista.mostrarMensaje("\n====================================");
    vista.mostrarMensaje(perdedor.getNombre() + " ha caido");
    vista.mostrarMensaje("El ganador es " + ganador.getNombre().toUpperCase());
    
    
    }

}
