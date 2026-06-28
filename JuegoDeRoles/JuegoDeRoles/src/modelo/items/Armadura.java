package modelo.items;

public class Armadura extends Objeto {

    public Armadura(String nombre, int defensaExtra) {
        super(nombre, defensaExtra);
    }

    @Override
    public int getBonusAtaque() { return 0; }

    @Override
    public int getBonusDefensa() { return modificador; }
}
