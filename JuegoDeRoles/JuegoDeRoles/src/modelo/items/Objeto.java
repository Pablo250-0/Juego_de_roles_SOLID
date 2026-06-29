package modelo.items;

// Define el contrato base de cualquier item del juego
public abstract class Objeto {
    protected String nombre;
    protected int modificador;

    public Objeto(String nombre, int modificador) {
        this.nombre = nombre;
        this.modificador = modificador;
    }

    // Retorna el nombre del objeto
    public String getNombre() { return nombre; }

    // Cada subclase decide como afecta al ataque
    public abstract int getBonusAtaque();

    // Cada subclase decide como afecta a la defensa
    public abstract int getBonusDefensa();
}