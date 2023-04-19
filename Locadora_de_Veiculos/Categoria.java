package Locadora_de_Veiculos;

public class Categoria {

    private String nome;
    private int identificador;

    public Categoria(String nome, int identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Categoria [nome=" + nome + ", identificador=" + identificador + "]";
    }
}
