package com.example.guilherme.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;


import com.example.guilherme.jumper.engine.Som;
import com.example.guilherme.jumper.graphic.Cores;



/**
 * Created by guilherme on 18/12/17.
 */

public class Pontuacao{

    private static final Paint BRANCO = Cores.getCorPontuacao();
    private int pontos = 0;
    private Som som;

    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100, 100, BRANCO);
    }

    public Pontuacao(Som som){
        this.som = som;
    }

    public void aumento() {
        som.toca(Som.pontuacao);
        pontos++;
    }

}
