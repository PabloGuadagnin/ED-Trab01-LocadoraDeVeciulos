package Locadora_de_Veiculos;

public class Main {
    public static void main(String[] args) {
        System.out.println("DALEEEEE");

        ListaClientes listaClientes = new ListaClientes();

        Cliente cliente1 = new Cliente("Zé", 1, 1, 1);
        Cliente cliente2 = new Cliente("JoZé", 2, 2, 2);

        listaClientes.insereInicio(cliente1);
        listaClientes.insereFim(cliente2);

        System.out.println(listaClientes.tamanho());
        listaClientes.imprimeLista();
    }
}
