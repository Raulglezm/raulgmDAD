/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.mycompany.practica01.Controller.Controller;
import com.mycompany.practica01.View.View;

/**
 *
 * @author alumno
 */
public class Main {
    
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        controller.Iniciar();
    }
}
