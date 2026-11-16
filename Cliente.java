public class Cliente {
    int numero;
    int cedula;
    string nombre;
    int telefono;
    string codigoConcierto;
    int cantidadEntradas;

public Cliente(int numero, int cedula, string nombre, int telefono, string codigoConcierto, int cantidadEntradas) {
        this.numero = numero;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.codigoConcierto = codigoConcierto;
        this.cantidadEntradas = cantidadEntradas;
    }

public int getNumero() {
        return numero;
    }

public void setNumero(int numero) {
        this.numero = numero;
    }

public int getCedula() {
        return cedula;
    }

public void setCedula(int cedula) {
        this.cedula = cedula;
    }

public String getNombre() {
        return nombre;
    }

public void setNombre(String nombre) {
        this.nombre = nombre;
    }

public int getTelefono() {
        return telefono;
    }

public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

public String getCodigoConcierto() {
        return codigoConcierto;
    }

public void setCodigoConcierto(String codigoConcierto) {
        this.codigoConcierto = codigoConcierto;
    }

public int getCantidadEntradas() {
        return cantidadEntradas;
    }

public void setCantidadEntradas(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }
}


