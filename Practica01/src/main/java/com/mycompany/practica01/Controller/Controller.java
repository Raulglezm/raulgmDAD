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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.btnAbrir) {
            gf.Abrir();
        }

        if (e.getSource()== this.view.btnGuardar) {
            gf.Guardar();
        }

        if (e.getSource() == this.view.btnAdd) {
            add(view.txtField.getText());
            view.txtArea.setText(mostrarContenido());
        }
    }

    public void add(String texto) {
        if (texto.length() > 0) {
            archivo.addlinea(texto);
        }
    }

    public String mostrarContenido() {
        String texto = "";
        for (String txt : archivo.getTextos()) {
            texto += txt + "\n";
        }
        return texto;
    }

}
