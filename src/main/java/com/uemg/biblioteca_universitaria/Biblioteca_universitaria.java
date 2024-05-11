/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.uemg.biblioteca_universitaria;
import static com.uemg.biblioteca_universitaria.controller.boxString.boxString;
import com.uemg.biblioteca_universitaria.model.classes.*;

/**
 *
 * @author Caio Cezar Dias, Isabely Toledo de Melo, Thaíssa Fernandes Silva, Luis Felippe Fernandes Silve, Maicon Parreiras Fernandes
 */
public class Biblioteca_universitaria {

    public static void main(String[] args) {
        String[] autors = {"Caio", "Larissa"};
        String[] keywords = {"Noite", "Cai"};
        Acervo acervo = new Acervo(0, autors, "Quando a noite cai", 2014, keywords, true, "AAaaaa");
        boxString(acervo.toString());
    }
}
