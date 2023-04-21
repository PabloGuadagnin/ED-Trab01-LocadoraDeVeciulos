package Locadora_de_Veiculos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaVeiculos {

    private NohObjetos inicio;

    public ListaVeiculos() {
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

    public Veiculo selecionaPorPlaca(String placa) {
        NohObjetos aux = inicio;
    
        while (aux != null) {
            if (aux.getObject() instanceof Veiculo) {
                Veiculo veiculo = (Veiculo) aux.getObject();
                if (veiculo.getPlaca().equals(placa)) {
                    System.out.println(veiculo.toString());
                    return veiculo;
                }
            }
            aux = aux.getProximo();
        }
        System.out.println("N encontrado");
        return null;
    }

    public void preenche() throws FileNotFoundException{
        String caminhoVei = "Locadora_de_Veiculos/Dados/Veiculos.csv";
            File arqVeic = new File(caminhoVei);
            Scanner scanVeic = new Scanner(arqVeic);
            scanVeic.useDelimiter(";|\n");
    
            // Ignora a primeira linha do arquivo, que contém o cabeçalho
            scanVeic.nextLine();
    
            while (scanVeic.hasNextLine()) {
                String linha = scanVeic.nextLine();
                String[] campos = linha.split(";");
                String placa = campos[0];
                String modelo = campos[1];
                String marca = campos[2];
                int ano = Integer.parseInt(campos[3]);
                int potencia = Integer.parseInt(campos[4]);
                int nLugares = Integer.parseInt(campos[5]);
                String categoria = campos[6];
                Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, potencia, nLugares, categoria);
                insereFim(veiculo);
                
            }
            //listaVeiculos.imprimeLista();
            scanVeic.close();
        }
}
