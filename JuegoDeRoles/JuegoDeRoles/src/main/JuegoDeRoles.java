/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controlador.GestorJuego;
import controlador.Combate;
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

/**
 *
 * @author ASUS
 */
public class JuegoDeRoles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IVistaCombate vista = new VistaConsola();
        Combate motor = new Combate(vista);

        // Preparamos el catálogo de magias
        List<IEspecialidadMagica> catalogoMagias = new ArrayList<>();
        catalogoMagias.add(new MagiaFuego());
        catalogoMagias.add(new MagiaAgua());
        catalogoMagias.add(new MagiaTierra());
        catalogoMagias.add(new MagiaAire());

        // Preparamos el catálogo de Clases Base
        List<ICreadorPersonaje> registroClases = new ArrayList<>();

        // Le inyectamos todas las magias al creador de magos
        registroClases.add(new CreadorMago(catalogoMagias));

       
        // Arrancamos el juego
        GestorJuego gestor = new GestorJuego(vista, motor, registroClases);
        gestor.iniciar();

    }

}
