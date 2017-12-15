package com.example.guilherme.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.guilherme.jumper.graphic.Cores;
import com.example.guilherme.jumper.graphic.Tela;

/**
 * Created by guilherme on 14/12/17.
 */

public class Cano {

    private Tela tela;
    private final int alturaCanoInferior;
    private static final int Tamanho_Cano = 250;
    private static final int Largura_Cano = 100;
    private static final Paint verde = Cores.getCorCano();
    private int posicao;
    private int alturaCanoSuperior;

    public Cano(Tela tela, int posicao){
        this.tela = tela;
        this.posicao = posicao;

        alturaCanoInferior = tela.getAltura() - Tamanho_Cano - valorAleatorio();
        alturaCanoSuperior = 0 + Tamanho_Cano + valorAleatorio();
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoSuperior(canvas);
        desenhaCanoInferior(canvas);
    }

    public void desenhaCanoInferior(Canvas canvas) {
        canvas.drawRect(posicao, alturaCanoInferior, posicao + Largura_Cano, tela.getAltura(), verde);
    }

    public void desenhaCanoSuperior(Canvas canvas) {
        canvas.drawRect(posicao, 0, posicao + Largura_Cano, alturaCanoSuperior, verde);
    }

    public void move() {
        this.posicao -= 5;
    }

    public boolean saiuTela() {
        return posicao + Largura_Cano < 0;
    }

    public int getPoxicao() {
        return posicao;
    }

}