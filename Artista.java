public class Artista {
    int id;
    String nombre;
    String genero;
    int ranking;

public Artista(int id, String nombre, String genero, int ranking) {
    this.id = id;
    this.nombre = nombre;
    this.genero = genero;
    this.ranking = ranking;
}

public int getId() {
    return id;
}

public void setId(int id) {
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
}