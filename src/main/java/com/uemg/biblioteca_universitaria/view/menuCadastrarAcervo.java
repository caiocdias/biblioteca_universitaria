/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uemg.biblioteca_universitaria.view;

import com.uemg.biblioteca_universitaria.model.classes.*;
import static com.uemg.biblioteca_universitaria.controller.crudAcervoAcademicos.*;
import static com.uemg.biblioteca_universitaria.controller.crudAcervoCartazes.*;
import static com.uemg.biblioteca_universitaria.controller.crudAcervoLivros.*;
import static com.uemg.biblioteca_universitaria.controller.crudAcervoMapas.*;
import static com.uemg.biblioteca_universitaria.controller.crudAcervoMidias.*;
import static com.uemg.biblioteca_universitaria.controller.crudAcervoPeriodicos.*;
import static com.uemg.biblioteca_universitaria.controller.crudAcervoRelatorios.*;
import java.util.ArrayList;
import java.util.Scanner;

public class menuCadastrarAcervo {
    public static void menuCadastrarAcervo(ArrayList<Acervo> listAcervo) {
        int op;
        Scanner scan = new Scanner(System.in);
        
        do {            
            System.out.print("\n\t\tMenu de Cadastro de Item no Acervo\n\n");
            System.out.println("1- Cadastrar Academicos");
            System.out.println("2- Cadasrar Cartazes");
            System.out.println("3- Cadastrar Livros");
            System.out.println("4- Cadastrar Mapas");
            System.out.println("5- Cadastrar Midias");
            System.out.println("6- Cadastrar Periodicos");
            System.out.println("7- Cadastrar Relatorios");
            System.out.println("0- Voltar");
            System.out.print("\nSua opcao: ");
            op = scan.nextInt();
            
            switch (op) {
                case 1:
                    acervoAcademicos acervoAcademicos = new acervoAcademicos();
                    if (cadastrarAcervoAcademicos(acervoAcademicos)) {
                        listAcervo.add(acervoAcademicos);
                        System.out.println("Cadastro de academico realizado com sucesso.");
                    } else {
                        System.out.println("Erro ao cadastrar academico.");
                    }
                    break;
                case 2:
                    acervoCartazes acervoCartazes = new acervoCartazes();
                    if (cadastrarAcervoCartazes(acervoCartazes)) {
                        listAcervo.add(acervoCartazes);
                        System.out.println("Cadastro de cartaz realizado com sucesso.");
                    } else {
                        System.out.println("Erro ao cadastrar cartaz.");
                    }
                    break;
                case 3:
                    acervoLivros acervoLivros = new acervoLivros();
                    if (cadastrarAcervoLivros(acervoLivros)) {
                        listAcervo.add(acervoLivros);
                        System.out.println("Cadastro de livro realizado com sucesso.");
                    } else {
                        System.out.println("Erro ao cadastrar livro.");
                    }
                    break;
                case 4:
                    acervoMapas acervoMapas = new acervoMapas();
                    if (cadastrarAcervoMapas(acervoMapas)) {
                        listAcervo.add(acervoMapas);
                        System.out.println("Cadastro de mapa realizado com sucesso.");
                    } else {
                        System.out.println("Erro ao cadastrar mapa.");
                    }
                    break;
                case 5:
                    acervoMidias acervoMidias = new acervoMidias();
                    if (cadastrarAcervoMidias(acervoMidias)) {
                        listAcervo.add(acervoMidias);
                        System.out.println("Cadastro de midia realizado com sucesso.");
                    } else {
                        System.out.println("Erro ao cadastrar midia.");
                    }
                    break;
                case 6:
                    acervoPeriodicos acervoPeriodicos = new acervoPeriodicos();
                    if (cadastrarAcervoPeriodicos(acervoPeriodicos)) {
                        listAcervo.add(acervoPeriodicos);
                        System.out.println("Cadastro de periodico realizado com sucesso.");
                    } else {
                        System.out.println("Erro ao cadastrar periodico.");
                    }
                    break;
                case 7:
                    acervoRelatorios acervoRelatorios = new acervoRelatorios();
                    if (cadastrarAcervoRelatorios(acervoRelatorios)) {
                        listAcervo.add(acervoRelatorios);
                        System.out.println("Cadastro de relatorio realizado com sucesso.");
                    } else {
                        System.out.println("Erro ao cadastrar periodico.");
                    }
                    break;
                case 0:
                    System.out.println("Voltando ao menu anterior...");
                    break;
                default:
                    System.out.println("Entre com uma opcao valida.");
                    break;
            }
        } while (op != 0);
    }
}
