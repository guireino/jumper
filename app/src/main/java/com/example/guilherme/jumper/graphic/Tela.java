package com.example.guilherme.jumper.graphic;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by guilherme on 14/12/17.
 */

public class Tela {

    private DisplayMetrics metrics;
    private float altura;

    public Tela(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        metrics = new DisplayMetrics();   // o metado metrics cuida das dimenção da tela do aplicativo
        display.getMetrics(metrics);
    }

    public int getAltura() {
        return metrics.heightPixels;
    }
}
