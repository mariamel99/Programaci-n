import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Flujo1 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        File fichero1 =   new File("./recursos/foo2.txt");
        File fichiro2= new File("./recursos/foo.txt");
        int eleccion;
        do{
           menu();
           eleccion= scan.nextInt();

        }while ()

       // lecturaFichero(fichero1);
        System.out.println();
       // copiaFichero(fichero,fichiroCopia);
        añadirEnFichero(fichero1,fichiro2);



    }



    public static void lecturaFichero(File f) throws IOException{
        FileInputStream fichero = new FileInputStream(f);
        int lectura = fichero.read();
        while (lectura != -1){
            System.out.print((char)lectura);
            lectura = fichero.read();
        }
        fichero.close();
    }
    public static void copiaFichero(File f1, File f2) throws IOException{
        FileInputStream ficheroOriginal =   new FileInputStream(f1);
        FileOutputStream ficheroCopia = new FileOutputStream(f2);
        int cantidad =  ficheroOriginal.available();
        int lectura = ficheroOriginal.read();
        while (lectura != -1){
            ficheroCopia.write(lectura);
            lectura = ficheroOriginal.read();
        }
        System.out.println("La cantidad de caracteres copiados es: "+cantidad);
        ficheroOriginal.close();
        ficheroCopia.close();

    }
    public static void  añadirEnFichero(File f1,File f2)throws IOException {

        FileInputStream ficheroOriginal = new FileInputStream(f1);
        FileOutputStream ficheroCambiado = new FileOutputStream(f2, true);
        int lectura = ficheroOriginal.read();
        ficheroCambiado.write("\n".getBytes());
        while (lectura != -1) {
            ficheroCambiado.write((lectura));
            lectura = ficheroOriginal.read();
        }

    }
    public static void menu(){
        System.out.println("Elige una opción (1,2,3) si queres salir del menu elige 0:");
        System.out.println("Opción 1: Lectura del fichero:\nOpción 2: Copia del contenido de fichero a otro:\nOpción 3: Añadir el contenido de un fichero al primer fichero:");
    }
}


