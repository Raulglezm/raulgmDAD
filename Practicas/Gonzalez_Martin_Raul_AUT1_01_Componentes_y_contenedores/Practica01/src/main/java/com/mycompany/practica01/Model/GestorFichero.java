/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica01.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;

/**
 *
 * @author alumno
 */
public class GestorFichero {

    Archivo archivo;
    JFileChooser fc;
    ArrayList<String> fichero;
    String path;
    boolean guardado;

    public GestorFichero() {
        fc = new JFileChooser();
        guardado = false;
    }

    public boolean Guardar(Archivo archivo) {
        this.archivo = archivo;
        fc.showSaveDialog(null);
        path = fc.getSelectedFile().getPath();
        if (path != null) {
            if (escribirFichero()) {
                return true;
            }
        }
        return false;
    }

    public void Abrir(Archivo archivo) {
        fc.showOpenDialog(null);
        path = fc.getSelectedFile().toString();
        if (path != null) {
            archivo.addTexto(leerFichero());
        }
    }

    public ArrayList leerFichero() {

        fichero = new ArrayList<>();

        File f = new File(path);
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

    public boolean escribirFichero() {
        //inicializadores del writter
        File f = new File(path);
        fichero = archivo.getTextos();

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            for (String linea : fichero) {
                System.out.println(linea);
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

    public boolean isGuardado() {
        return guardado;
    }

    public void setGuardado(boolean guardado) {
        this.guardado = guardado;
    }

}
