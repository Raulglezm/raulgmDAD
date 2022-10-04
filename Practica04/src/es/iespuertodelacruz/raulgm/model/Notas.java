/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.raulgm.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author alumno
 */
public class Notas extends LinkedList<Nota> {

    DateTimeFormatter dtf;
    Nota nota;

    public Notas() {
        dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void addNota(String text, int dia, int mes, int anio) {
        nota = new Nota(text, dia, mes, anio);
        this.add(nota);
    }
    
    public void dropNota(Nota nota){
        this.remove(nota);
    }
    
    public void modNota(Nota nota, String text, int dia, int mes, int anio){
        this.nota = nota;
        this.nota.setAnio(anio);
        this.nota.setDia(dia);
        this.nota.setMes(mes);
        this.nota.setTxt(text);
    }

    public LinkedList<Nota> getNotas() {
        return this;
    }

    public void ordenarNotas() {
        String fecha = dtf.format(LocalDateTime.now());
        String[] split = fecha.split("/");

        int actualAnio, actualMes, actualDia;

        actualAnio = Integer.parseInt(split[2]);
        actualMes = Integer.parseInt(split[1]);
        actualDia = Integer.parseInt(split[0]);

        for (Nota note : this) {
            if (note.anio > actualAnio) {
                note.setRealizada(false);
            } else if (note.anio == actualAnio && note.mes > actualMes) {
                note.setRealizada(false);
            } else if (note.anio == actualAnio && note.mes == actualMes && note.dia > actualDia) {
                note.setRealizada(false);
            } else {
                note.setRealizada(true);
            }
        }
    }

}
