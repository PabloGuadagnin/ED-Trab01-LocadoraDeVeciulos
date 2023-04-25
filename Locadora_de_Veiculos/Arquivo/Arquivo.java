package Locadora_de_Veiculos.Arquivo;

import java.io.File;
import java.util.Scanner;

import Locadora_de_Veiculos.Listas.ListaObjetos;
import Locadora_de_Veiculos.Objetos.Categoria;
import Locadora_de_Veiculos.Objetos.Cliente;
import Locadora_de_Veiculos.Objetos.Veiculo;

public class Arquivo {
    String caminhoVeiculos = "Locadora_de_Veiculos\\Dados\\Veiculos.csv";
    String caminhoCategorias = "Locadora_de_Veiculos\\Dados\\Categorias.csv";
    String caminhoClientes = "Locadora_de_Veiculos\\Dados\\Clientes.csv";

    public void getVeiculos(ListaObjetos lista) {

        try {
            File arqVeic = new File(caminhoVeiculos);
            Scanner scanner = new Scanner(arqVeic);
            scanner.useDelimiter(";|\n");

            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] campos = linha.split(";");
                String placa = campos[0];
                String modelo = campos[1];
                String marca = campos[2];
                int ano = Integer.parseInt(campos[3]);
                int potencia = Integer.parseInt(campos[4]);
                int nLugares = Integer.parseInt(campos[5]);
                String categoria = campos[6];
                Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, potencia, nLugares, categoria);
                lista.insereFim(veiculo);
            }
            scanner.close();

        } catch (Exception ex) {
            System.out.println("Erro na leitura do arquivo!");
        }
    }

    public void getCategorias(ListaObjetos lista) {
        try {
            File arqVeic = new File(caminhoCategorias);
            Scanner scanner = new Scanner(arqVeic);
            scanner.useDelimiter(";|\n");

            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] campos = linha.split(";");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                Categoria categoria = new Categoria(id, nome);
                lista.insereFim(categoria);
            }
            scanner.close();

        } catch (Exception ex) {
            System.out.println("Erro na leitura do arquivo!");
        }
    }

    public void getClientes(ListaObjetos lista) {
        try {
            File arqClientes = new File(caminhoClientes);
            Scanner scanner = new Scanner(arqClientes);
            scanner.useDelimiter(";|\n");

            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] campos = linha.split(";");
                String nome = campos[0];
                long cnh = Long.parseLong(campos[1]);
                long telefone = Long.parseLong(campos[2]);
                long cpf = Long.parseLong(campos[3]);

                Cliente cliente = new Cliente(nome, cnh, telefone, cpf);
                lista.insereFim(cliente);
            }
            scanner.close();

        } catch (Exception ex) {
            System.out.println("Erro na leitura do arquivo!");
        }
    }
}