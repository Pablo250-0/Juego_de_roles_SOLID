/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controlador.GestorJuego;
import controlador.Combate;
import fabricas.CreadorArquero;
import fabricas.CreadorMago;
import fabricas.ICreadorPersonaje;
import interfaces.IVistaCombate;
import modelo.magia.MagiaAgua;
import modelo.magia.MagiaFuego;
import modelo.magia.MagiaAire;
import modelo.magia.MagiaTierra;
import modelo.magia.IEspecialidadMagica;
import vista.VistaConsola;
import fabricas.CreadorGuerrero;
import java.util.ArrayList;
import java.util.List;
import fabricas.CreadorConEstados; // Import del decorador de fábricas

/**
 *
 * @author ASUS
 */
public class JuegoDeRoles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IVistaCombate vista = new VistaConsola();
        Combate motor = new Combate(vista);

        // Preparamos el catálogo de magias
        List<IEspecialidadMagica> catalogoMagias = new ArrayList<>();
        catalogoMagias.add(new MagiaFuego());
        catalogoMagias.add(new MagiaAgua());
        catalogoMagias.add(new MagiaTierra());
        catalogoMagias.add(new MagiaAire());

        // --- Registro de clases (Ensamblaje del juego) ---
        List<ICreadorPersonaje> registroClases = new ArrayList<>();

        // Preparamos el catálogo de Clases Base
        // Registramos al Mago, envuelto en el CreadorConEstados para activar el sistema de estados
        ICreadorPersonaje creadorMago = new CreadorMago(catalogoMagias);
        registroClases.add(new CreadorConEstados(creadorMago, vista));

        // Registramos al Arquero, también envuelto para que soporte estados
        ICreadorPersonaje creadorArquero = new CreadorArquero();
        registroClases.add(new CreadorConEstados(creadorArquero, vista));

        // Registramos al Guerrero, también envuelto para que soporte estados
        ICreadorPersonaje creadorGuerrero = new CreadorGuerrero();
        registroClases.add(new CreadorConEstados(creadorGuerrero, vista));

        // --- Inicio del Gestor ---
        GestorJuego gestor = new GestorJuego(vista, motor, registroClases);
        gestor.iniciar();
    }

}
