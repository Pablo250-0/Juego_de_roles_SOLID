/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.estados;

import interfaces.Combatiente;
import interfaces.IVistaCombate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class RegistroEstados {

    // Un mapa que asocia a cada combatiente con sus estados actuales
    private static final Map<Combatiente, List<IEstadoAlterado>> historial = new HashMap<>();

    public static void aplicarEstado(Combatiente victima, IEstadoAlterado estado, IVistaCombate vista) {
        historial.computeIfAbsent(victima, k -> new ArrayList<>()).add(estado);
        vista.mostrarMensaje(victima.getNombre() + " ha sido afectado por: " + estado.getNombre());
    }

    public static boolean puedeMoverse(Combatiente combatiente) {
        List<IEstadoAlterado> estados = historial.getOrDefault(combatiente, new ArrayList<>());
        for (IEstadoAlterado e : estados) {
            if (!e.permiteAtacar()) {
                return false;
            }
        }
        return true;
    }

    public static void procesarFinDeTurno(Combatiente combatiente, IVistaCombate vista) {
        List<IEstadoAlterado> estados = historial.getOrDefault(combatiente, new ArrayList<>());
        List<IEstadoAlterado> aEliminar = new ArrayList<>();

        for (IEstadoAlterado estado : estados) {
            estado.aplicarEfectoPorTurno(combatiente, vista);
            estado.disminuirDuracion();
            if (!estado.estaActivo()) {
                aEliminar.add(estado);
                vista.mostrarMensaje("El efecto de " + estado.getNombre() + " ha terminado.");
            }
        }
        estados.removeAll(aEliminar);
    }

}
