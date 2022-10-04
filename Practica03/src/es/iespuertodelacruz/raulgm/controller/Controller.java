/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.raulgm.controller;

import es.iespuertodelacruz.raulgm.model.Nota;
import es.iespuertodelacruz.raulgm.model.Notas;
import es.iespuertodelacruz.raulgm.view.VistaAgregar;
import es.iespuertodelacruz.raulgm.view.VistaHistorial;
import es.iespuertodelacruz.raulgm.view.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author alumno
 */
public class Controller implements ActionListener {

    VistaPrincipal vp;
    VistaAgregar va;
    VistaHistorial vh;
    Notas notas;

    public Controller(VistaPrincipal vp, VistaAgregar va, VistaHistorial vh) {
        this.vp = vp;
        this.va = va;
        this.vh = vh;
        this.vp.btnAgregar.addActionListener(this);
        this.vp.btnHistorial.addActionListener(this);
        this.va.btnAgregar.addActionListener(this);
        this.vh.btnPendientes.addActionListener(this);
        this.vp.txtPendientes.setEditable(false);
        this.vh.txtPasadas.setEditable(false);

        notas = new Notas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vp.btnAgregar) {
            this.va.setVisible(true);

        } else if (e.getSource() == this.vp.btnHistorial) {
            this.vp.txtPendientes.setText("");
            rellenarTxt();
            this.vh.setVisible(true);
            this.va.setVisible(false);

        } else if (e.getSource() == this.va.btnAgregar) {
            addNota();
            this.vp.txtPendientes.setText("");
            rellenarTxt();

        } else if (e.getSource() == this.vh.btnPendientes) {
            this.vp.txtPendientes.setText("");
            rellenarTxt();

            this.vp.setVisible(true);
            this.vh.setVisible(false);
        }

    }

    public void rellenarTxt() {

        LinkedList<Nota> notes = this.notas.returnNotasValidas();
        String cadena = "";

        if (notes.size() > 0) {
            System.out.println(notas.size());
            for (Nota note : notes) {
                System.out.println(notes);
                            
                System.out.println(notes.size());
                System.out.println(cadena);
                cadena += note.toString() + "\n";
            }
        }
        this.vp.txtPendientes.setText(cadena);

        notes = this.notas.returnNotasNoValidas();
        cadena = "";
        if (notes.size() > 0) {
            for (Nota note : notes) {
                cadena += note.toString() + "\n";
            }
        }
        this.vh.txtPasadas.setText(cadena);

    }

    public void addNota() {
        String titulo = this.va.txtTitulo.getText();
        String fecha = this.va.spinnerFecha.getValue().toString();

        System.out.println(fecha);
        String[] split = fecha.split(" ");

        int actualAnio, actualMes, actualDia;

        actualAnio = Integer.parseInt(split[5]);
        actualMes = numMes(split[1]);
        actualDia = Integer.parseInt(split[2]);

        notas.addNota(titulo, actualDia, actualMes, actualAnio);

    }

    public int numMes(String txt) {

        String[] meses = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int mes = 0;
        for (int i = 0; i < meses.length; i++) {
            if (txt.equals(meses[i])) {
                mes = i + 1;
            }
        }
        return mes;
    }

    public void Iniciar() {
        vp.setVisible(true);
    }

}
