
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CargadorArchivos {

    public static void cargarArtistas(ArbolArtistas arbol, String rutaArchivo) {
        try {
            Scanner scanner = new Scanner(new File(rutaArchivo));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (!linea.isEmpty()) {
                    String[] datos = linea.split(";");
                    if (datos.length == 4) {
                        try {
                            String id = datos[0].trim();
                            String nombre = datos[1].trim();
                            String genero = datos[2].trim();
                            int ranking = Integer.parseInt(datos[3].trim());

                            if (arbol.buscarPorId(id) != null) {
                                System.out.println("El artista con ID " + id + " ya existe.");
                            } else {
                                Artista artista = new Artista(id, nombre, genero, ranking);
                                arbol.insertar(artista);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Ranking invalido en linea: " + linea);
                        }
                    } else {
                        System.out.println("Linea incorrecta: " + linea);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }
}
