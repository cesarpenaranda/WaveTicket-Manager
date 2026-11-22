public class Main {

    public static void main(String[] args) {
        WaveticketManager sistema = new WaveticketManager();
        sistema.cargarDatos();
        Menu menu = new Menu(sistema);
        menu.menuPrincipal();
    }
}
