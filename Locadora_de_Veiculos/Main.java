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

        Cliente cliente1 = new Cliente("Zé", 1, 1, 1);
        Cliente cliente2 = new Cliente("JoZé", 2, 2, 2);

        listaClientes.insereInicio(cliente1);
        listaClientes.insereFim(cliente2);

        listaClientes.procuraClientePorCpf(2);
        System.out.println("");
        listaClientes.editarCliente("André", 8, 7, 2);
        listaClientes.imprimeLista();
        // Constroi a lista de Categorias ------------------------------------------

        

        System.out.println(" -------------------------- ");

        PreencerVeiculos preencerVeiculos = new PreencerVeiculos();
        PreencheCategorias preencheCategorias = new PreencheCategorias();

        //preencheCategorias.preenche();
        //preencerVeiculos.preenche();

    }
}