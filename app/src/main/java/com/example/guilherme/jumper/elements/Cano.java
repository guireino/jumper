package com.example.guilherme.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.guilherme.jumper.R;
import com.example.guilherme.jumper.graphic.Cores;
import com.example.guilherme.jumper.graphic.Tela;

/**
 * Created by guilherme on 14/12/17.
 */

public class Cano {

    private Tela tela;

    private static final int Tamanho_Cano = 250;
    private static final int Largura_Cano = 100;
    private static final Paint verde = Cores.getCorCano();

    private int posicao;
    private int alturaCanoSuperior;
    private int alturaCanoInferior;

    private Bitmap canoInferior;
    private Bitmap canoSuperior;

    public Cano(Tela tela, int posicao, Context context){
        this.tela = tela;
        this.posicao = posicao;

        alturaCanoInferior = tela.getAltura() - Tamanho_Cano - valorAleatorio();
        alturaCanoSuperior = 0 + Tamanho_Cano + valorAleatorio();
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        canoInferior = Bitmap.createScaledBitmap(bp, Largura_Cano, alturaCanoInferior, false);
        canoSuperior = Bitmap.createScaledBitmap(bp, Largura_Cano, alturaCanoSuperior, false);
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    public void desenhaNo(Canvas canvas) {
        desenhaCanoSuperior(canvas);
        desenhaCanoInferior(canvas);
    }

    public void desenhaCanoInferior(Canvas canvas) {
//      canvas.drawRect(posicao, alturaCanoInferior, posicao + Largura_Cano, tela.getAltura(), verde);
        canvas.drawBitmap(canoInferior, posicao, alturaCanoInferior, null);
    }

    public void desenhaCanoSuperior(Canvas canvas) {
//      canvas.drawRect(posicao, 0, posicao + Largura_Cano, alturaCanoSuperior, verde);
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
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

    public boolean temColisaoHorizontal(passaro passaro_0) {
        return this.posicao < passaro.X + passaro.RAIO;
    }

    public boolean temColisaoVertical(passaro passaro_0) {
        return passaro_0.getAltura() - passaro_0.RAIO < this.alturaCanoSuperior
                || passaro_0.getAltura() + passaro_0.RAIO > this.alturaCanoInferior;
    }
}