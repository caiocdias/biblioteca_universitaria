/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uemg.biblioteca_universitaria.controller;
import static com.uemg.biblioteca_universitaria.controller.crudAcervo.*;
import com.uemg.biblioteca_universitaria.model.classes.acervoRelatorios;
import static com.uemg.biblioteca_universitaria.view.boxString.boxString;
import java.util.Scanner;

public class crudAcervoRelatorios {
    public static boolean cadastrarAcervoRelatorios(acervoRelatorios acervoRelatorios) {
        if (cadastrarAcervo(acervoRelatorios)) {
            int relatoriosQtdPaginas;
            String relatoriosEditora;
            String relatoriosCidade;
            
            Scanner scan = new Scanner(System.in);
            System.out.print("Entre com a quantidade de paginas: ");
            relatoriosQtdPaginas = scan.nextInt();
            
            scan = new Scanner(System.in);
            System.out.print("Entre com a editora: ");
            relatoriosEditora = scan.nextLine();
            
            System.out.print("Entre com a cidade: ");
            relatoriosCidade = scan.nextLine();
            
            acervoRelatorios.setRelatoriosQtdPaginas(relatoriosQtdPaginas);
            acervoRelatorios.setRelatoriosEditora(relatoriosEditora);
            acervoRelatorios.setRelatoriosCidade(relatoriosCidade);
            
            return true;
        } else {
            return false;
        }
    }
    
    public static void imprimirAcervoRelatorios(acervoRelatorios acervoRelatorios) {
        boxString(acervoRelatorios.toString());
    }
}
