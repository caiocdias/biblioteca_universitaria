/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package uemg.models.enums;

public enum cartazesTipo {
    FILME("FILME"), SERIE("SERIE"), PECA("PECA"), ESPORTE("ESPORTE"), POLITICO("POLITICO"), OUTRO("OUTRO");
    
    private final String descricao;
    
    cartazesTipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
