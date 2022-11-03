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

    LinkedList<Nota> grupoNotas;
    LinkedList<Nota> grupoVencidas;
    DateTimeFormatter dtf;
    Nota nota;

    public Notas() {
        grupoNotas = new LinkedList<>();
        grupoVencidas = new LinkedList<>();
        dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    public void addNota(String text, int dia, int mes, int anio) {
        nota = new Nota(text, dia, mes, anio);
        this.add(nota);
    }

    public LinkedList<Nota> returnNotas() {
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
            System.out.println("entre");
            if (note.anio > actualAnio) {
                grupoNotas.add(note);
            } else if (note.anio == actualAnio && note.mes > actualMes) {
                grupoNotas.add(note);
            } else if (note.anio == actualAnio && note.mes == actualMes && note.dia > actualDia) {
                grupoNotas.add(note);
            } else {
                grupoVencidas.add(note);
            }
        }
    }

    public LinkedList<Nota> returnNotasValidas() {
        grupoNotas = new LinkedList<>();
        ordenarNotas();
        return grupoNotas;
    }

    public LinkedList<Nota> returnNotasNoValidas() {
        grupoVencidas = new LinkedList<>();
        ordenarNotas();
        return grupoVencidas;
    }

}
