/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author ASUS
 */
public interface Combatiente {

    void atacar(Combatiente objetivo);

    void defender(int danioEntrante);

    boolean estaVivo();

    String getNombre();

    int getHpActual();

}
