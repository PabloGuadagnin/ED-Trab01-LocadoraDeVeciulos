package Locadora_de_Veiculos;

import Locadora_de_Veiculos.Arquivo.Arquivo;
import Locadora_de_Veiculos.Listas.ListaObjetos;

public class Main {
    public static void main(String[] args) throws Exception {
       
        ListaObjetos categorias = new ListaObjetos();
        ListaObjetos veiculos = new ListaObjetos();
        

        Arquivo arquivo = new Arquivo();
        arquivo.setVeiculos(veiculos);
        arquivo.setCategorias(categorias);
    

        veiculos.imprimeLista();
        categorias.imprimeLista();

    }
}
