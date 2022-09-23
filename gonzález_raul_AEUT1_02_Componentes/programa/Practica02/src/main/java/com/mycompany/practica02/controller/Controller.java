/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica02.controller;

import com.mycompany.practica02.view.PantallaDialogo;
import com.mycompany.practica02.view.PantallaPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import javax.swing.ImageIcon;

/**
 *
 * @author alumno
 */
public class Controller implements ActionListener {

    PantallaDialogo view;
    PantallaPrincipal viewPrincipal;

    public Controller(PantallaPrincipal viewPrincipal, PantallaDialogo view) {
        this.view = view;
        this.viewPrincipal = viewPrincipal;
        this.viewPrincipal.btnAcceder.addActionListener(this);
        this.view.jRadioButtonBanquete.addActionListener(this);
        this.view.jRadioButtonCongreso.addActionListener(this);
        this.view.jRadioButtonJornada.addActionListener(this);
        this.view.jRadioButtonReservar.addActionListener(this);
        this.view.jtxtApellido.addActionListener(this);
        this.view.jtxtNombre.addActionListener(this);
        style();
    }
    
    public void style(){
        Font font = new Font("Serif", Font.BOLD, 12);
        this.viewPrincipal.btnAcceder.setBackground(Color.DARK_GRAY);
        this.viewPrincipal.btnAcceder.setFont(font);
        this.viewPrincipal.btnAcceder.setForeground(Color.WHITE);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.viewPrincipal.btnAcceder){
            view.setVisible(true);
        }
        
        if (this.view.jRadioButtonCongreso.isSelected()) {
            this.view.jSpinnerJornadasCongreso.setEnabled(true);
            this.view.jRadioButtonReservar.setEnabled(true);
            this.view.jLabelDuracioón.setEnabled(true);

        } else if (this.view.jRadioButtonBanquete.isSelected()) {
            this.view.jSpinnerJornadasCongreso.setEnabled(false);
            this.view.jRadioButtonReservar.setEnabled(false);
            this.view.jLabelDuracioón.setEnabled(false);

        } else if (this.view.jRadioButtonJornada.isSelected()) {
            this.view.jSpinnerJornadasCongreso.setEnabled(false);
            this.view.jRadioButtonReservar.setEnabled(false);
            this.view.jLabelDuracioón.setEnabled(false);
        }
        
        
        
    }
    
    public void iniciar(){
        this.viewPrincipal.setVisible(true);
    }

}
