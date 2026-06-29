package modelo.items;

// Representa una armadura que suma bonus a la defensa
public class Armadura extends Objeto {

    // Constructor que recibe nombre y bonus de defensa
    public Armadura(String nombre, int defensaExtra) {
        super(nombre, defensaExtra);
    }

    // Las armaduras no aportan ataque
    @Override
    public int getBonusAtaque() { return 0; }

    // Las armaduras solo aportan a la defensa
    @Override
    public int getBonusDefensa() { return modificador; }
}