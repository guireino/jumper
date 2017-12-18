package com.example.guilherme.jumper.graphic;

import android.graphics.Paint;
import android.graphics.Typeface;

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

    public static Paint getCorPontuacao() {
        Paint paint = new Paint();
        paint.setColor(0xFFFFFFFF);
        paint.setTextSize(80);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(3, 5, 5, 0xFF000000);
        return paint;
    }

    public static Paint getCorGameOver(){
        Paint painRed = new Paint();
        painRed.setColor(0xFFFF0000);
        painRed.setTextSize(50);
        painRed.setTypeface(Typeface.DEFAULT_BOLD);
        painRed.setShadowLayer(2,3,3,0xFF000000);
        return painRed;
    }
}