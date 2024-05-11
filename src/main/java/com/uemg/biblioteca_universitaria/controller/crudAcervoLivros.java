/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uemg.biblioteca_universitaria.controller;
import static com.uemg.biblioteca_universitaria.controller.crudAcervo.*;
import com.uemg.biblioteca_universitaria.model.classes.acervoLivros;
import static com.uemg.biblioteca_universitaria.controller.boxString.boxString;
import java.util.Scanner;

public class crudAcervoLivros {
    public static boolean cadastrarAcervoLivros(acervoLivros acervoLivros) {
        if (cadastrarAcervo(acervoLivros)) {
            int livrosQtdPaginas;
            int livrosEdicao;
            String livrosEditora;
            String livrosCidade;
            String livrosISBN;
            
            Scanner scan = new Scanner(System.in);
            System.out.print("Entre com a quantidade de paginas: ");
            livrosQtdPaginas = scan.nextInt();
            
            System.out.print("Entre com a edicao: ");
            livrosEdicao = scan.nextInt();
            
            scan = new Scanner(System.in);
            System.out.print("Entre com a editora: ");
            livrosEditora = scan.nextLine();
            
            System.out.print("Entre com cidade: ");
            livrosCidade = scan.nextLine();
            
            System.out.print("Entre com o ISBN: ");
            livrosISBN = scan.nextLine();
            
            acervoLivros.setLivrosQtdPaginas(livrosQtdPaginas);
            acervoLivros.setLivrosEdicao(livrosEdicao);
            acervoLivros.setLivrosEditora(livrosEditora);
            acervoLivros.setLivrosEditora(livrosEditora);
            acervoLivros.setLivrosCidade(livrosCidade);
            acervoLivros.setLivrosISBN(livrosISBN);
            
            return true;
        } else {
            return false;
        }
    }
    
    public static void imprimirAcervoLivros(acervoLivros acervoLivros) {
        boxString(acervoLivros.toString());
    }
}
