package Locadora_de_Veiculos.Objetos;

public class Locacao {

    private Cliente cliente;
    private Veiculo veiculo;
    
    public Locacao(){
        this.cliente = null;
        this.veiculo = null;
    }

    public Cliente getCliente(){return cliente;}
    public void setCLiente(Cliente cliente){this.cliente = cliente;}

    public Veiculo getVeiculo(){return veiculo;}
    public void setVeiculo(Veiculo veiculo){this.veiculo = veiculo;}


    
}
