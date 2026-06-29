package modelo.magia;
public class MagiaTierra implements IEspecialidadMagica {
    @Override public String getNombreElemento() { return "Tierra"; }
    @Override public int calcularDanoElemental(int p) { return (int)(p * 1.0); }
    @Override public String obtenerEfectoVisual() { return "dispara estalagmitas afiladas desde el suelo"; }
}
