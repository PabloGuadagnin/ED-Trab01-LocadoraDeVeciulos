package Locadora_de_Veiculos.SemUso;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Locadora_de_Veiculos.Listas.ListaObjetos;
import Locadora_de_Veiculos.Objetos.Categoria;
import Locadora_de_Veiculos.Objetos.Veiculo;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Constroi a lista de Categorias ------------------------------------------
        //ListaCategorias listaCategorias = new ListaCategorias();

        ListaObjetos listaCategorias = new ListaObjetos();

        File arqCat = new File("Locadora_de_Veiculos\\Dados\\Categorias.csv");
        Scanner scanCat = new Scanner(arqCat);
        scanCat.useDelimiter(";|\n");

        // Ignora a primeira linha do arquivo, que contém o cabeçalho
        scanCat.nextLine();

        while (scanCat.hasNextLine()) {
            String linha = scanCat.nextLine();
            String[] campos = linha.split(";");
            int id = Integer.parseInt(campos[0]);
            String nome = campos[1];
            Categoria categoria = new Categoria(id, nome);
            listaCategorias.insereFim(categoria);
        }

        scanCat.close();
        // ---------------------------------------------------------------------------

        // Constroi a lista de Veiculos ----------------------------------------------

        ListaObjetos listaVeiculos = new ListaObjetos();

        File arqVeic = new File("Locadora_de_Veiculos\\Dados\\Veiculos.csv");
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
            listaVeiculos.insereFim(veiculo);
        }
        scanVeic.close();
        // ---------------------------------------------------------------------------

        listaCategorias.imprimeLista();

        System.out.println(" -------------------------- ");

        listaVeiculos.imprimeLista();

    }
}
