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
        Scanner scan = new Scanner(System.in);
        // System.out.println("DALEEEEE");
        ListaVeiculos listaVeiculos = new ListaVeiculos();
        ListaClientes listaClientes = new ListaClientes();
        ListaCategorias listaCategorias = new ListaCategorias();

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


        listaVeiculos.preenche();
        listaCategorias.preenche();

        

        listaVeiculos.selecionaPorPlaca("IVV-3E24");
        listaVeiculos.selecionaPorPlaca("ITT-8Y43");
        
        listaCategorias.verificaCategoria(1015);
        
        System.out.println("|------------------------|");
        System.out.println("| A | Verificar  veiculo |");
        System.out.println("|------------------------|");
        System.out.println("| B | Verificar  cliente |");
        System.out.println("|------------------------|");
        System.out.println("| C | Adicionar  Veiculo |");
        System.out.println("|------------------------|");
        
        String x = scan.nextLine();

        switch (x){

            case "a":
                System.out.println("Informe a placo do veiculo: ");
                String placa = scan.nextLine();
                listaVeiculos.selecionaPorPlaca(placa);
                break;

            case "b":
                System.out.println("Informe o cpf: ");
                long cpf = scan.nextLong();
                listaClientes.procuraClientePorCpf(cpf);
                break;

            case "c":
                System.out.println("");
        }
    }
}