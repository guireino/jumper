package com.example.guilherme.jumper.graphic;

import android.graphics.Paint;

/**
 * Created by guilherme on 12/12/17.
 */

public class Cores {

    public static Paint getCorDoPassado() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        return paint;
    }

    public static Paint getCorCano() {
        Paint verde = new Paint();
        verde.setColor(0xFF00FF00);
        return verde;
    }
}