package com.example.guilherme.jumper.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.guilherme.jumper.elements.passaro;

/**
 * Created by guilherme on 12/12/17.
 */

public class Game extends SurfaceView implements Runnable {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private passaro passaro_0;

    public Game(Context context) {
        super(context);

        inicializaElementos();
    }

    private void inicializaElementos() {
        passaro_0 = new passaro();
    }

    @Override
    public void run() {
        while(isRunning){  // desenho dos camponentes do jogo
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();

            passaro_0.desenhaNo(canvas);
            passaro_0.cai();

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicia() {
        isRunning = true;
    }

    public void pausa() {
        isRunning = false;
    }
}