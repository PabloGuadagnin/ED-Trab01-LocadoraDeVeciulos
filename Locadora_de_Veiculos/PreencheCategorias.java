package Locadora_de_Veiculos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PreencheCategorias {

    public void preenche() throws FileNotFoundException{
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
        listaCategorias.imprimeLista();
    }
}
