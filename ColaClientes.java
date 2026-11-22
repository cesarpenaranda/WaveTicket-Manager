
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
       NodoCliente nuevoNodo = new NodoCliente(cliente);
       if (cliente == null) {
            return;
        }
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
            System.out.println("La cola está vacía.");
            return;
        }
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
       }
       public int getTamano() {
        return tamano;
}
}

