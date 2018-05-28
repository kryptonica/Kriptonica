/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptonica.models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Mathe
 */
public class TabelaMoedas {
    
    private final String moeda;
    private final String menorValor;
    private final String maiorValor;

    public TabelaMoedas(String moeda, String menorValor, String maiorValor) {
        this.moeda = moeda;
        this.menorValor = menorValor;
        this.maiorValor = maiorValor;
    }
    
    public String getMoeda() {
        return moeda;
    }

    public String getMenorValor() {
        return menorValor;
    }

    public String getMaiorValor() {
        return maiorValor;
    }

}
