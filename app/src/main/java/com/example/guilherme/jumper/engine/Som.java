package com.example.guilherme.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.example.guilherme.jumper.R;

/**
 * Created by guilherme on 19/12/17.
 */

public class Som{

    public static int pontuacao;
    public static int colisao;
    SoundPool soundPool;
    public static int pulo;

    public Som(Context context){
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        pontuacao = soundPool.load(context, R.raw.pontos, 0);
        pulo = soundPool.load(context, R.raw.pulo, 1);
        colisao = soundPool.load(context, R.raw.colisao, 0);
    }

    public void toca(int som){
        soundPool.play(som,1,1,1,0,1);
    }

}