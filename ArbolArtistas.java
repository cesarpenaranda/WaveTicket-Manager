public class ArbolArtistas {
    private NodoArtista raiz;
    public ArbolArtistas(){
        this.raiz = null;
    }
    public boolean estaVacio(){
     return this.raiz == null;
    }

    public void insertar(Artista dato){
        this.raiz = insertarRecursivo(this.raiz, dato);
    }
    private NodoArtista insertarRecursivo(NodoArtista nodo, Artista dato){
    if (nodo == null){
            return new NodoArtista(dato);
        }
        if (dato.getRanking() < nodo.getArtista().getRanking()){
            nodo.setAnterior(insertarRecursivo(nodo.getAnterior(), dato));
        } else if (dato.getRanking() > nodo.getArtista().getRanking()){
            nodo.setSiguiente(insertarRecursivo(nodo.getSiguiente(), dato));
        }
        return nodo;
    }
    public void mostrarEnOrden(){
        if (estaVacio()){
            System.out.print("No hay artista");
        } else{
            mostrarEnOrdenRec(raiz);
        }
    }
    private void mostrarEnOrdenRec(NodoArtista nodo){
        NodoArtista actual = nodo;
        if (actual != null){
            mostrarEnOrdenRec(actual.getAnterior());
            System.out.println(actual.getArtista().getNombre() + " - Ranking: " + actual.getArtista().getRanking());
            mostrarEnOrdenRec(actual.getSiguiente());
        }
    }
    public Artista buscarPorId(String id) {
        return buscarPorIdRec(raiz, id);
    }
 private Artista buscarPorIdRec(NodoArtista actual, String id) {
    if (actual == null) {
        return null;
    }
    if (actual.getArtista().getId().equals(id)) {
        return actual.getArtista();
    }
    Artista encontrado = buscarPorIdRec(actual.getAnterior(), id);
    if (encontrado != null) {
        return encontrado;
    }
    return buscarPorIdRec(actual.getSiguiente(), id);
}

    public boolean existeId(String id) {
        return existeIdRec(raiz, id);
    }
    private boolean existeIdRec(NodoArtista actual, String id) {
        if (actual == null) {
            return false;
        }
        if (actual.getArtista().getId().equals(id)) {
            return true;
        }
        return existeIdRec(actual.getAnterior(), id) || existeIdRec(actual.getSiguiente(), id);
    }
}


