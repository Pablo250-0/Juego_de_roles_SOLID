package modelo;

public interface Combatiente {
    void atacar(Combatiente objetivo);
    void defender(int danoEntrante);
    boolean estaVivo();
    String getNombre();
    int getHpActual();
}