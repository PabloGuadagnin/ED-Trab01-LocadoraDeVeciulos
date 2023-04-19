package Locadora_de_Veiculos;

public class Cliente {
    private String nome;
    private long cnh;
    private double telefone;
    private long cpf;

    public Cliente(String nome, long cnh, double telefone, long cpf) {
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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Veiculo [nome=" + nome + ", cnh=" + cnh + ", telefone=" + telefone + ", cpf=" + cpf + "]";
    }
}