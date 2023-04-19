package Locadora_de_Veiculos;

public class NohObjetos {

    private Object obj;
    private NohObjetos proximo;

    public NohObjetos(Object obj) {
        this.obj = obj;
        this.proximo = null;
    }

    public Object getInfo() {
        return obj;
    }

    public void setInfo(Object obj) {
        this.obj = obj;
    }

    public NohObjetos getProximo() {
        return proximo;
    }

    public void setProximo(NohObjetos proximo) {
        this.proximo = proximo;
    }

}
