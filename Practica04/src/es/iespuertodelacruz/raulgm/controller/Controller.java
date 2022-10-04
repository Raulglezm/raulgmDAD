/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.raulgm.controller;

import es.iespuertodelacruz.raulgm.model.GestorFichero;
import es.iespuertodelacruz.raulgm.model.Nota;
import es.iespuertodelacruz.raulgm.model.Notas;
import es.iespuertodelacruz.raulgm.view.VistaAgregar;
import es.iespuertodelacruz.raulgm.view.VistaHistorial;
import es.iespuertodelacruz.raulgm.view.VistaOpcion;
import es.iespuertodelacruz.raulgm.view.VistaPrincipal;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alumno
 */
public class Controller implements ActionListener {

    VistaPrincipal vp;
    VistaAgregar va;
    VistaHistorial vh;
    VistaOpcion vo;
    GestorFichero gf;
    Notas notas;
    Nota nota;

    DefaultTableModel dtmPendientes, dtmPasadas;

    public Controller(VistaPrincipal vp, VistaAgregar va, VistaHistorial vh, VistaOpcion vo, GestorFichero gf) {
        this.vp = vp;
        this.va = va;
        this.vh = vh;
        this.vo = vo;
        this.gf = gf;
        this.vp.btnAgregar.addActionListener(this);
        this.vp.btnHistorial.addActionListener(this);
        this.va.btnAgregar.addActionListener(this);
        this.vh.btnPendientes.addActionListener(this);
        this.vo.btnBorrar.addActionListener(this);
        this.vo.btnEditar.addActionListener(this);
        this.vo.btnFinalizar.addActionListener(this);
        dtmPendientes = (DefaultTableModel) this.vp.tablePendientes.getModel();
        dtmPasadas = (DefaultTableModel) this.vh.tablePasadas.getModel();
        this.vp.tablePendientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                Point point = mouseEvent.getPoint();
                int row = Controller.this.vp.tablePendientes.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && Controller.this.vp.tablePendientes.getSelectedRow() != -1) {
                    nota = (Nota) dtmPendientes.getValueAt(Controller.this.vp.tablePendientes.getSelectedRow(), 0);
                    Controller.this.vo.txtTarea.setText(nota.getTxt());

                    Controller.this.vo.setVisible(true);
                }
            }
        });

        this.vh.tablePasadas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                Point point = mouseEvent.getPoint();
                int row = Controller.this.vh.tablePasadas.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && Controller.this.vh.tablePasadas.getSelectedRow() != -1) {
                    nota = (Nota) dtmPendientes.getValueAt(Controller.this.vh.tablePasadas.getSelectedRow(), 0);
                    Controller.this.vo.txtTarea.setText(nota.getTxt());

                    Controller.this.vo.setVisible(true);
                }
            }
        });

        notas = new Notas();
        fileToNotas(notas);
        rellenarTxt();
    }

    public void fileToNotas(Notas notas) {

        ArrayList<String> leerFichero = gf.leerFichero(notas);

        if (leerFichero.size() > 0) {
            for (String txt : leerFichero) {
                String[] splitTotal = txt.split("_");

                String[] splitFecha;
                splitFecha = splitTotal[1].split("/");
                this.notas.addNota(splitTotal[0], Integer.parseInt(splitFecha[0]), Integer.parseInt(splitFecha[1]), Integer.parseInt(splitFecha[2]));
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vp.btnAgregar) {
            this.va.setVisible(true);

        } else if (e.getSource() == this.vp.btnHistorial) {
            this.vp.tablePendientes.removeAll();
            rellenarTxt();
            this.vh.setVisible(true);
            this.va.setVisible(false);

        } else if (e.getSource() == this.va.btnAgregar) {
            addNota();
            this.va.txtTitulo.setText("");
            this.vp.tablePendientes.removeAll();
            rellenarTxt();
            System.out.println(notas);
            this.gf.escribirFichero(this.notas);

        } else if (e.getSource() == this.vh.btnPendientes) {
            this.vp.tablePendientes.removeAll();
            rellenarTxt();

            this.vp.setVisible(true);
            this.vh.setVisible(false);

        } else if (e.getSource() == this.vo.btnBorrar) {
            notas.dropNota(nota);
            this.vo.setVisible(false);

        } else if (e.getSource() == this.vo.btnEditar) {
            this.vo.setVisible(false);
            this.va.txtTitulo.setText(nota.getTxt());
            modNota();
            rellenarTxt();
            this.gf.escribirFichero(this.notas);

        } else if (e.getSource() == this.vo.btnFinalizar){
            this.vo.setVisible(false);
            this.va.txtTitulo.setText(nota.getTxt());
            finalizarNota();
            rellenarTxt();
            this.gf.escribirFichero(this.notas);
        }
    }
    
    public void finalizarNota(){
        notas.modNota(nota, nota.getTxt(), 1, 1, 1970);
    }

    public void modNota() {
        String titulo = this.vo.txtTarea.getText();
        String fecha = this.vo.spinnerFecha.getValue().toString();

        String[] split = fecha.split(" ");

        int actualAnio, actualMes, actualDia;

        actualAnio = Integer.parseInt(split[5]);
        actualMes = numMes(split[1]);
        actualDia = Integer.parseInt(split[2]);

        notas.modNota(nota, titulo, actualDia, actualMes, actualAnio);
    }

    public void rellenarTxt() {
        borrarTablas();
        notas.ordenarNotas();
        Object[] notasValidas = new Object[3];
        Object[] notasNoValidas = new Object[3];
        if (notas.size() > 0) {
            for (Nota note : notas) {
                if (note.isRealizada()) {
                    notasNoValidas[0] = note;
                    notasNoValidas[1] = note.getTxt();
                    notasNoValidas[2] = note.getFecha();
                    dtmPasadas.addRow(notasNoValidas);
                } else {
                    notasValidas[0] = note;
                    notasValidas[1] = note.getTxt();
                    notasValidas[2] = note.getFecha();
                    dtmPendientes.addRow(notasValidas);
                }
            }
        }
    }

    public void borrarTablas() {

        while (dtmPasadas.getRowCount() > 0) {
            dtmPasadas.removeRow(0);
        }
        while (dtmPendientes.getRowCount() > 0) {
            dtmPendientes.removeRow(0);
        }

    }

    public void addNota() {
        String titulo = this.va.txtTitulo.getText();
        String fecha = this.va.spinnerFecha.getValue().toString();

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
