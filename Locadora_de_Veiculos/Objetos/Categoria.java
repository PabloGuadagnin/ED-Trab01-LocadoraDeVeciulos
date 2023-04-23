package Locadora_de_Veiculos.Objetos;

public class Categoria {

    private String nome;
    private int identificador;

    public Categoria(int identificador, String nome) {
        this.nome = nome;
        this.identificador = identificador;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}  
    
    public int getIdentificador() {return identificador;}
    public void setIdentificador(int identificador) {this.identificador = identificador;}

    @Override
    public String toString() {
        return "Categoria [nome=" + nome + ", identificador=" + identificador + "]";
    }
}
