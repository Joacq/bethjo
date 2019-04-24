/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bethjo;

/**
 *
 * @author Joac
 */
public class Token {

    String tipo;
    String valor;
    int comlumna;
    int fila;

    public Token(String tipo, String valor, int comlumna, int fila) {
        this.tipo = tipo;
        this.valor = valor;
        this.comlumna = comlumna;
        this.fila = fila;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getComlumna() {
        return comlumna;
    }

    public void setComlumna(int comlumna) {
        this.comlumna = comlumna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    @Override
    public String toString() {
        return "Token:"  + tipo + ": " + valor ;
    }

}
