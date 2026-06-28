package modelo;

public abstract class Objeto {
    protected String nombre;
    protected int modificador;

    public Objeto(String nombre, int modificador) {
        this.nombre = nombre;
        this.modificador = modificador;
    }

    public String getNombre() { return nombre; }
    public int getModificador() { return modificador; }

    public abstract int getBonusAtaque();
    public abstract int getBonusDefensa();
}
