/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uemg.models.classes;
import uemg.models.enums.midiaTipo;

public class acervoMidias extends Acervo {

    private midiaTipo midiaTipo;
    private String midiaProdutora;
    private String midiaISMN;

    public acervoMidias() {
    }

    public acervoMidias(midiaTipo midiaTipo, String midiaProdutora, String midiaISMN, int acervoId, String[] acervoAutores, String acervoTitulo, int acervoAno, String[] acervoPalavrasChave, boolean acervoFlagEmprestado, String acervoCDU) {
        super(acervoId, acervoAutores, acervoTitulo, acervoAno, acervoPalavrasChave, acervoFlagEmprestado, acervoCDU);
        this.setMidiaTipo(midiaTipo);
        this.setMidiaProdutora(midiaProdutora);
        this.setMidiaISMN(midiaISMN);
    }

    //Gets
    public midiaTipo getMidiaTipo() {
        return midiaTipo;
    }
    public String getMidiaProdutora() {
        return midiaProdutora;
    }
    public String getMidiaISMN() {
        return midiaISMN;
    }
    
    //Sets
    public void setMidiaTipo(midiaTipo midiaTipo) {
        this.midiaTipo = midiaTipo;
    }
    public void setMidiaProdutora(String midiaProdutora) {
        this.midiaProdutora = midiaProdutora;
    }
    public void setMidiaISMN(String midiaISMN) {
        this.midiaISMN = midiaISMN;
    }

    @Override
    public String toString() {
        String res = ""; 
        for (String autor: super.getAcervoAutores()) {
            res += autor + ". ";
        }
        
        res += super.getAcervoId() + ".";
        res += "\n\n";
        res += super.getAcervoTitulo() + " - " + this.getMidiaTipo() + " - " + this.getMidiaProdutora() + " - " + super.getAcervoAno();
        res += "\n\n";
        
        res += this.getMidiaISMN();
        
        res += "\n\n";
        for (String palavra: super.getAcervoPalavrasChave()) {
            res += palavra + ". ";
        }
        
        res += "\n\n";
        if (super.isAcervoFlagEmprestado()) {
            res += "Emprestado";
        } else {
            res += "Disponivel";
        }
        
        res += "           CDU: " + super.getAcervoCDU();
        
        return res;
    }
    
}
