package Imagenes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class TransformaImagen {
    File f;
    public TransformaImagen(File fEnt) {
        // Control de existencia del fichero y control de la extensión .bmp (sacar
        // mensajes de error)
        if (fEnt.exists() && fEnt.isFile() && fEnt.getName().toLowerCase().endsWith(".bmp")) {
            this.f = fEnt;
        }
        else {
            System.out.println("Error: Archivo no válido o extensión incorrecta.");
        }

    }
    public void procesarImagen() {
        if (f != null) {
            try (FileInputStream fis = new FileInputStream(f)) {
                // Leer y procesar los primeros 54 bytes para obtener información diversa
                byte[] buffer = new byte[54];
                fis.read(buffer);

                // Aquí puedes realizar acciones con la información obtenida del encabezado (header)

                // Resto del código para procesar los bytes de la imagen (R, G, B)
                // ...

                System.out.println("Imagen procesada exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al procesar la imagen: " + e.getMessage());
            }
        } else {
            System.out.println("Error: El archivo no ha sido inicializado correctamente.");
        }
    }
    public void transformaNegativo() throws IOException {
        // Transformar a negativo y guardar como *_n.bmp
    }
    public void transformaOscuro() throws IOException {
        // Transformar a una imagen más oscura y guardar como *_o.bmp

    }

    public void transformaBlancoNegro() throws IOException {
        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp
    }
    private String getNombreSinExtension() {
        //Devuelve el nombre del archivo f sin extensión
        return "";
    }

}
