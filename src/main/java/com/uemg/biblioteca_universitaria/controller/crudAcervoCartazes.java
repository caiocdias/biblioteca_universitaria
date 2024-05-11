/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uemg.biblioteca_universitaria.controller;

import com.uemg.biblioteca_universitaria.model.classes.acervoCartazes;
import com.uemg.biblioteca_universitaria.model.enums.cartazesTipo;
import static com.uemg.biblioteca_universitaria.controller.crudAcervo.*;
import static com.uemg.biblioteca_universitaria.view.boxString.boxString;
import java.util.Scanner;

public class crudAcervoCartazes {

    public static boolean cadastrarAcervoCartazes(acervoCartazes acervoCartazes) {
        if (cadastrarAcervo(acervoCartazes)) {
            Scanner scan = new Scanner(System.in);
            int op;
            cartazesTipo cartazesTipo = null;
            
            do {
                System.out.print("Entre com o tipo de cartaz\n\n1- Filme\n2- Serie\n3- Peça\n4- Esporte\n5- Politico\n6- Outro\n\nSua opcao: ");
                op = scan.nextInt();
                
                switch (op) {
                    case 1:
                        cartazesTipo = cartazesTipo.FILME;
                        break;
                    case 2:
                        cartazesTipo = cartazesTipo.SERIE;
                        break;
                    case 3:
                        cartazesTipo = cartazesTipo.PECA;
                        break;
                    case 4:
                        cartazesTipo = cartazesTipo.ESPORTE;
                        break;
                    case 5:
                        cartazesTipo = cartazesTipo.POLITICO;
                        break;
                    case 6:
                        cartazesTipo = cartazesTipo.OUTRO;
                        break;
                    default:
                        System.out.println("Entre com uma opcao valida.");
                        break;
                }
            } while (op < 1 || op > 6);
            
            acervoCartazes.setCartazesTipo(cartazesTipo);
            
            return true;
        } else {
            return false;
        }
    }
    
    public static void imprimirAcervoCartazes(acervoCartazes acervoCartazes) {
        boxString(acervoCartazes.toString());
    }
}
