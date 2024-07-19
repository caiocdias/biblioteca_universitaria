/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package uemg.models.enums;

public enum academicosTipo {
    MONOGRAFIA("MONOGRAFIA"), DISSERTACAO("DISSERTAÇÃO"), TESE("TESE");
    
    private final String descricao;
    
    academicosTipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
