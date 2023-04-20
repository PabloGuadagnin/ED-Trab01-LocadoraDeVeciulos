package Locadora_de_Veiculos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.out.println("DALEEEEE");
        ListaVeiculos listaVeiculos = new ListaVeiculos();
        ListaClientes listaClientes = new ListaClientes();

        Cliente cliente1 = new Cliente("Zé", 1, 1, "1");
        Cliente cliente2 = new Cliente("JoZé", 2, 2, "2");

        listaClientes.insereInicio(cliente1);
        listaClientes.insereFim(cliente2);

        listaClientes.procuraClientePorCpf("2");
        /*
         * 
         * ListaVeiculos listaVeiculos = new ListaVeiculos();
         * ListaLocacaoes listaLocacaoes = new ListaLocacaoes();
         * 
         * 
         * 
         * 
         * 
         * listaClientes.insereFim(cliente2);
         * 
         * //System.out.println(listaClientes.tamanho());
         * //listaClientes.imprimeLista();
         * 
         * Veiculo veiculo1 = new Veiculo("IVI-5T72", "Camaro", "Chevrolet", 2012, 450,
         * 0, "1010");
         * Veiculo veiculo2 = new Veiculo("IVV-3E24", "City", "Honda", 2020, 115, 5,
         * "1011");
         * 
         * listaVeiculos.insereInicio(veiculo1);
         * listaVeiculos.insereFim(veiculo2);
         * 
         * Locacao locacao1 = new Locacao(cliente2, veiculo2,
         * LocalDate.parse("2023-04-22"), LocalDate.parse("2023-04-25"),50);
         * Locacao locacao2 = new Locacao(cliente2, veiculo2,
         * LocalDate.parse("2023-04-20"), LocalDate.parse("2023-04-30"),30);
         * //listaVeiculos.imprimeLista();
         * 
         * listaLocacaoes.insereInicio(locacao1);
         * listaLocacaoes.insereFim(locacao2);
         * 
         * listaLocacaoes.imprimeLista();
         * 
         */

        // Constroi a lista de Categorias ------------------------------------------
/*
        String caminhoVei = "Locadora_de_Veiculos/Dados/Veiculos.csv";
        String caminhoCat = "Locadora_de_Veiculos/Dados/Categorias.csv";
        // Constroi a lista de Categorias ------------------------------------------
        ListaCategorias listaCategorias = new ListaCategorias();

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
            listaCategorias.insereFim(categoria);
        }

        scanCat.close();
        // ---------------------------------------------------------------------------

        // Constroi a lista de Veiculos ----------------------------------------------


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
            listaVeiculos.insereFim(veiculo);
        }
        scanVeic.close();
        // ---------------------------------------------------------------------------

        listaCategorias.imprimeLista();

        System.out.println(" -------------------------- ");

        listaVeiculos.imprimeLista();
        */

    }
}