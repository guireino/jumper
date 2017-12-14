package com.example.guilherme.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.guilherme.jumper.graphic.Cores;

/**
 * Created by guilherme on 12/12/17.
 */

public class passaro {

    private static final float X = 100;
    private static final float RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassado();
    private int altura;

    public passaro(){
        this.altura = 100;
    }

    public void desenhaNo(Canvas canvas){
        canvas.drawCircle(X, altura, RAIO, VERMELHO);
    }

    public void cai() {
        this.altura += 5;
    }
}