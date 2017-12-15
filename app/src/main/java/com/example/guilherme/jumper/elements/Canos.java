package com.example.guilherme.jumper.elements;

import android.graphics.Canvas;

import com.example.guilherme.jumper.graphic.Tela;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilherme on 15/12/17.
 */

public class Canos {

    private static final int distancia_Canos = 200;
    private final List<Cano> canos = new ArrayList<Cano>();
    public static final int quantidade_Canos = 5;

    public Canos(Tela tela){
        int posicao = 400;
        
        for (int i = 0; i < quantidade_Canos; i++){
            posicao += distancia_Canos;
            Cano cano = new Cano(tela, posicao);
            canos.add(cano);
        }
    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano : canos){
            cano.desenhaNo(canvas);
        }
    }

    public void move(){
        for (Cano cano : canos){
            cano.move();
        }
    }
}
