/*
 * Pablo L. A. guadagnin
 * Lucas de L. Martinez
 * Wagner de O. Quadros
 */

package Locadora_de_Veiculos.SemUso;

import java.util.Scanner;

import Locadora_de_Veiculos.Arquivo.Arquivo;
import Locadora_de_Veiculos.Cadastro.CadClientes;
import Locadora_de_Veiculos.Listas.ListaObjetos;
import Locadora_de_Veiculos.Objetos.Cliente;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);

        int escolha = 0;

        ListaObjetos categorias = new ListaObjetos();
        ListaObjetos veiculos = new ListaObjetos();
        CadClientes clientes = new CadClientes();

        Arquivo arquivo = new Arquivo();
        arquivo.getVeiculos(veiculos);
        arquivo.getCategorias(categorias);
        arquivo.getClientes(clientes);

        
        do {
            System.out.println("O que quer fazer ?");
            System.out.println("1 - Imprimir lista de clientes");
            System.out.println("2 - Cadastrar clientes");
            System.out.println("3 - Editar clientes");
            System.out.println("4 - Excluir clientes");
            System.out.println("0 - Sair");
            System.out.print("Sua escolha: ");
            escolha = entrada.nextInt();
            entrada.nextLine();

            switch (escolha) {
                case 1:
                    clientes.imprimeListaInicio();
                    System.out.println("");
                    clientes.imprimeListaFinal();

                    break;
                case 2:
                    Cliente cliente = new Cliente(null, 0, 0, 0); // Cria o obj
                    System.out.print("Nome: ");
                    cliente.setNome(entrada.nextLine());
                    System.out.print("CNH: ");
                    cliente.setCnh(entrada.nextLong());
                    System.out.print("Telefone: ");
                    cliente.setTelefone(entrada.nextLong());
                    System.out.print("CPF: ");
                    cliente.setCpf(entrada.nextLong());

                    clientes.insereFim(cliente); // Insere no fim da lista
                    break;
                case 3:
                    System.out.print("Qual o CPF do cliente que quer editar ? ");
                    clientes.remove(clientes.procuraClientePorCpf(entrada.nextLong()));

                    System.out.println("Insira as novas informações: ");
                    entrada.nextLine();
                    Cliente cliente2 = new Cliente(null, 0, 0, 0); // Cria o obj
                    System.out.print("Nome: ");
                    cliente2.setNome(entrada.nextLine());
                    System.out.print("CNH: ");
                    cliente2.setCnh(entrada.nextLong());
                    System.out.print("Telefone: ");
                    cliente2.setTelefone(entrada.nextLong());
                    System.out.print("CPF: ");
                    cliente2.setCpf(entrada.nextLong());

                    clientes.insereFim(cliente2); // Insere no fim da lista
                    break;
                case 4:
                    System.out.print("Qual o CPF do cliente que quer remover ? ");
                    if (clientes.remove(clientes.procuraClientePorCpf(entrada.nextLong())) == true) {
                        System.out.println("Clinte removido com sucesso");
                        break;
                    }
                    System.out.println("Cliente não encontrado.");
                    break;
                case 0:
                    System.out.println("Você escolheu sair.");
                    break;

                default:
                    break;
            }
        } while (escolha != 0);
        entrada.close();
    }
}
