package Locadora_de_Veiculos.Cadastro;

import Locadora_de_Veiculos.Listas.ListaObjetos;
import Locadora_de_Veiculos.Listas.NohObjetos;
import Locadora_de_Veiculos.Objetos.Cliente;

public class CadClientes extends ListaObjetos{

    /*
    * Método encontra o cliente pelo CPF
    * Imprime e retorna um cliente.
    */
    public Object procuraClientePorCpf(long cpf) {
        NohObjetos novoNoh = inicio;
        while (novoNoh != null) {
            Object obj = novoNoh.getObj();
            if (obj instanceof Cliente) {
                Cliente cliente = (Cliente) obj;
                if (cliente.getCpf() == cpf) {
                    return cliente;
                }
            }
            novoNoh = novoNoh.getProximo();
        }
        System.out.println("Não encontrado");
        return null; 
    }

    public Object procuraClientePorCnh(long cnh) {
        NohObjetos novoNoh = inicio;
        while (novoNoh != null) {
            Object obj = novoNoh.getObj();
            if (obj instanceof Cliente) {
                Cliente cliente = (Cliente) obj;
                if (cliente.getCnh() == cnh) {
                    return cliente;
                }
            }
            novoNoh = novoNoh.getProximo();
        }
        System.out.println("Não encontrado");
        return null; 
    }

    public boolean clienteEmLocacao(long cpf) {
        NohObjetos novoNoh = inicio;
        while (novoNoh != null) {
            Object obj = novoNoh.getObj();
            if (obj instanceof Cliente) {
                Cliente cliente = (Cliente) obj;
                if (cliente.getCpf() == cpf) {
                    return cliente.getLocacao();
                }
            }
            novoNoh = novoNoh.getProximo();
        }
        System.out.println("Não encontrado");
        return false; 
    }


}