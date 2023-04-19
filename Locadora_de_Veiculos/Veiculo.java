package Locadora_de_Veiculos;

public class Veiculo {
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private int potencia;
    private int nLugares;
    private String categoria;

    public Veiculo(String placa, String modelo, String marca, int ano, int potencia, int nLugares, String categoria) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.potencia = potencia;
        this.nLugares = nLugares;
        this.categoria = categoria;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getnLugares() {
        return nLugares;
    }

    public void setnLugares(int nLugares) {
        this.nLugares = nLugares;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Veiculo [placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", ano=" + ano + ", potencia="
                + potencia + ", nLugares=" + nLugares + ", categoria=" + categoria + "]";
    }

}