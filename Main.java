public class Main {

    public static void main(String[] args) {
        WaveticketManager sistema = new WaveticketManager();
        sistema.cargarDatos(); // carga automatica de txt al arrancar
        Menu menu = new Menu(sistema);
        menu.menuPrincipal();
    }
}
