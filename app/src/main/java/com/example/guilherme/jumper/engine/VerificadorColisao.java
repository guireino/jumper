package com.example.guilherme.jumper.engine;

import com.example.guilherme.jumper.elements.Canos;
import com.example.guilherme.jumper.elements.passaro;

/**
 * Created by guilherme on 18/12/17.
 */

class VerificadorColisao {

    private passaro passaro_0;
    private Canos canos;

    public VerificadorColisao(passaro passaro_0, Canos canos) {

        this.passaro_0 = passaro_0;
        this.canos = canos;
    }

    public boolean temColicao() {
        return canos.temColisaoCom(passaro_0);
    }

}
