/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uemg.biblioteca_universitaria.model.classes;
import com.uemg.biblioteca_universitaria.model.enums.cartazesTipo;

public class acervoCartazes extends Acervo {
    private cartazesTipo cartazesTipo;

    public acervoCartazes() {
    }

    public acervoCartazes(cartazesTipo cartazesTipo, int acervoId, String[] acervoAutores, String acervoTitulo, int acervoAno, String[] acervoPalavrasChave, boolean acervoFlagEmprestado, String acervoCDU) {
        super(acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
        this.setCartazesTipo(cartazesTipo);
    }

    //Sets
    public cartazesTipo getCartazesTipo() {
        return cartazesTipo;
    }
    
    //Gets
    public void setCartazesTipo(cartazesTipo cartazesTipo) {
        this.cartazesTipo = cartazesTipo;
    }
    
    
}
