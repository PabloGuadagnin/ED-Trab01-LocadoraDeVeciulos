package Locadora_de_Veiculos.Interfaces;

public interface IListaObjetos {
    
    public void insereInicio(Object ob);
    public void insereFim(Object ob);
    public boolean estahVazia();
    public boolean remove(Object ob);
    public int tamanho();
}
