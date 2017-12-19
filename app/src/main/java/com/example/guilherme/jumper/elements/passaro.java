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
 * Created by guilherme on 12/12/17.
 */

public class passaro {

    public static final float X = 100;
    public static final int RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassado();
    private Bitmap passaro;
    private float altura;
    private Tela tela;

    public passaro(Tela tela, Context context){
        this.tela = tela;
        this.altura = 100;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2, false);
    }

    public void desenhaNo(Canvas canvas){
//      canvas.drawCircle(X, altura, RAIO, VERMELHO);
        canvas.drawBitmap(passaro, X - RAIO, altura - RAIO, null);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();

        if (!chegouNoChao){
            this.altura += 5;
        }
    }

    public void pula() {
        if (altura - RAIO > 0){
            this.altura -= 150;
        }
    }

    public float getAltura() {
        return this.altura;
    }
}