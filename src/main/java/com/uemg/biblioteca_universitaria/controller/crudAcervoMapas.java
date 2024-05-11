/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uemg.biblioteca_universitaria.controller;
import static com.uemg.biblioteca_universitaria.controller.crudAcervo.*;
import com.uemg.biblioteca_universitaria.model.classes.acervoMapas;
import java.util.Scanner;

public class crudAcervoMapas {
    public static boolean cadastrarAcervoMapas(acervoMapas acervoMapas) {
        if (cadastrarAcervo(acervoMapas)) {
            String mapalocal;
            int mapaEdicao;
            
            Scanner scan = new Scanner(System.in);
            System.out.print("Entre com o local do mapa: ");
            mapalocal = scan.nextLine();
            
            scan = new Scanner(System.in);
            System.out.print("Entre com a edicao do mapa: ");
            mapaEdicao = scan.nextInt();
            
            acervoMapas.setMapalocal(mapalocal);
            acervoMapas.setMapaEdicao(mapaEdicao);
            return true;
        } else {
            return false;
        }
    }
}
