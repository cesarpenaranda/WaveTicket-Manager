
public class Main {

    public static void main(String[] args) {
        // ===== PRUEBA HASTA FASE 6 =====
        WaveticketManager sistema = new WaveticketManager();
        sistema.cargarDatos();

        System.out.println("\n=== ARTISTAS EN ORDEN DE RANKING ===");
        sistema.getArbolArtistas().mostrarEnOrden();

        System.out.println("\n=== CONCIERTOS ACTIVOS ===");
        sistema.getListaConciertos().mostrarConciertosActivos();

        System.out.println("\n=== PRUEBA ATENDER COLA C003 2x3 = 6 asientos ===");
        Concierto c3 = sistema.getListaConciertos().buscarPorCodigo("C003");
        sistema.atenderSiguiente(c3);
        sistema.atenderSiguiente(c3);
        sistema.atenderSiguiente(c3);
        sistema.atenderSiguiente(c3);
        sistema.atenderSiguiente(c3);
        c3.mostrarAsientos();

        System.out.println("\n=== PRUEBA REGLAS EN C005, C004, C002 ===");
        sistema.atenderSiguiente(sistema.getListaConciertos().buscarPorCodigo("C005"));
        sistema.atenderSiguiente(sistema.getListaConciertos().buscarPorCodigo("C004"));
        sistema.atenderSiguiente(sistema.getListaConciertos().buscarPorCodigo("C002"));
    }
}
