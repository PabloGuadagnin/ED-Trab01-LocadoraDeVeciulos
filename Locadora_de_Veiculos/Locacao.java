package Locadora_de_Veiculos;

import java.time.LocalDate;
import java.util.Date;

public class Locacao {

    private Cliente cliente;
    private Veiculo veiculo;
    private Date dataRetirada;
    private Date dataDevolucao;
    private double valorPago;

    public Locacao(Cliente cliente, Veiculo veiculo, Date dataInicio, Date dataFim, double valorPago) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataRetirada = dataInicio;
        this.dataDevolucao = dataFim;
        this.valorPago = valorPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    @Override
    public String toString() {
        return "Locação [" +
                "Cliente = " + cliente +
                ", Veículo = " + veiculo +
                ", Data de Retirada = " + dataRetirada +
                ", Data de Devolução = " + dataDevolucao +
                ", Valor Pago = " + valorPago +
                ']';
    }
}
