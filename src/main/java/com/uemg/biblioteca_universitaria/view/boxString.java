/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uemg.biblioteca_universitaria.view;

public class boxString {
public static void boxString(String conteudoString) {
    String[] linhas = conteudoString.split("\n");
    
    int maxLength = 0;
    for (String linha : linhas) {
        if (linha.length() > maxLength) {
            maxLength = linha.length();
        }
    }
    
    for (int i = 0; i < maxLength + 2; i++) {
        System.out.print("-");
    }
    System.out.println();
    
    for (String linha : linhas) {
        System.out.print("|" + linha);
        for (int i = linha.length(); i < maxLength; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }
    
    for (int i = 0; i < maxLength + 2; i++) {
        System.out.print("-");
    }
    System.out.println();
}

}
