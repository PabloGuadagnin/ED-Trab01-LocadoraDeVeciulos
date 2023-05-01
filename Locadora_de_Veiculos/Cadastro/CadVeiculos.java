package Locadora_de_Veiculos.Cadastro;

import Locadora_de_Veiculos.Listas.ListaObjetos;
import Locadora_de_Veiculos.Listas.NohObjetos;
import Locadora_de_Veiculos.Objetos.Veiculo;

public class CadVeiculos extends ListaObjetos {

    public Object procuraVeiculoPorPlaca(String placa) {
        NohObjetos novoNoh = inicio;
        while (novoNoh != null) {
            Object obj = novoNoh.getObj();
            if (obj instanceof Veiculo) {
                Veiculo veiculo = (Veiculo) obj;
                if (veiculo.getPlaca().equals(placa)) {
                    return veiculo;
                }
            }
            novoNoh = novoNoh.getProximo();
        }
        System.out.println("Não encontrado");
        return null; 
    }


}
