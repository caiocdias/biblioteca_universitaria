/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.uemg.biblioteca_universitaria;

import static com.uemg.biblioteca_universitaria.controller.boxString.boxString;
import com.uemg.biblioteca_universitaria.model.classes.*;
import com.uemg.biblioteca_universitaria.controller.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Caio Cezar Dias, Isabely Toledo de Melo, Thaíssa Fernandes Silva,
 * Luis Felippe Fernandes Silve, Maicon Parreiras Fernandes
 */
public class Biblioteca_universitaria {

    public static void main(String[] args) {
        ArrayList<Acervo> listAcervo = new ArrayList<>();
        int op;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("\t\tBiblioteca Universitaria\n\n");
            System.out.println("1- Cadastrar no Acervo");
            System.out.println("2- Pesquisar no Acervo");
            System.out.println("3- Remover do Acervo");
            System.out.println("4- Imprimir Ficha");
            System.out.println("5- Pegar Item Emprestado");
            System.out.println("6- Devolver Item Emprestado");
            System.out.println("0- Sair");
            System.out.print("\nSua opcao: ");
            op = scan.nextInt();
            
            switch (op) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o programa.");
                    break;
                default:
                    System.out.println("Entre com opcao valida.");
                    break;
            }
        } while (op != 0);
    }
}
