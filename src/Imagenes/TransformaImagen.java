package Imagenes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class TransformaImagen {
    File f;
    byte[] cabecera = new byte[54];
    public TransformaImagen(File fEnt) {
        // Control de existencia del fichero y control de la extensión .bmp (sacar
        // mensajes de error)
        if (fEnt.exists() && fEnt.isFile() && fEnt.getName().toLowerCase().endsWith(".bmp")) {
            this.f = fEnt;
        } else {
            System.out.println("Error: Archivo no válido o extensión incorrecta.");
        }

    }

    public void transformaNegativo() {
        // Transformar a negativo y guardar como *_n.bmp
        try  {
            FileInputStream file = new FileInputStream(f);
            FileOutputStream file2 = new FileOutputStream("./recursos/" + getNombreSinExtension("_n") + ".bmp");
            file.read(cabecera);
            file2.write(cabecera);
            int lectura = file.read();
            while (lectura != -1) {
                file2.write(255 - lectura);
                lectura = file.read();

            }
            file.close();
            file2.close();

        } catch (IOException e) {
            System.out.println("Error al procesar la imagen: " + e.getMessage());
        }
    }

    public void transformaOscuro() {
        // Transformar a una imagen más oscura y guardar como *_o.bmp
        try  {
            FileInputStream file = new FileInputStream(f);
            FileOutputStream file3 = new FileOutputStream("./recursos/" + getNombreSinExtension("_o") + ".bmp");
            file.read(cabecera);
            file3.write(cabecera);
            int lectura = file.read();
            while (lectura != -1) {
                file3.write(lectura / 2);
                lectura = file.read();

            }
            file.close();
            file3.close();

        } catch (IOException e) {
            System.out.println("Error al procesar la imagen: " + e.getMessage());
        }
    }


    public void transformaBlancoNegro() {
        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp
        try {
            FileInputStream file = new FileInputStream(f);
            FileOutputStream file4 = new FileOutputStream("./recursos/" + getNombreSinExtension("_nb") + ".bmp");
            int R , G , B;
            file.read(cabecera);
            file4.write(cabecera);
            int lectura = file.read();
           while (lectura != -1) {
               R= lectura;
               G= file.read();
               B= file.read();
               int gris = (R+G+B)/3;
               file4.write(gris);
               file4.write(gris);
               file4.write(gris);
               lectura= file.read();
            }

        file.close();
        file4.close();
         }
        catch(IOException e) {
        System.out.println("Error al procesar la imagen: " + e.getMessage());
    }

}
    private String getNombreSinExtension(String n) {
        //Devuelve el nombre del archivo f sin extensión
        String nombreImagen = f.getName();
        nombreImagen = nombreImagen.substring(0,nombreImagen.indexOf('.'));
        return nombreImagen+n;
    }


}
