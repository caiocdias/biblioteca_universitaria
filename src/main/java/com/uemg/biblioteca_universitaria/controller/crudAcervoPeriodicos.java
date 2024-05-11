/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uemg.biblioteca_universitaria.controller;

import static com.uemg.biblioteca_universitaria.controller.crudAcervo.*;
import com.uemg.biblioteca_universitaria.model.classes.acervoPeriodicos;
import com.uemg.biblioteca_universitaria.model.enums.periodicosTipo;
import java.util.Scanner;

public class crudAcervoPeriodicos {

    public static boolean cadastrarAcervoPeriodicos(acervoPeriodicos acervoPeriodicos) {
        if (cadastrarAcervo(acervoPeriodicos)) {
            int periodicosQtdPaginas;
            int periodicosEdicao;
            periodicosTipo periodicosTipo = null;
            String periodicosEditora;
            String periodicosCidade;
            String periodicosISBN;
            int op;
            
            Scanner scan = new Scanner(System.in);
            System.out.print("Entre com a quantidade de paginas: ");
            periodicosQtdPaginas = scan.nextInt();

            System.out.print("Entre com a edicao: ");
            periodicosEdicao = scan.nextInt();

            do {
                System.out.print("Entre com o tipo do periodico\n\n1- Revistas\n2- Jornais\n\nSua opcao: ");
                op = scan.nextInt();
                
                switch (op) {
                    case 1:
                        periodicosTipo = periodicosTipo.REVISTAS;
                        break;
                    case 2:
                        periodicosTipo = periodicosTipo.JORNAIS;
                        break;
                    default:
                        System.out.println("Entre com uma opcao valida.");
                        break;
                }
            } while (op < 1 || op > 2);

            scan = new Scanner(System.in);
            System.out.print("Entre com a editora: ");
            periodicosEditora = scan.nextLine();

            System.out.print("Entre com cidade: ");
            periodicosCidade = scan.nextLine();

            System.out.print("Entre com o ISBN: ");
            periodicosISBN = scan.nextLine();
            
            acervoPeriodicos.setPeriodicosQtdPaginas(periodicosQtdPaginas);
            acervoPeriodicos.setPeriodicosEdicao(periodicosEdicao);
            acervoPeriodicos.setPeriodicosTipo(periodicosTipo);
            acervoPeriodicos.setPeriodicosEditora(periodicosEditora);
            acervoPeriodicos.setPeriodicosCidade(periodicosCidade);
            acervoPeriodicos.setPeriodicosISBN(periodicosISBN);
            
            return true;
        } else {
            return false;
        }
    }
}
