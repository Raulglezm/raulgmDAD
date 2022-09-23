/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.mycompany.practica02.controller.Controller;
import com.mycompany.practica02.view.PantallaDialogo;
import com.mycompany.practica02.view.PantallaPrincipal;

/**
 *
 * @author alumno
 */
public class Main {
    
    public static void main(String[] args) {
        PantallaPrincipal viewPrincipal = new PantallaPrincipal();
        PantallaDialogo viewDialogo = new PantallaDialogo(viewPrincipal, true);
        Controller controller = new Controller(viewPrincipal, viewDialogo);
        controller.iniciar();
    }
}
