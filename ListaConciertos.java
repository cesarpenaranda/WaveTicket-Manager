
public class ListaConciertos {

    private NodoConcierto cabeza;
    private NodoConcierto cola;

    public ListaConciertos() {
        this.cabeza = null;
        this.cola = null;
    }

    public Concierto buscarPorCodigo(String codigo) {
        NodoConcierto actual = cabeza;
        while (actual != null) {
            if (actual.getConcierto().getCodigo().equals(codigo)) {
                return actual.getConcierto();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean agregarConcierto(Concierto concierto) {
        if (concierto == null || concierto.getArtista() == null) {
            System.out.println("No se puede registrar un concierto sin un artista asociado.");
            return false;
        }
        NodoConcierto nuevoNodo = new NodoConcierto(concierto);
        if (buscarPorCodigo(concierto.getCodigo()) != null) {
            System.out.println("El concierto con código " + concierto.getCodigo() + " ya existe.");
            return false;
        }
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(cola);
            cola = nuevoNodo;
        }
        System.out.println("Concierto agregado: " + concierto.getNombre());
        return true;
    }

    public void mostrarTodosLosConciertos() {
        if (cabeza == null) {
            System.out.println("No hay conciertos disponibles.");
            return;
        }
        NodoConcierto actual = cabeza;
        System.out.println("Lista de Conciertos:");
        while (actual != null) {
            Concierto concierto = actual.getConcierto();
            System.out.println("Código: " + concierto.getCodigo() + ", Nombre: " + concierto.getNombre() + ", Fecha: " + concierto.getFecha() + ", Artista: " + concierto.getArtista().getNombre() + ", Lugar: " + concierto.getLugar() + ", Estado: " + concierto.getEstado() + ", Costo: " + concierto.getCosto());
            actual = actual.getSiguiente();
        }
    }

    public void mostrarConciertosActivos() {
        boolean hayActivos = false;
        if (cabeza == null) {
            System.out.println("No hay conciertos disponibles.");
            return;
        }
        NodoConcierto actual = cabeza;
        System.out.println("Lista de Conciertos Activos:");
        while (actual != null) {
            Concierto concierto = actual.getConcierto();
            if (concierto.getEstado().equalsIgnoreCase("Activo")) {
                System.out.println("Código: " + concierto.getCodigo() + ", Nombre: " + concierto.getNombre() + ", Fecha: " + concierto.getFecha() + ", Artista: " + concierto.getArtista().getNombre() + ", Lugar: " + concierto.getLugar() + ", Estado: " + concierto.getEstado() + ", Costo: " + concierto.getCosto());
                hayActivos = true;
            }
            actual = actual.getSiguiente();
        }
        if (!hayActivos) {
            System.out.println("No hay conciertos activos.");
        }
    }

    public void buscarPorArtista(String nombreArtista) {
        if (cabeza == null) {
            System.out.println("No hay conciertos disponibles.");
            return;
        }
        NodoConcierto actual = cabeza;
        boolean encontrado = false;
        System.out.println("Conciertos del Artista: " + nombreArtista);
        while (actual != null) {
            Concierto concierto = actual.getConcierto();
            if (concierto.getArtista().getNombre().equalsIgnoreCase(nombreArtista)) {
                System.out.println("Código: " + concierto.getCodigo() + ", Nombre: " + concierto.getNombre() + ", Fecha: " + concierto.getFecha() + ", Lugar: " + concierto.getLugar() + ", Estado: " + concierto.getEstado() + ", Costo: " + concierto.getCosto());
                encontrado = true;
            }
            actual = actual.getSiguiente();
        }
        if (!encontrado) {
            System.out.println("No se encontraron conciertos para el artista especificado.");
        }
    }

    public void eliminarConcierto(String codigo) {
        if (cabeza == null) {
            System.out.println("No hay conciertos disponibles.");
            return;
        }
        NodoConcierto actual = cabeza;
        while (actual != null) {
            if (actual.getConcierto().getCodigo().equals(codigo)) {
                if (actual == cabeza) {
                    cabeza = actual.getSiguiente();
                    if (cabeza != null) {
                        cabeza.setAnterior(null);
                    } else {
                        cola = null; // La lista quedó vacía
                    }
                } else if (actual == cola) {
                    cola = actual.getAnterior();
                    if (cola != null) {
                        cola.setSiguiente(null);
                    } else {
                        cabeza = null; // La lista quedó vacía
                    }
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                System.out.println("Concierto eliminado: " + actual.getConcierto().getNombre());
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Concierto no encontrado.");
    }

    public String cancelarConcierto(String codigo) {
        if (cabeza == null) {
            return "No hay conciertos disponibles.";
        }
        NodoConcierto actual = cabeza;
        while (actual != null) {
            if (actual.getConcierto().getCodigo().equals(codigo)) {
                if (actual.getConcierto().tieneVentas()) {
                    return "No se puede cancelar el concierto, ya tiene ventas registradas.";
                }
                actual.getConcierto().setEstado("CANCELADO");
                return "Concierto cancelado: " + actual.getConcierto().getNombre();
            }
            actual = actual.getSiguiente();
        }
        return "Concierto no encontrado.";
    }
    
}
