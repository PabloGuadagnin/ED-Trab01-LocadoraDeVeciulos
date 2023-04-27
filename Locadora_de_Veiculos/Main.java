package Locadora_de_Veiculos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        Cliente clienteA = new Cliente(null, 0, 0, 0);
        Veiculo veiculoA = new Veiculo(null, null, null, 0, 0, 0, null);

        ListaVeiculos listaVeiculos = new ListaVeiculos();
        ListaClientes listaClientes = new ListaClientes();
        ListaCategorias listaCategorias = new ListaCategorias();
        ListaLocacaoes listaLocacaoes = new ListaLocacaoes();

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
        int p = 0;
        while (p == 0) {

            System.out.println("|------------------------|");
            System.out.println("| A | Verificar  veiculo |");
            System.out.println("|------------------------|");
            System.out.println("| B | Verificar  cliente |");
            System.out.println("|------------------------|");
            System.out.println("| C | Adicionar  Veiculo |");
            System.out.println("|------------------------|");
            System.out.println("| D |    ADD Client      |");
            System.out.println("| E |  Locar carro       ");
            System.out.println("|------------------------|");
            System.out.println("| J | Sair               |");
            System.out.println("|------------------------|");

            String x = scan.nextLine();

            switch (x) {

                case "a":
                    System.out.println("Informe a placo do veiculo: ");
                    String placa = scan.nextLine();
                    listaVeiculos.selecionaPorPlaca(placa);
                    scan.nextLine();
                    System.out.print("\033[H\033[2J");
                    break;

                case "b":
                    System.out.println("Informe o cpf: ");
                    long cpf = scan.nextLong();
                    listaClientes.procuraClientePorCpf(cpf);
                    scan.nextLine();
                    scan.nextLine();
                    System.out.print("\033[H\033[2J");
                    break;

                case "c":
                    System.out.print("Informe a placa: ");
                    String placaV = scan.nextLine();
                    System.out.print("Informe o modelo: ");
                    String modeloV = scan.nextLine();
                    System.out.print("Informe a marca: ");
                    String marcaV = scan.nextLine();
                    System.out.print("Informe o ano: ");
                    int ano = scan.nextInt();
                    System.out.print("Informe a potencia: ");
                    int potenciaV = scan.nextInt();
                    System.out.print("Informe o anor: ");
                    int anoV = scan.nextInt();
                    System.out.print("Informe a categoria: ");
                    String catV = scan.nextLine();
                    scan.nextLine();
                    Veiculo novoCarro = new Veiculo(placaV, modeloV, marcaV, ano, potenciaV, anoV, catV);
                    listaVeiculos.insereFim(novoCarro);
                    System.out.println("Carro adicionado com \u001B[32msucesso\u001B[0m");
                    scan.nextLine();
                    System.out.print("\033[H\033[2J");

                    break;

                case "d":
                    System.out.print("Informe o nome: ");
                    String nome = scan.nextLine();
                    System.out.print("Informe o cnh: ");
                    long cnh = scan.nextLong();
                    System.out.print("Informe o telefone: ");
                    double tel = scan.nextDouble();
                    System.out.print("Informe o cpf: ");
                    long cpfC = scan.nextLong();

                    Cliente novoCliente = new Cliente(nome, cnh, tel, cpfC);
                    listaClientes.insereFim(novoCliente);
                    System.out.println("Cliente adicionado com \u001B[32msucesso\u001B[0m");
                    scan.nextLine();
                    scan.nextLine();
                    System.out.print("\033[H\033[2J");
                    break;

                case "e":
                    System.out.println("Informe o cpf do cliente: ");
                    long cpfL = scan.nextLong();
                    scan.nextLine();
                    clienteA = listaClientes.procuraClientePorCpf(cpfL);

                    System.out.println("Informe a placa do carro: ");
                    String placaA = scan.nextLine();
                    veiculoA = listaVeiculos.selecionaPorPlaca(placaA);

                    System.out.println("Informe a data de início (no formato AAAA-MM-DD):");
                    String dataInicioStr = scan.nextLine();
                    Date dataInicio = formato.parse(dataInicioStr);

                    // Lê a data de fim
                    System.out.println("Informe a data de fim (no formato AAAA-MM-DD):");
                    String dataFimStr = scan.nextLine();
                    Date dataFim = formato.parse(dataFimStr);

                    // Cria objetos Calendar para as duas datas
                    Calendar calendarInicio = Calendar.getInstance();
                    calendarInicio.setTime(dataInicio);
                    Calendar calendarFim = Calendar.getInstance();
                    calendarFim.setTime(dataFim);

                    scan.nextLine();
                    // Calcula a diferença em dias entre as datas
                    long diferencaEmMillis = calendarFim.getTimeInMillis() - calendarInicio.getTimeInMillis();
                    long dias = diferencaEmMillis / (24 * 60 * 60 * 1000);

                    Locacao novLocacao = new Locacao(clienteA, veiculoA, dataInicio, dataFim, dias*50);
                    listaLocacaoes.insereFim(novLocacao);
                    scan.nextLine();
                    System.out.println( novLocacao.toString());
                    scan.nextLine();

                    break;

                case "j":
                    System.out.println("");
                    p = 1;
                    break;
            }

        }
    }
}