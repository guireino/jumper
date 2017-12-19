package com.example.guilherme.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.guilherme.jumper.graphic.Cores;
import com.example.guilherme.jumper.graphic.Tela;

/**
 * Created by guilherme on 18/12/17.
 */

public class GameOver {

    private static final Paint paintRed = Cores.getCorGameOver();

    private final Tela tela;
    private int centroHorizontal;
    private int centrolizaTexto;

    private int centralizaTexto(String texto) {
        Rect limiteTexto = new Rect();
        paintRed.getTextBounds(texto, 0, texto.length(), limiteTexto);

        centrolizaTexto = (limiteTexto.right - limiteTexto.left) / 2;

        centroHorizontal = tela.getLargura() / 2 - (limiteTexto.right - limiteTexto.left) / 2;

        return centroHorizontal;
    }

    public GameOver(Tela tela) {
        this.tela = tela;
    }

    public void desenhoNo(Canvas canvas) {
        String gamerOver = "Game Over";
        centroHorizontal = centralizaTexto(gamerOver);

        canvas.drawText(gamerOver, centroHorizontal, tela.getAltura() / 2, paintRed);
    }
}
