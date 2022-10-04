/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.raulgm.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;

/**
 *
 * @author alumno
 */
public class GestorFichero {

    Notas notas;
    JFileChooser fc;
    ArrayList<String> fichero;

    public GestorFichero() {
        fichero = new ArrayList<>();
    }

    public ArrayList leerFichero(Notas notas) {
        this.notas = notas;
        fichero = new ArrayList<>();

        File f = new File("/tmp/notas.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            while (linea != null) {
                linea = br.readLine();
                if (linea != null) {
                    fichero.add(linea);
                }
            }
            br.close();
            return fichero;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        fichero.add("se ha producido un error inexperado");
        return fichero;
    }

    public boolean escribirFichero(Notas notas) {
        //inicializadores del writter
        this.notas = notas;

        File f = new File("/tmp/notas.txt");
        notasToTxt();

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            for (String linea : fichero) {
                bw.write(linea);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public void notasToTxt() {
        LinkedList<Nota> notas1 = notas.getNotas();

        fichero = new ArrayList<>();
        for (Nota nota : notas1) {
            fichero.add(nota.getTxt() + "_" + nota.getFecha());
        }
    }

}
