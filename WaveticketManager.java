
import java.util.Random;
import java.util.Scanner;

public class WaveticketManager {

    private ArbolArtistas arbolArtistas;
    private ListaConciertos listaConciertos;
    private Cliente[] fans;
    private Random random;

    public WaveticketManager() {
        arbolArtistas = new ArbolArtistas();
        listaConciertos = new ListaConciertos();
        fans = new Cliente[0];
        random = new Random();
    }

    public void cargarDatos() {
        CargadorArchivos.cargarArtistas(arbolArtistas, "artistas.txt");
        CargadorArchivos.cargarConciertos(listaConciertos, arbolArtistas, "conciertos.txt");
        fans = CargadorArchivos.cargarFans("fans.txt");
        CargadorArchivos.repartirFansEnColas(fans, listaConciertos);
    }

    public ArbolArtistas getArbolArtistas() {
        return arbolArtistas;
    }

    public ListaConciertos getListaConciertos() {
        return listaConciertos;
    }

    public Cliente[] getFans() {
        return fans;
    }

    public int leerEntero(Scanner sc, String mensaje) {
        boolean valido = false;
        int numero = 0;
        while (!valido) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                numero = Integer.parseInt(entrada);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("numero invalido, intente de nuevo");
            }
        }
        return numero;
    }

    public void atenderSiguiente(Concierto c) {
        if (c == null) {
            System.out.println("concierto no encontrado");
            return;
        }
        if (c.getColaClientes().estaVacia()) {
            System.out.println("no hay clientes en la cola de " + c.getNombre());
            return;
        }
        Cliente clienteAtendido = c.getColaClientes().desencolar();
        System.out.println("atendiendo a: " + clienteAtendido.getNombre() + " (ced: " + clienteAtendido.getCedula() + ")");
        if (c.getEstado().equalsIgnoreCase("CANCELADO")) {
            System.out.println("el concierto " + c.getNombre() + " esta cancelado, no se venden entradas");
            return;
        }
        if (c.getEstado().equalsIgnoreCase("VENDIDO")) {
            System.out.println("el concierto " + c.getNombre() + " ya esta lleno");
            return;
        }
        if (!c.getEstado().equalsIgnoreCase("ACTIVO")) {
            System.out.println("el concierto " + c.getNombre() + " no esta activo todavia");
            return;
        }
        int cantidad = clienteAtendido.getCantidadEntradas();
        if (cantidad > c.contarDisponibles()) {
            System.out.println("no hay espacio suficiente para " + cantidad + " entradas (" + clienteAtendido.getNombre() + ")");
            return;
        }
        if (c.asignarPrimerosLibres(cantidad)) {
            double montoTotal = c.getCosto() * cantidad;
            System.out.println("vendidas " + cantidad + " entradas para " + c.getNombre()
                    + " a " + clienteAtendido.getNombre() + " | total: " + montoTotal);
        } else {
            System.out.println("no se pudieron vender las entradas a " + clienteAtendido.getNombre());
        }
    }

    public void comprarEntradas(Scanner sc) {
        listaConciertos.mostrarConciertosActivos();
        System.out.print("codigo del concierto: ");
        String codigo = sc.nextLine().trim();

        Concierto c = listaConciertos.buscarPorCodigo(codigo);
        if (c == null) {
            System.out.println("no existe ningun concierto con codigo " + codigo);
            return;
        }
        if (!c.getEstado().equalsIgnoreCase("ACTIVO")) {
            System.out.println("ese concierto no esta disponible (" + c.getEstado() + ")");
            return;
        }

        int antes = random.nextInt(4);
        if (antes > 0) {
            System.out.println("hay " + antes + " personas antes que usted en la fila");
            for (int i = 0; i < antes && !c.getColaClientes().estaVacia(); i++) {
                atenderSiguiente(c);
            }
        } else {
            System.out.println("no hay nadie antes que usted, pasa directo");
        }

        if (!c.getEstado().equalsIgnoreCase("ACTIVO")) {
            System.out.println("el concierto ya no tiene espacio o cambio de estado (" + c.getEstado() + ")");
            return;
        }

        int cedula = leerEntero(sc, "cedula: ");
        System.out.print("nombre completo: ");
        String nombre = sc.nextLine().trim();
        int telefono = leerEntero(sc, "telefono: ");

        c.mostrarAsientos();
        int disponibles = c.contarDisponibles();
        int cantidad = leerEntero(sc, "cuantas entradas quiere? (disponibles " + disponibles + "): ");
        if (cantidad <= 0 || cantidad > disponibles) {
            System.out.println("cantidad invalida o no alcanzan los asientos");
            return;
        }

        Cliente comprador = new Cliente(0, cedula, nombre, telefono, c.getCodigo(), cantidad);

        int vendidos = 0;
        while (vendidos < cantidad) {
            System.out.println("asiento " + (vendidos + 1) + " de " + cantidad);
            int fila = leerEntero(sc, "  fila (1-" + c.getFilas() + "): ");
            int col = leerEntero(sc, "  columna (1-" + c.getColumnas() + "): ");
            if (c.venderAsiento(fila - 1, col - 1)) {
                vendidos++;
            } else {
                System.out.println("ese asiento esta ocupado o no existe, pruebe otro");
            }
        }

        double montoTotal = cantidad * c.getCosto();
        System.out.println("compra lista! " + comprador.getNombre() + " - "
                + cantidad + " entradas para " + c.getNombre() + " | total a pagar: " + montoTotal);
        c.mostrarAsientos();
    }
}
