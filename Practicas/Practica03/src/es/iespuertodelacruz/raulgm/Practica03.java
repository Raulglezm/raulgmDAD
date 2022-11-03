/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.raulgm;

import es.iespuertodelacruz.raulgm.controller.Controller;
import es.iespuertodelacruz.raulgm.view.VistaAgregar;
import es.iespuertodelacruz.raulgm.view.VistaHistorial;
import es.iespuertodelacruz.raulgm.view.VistaPrincipal;

/**
 *
 * @author dam2
 */
public class Practica03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VistaPrincipal vp = new VistaPrincipal();
        VistaHistorial vh = new VistaHistorial();
        VistaAgregar va = new VistaAgregar(vh, false);
        
        Controller controller = new Controller(vp, va, vh);
        controller.Iniciar();
    }
    
}
