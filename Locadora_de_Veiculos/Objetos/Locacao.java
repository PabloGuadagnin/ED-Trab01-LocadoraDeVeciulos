package Locadora_de_Veiculos.Objetos;

public class Locacao {

    private long cnhLocador;
    private String placaVeiculo;
    private String dataInicio;
    private String dataFim;
    private double valor;
    
    public Locacao(long cnhLocador, String placaVeiculo, String dataInicio, String dataFim, double valor) {
        this.cnhLocador = cnhLocador;
        this.placaVeiculo = placaVeiculo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valor = valor;
    }

    public long getCnhLocador() {return cnhLocador;}
    public void setCnhLocador(long cnhLocador) {this.cnhLocador = cnhLocador;}
   
    public String getPlacaVeiculo() {return placaVeiculo;}
    public void setPlacaVeiculo(String placaVeiculo) {this.placaVeiculo = placaVeiculo;}

    public String getDataInicio() {return dataInicio;}
    public void setDataInicio(String dataInicio) {this.dataInicio = dataInicio;}

    public String getDataFim() {return dataFim;}
    public void setDataFim(String dataFim) {this.dataFim = dataFim;}

    public double getValor() {return valor;}
    public void setValor(double valor) {this.valor = valor;}

    public String toString() {
        return "Locacao [cnhLocador=" + cnhLocador + ", placaVeiculo=" + placaVeiculo + ", dataInicio=" + dataInicio
                + ", dataFim=" + dataFim + ", valor=" + valor + "]";
    }
    
    
}
