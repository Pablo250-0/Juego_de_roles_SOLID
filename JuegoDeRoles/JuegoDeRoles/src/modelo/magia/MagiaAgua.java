package modelo.magia;
public class MagiaAgua implements IEspecialidadMagica {
    @Override public String getNombreElemento() { return "Agua"; }
    @Override public int calcularDanoElemental(int p) { return p; }
    @Override public String obtenerEfectoVisual() { return "dispara un torrente de agua a alta presión"; }
}
