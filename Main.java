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
        // ===== PROBAR buscarPorId =====
        System.out.println("Artista con ID A001: " + arbol.buscarPorId("A001"));
        System.out.println("Artista con ID A002: " + arbol.buscarPorId("A002"));
        System.out.println("Artista con ID A003: " + arbol.buscarPorId("A003"));
        System.out.println("Artista con ID A004: " + arbol.buscarPorId("A004"));
        System.out.println("Artista con ID A005: " + arbol.buscarPorId("A005"));        
        arbol.mostrarEnOrden();
    }
}
