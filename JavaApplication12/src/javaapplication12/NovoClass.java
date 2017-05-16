/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

/**
 *
 * @author Filipe
 */
public class NovoClass {

    private float frequencia;

    public boolean calcularAprovacao(float nota1, float nota2) {
        float media;
        float notaFinal = nota1 + nota2;
        if (frequencia < 75) {
            return false;
        } else {
            media = (nota1 + nota2) / 2;
            if (media < 30) {
                return false;
            } else if (media > 70) {
                return true;
            } else if (((media + notaFinal) / 2) >= 50) {
                return true;
            } else {
                return false;
            }
        }
    }
}
