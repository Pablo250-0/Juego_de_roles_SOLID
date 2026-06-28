/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.magia;

/**
 *
 * @author ASUS
 */
public class MagiaAgua implements IEspecialidadMagica {

    @Override
    public String getNombreElemento() {
        return "Agua";
    }

    @Override
    public int calcularDanoElemental(int poderMagicoBase) {
        // El agua es equilibrada, daño normal pero constante
        return poderMagicoBase;
    }

    @Override
    public String obtenerEfectoVisual() {
        return "dispara un torrente de agua a alta presión";

    }

}
