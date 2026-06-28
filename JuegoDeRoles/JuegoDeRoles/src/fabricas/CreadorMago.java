/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import interfaces.Combatiente;
import modelo.magia.IEspecialidadMagica;
import modelo.personajes.Mago;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CreadorMago implements ICreadorPersonaje {

    // Lista de magias que este creador puede ofrecer
    private final List<IEspecialidadMagica> magiasDisponibles;

    public CreadorMago(List<IEspecialidadMagica> magiasDisponibles) {
        this.magiasDisponibles = magiasDisponibles;
    }

    @Override
    public String getNombreClaseMenu() {
        return "Mago";
    }

    @Override
    public boolean requiereSubMenu() {
        return true; // El Mago SÍ necesita preguntar qué elemento quiere
    }

    @Override
    public String[] getOpcionesSubMenu() {
        // Extraemos los nombres de las magias para mostrarlas en el menú
        String[] opciones = new String[magiasDisponibles.size()];
        for (int i = 0; i < magiasDisponibles.size(); i++) {
            opciones[i] = magiasDisponibles.get(i).getNombreElemento();
        }
        return opciones;

    }

    @Override
    public Combatiente crear(String nombreJugador, int opcionSubMenu) {
        IEspecialidadMagica magiaElegida = magiasDisponibles.get(opcionSubMenu);
        return new Mago(20, 5, magiaElegida, nombreJugador, 100);
        }

}
