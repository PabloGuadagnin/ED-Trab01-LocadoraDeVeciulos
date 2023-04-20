package Locadora_de_Veiculos;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PreencerVeiculos {

    public void preenche() throws FileNotFoundException{
    ListaVeiculos listaVeiculos = new ListaVeiculos();
    String caminhoVei = "Locadora_de_Veiculos/Dados/Veiculos.csv";
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
        listaVeiculos.imprimeLista();
        scanVeic.close();
    }
}
