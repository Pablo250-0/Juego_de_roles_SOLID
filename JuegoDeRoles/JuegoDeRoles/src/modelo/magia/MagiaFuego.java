/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.magia;

/**
 *
 * @author ASUS
 */
public class MagiaFuego implements IEspecialidadMagica {

    @Override
    public String getNombreElemento() {
        return "Fuego";
    }

    @Override
    public int calcularDanoElemental(int poderMagicoBase) {
        // El fuego es ofensivo: aumenta el daño un 50%
        return (int) (poderMagicoBase * 1.5);
    }

    @Override
    public String obtenerEfectoVisual() {
        return "lanza una bola de fuego";
    }

}
