
public class Main {

    public static void main(String[] args) {
        // ===== PRUEBA FASE 0: clases Artista y Cliente =====
        Artista a = new Artista("A001", "Coldplay", "Rock alternativo", 7);
        System.out.println(a);

        Cliente c = new Cliente(1, 114560789, "Ana Rodriguez", 88112233, "C001", 2);
        System.out.println(c);
        // ===== PRUEBA FASE 1 =====
        ArbolArtistas arbol = new ArbolArtistas();
        arbol.insertar(new Artista("A001", "Coldplay", "Rock alternativo", 7));
        arbol.insertar(new Artista("A002", "Bad Bunny", "Reggaeton", 3));
        arbol.insertar(new Artista("A003", "Metallica", "Metal", 10));
        arbol.insertar(new Artista("A004", "Taylor Swift", "Pop", 1));
        arbol.insertar(new Artista("A005", "Karol G", "Reggaeton", 5));
        arbol.mostrarEnOrden();
        // ===== PROBAR buscarPorId =====
        System.out.println("Artista con ID A001: " + arbol.buscarPorId("A001"));
        System.out.println("Artista con ID A002: " + arbol.buscarPorId("A002"));
        System.out.println("Artista con ID A003: " + arbol.buscarPorId("A003"));
        System.out.println("Artista con ID A004: " + arbol.buscarPorId("A004"));
        System.out.println("Artista con ID A005: " + arbol.buscarPorId("A005"));
        System.out.println("Existe A001? " + arbol.existeId("A001"));
        System.out.println("Existe A006? " + arbol.existeId("A006"));
        // ===== PRUEBA FASE 2 =====
        ArbolArtistas arbol2ArbolArtistas = new ArbolArtistas();
        CargadorArchivos.cargarArtistas(arbol2ArbolArtistas, "artistas.txt");
        arbol2ArbolArtistas.mostrarEnOrden();
        // ===== PRUEBA FASE 3 =====
        Artista malpais = new Artista("A006", "Malpais", "Rock", 9);
        Concierto concierto1= new Concierto("C003", "Noche de Rock Tico", "10/01/2027", malpais, 2, 3, "ACTIVO", 15000, "Teatro Melico Salazar");concierto1.mostrarAsientos();
        System.out.println("Vender (0,1): " + concierto1.venderAsiento(0, 1));   
        System.out.println("Vender (0,1) otra vez: " + concierto1.venderAsiento(0, 1));
        System.out.println("Asignar 4: " + concierto1.asignarPrimerosLibres(4)); 
        concierto1.mostrarAsientos();
        System.out.println("Disponibles: " + concierto1.contarDisponibles());   
        System.out.println("Asignar 2: " + concierto1.asignarPrimerosLibres(2)); 
        System.out.println("Asignar 1: " + concierto1.asignarPrimerosLibres(1)); 
        System.out.println("Lleno? " + concierto1.estaLleno() + " Estado: " + concierto1.getEstado()); 
    }
}
