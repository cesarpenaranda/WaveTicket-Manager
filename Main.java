public class Main {

    public static void main(String[] args) {
        // ===== PRUEBA FASE 0: clases Artista y Cliente =====
        Artista a = new Artista("A001", "Coldplay", "Rock alternativo", 7);
        System.out.println(a);

        Cliente c = new Cliente(1, 114560789, "Ana Rodriguez", 88112233, "C001", 2);
        System.out.println(c);
    }
}
