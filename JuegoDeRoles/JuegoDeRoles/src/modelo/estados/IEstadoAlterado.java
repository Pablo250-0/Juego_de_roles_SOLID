/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.estados;

import interfaces.Combatiente;
import interfaces.IVistaCombate;

/**
 *
 * @author ASUS
 */
public interface IEstadoAlterado {

    String getNombre();

    boolean estaActivo();

    void disminuirDuracion();

    boolean permiteAtacar();

    void aplicarEfectoPorTurno(Combatiente afectado, IVistaCombate vista);
}
