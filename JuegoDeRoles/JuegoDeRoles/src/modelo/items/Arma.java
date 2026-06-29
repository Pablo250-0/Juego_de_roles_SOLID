package modelo.items;

// Representa un arma que suma bonus al ataque
public class Arma extends Objeto {

    // Constructor que recibe nombre y bonus de daño
    public Arma(String nombre, int danioExtra) {
        super(nombre, danioExtra);
    }

    // Las armas solo aportan al ataque
    @Override
    public int getBonusAtaque() { return modificador; }

    // Las armas no aportan defensa
    @Override
    public int getBonusDefensa() { return 0; }
}