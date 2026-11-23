# WaveTicket Manager

Sistema de consola en Java para administrar artistas, conciertos y venta de entradas 

## Requisitos

- **Java JDK** 
- Un editor o IDE como **Visual Studio Code** (opcional, también se puede correr directo desde la terminal).
- Mantener los archivos `artistas.txt`, `conciertos.txt` y `fans.txt` en la misma carpeta desde donde se ejecuta el programa.

## Cómo compilar y ejecutar

1. Clonar o descargar el repositorio y abrir la terminal dentro de la carpeta del proyecto:
   ```bash
   cd "WaveTicket Manager"
   ```
2. Compilar todos los archivos `.java`:
   ```bash
   javac *.java
   ```
3. Ejecutar el programa:
   ```bash
   java Main
   ```

> Si estás en macOS y `javac` no aparece en la terminal, puedes usar la ruta de tu JDK o darle **Run** en `Main.java` desde VS Code.

## Cómo funciona

Al arrancar, el programa carga automáticamente los datos iniciales sin preguntar:
- `artistas.txt` -> se inserta en un **Árbol Binario de Búsqueda** ordenado por ranking.
- `conciertos.txt` -> se carga en una **Lista Doblemente Enlazada** (validando que el artista exista en el árbol).
- `fans.txt` -> se carga en un arreglo `Cliente[]` y se encola en una **Cola única (lista simple)** de clientes en espera.

Luego aparece el menú principal:

### Menú Administrador
1. Registrar artista (ID único y ranking).
2. Buscar artista por ID.
3. Mostrar artistas ordenados por ranking (recorrido in-orden).
4. Registrar concierto (código único y artista existente).
5. Cancelar concierto (solo si no tiene ventas).
6. Eliminar concierto.
7. Mostrar todos los conciertos.
8. Ver cola única de clientes en espera.
9. Salir al menú principal.

### Menú Cliente
1. Ver conciertos activos y cupos disponibles.
2. Buscar conciertos por nombre o ID de artista.
3. Ver mapa de asientos de un concierto (`_` libre, `X` ocupado).
4. Comprar entradas: simula de `0` a `3` personas delante en la cola única (atendiéndolas primero) y luego permite escoger fila y columna de cada asiento.
5. Salir al menú principal.

## Archivos principales

- `Main.java` / `Menu.java`: punto de entrada e interfaz de menús en consola.
- `WaveticketManager.java`: coordina el árbol, la lista de conciertos, la cola y las compras.
- `CargadorArchivos.java`: lectura y validación de los archivos `.txt`.
- `Artista.java`, `NodoArtista.java`, `ArbolArtistas.java`: entidad y ABB de artistas.
- `Concierto.java`, `NodoConcierto.java`, `ListaConciertos.java`: entidad (con matriz `char[][]`) y lista doble de conciertos.
- `Cliente.java`, `NodoCliente.java`, `ColaClientes.java`: entidad y cola FIFO de clientes.
- `artistas.txt`, `conciertos.txt`, `fans.txt`: datos iniciales de prueba (campos separados por `;`).
