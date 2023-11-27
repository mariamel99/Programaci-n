package Imagenes;
import java.io.File;
public class Mybmp {
    public static void main(String[] args) {
        File archivoBMP = new File("./recursos/penyagolosa.bmp");
        TransformaImagen transformador = new TransformaImagen(archivoBMP);
        transformador.procesarImagen();
    }
}
