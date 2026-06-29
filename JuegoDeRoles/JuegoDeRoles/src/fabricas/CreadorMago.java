package fabricas;

import interfaces.Combatiente;
import modelo.magia.IEspecialidadMagica;
import modelo.personajes.Mago;
import java.util.List;

public class CreadorMago implements ICreadorPersonaje {

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
        return true;
    }

    @Override
    public String[] getOpcionesSubMenu() {
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
