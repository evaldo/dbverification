/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Filipe
 */
public class AcessoTexto {
    private Long Idparam;
    private String DesParam;
    private int NumInicio;
    private int NumFim;
    private int Tamanho;
    private String FlagFim;
    private String Tipo;

    public AcessoTexto() {
    }

    public Long getIdparam() {
        return Idparam;
    }

    public void setIdparam(Long Idparam) {
        this.Idparam = Idparam;
    }

    public String getDesParam() {
        return DesParam;
    }

    public void setDesParam(String DesParam) {
        this.DesParam = DesParam;
    }



    public String getFlagFim() {
        return FlagFim;
    }

    public void setFlagFim(String FlagFim) {
        this.FlagFim = FlagFim;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getNumInicio() {
        return NumInicio;
    }

    public void setNumInicio(int NumInicio) {
        this.NumInicio = NumInicio;
    }

    public int getNumFim() {
        return NumFim;
    }

    public void setNumFim(int NumFim) {
        this.NumFim = NumFim;
    }

    public int getTamanho() {
        return Tamanho;
    }

    public void setTamanho(int Tamanho) {
        this.Tamanho = Tamanho;
    }
    
    
    
}
