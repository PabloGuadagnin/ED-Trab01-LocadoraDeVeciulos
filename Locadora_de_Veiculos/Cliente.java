package Locadora_de_Veiculos;

public class Cliente {
    private String nome;
    private long cnh;
    private double telefone;
    private String cpf;

    public Cliente(String nome, long cnh, double telefone, String cpf) {
        this.nome = nome;
        this.cnh = cnh;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCnh() {
        return cnh;
    }

    public void setCnh(long cnh) {
        this.cnh = cnh;
    }

    public double getTelefone() {
        return telefone;
    }

    public void setTelefone(double telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", cnh=" + cnh + ", telefone=" + telefone + ", cpf=" + cpf + "]";
    }
}