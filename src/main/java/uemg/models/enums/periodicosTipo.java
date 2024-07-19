/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package uemg.models.enums;

public enum periodicosTipo {
    REVISTAS("REVISTAS"), JORNAIS("JORNAIS");
    
    private final String descricao;
    
    periodicosTipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
