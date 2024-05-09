/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uemg.biblioteca_universitaria.view;

public class boxString {
public static void boxString(String conteudoString) {
    // Divide a string original em linhas
    String[] linhas = conteudoString.split("\n");
    
    // Determina o comprimento máximo de linha
    int maxLength = 0;
    for (String linha : linhas) {
        if (linha.length() > maxLength) {
            maxLength = linha.length();
        }
    }
    
    // Imprime a linha superior da caixa
    for (int i = 0; i < maxLength + 2; i++) {
        System.out.print("-");
    }
    System.out.println();
    
    // Imprime cada linha dentro de uma borda
    for (String linha : linhas) {
        System.out.print("|" + linha);
        // Preenche o espaço restante na linha com espaços, se necessário
        for (int i = linha.length(); i < maxLength; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }
    
    // Imprime a linha inferior da caixa
    for (int i = 0; i < maxLength + 2; i++) {
        System.out.print("-");
    }
    System.out.println();
}

}
