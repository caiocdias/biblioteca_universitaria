/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uemg.biblioteca_universitaria.controller;

import com.uemg.biblioteca_universitaria.model.enums.academicosTipo;
import com.uemg.biblioteca_universitaria.model.classes.acervoAcademicos;
import static com.uemg.biblioteca_universitaria.controller.crudAcervo.*;
import static com.uemg.biblioteca_universitaria.view.boxString.boxString;
import java.util.Scanner;

public class crudAcercoAcademicos {

    public static boolean cadastrarAcervoAcademicos(acervoAcademicos acervoAcademicos) {
        if (cadastrarAcervo(acervoAcademicos)) {
            int academicosQtdPaginas;
            academicosTipo academicosTipo = null;
            String academicosEditora;
            String academicosCidade;
            String academicosDOI;

            Scanner scan = new Scanner(System.in);
            System.out.print("Entre com quantidade de paginas: ");
            academicosQtdPaginas = scan.nextInt();

            int op;
            do {
                System.out.print("Entre com o tipo de academico\n\n1- Monografia\n2- Dissertacao\n3- Tese\n\nSua opcao: ");
                op = scan.nextInt();
                switch (op) {
                    case 1:
                        academicosTipo = academicosTipo.MONOGRAFIA;
                        break;
                    case 2:
                        academicosTipo = academicosTipo.DISSERTACAO;
                        break;
                    case 3:
                        academicosTipo = academicosTipo.TESE;
                        break;
                    default:
                        System.out.println("Entre com uma opcao valida.");
                        break;
                }
            } while (op < 1 || op > 3);

            scan = new Scanner(System.in);
            System.out.print("Entre com a editora: ");
            academicosEditora = scan.nextLine();

            System.out.print("Entre com a cidade: ");
            academicosCidade = scan.nextLine();

            System.out.print("Entre com o DOI: ");
            academicosDOI = scan.nextLine();

            acervoAcademicos.setAcademicosQtdPaginas(academicosQtdPaginas);
            acervoAcademicos.setAcademicosTipo(academicosTipo);
            acervoAcademicos.setAcademicosEditora(academicosEditora);
            acervoAcademicos.setAcademicosCidade(academicosCidade);
            acervoAcademicos.setAcademicosDOI(academicosDOI);

            return true;
        } else {
            return false;
        }
    }
    
    public static void imprimirAcervoAcademicos(acervoAcademicos acervoAcademicos) {
        boxString(acervoAcademicos.toString());
    }
}
