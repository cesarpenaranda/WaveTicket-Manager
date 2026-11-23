import java.util.Scanner;

public class Menu {

    private WaveticketManager sistema;
    private Scanner sc;

    public Menu(WaveticketManager sistema) {
        this.sistema = sistema;
        this.sc = new Scanner(System.in);
    }

    public Menu() {
        this.sistema = new WaveticketManager();
        this.sistema.cargarDatos();
        this.sc = new Scanner(System.in);
    }

    public void menuPrincipal() {
        int opcion = 0;
        // El ciclo termina por condicion cuando el usuario elige 3
        while (opcion != 3) {
            System.out.println("\n--- Waveticket Manager ---");
            System.out.println("1. Ingreso de Administrador");
            System.out.println("2. Ingreso de Clientes");
            System.out.println("3. Cerrar el Sistema");
            opcion = sistema.leerEntero(sc, "opcion: ");

            if (opcion == 1) {
                menuAdministrador();
            } else if (opcion == 2) {
                menuCliente();
            } else if (opcion == 3) {
                System.out.println("cerrando el sistema...");
            } else {
                System.out.println("opcion invalida, intente de nuevo");
            }
        }
    }

    public void menuCliente() {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\n--- Menu Cliente ---");
            System.out.println("1. Ver conciertos disponibles");
            System.out.println("2. Buscar concierto de un artista");
            System.out.println("3. Ver asientos de un concierto");
            System.out.println("4. Comprar entradas");
            System.out.println("5. Salir");
            opcion = sistema.leerEntero(sc, "opcion: ");

            if (opcion == 1) {
                sistema.getListaConciertos().mostrarConciertosActivos();
            } else if (opcion == 2) {
                System.out.print("nombre o id del artista (Ej: Coldplay o A001): ");
                String criterio = sc.nextLine().trim();
                sistema.getListaConciertos().buscarPorArtista(criterio);
            } else if (opcion == 3) {
                System.out.print("codigo del concierto (Ej: C001): ");
                String codigoConcierto = sc.nextLine().trim();
                Concierto concierto = sistema.getListaConciertos().buscarPorCodigo(codigoConcierto);
                if (concierto != null) {
                    concierto.mostrarAsientos();
                } else {
                    System.out.println("concierto no encontrado");
                }
            } else if (opcion == 4) {
                sistema.comprarEntradas(sc);
            } else if (opcion == 5) {
                System.out.println("volviendo al menu principal...");
            } else {
                System.out.println("opcion invalida, intente de nuevo");
            }
        }
    }

    public void menuAdministrador() {
        int opcion = 0;
        while (opcion != 9) {
            System.out.println("\n--- Menu Administrador ---");
            System.out.println("1. Registrar artista");
            System.out.println("2. Buscar artista");
            System.out.println("3. Mostrar artistas en el orden del ranking");
            System.out.println("4. Registrar concierto");
            System.out.println("5. Cancelar concierto");
            System.out.println("6. Eliminar concierto");
            System.out.println("7. Mostrar todos los conciertos");
            System.out.println("8. Ver cola de clientes para compra de tiquetes");
            System.out.println("9. Salir");
            opcion = sistema.leerEntero(sc, "opcion: ");

            if (opcion == 1) {
                registrarArtista();
            } else if (opcion == 2) {
                buscarArtista();
            } else if (opcion == 3) {
                sistema.getArbolArtistas().mostrarEnOrden();
            } else if (opcion == 4) {
                registrarConcierto();
            } else if (opcion == 5) {
                System.out.print("codigo del concierto a cancelar (Ej: C001): ");
                String codigo = sc.nextLine().trim();
                System.out.println(sistema.getListaConciertos().cancelarConcierto(codigo));
            } else if (opcion == 6) {
                System.out.print("codigo del concierto a eliminar (Ej: C001): ");
                String codigo = sc.nextLine().trim();
                sistema.getListaConciertos().eliminarConcierto(codigo);
            } else if (opcion == 7) {
                sistema.getListaConciertos().mostrarTodosLosConciertos();
            } else if (opcion == 8) {
                sistema.getColaClientes().mostrarCola();
            } else if (opcion == 9) {
                System.out.println("volviendo al menu principal...");
            } else {
                System.out.println("opcion invalida, intente de nuevo");
            }
        }
    }

    private void registrarArtista() {
        System.out.print("id del artista (Ej: A013): ");
        String id = sc.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("el id no puede quedar vacio");
            return;
        }
        if (sistema.getArbolArtistas().existeId(id)) {
            System.out.println("ya existe un artista con ese id");
            return;
        }
        String nombre = sistema.leerTexto(sc, "nombre del artista (Ej: Soda Stereo): ");
        String genero = sistema.leerTexto(sc, "genero musical (Ej: Rock): ");
        int ranking = sistema.leerEntero(sc, "posicion en el ranking (Ej: 13): ");
        if (ranking <= 0) {
            System.out.println("el ranking debe ser mayor a 0");
            return;
        }
        Artista nuevo = new Artista(id, nombre, genero, ranking);
        sistema.getArbolArtistas().insertar(nuevo);
        System.out.println("artista registrado: " + nuevo);
    }

    private void buscarArtista() {
        System.out.print("id del artista a buscar (Ej: A001): ");
        String id = sc.nextLine().trim();
        Artista a = sistema.getArbolArtistas().buscarPorId(id);
        if (a != null) {
            System.out.println(a);
        } else {
            System.out.println("artista no encontrado");
        }
    }

    private void registrarConcierto() {
        System.out.print("codigo del concierto (Ej: C007): ");
        String codigo = sc.nextLine().trim();
        if (codigo.isEmpty()) {
            System.out.println("el codigo no puede quedar vacio");
            return;
        }
        if (sistema.getListaConciertos().buscarPorCodigo(codigo) != null) {
            System.out.println("ya existe un concierto con ese codigo");
            return;
        }
        System.out.print("id del artista principal (Ej: A001): ");
        String idArtista = sc.nextLine().trim();
        Artista artista = sistema.getArbolArtistas().buscarPorId(idArtista);
        if (artista == null) {
            System.out.println("no existe un artista con ese id, registrelo primero");
            return;
        }
        String nombre = sistema.leerTexto(sc, "nombre del evento (Ej: Gira 2027): ");
        String fecha = sistema.leerTexto(sc, "fecha (Ej: 25/07/2027): ");
        String lugar = sistema.leerTexto(sc, "lugar (Ej: Estadio Nacional): ");
        int filas = sistema.leerEntero(sc, "cantidad de filas de asientos (Ej: 5): ");
        int columnas = sistema.leerEntero(sc, "cantidad de columnas de asientos (Ej: 8): ");
        if (filas <= 0 || columnas <= 0) {
            System.out.println("filas y columnas deben ser mayores a 0");
            return;
        }
        double costo = leerDouble("costo de la entrada (Ej: 35000): ");
        if (costo < 0) {
            System.out.println("el costo no puede ser negativo");
            return;
        }
        int tipoEstado = sistema.leerEntero(sc, "estado inicial (1. ACTIVO, 2. EN_PLANEACION): ");
        while (tipoEstado != 1 && tipoEstado != 2) {
            System.out.println("opcion invalida, elija 1 o 2");
            tipoEstado = sistema.leerEntero(sc, "estado inicial (1. ACTIVO, 2. EN_PLANEACION): ");
        }
        String estado = "ACTIVO";
        if (tipoEstado == 2) {
            estado = "EN_PLANEACION";
        }
        Concierto nuevo = new Concierto(codigo, nombre, fecha, artista, filas, columnas, estado, costo, lugar);
        sistema.getListaConciertos().agregarConcierto(nuevo);
    }

    private double leerDouble(String mensaje) {
        boolean valido = false;
        double numero = 0;
        while (!valido) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                numero = Double.parseDouble(entrada);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("numero invalido, intente de nuevo");
            }
        }
        return numero;
    }
}
