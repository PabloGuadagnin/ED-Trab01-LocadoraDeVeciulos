package Locadora_de_Veiculos.Listas;

import Locadora_de_Veiculos.Interfaces.IListaObjetos;
import Locadora_de_Veiculos.Objetos.Cliente;

public class ListaObjetos implements IListaObjetos {

    private NohObjetos inicio;
    private NohObjetos fim;

    public ListaObjetos() {
        this.inicio = null;
        // this.fim = null;
    }

    public void insereInicio(Object ob) {
        NohObjetos novo = new NohObjetos(ob);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        }
    }

    public void insereFim(Object ob) {
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

    public boolean remove(Object ob) {
        NohObjetos p = inicio;

        while (p != null && p.getObj() != ob) {
            p = p.getProximo();
        }

        if (p == null)
            return false;
        if (p == inicio) {
            inicio = p.getProximo();
            if (inicio != null)
                inicio.setAnterior(null);
            else
                fim = null;
        } else if (p.getProximo() == null) {
            p.getAnterior().setProximo(null);
            fim = p.getAnterior();

        } else {
            p.getAnterior().setProximo(p.getProximo());
            p.getProximo().setAnterior(p.getAnterior());
        }

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

    /*
     * Método encontra o cliente pelo CPF
     * Imprime e retorna um cliente.
     */
    public Object procuraClientePorCpf(long cpf) {
        NohObjetos novoNoh = inicio;
        while (novoNoh != null) {
            Object obj = novoNoh.getObj();
            if (obj instanceof Cliente) {
                Cliente cliente = (Cliente) obj;
                if (cliente.getCpf() == cpf) {
                    // System.out.println("Cliente encontrado: " + cliente.toString());
                    return cliente;
                }
            }
            novoNoh = novoNoh.getProximo();
        }
        System.out.println("Não encontrado");
        return null; // Se não encontrou nenhum cliente com o CPF informado
    }
}
