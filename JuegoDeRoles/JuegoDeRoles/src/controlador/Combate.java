package controlador;

import interfaces.Combatiente;
import interfaces.IVistaCombate;
import modelo.personajes.Personajes;

public class Combate {

    private final IVistaCombate vista;

    public Combate(IVistaCombate vista) {
        this.vista = vista;
    }

    public void iniciarBatalla(Combatiente p1, Combatiente p2) {
        vista.mostrarMensaje("===================================");
        vista.mostrarMensaje("       LA BATALLA COMIENZA          ");
        vista.mostrarMensaje("===================================");
        vista.mostrarMensaje(p1.getNombre() + " VS " + p2.getNombre());
        vista.mostrarMensaje("------------------------------------");

        int turno = 1;

        while (p1.estaVivo() && p2.estaVivo()) {
            vista.mostrarMensaje("\n-- RONDA " + turno + " --");
            vista.mostrarEstado(p1, p2);

            ejecutarTurno(p1, p2);
            if (!p2.estaVivo()) break;

            ejecutarTurno(p2, p1);

            if (p1 instanceof Personajes) {
                ((Personajes) p1).recuperarMana(10);
                ((Personajes) p1).reducirCooldown();
            }
            if (p2 instanceof Personajes) {
                ((Personajes) p2).recuperarMana(10);
                ((Personajes) p2).reducirCooldown();
            }

            turno++;
        }

        evaluarGanador(p1, p2);
    }

    private void ejecutarTurno(Combatiente atacante, Combatiente defensor) {
        vista.mostrarMensaje(atacante.getNombre() + " lanza su ataque contra " + defensor.getNombre());

        boolean usóHabilidad = false;

        if (atacante instanceof Personajes) {
            usóHabilidad = ((Personajes) atacante).usarHabilidadEspecial(defensor, vista);
        }

        if (!usóHabilidad) {
            atacante.atacar(defensor);
        }

        vista.mostrarMensaje("La salud de " + defensor.getNombre() + " baja a " + defensor.getHpActual() + " HP");
    }

    private void evaluarGanador(Combatiente p1, Combatiente p2) {
        Combatiente ganador = p1.estaVivo() ? p1 : p2;
        Combatiente perdedor = p1.estaVivo() ? p2 : p1;

        vista.mostrarMensaje("\n====================================");
        vista.mostrarMensaje(perdedor.getNombre() + " ha caido");
        vista.mostrarMensaje("El ganador es " + ganador.getNombre().toUpperCase());
    }
}
