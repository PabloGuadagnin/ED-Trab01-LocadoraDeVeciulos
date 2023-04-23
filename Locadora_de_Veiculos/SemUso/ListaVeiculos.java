package Locadora_de_Veiculos.SemUso;

import Locadora_de_Veiculos.Listas.NohObjetos;
import Locadora_de_Veiculos.Objetos.Veiculo;

public class ListaVeiculos {

    private NohObjetos inicio;

    public ListaVeiculos() {
        this.inicio = null;
    }

    public void insereInicio(Veiculo ob) {
        NohObjetos novo = new NohObjetos(ob);
        if (inicio == null)
            inicio = novo;
        else {
            novo.setProximo(inicio);
            inicio = novo;
        }
    }

    public void insereFim(Veiculo ob) {
        NohObjetos novo = new NohObjetos(ob);
        if (inicio == null)
            inicio = novo;
        else {
            NohObjetos ultimo = null;
            for (NohObjetos i = inicio; i != null; i = i.getProximo())
                ultimo = i;
            ultimo.setProximo(novo);
        }
    }

    public boolean estahVazia() {
        if (inicio != null)
            return false;
        return true;
    }

    public boolean remove(Veiculo ob) {
        NohObjetos ant = null, p;
        p = inicio;

        while (p != null && p.getObj() != ob) {
            ant = p;
            p = p.getProximo();
        }

        if (p == null)
            return false;
        if (ant == null)
            inicio = p.getProximo();
        else
            ant.setProximo(p.getProximo());

        return true;
    }

    public int tamanho() {
        NohObjetos aux = inicio;
        int tamanho = 0;

        if (!this.estahVazia()) {
            while (aux != null) {
                tamanho += 1;
                aux = aux.getProximo();
            }
        }
        return tamanho;
    }

    public void imprimeLista() {
        NohObjetos atual = inicio;
        while (atual != null) {
            System.out.println(atual.getObj());
            atual = atual.getProximo();
        }
    }

    public void imprimeListaInversa() {
        imprimeListaInversaRecursivo(inicio);
    }

    private void imprimeListaInversaRecursivo(NohObjetos noh) {
        if (noh == null) {
            return;
        }
        imprimeListaInversaRecursivo(noh.getProximo());
        System.out.println(noh.getObj());
    }
}
