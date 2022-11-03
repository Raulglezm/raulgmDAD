/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica01.Model;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Archivo {
    
    ArrayList<String> textos;
    
    public Archivo(){
        textos = new ArrayList<>();
    }
    
    public void addlinea(String texto){
        textos.add(texto);
    }

    public ArrayList<String> getTextos() {
        return textos;
    }
    
    public void addTexto(ArrayList<String> texts){
        textos.clear();
        for (String text : texts) {
            textos.add(text);
        }
    }
    
}
