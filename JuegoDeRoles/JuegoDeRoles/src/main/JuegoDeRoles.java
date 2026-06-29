package main;

import controlador.GestorJuego;
import controlador.Combate;
import fabricas.CreadorArquero;
import fabricas.CreadorGuerrero;
import fabricas.CreadorMago;
import fabricas.ICreadorPersonaje;
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
        IVistaCombate vista = new VistaConsola();
        Combate motor = new Combate(vista);

        List<IEspecialidadMagica> catalogoMagias = new ArrayList<>();
        catalogoMagias.add(new MagiaFuego());
        catalogoMagias.add(new MagiaAgua());
        catalogoMagias.add(new MagiaTierra());
        catalogoMagias.add(new MagiaAire());

        List<ICreadorPersonaje> registroClases = new ArrayList<>();
        registroClases.add(new CreadorMago(catalogoMagias));
        registroClases.add(new CreadorGuerrero());
        registroClases.add(new CreadorArquero());  // CORREGIDO: antes había dos CreadorMago

        GestorJuego gestor = new GestorJuego(vista, motor, registroClases);
        gestor.iniciar();
    }
}
