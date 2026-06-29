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

        // El Mago (Recibe estados y además sus ataques congelan)
        ICreadorPersonaje creadorMago = new CreadorMago(catalogoMagias);
        registroClases.add(new CreadorConEstados(creadorMago, vista));

        // El Arquero (Solo recibe estados)
        ICreadorPersonaje creadorArquero = new CreadorArquero();
        registroClases.add(new CreadorConEstados(creadorArquero, vista));

        // El Guerrero (Solo recibe estados)
        ICreadorPersonaje creadorGuerrero = new CreadorGuerrero();
        registroClases.add(new CreadorConEstados(creadorGuerrero, vista));

        // ---  Inicio del Gestor ---
        GestorJuego gestor = new GestorJuego(vista, motor, registroClases);
        gestor.iniciar();
    }
}
