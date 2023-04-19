package Locadora_de_Veiculos;

public class Cliente {
    private String nome;
    private Long cnh;
    private double telefone;
    private long cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCnh() {
        return cnh;
    }

    public void setCnh(Long cnh) {
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