package Locadora_de_Veiculos;

public class NohObjetos {

    private Object obj;
    private NohObjetos anterior;
    private NohObjetos proximo;

    public NohObjetos(Object obj) {
        this.obj = obj;
        this.anterior = null;
        this.proximo = null;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public NohObjetos getAnterior() {
        return anterior;
    }

    public void setAnterior(NohObjetos anterior) {
        this.anterior = anterior;
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
