package modelo.magia;
public class MagiaAire implements IEspecialidadMagica {
    @Override public String getNombreElemento() { return "Aire"; }
    @Override public int calcularDanoElemental(int p) { return (int)(p * 0.5); }
    @Override public String obtenerEfectoVisual() { return "Dispara un embudo de viento concentrado"; }
}
