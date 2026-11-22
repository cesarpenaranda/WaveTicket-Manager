
public class Concierto {

    private String codigo;
    private String nombre;
    private String fecha;
    private Artista artista;
    private String lugar;
    private int filas;
    private int columnas;
    private String estado;
    private double costo;
    private char[][] asientos;

    public Concierto(String codigo, String nombre, String fecha, Artista artista, int filas, int columnas, String estado, double costo, String lugar) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.artista = artista;
        this.filas = filas;
        this.columnas = columnas;
        this.lugar = lugar;
        this.estado = estado;
        this.costo = costo;
        this.asientos = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.asientos[i][j] = '_';
            }
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public Artista getArtista() {
        return artista;
    }

    public int getColumnas() {
        return columnas;
    }

    public String getEstado() {
        return estado;
    }

    public double getCosto() {
        return costo;
    }

    public char[][] getAsientos() {
        return asientos;
    }

    public String getLugar() {
        return lugar;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getFilas() {
        return filas;
    }

    public void mostrarAsientos() {
        System.out.println("Asientos del concierto " + nombre + " (" + contarDisponibles() + "/" + getCapacidad() + " disponibles):");
        System.out.print("    ");
        for (int j = 0; j < columnas; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < filas; i++) {
            System.out.print((i + 1) + "   ");
            for (int j = 0; j < columnas; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int contarDisponibles() {
        int disponibles = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (asientos[i][j] == '_') {
                    disponibles++;
                }
            }
        }
        return disponibles;
    }

    public boolean estaLleno() {
        return contarDisponibles() == 0;
    }

    public boolean tieneVentas() {
        return contarDisponibles() < getCapacidad();
    }

    public int getCapacidad() {
        return filas * columnas;
    }

    public boolean asientoDisponible(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            return false;
        }
        return asientos[fila][columna] == '_';
    }

    public boolean venderAsiento(int fila, int columna) {
        if (asientoDisponible(fila, columna)) {
            asientos[fila][columna] = 'X';
            if (estaLleno()) {
                this.estado = "VENDIDO";
            }
            System.out.println("Asiento vendido: Fila " + (fila + 1) + ", Columna " + (columna + 1));
            return true;
        } else {
            System.out.println("Asiento no disponible: Fila " + (fila + 1) + ", Columna " + (columna + 1));
            return false;
        }
    }

    public boolean asignarPrimerosLibres(int cantidad) {
        if (cantidad <= 0 || cantidad > contarDisponibles()) {
            System.out.println("No hay suficientes asientos disponibles para asignar " + cantidad + " asientos.");
            return false;
        }
        int asignados = 0;
        for (int i = 0; i < filas && asignados < cantidad; i++) {
            for (int j = 0; j < columnas && asignados < cantidad; j++) {
                if (asientoDisponible(i, j)) {
                    venderAsiento(i, j);
                    asignados++;
                }
            }
        }
        return true;
    }
}
