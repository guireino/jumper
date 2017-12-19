package com.example.guilherme.jumper.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.guilherme.jumper.R;
import com.example.guilherme.jumper.elements.Cano;
import com.example.guilherme.jumper.elements.Canos;
import com.example.guilherme.jumper.elements.GameOver;
import com.example.guilherme.jumper.elements.Pontuacao;
import com.example.guilherme.jumper.elements.passaro;
import com.example.guilherme.jumper.graphic.Tela;

/**
 * Created by guilherme on 12/12/17.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private passaro passaro_0;
    private Bitmap background;
    private Tela tela;
    private Context context;
    private Canos canos;
    private Pontuacao pontuacao;

    public Game(Context context) {
        super(context);

        tela = new Tela(context);
        this.context = context;

        inicializaElementos();
        setOnTouchListener(this);
    }

    private void inicializaElementos() {
        passaro_0 = new passaro(tela, context);
        pontuacao = new Pontuacao();
        canos = new Canos(tela, pontuacao, context);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);
    }

    @Override
    public void run() {
        while(isRunning){
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();

            // desenho dos camponentes do jogo
            canvas.drawBitmap(background, 0,0, null);
            passaro_0.desenhaNo(canvas);
            passaro_0.cai();

            canos.desenhaNo(canvas);
            canos.move();

            pontuacao.desenhaNo(canvas);

            if (new VerificadorColisao(passaro_0, canos).temColicao()){
                new GameOver(tela).desenhoNo(canvas);
                isRunning = false;
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void inicia() {
        isRunning = true;
    }

    public void pausa() {
        isRunning = false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        passaro_0.pula();
        return false;
    }
}