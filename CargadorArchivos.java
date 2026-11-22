
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

    public static void cargarConciertos(ListaConciertos lista, ArbolArtistas arbol, String rutaArchivo) {
        try {
            Scanner scanner = new Scanner(new File(rutaArchivo));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (!linea.isEmpty()) {
                    String[] datos = linea.split(";");
                    if (datos.length == 9) {
                        try {
                            String codigo = datos[0].trim();
                            String nombre = datos[1].trim();
                            String fecha = datos[2].trim();
                            String lugar = datos[3].trim();
                            String idArtista = datos[4].trim();
                            int filas = Integer.parseInt(datos[5].trim());
                            int columnas = Integer.parseInt(datos[6].trim());
                            String estado = datos[7].trim();
                            double costo = Double.parseDouble(datos[8].trim());
                            Artista artista = arbol.buscarPorId(idArtista);
                            if (artista == null) {
                                System.out.println("Artista con ID " + idArtista + " no encontrado para el concierto: " + nombre);

                            } else {
                                Concierto concierto = new Concierto(codigo, nombre, fecha, artista, filas, columnas, estado, costo, lugar);
                                lista.agregarConcierto(concierto);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Datos invalidos en linea: " + linea);
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
