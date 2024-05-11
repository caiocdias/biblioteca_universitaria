/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uemg.biblioteca_universitaria.controller;
import static com.uemg.biblioteca_universitaria.controller.crudAcervo.*;
import com.uemg.biblioteca_universitaria.model.classes.acervoMidias;
import com.uemg.biblioteca_universitaria.model.enums.midiaTipo;
import static com.uemg.biblioteca_universitaria.controller.boxString.boxString;
import java.util.Scanner;

public class crudAcervoMidias {
    public static boolean cadastrarAcervoMidias(acervoMidias acervoMidias) {
        if (cadastrarAcervo(acervoMidias)) {
            midiaTipo midiaTipo = null;
            String midiaProdutora;
            String midiaISMN;
            
            Scanner scan = new Scanner(System.in);
            System.out.print("Entre com a produtora: ");
            midiaProdutora = scan.nextLine();
            
            System.out.print("Entre com o ISMN: ");
            midiaISMN = scan.nextLine();
            
            scan = new Scanner(System.in);
            int op;
            do {                
                System.out.print("Entre com o tipo da midia\n\n1- VHS\n2- CD\n3- DVD\n\nSua opcao: ");
                op = scan.nextInt();
                
                switch (op) {
                    case 1:
                        midiaTipo = midiaTipo.VHS;
                        break;
                    case 2:
                        midiaTipo = midiaTipo.CDS;
                        break;
                    case 3:
                        midiaTipo = midiaTipo.DVD;
                        break;
                    default:
                        System.out.println("Entre com uma opcao valida.");
                        break;
                }
            } while (op < 1 || op > 3);
            
            acervoMidias.setMidiaTipo(midiaTipo);
            acervoMidias.setMidiaProdutora(midiaProdutora);
            acervoMidias.setMidiaISMN(midiaISMN);
            
            return true;
        } else {
            return false;
        }
    }
    
    public static void imprimirAcervoMidias(acervoMidias acervoMidias) {
        boxString(acervoMidias.toString());
    }
}
