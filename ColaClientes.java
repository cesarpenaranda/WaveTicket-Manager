
// Cola FIFO con lista enlazada simple para la fila de clientes
public class ColaClientes {

    private NodoCliente cabeza;
    private NodoCliente cola;
    private int tamano;

    public ColaClientes() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void encolar(Cliente cliente) {
        if (cliente == null) {
            return;
        }
        NodoCliente nuevoNodo = new NodoCliente(cliente);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            cola = nuevoNodo;
        }
        tamano++;
    }

    public Cliente desencolar() {
        if (estaVacia()) {
            return null;
        }
        Cliente cliente = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        if (cabeza == null) {
            cola = null;
        }
        tamano--;
        return cliente;
    }

    public void mostrarCola() {
        NodoCliente actual = cabeza;
        if (estaVacia()) {
            System.out.println("la cola esta vacia");
            return;
        }
        int posicion = 1;
        while (actual != null) {
            System.out.println(posicion + ". " + actual.getDato());
            actual = actual.getSiguiente();
            posicion++;
        }
    }

    public int getTamano() {
        return tamano;
    }

}
