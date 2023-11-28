package Imagenes;
import java.io.File;
import java.util.Scanner;

public class Mybmp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        File archivoBMP = new File("./recursos/penyagolosa.bmp");
        TransformaImagen transformador = new TransformaImagen(archivoBMP);
        transformador.transformaNegativo();
        transformador.transformaOscuro();
        transformador.transformaBlancoNegro();
    }
}
