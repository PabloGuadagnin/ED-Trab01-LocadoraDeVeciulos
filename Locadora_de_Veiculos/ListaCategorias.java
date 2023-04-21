package Locadora_de_Veiculos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaCategorias {

    private NohObjetos inicio;

    public ListaCategorias() {
        this.inicio = null;
    }

    public void insereInicio(Object ob) {
        NohObjetos novo = new NohObjetos(ob);
        if (inicio == null)
            inicio = novo;
        else {
            novo.setProximo(inicio);
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
        NohObjetos ant = null, p;
        p = inicio;

        while (p != null && p.getObject() != ob) {
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

    public void imprimeLista(){
        NohObjetos novoNoh = inicio;
        while (novoNoh !=null){
            System.out.println(novoNoh.getObject()+" ");
            novoNoh = novoNoh.getProximo();
        }
        System.out.println("");
    }

    public void preenche() throws FileNotFoundException{
        String caminhoCat = "Locadora_de_Veiculos/Dados/Categorias.csv";
            // Constroi a lista de Categorias ------------------------------------------
    
            File arqCat = new File(caminhoCat);
            Scanner scanCat = new Scanner(arqCat);
            scanCat.useDelimiter(";|\n");
    
            // Ignora a primeira linha do arquivo, que contém o cabeçalho
            scanCat.nextLine();
    
            while (scanCat.hasNextLine()) {
                String linha = scanCat.nextLine();
                String[] campos = linha.split(";");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                Categoria categoria = new Categoria(nome, id);
                insereFim(categoria);
            }
            scanCat.close();
            //listaCategorias.imprimeLista();
        }
}
