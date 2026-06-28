package modelo;

public class Arma extends Objeto {

    public Arma(String nombre, int danioExtra) {
        super(nombre, danioExtra);
    }

    @Override
    public int getBonusAtaque() { return modificador; }

    @Override
    public int getBonusDefensa() { return 0; }
}