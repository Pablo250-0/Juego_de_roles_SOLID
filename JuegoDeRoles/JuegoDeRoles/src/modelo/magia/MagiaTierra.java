/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.magia;

/**
 *
 * @author ASUS
 */
public class MagiaTierra implements IEspecialidadMagica{

    @Override
    public String getNombreElemento() {
        return "Tierra";
    }

    @Override
    public int calcularDanoElemental(int poderMagicoBase) {
        return (int) (poderMagicoBase * 1.0);
    }

    @Override
    public String obtenerEfectoVisual() {
        return "dispara estalagmitas afiladas desde el suelo";
    
    }
    
}
