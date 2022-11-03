/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.raulgm.model;

/**
 *
 * @author alumno
 */
public class Nota {
    
    boolean realizada;
    String txt;
    int dia, mes, anio;
    
    public Nota(String txt, int dia, int mes, int anio){
        this.txt = txt;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        realizada = false;
    }
    
    public String getFecha(){
        return dia+"/"+mes+"/"+anio; 
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean terminada) {
        this.realizada = terminada;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "- "+txt+" ["+dia+"/"+mes+"/"+anio+"]";
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
}
