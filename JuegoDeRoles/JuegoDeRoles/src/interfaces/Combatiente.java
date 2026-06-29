package interfaces;

public interface Combatiente {

    void atacar(Combatiente objetivo);

    void defender(int danioEntrante);

    boolean estaVivo();

    String getNombre();

    int getHpActual();

    int getManaActual();

    int getCooldown();
}
