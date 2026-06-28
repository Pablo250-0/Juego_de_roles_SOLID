package modelo;
public class GuerreroNivel {

    public void aplicarMejora(guerrero g) {
        g.setFuerza(g.getFuerza() + 5);
        g.setArmaduraBase(g.getArmaduraBase() + 3);
        g.setHpMaximo(g.getHpMaximo() + 20);
        g.setHpActual(g.getHpMaximo()); // recupera HP al subir nivel
        System.out.println(g.getNombre() + " subió de nivel!");
        System.out.println("Fuerza: " + g.getFuerza() + " | Armadura: " + g.getArmaduraBase());
    }
}