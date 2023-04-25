package Locadora_de_Veiculos.Objetos;

public class Cliente {
    private String nome;
    private long cnh;
    private long telefone;
    private long cpf;
    private boolean locacao;

    public Cliente(String nome, long cnh, long telefone, long cpf) {
        this.nome = nome;
        this.cnh = cnh;
        this.telefone = telefone;
        this.cpf = cpf;
        this.locacao = false;
    }

    public String getNome() {return  nome;}
    public void setNome(String nome) {this.nome = nome;}

    public long getCnh() {return cnh;}
    public void setCnh(long cnh) {this.cnh = cnh;}

    public long getTelefone() {return telefone;}
    public void setTelefone(long telefone) {this.telefone = telefone;}

    public long getCpf() {return cpf;}
    public void setCpf(long cpf) {this.cpf = cpf;}
    
    public boolean getLocacao(){return locacao;}
    public void setLocacao(Boolean locacao){this.locacao = locacao;}

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", cnh=" + cnh + ", telefone=" + telefone + ", cpf=" + cpf + ", locacao="
                + locacao + "]";
    }

}