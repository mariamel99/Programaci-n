package Imagenes;
import java.io.File;
public class Mybmp {
    /** //El argumento 0 para el archivo de entrada.
     * //El argumento 1 para la acción utilizada.
     * @param args
     */
    public static void main(String[] args) {

        File archivoBMP = new File(args[0]);
        TransformaImagen transformador = new TransformaImagen(archivoBMP);

        if(args[1].equals("Negativo")) {
            System.out.println("Ejecutar la acción de "+args[1]);
            transformador.transformaNegativo();
        } else if (args[1].equals("Oscuro")) {
            System.out.println("Ejecutar la acción de "+args[1]);
            transformador.transformaOscuro();
        }else {
            if (args[1].equals("Blanco_Negro")) {
                System.out.println("Ejecutar la acción de "+args[1]);
                transformador.transformaBlancoNegro();
            } else {
                System.out.println("Argumento no existe");
            }
        }


    }
}
