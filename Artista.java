
public class Artista {

    private String id;
    private String nombre;
    private String genero;
    private int ranking;

    public Artista(String id, String nombre, String genero, int ranking) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.ranking = ranking;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " | " + genero + " | Ranking: " + ranking;
    }
}
