
public class NodoConcierto {

    private Concierto dato;
    private NodoConcierto siguiente;
    private NodoConcierto anterior;

    public NodoConcierto(Concierto dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Concierto getConcierto() {
        return dato;
    }

    public NodoConcierto getSiguiente() {
        return siguiente;
    }

    public NodoConcierto getAnterior() {
        return anterior;
    }

    public void setConcierto(Concierto dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoConcierto siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoConcierto anterior) {
        this.anterior = anterior;
    }
}
