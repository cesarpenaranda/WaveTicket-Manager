
public class NodoArtista {

    private Artista dato;
    private NodoArtista siguiente;
    private NodoArtista anterior;

    public NodoArtista(Artista dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Artista getArtista() {
        return dato;
    }

    public NodoArtista getSiguiente() {
        return siguiente;
    }

    public NodoArtista getAnterior() {
        return anterior;
    }

    public void setArtista(Artista dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoArtista siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoArtista anterior) {
        this.anterior = anterior;
    }
}
