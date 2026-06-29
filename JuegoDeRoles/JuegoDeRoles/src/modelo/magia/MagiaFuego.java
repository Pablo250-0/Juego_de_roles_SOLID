package modelo.magia;
public class MagiaFuego implements IEspecialidadMagica {
    @Override public String getNombreElemento() { return "Fuego"; }
    @Override public int calcularDanoElemental(int p) { return (int)(p * 1.5); }
    @Override public String obtenerEfectoVisual() { return "lanza una bola de fuego"; }
}
