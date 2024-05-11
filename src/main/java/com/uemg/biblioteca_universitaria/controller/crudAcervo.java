/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uemg.biblioteca_universitaria.controller;
import com.uemg.biblioteca_universitaria.model.classes.*;
import static com.uemg.biblioteca_universitaria.view.boxString.boxString;
import java.util.Scanner;

public class crudAcervo {
    public static boolean cadastrarAcervo(Acervo acervo) {
        try {
            int acervoId;
            String[] acervoAutores;
            String acervoTitulo;
            int acervoAno;
            String[] acervoPalavrasChave;
            String acervoCDU;

            Scanner scan = new Scanner(System.in);
            System.out.print("Entre com o ID do item do acervo: ");
            acervoId = scan.nextInt();

            int qtdAutores;
            System.out.print("Entre com a quantidade de autores: ");
            qtdAutores = scan.nextInt();

            scan = new Scanner(System.in);
            acervoAutores = new String[qtdAutores];

            for (int i = 0; i < qtdAutores; i++) {
                System.out.print("Entre o nome do autor " + qtdAutores+1 + ": ");
                acervoAutores[i] = scan.nextLine();
            }

            System.out.print("Entre com o titulo: ");
            acervoTitulo = scan.nextLine();

            int qtdPalavraChaves;
            scan = new Scanner(System.in);
            System.out.print("Entre com a quantidade de palavras chave: ");
            qtdPalavraChaves = scan.nextInt();

            scan = new Scanner(System.in);
            acervoPalavrasChave = new String[qtdPalavraChaves];
            for (int i = 0; i < qtdPalavraChaves; i++) {
                System.out.print("Entre o nome do autor " + qtdPalavraChaves+1 + ": ");
                acervoAutores[i] = scan.nextLine();
            }

            System.out.print("Entre com o CU: ");
            acervoCDU = scan.nextLine();

            scan = new Scanner(System.in);
            System.out.print("Entre com o ano do item do acervo: ");
            acervoAno = scan.nextInt();

            acervo.setAcervoId(acervoId);
            acervo.setAcervoAutores(acervoAutores);
            acervo.setAcervoTitulo(acervoTitulo);
            acervo.setAcervoAno(acervoAno);
            acervo.setAcervoPalavrasChave(acervoPalavrasChave);
            acervo.setAcervoCDU(acervoCDU);
            acervo.setAcervoFlagEmprestado(false);
            return true;
        } 
        catch (Exception e) {
            return false;
        }
    }
    
    public static void imprimirAcervo(Acervo acervo) {
        boxString(acervo.toString());
    }
}
