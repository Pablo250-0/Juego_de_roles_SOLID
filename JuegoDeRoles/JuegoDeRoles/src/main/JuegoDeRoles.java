package main;

import controlador.GestorJuego;
import controlador.Combate;
import fabricas.CreadorArquero;
import fabricas.CreadorGuerrero;
import fabricas.CreadorMago;
import fabricas.ICreadorPersonaje;
import fabricas.CreadorConEstados;
import interfaces.IVistaCombate;
import modelo.magia.MagiaAgua;
import modelo.magia.MagiaFuego;
import modelo.magia.MagiaAire;
import modelo.magia.MagiaTierra;
import modelo.magia.IEspecialidadMagica;
import vista.VistaConsola;
import java.util.ArrayList;
import java.util.List;

public class JuegoDeRoles {

    public static void main(String[] args) {

        // --- Inicialización ---
        IVistaCombate vista = new VistaConsola();
        Combate motor = new Combate(vista);

        // --- Catálogo de magias ---
        List<IEspecialidadMagica> catalogoMagias = new ArrayList<>();
        catalogoMagias.add(new MagiaFuego());
        catalogoMagias.add(new MagiaAgua());
        catalogoMagias.add(new MagiaTierra());
        catalogoMagias.add(new MagiaAire());

        // --- Registro de Clases con Decoradores ---
        List<ICreadorPersonaje> registroClases = new ArrayList<>();

        // El Mago (recibe estados y sus ataques congelan)
        ICreadorPersonaje creadorMago = new CreadorMago(catalogoMagias);
        registroClases.add(new CreadorConEstados(creadorMago, vista));

        // El Arquero (solo recibe estados)
        ICreadorPersonaje creadorArquero = new CreadorArquero();
        registroClases.add(new CreadorConEstados(creadorArquero, vista));

        // El Guerrero (solo recibe estados)
        ICreadorPersonaje creadorGuerrero = new CreadorGuerrero();
        registroClases.add(new CreadorConEstados(creadorGuerrero, vista));

        // --- Inicio del Gestor ---
        GestorJuego gestor = new GestorJuego(vista, motor, registroClases);
        gestor.iniciar();
    }
}