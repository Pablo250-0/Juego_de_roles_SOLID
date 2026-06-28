/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.magia;

/**
 *
 * @author ASUS
 */
public class MagiaAire implements IEspecialidadMagica {

    @Override
    public String getNombreElemento() {
        return "Aire";
    }

    @Override
    public int calcularDanoElemental(int poderMagicoBase) {
        return (int) (poderMagicoBase * 0.5);

    }

    @Override
    public String obtenerEfectoVisual() {
        return "Dispara un embudo de viento concentrado";
    }

}
