package entidades.herois;

import entidades.Entidade;
import entidades.Heroi;

public class Arqueiro extends Heroi {


    /*
        Construtor de Arqueiro
    */
    public Arqueiro(String nome, int forca, int maxHp) {
        super(nome, forca,maxHp);
    }

    @Override
    public Entidade atacar(Entidade inimigo) {
        return null;
    }

    @Override
    public void usarPocao() {

    }

    @Override
    public void mostrarDetalhes() {

    }
}
