/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica01.Controller;

import com.mycompany.practica01.Model.Archivo;
import com.mycompany.practica01.Model.GestorFichero;
import com.mycompany.practica01.View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;

/**
 *
 * @author alumno
 */
public class Controller implements ActionListener {

    Archivo archivo;
    GestorFichero gf;
    View view;

    public Controller(View view) {
        archivo = new Archivo();
        gf = new GestorFichero();
        this.view = view;
        this.view.btnAbrir.addActionListener(this);
        this.view.btnAdd.addActionListener(this);
        this.view.btnGuardar.addActionListener(this);
        this.view.txtField.addActionListener(this);
        this.view.btnBorrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.view.btnBorrar) {
            if (gf.isGuardado()) {
                archivo = new Archivo();
                view.txtArea.setText(mostrarContenido());
            } else {
                String[] botones = {"SI", "NO"};
                int option = JOptionPane.showOptionDialog(view, "El archivo no se ha guardado", "¿Desea borrarlo?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, archivo);

                if (option == 0) {
                    archivo = new Archivo();
                    view.txtArea.setText(mostrarContenido());
                }
            }
        }

        if (e.getSource() == this.view.btnAbrir) {
            gf.Abrir(this.archivo);
            view.txtArea.setText(mostrarContenido());
        }

        if (e.getSource() == this.view.btnGuardar) {
            if (gf.Guardar(this.archivo)) {
                gf.setGuardado(true);
            }

        }

        if (e.getSource() == this.view.btnAdd) {
            if (add(view.txtField.getText())) {
                view.txtArea.setText(mostrarContenido());
                view.txtField.setText("");
                gf.setGuardado(false);
            }

        }
    }

    public boolean add(String texto) {
        if (texto.length() > 0) {
            archivo.addlinea(texto);
            return true;
        }
        return false;
    }

    public String mostrarContenido() {
        String texto = "";
        for (String txt : archivo.getTextos()) {
            texto += txt + "\n";
        }
        return texto;
    }

    public void Iniciar() {
        this.view.setVisible(true);
    }

}
