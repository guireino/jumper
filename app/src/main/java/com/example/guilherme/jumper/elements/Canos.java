package com.example.guilherme.jumper.elements;

import android.graphics.Canvas;

import com.example.guilherme.jumper.graphic.Tela;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by guilherme on 15/12/17.
 */

public class Canos {

    private static final int distancia_Canos = 200;
    private final List<Cano> canos = new ArrayList<Cano>();
    public static final int quantidade_Canos = 5;
    private Tela tela;
    private Pontuacao pontuacao;

    public Canos(Tela tela, Pontuacao pontuacao){
        this.tela = tela;
        this.pontuacao = pontuacao;

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
        ListIterator<Cano> iterator = canos.listIterator();
        while (iterator.hasNext()){
            Cano cano = iterator.next();
            cano.move();
            if (cano.saiuTela()){  // if que verificar se cano saiu da tela e criar um novo cano
               pontuacao.aumento();
               iterator.remove();
               Cano outCano = new Cano(tela, getMaximo() + distancia_Canos);
               iterator.add(outCano);
            }
        }
    }

    private int getMaximo() {
        int maximo = 0;
        for (Cano cano : canos){
            maximo = (int) Math.max(cano.getPoxicao(), maximo);
        }

        return maximo;
    }
}