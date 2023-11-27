import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Flujo1 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
      File f1;
      File f2;
      String fichero1;
      String fichero2;
        int eleccion;
        do{
           menu();
           eleccion= scan.nextInt();
            scan.nextLine();
           switch (eleccion){
               //Si quiere leer un fichero si exeste si no vuelve un mensage de error.
               case 1:
                   listaFicheros();
                   System.out.println("Elige el nombre(sin extencion) de un fichero para leer:");
                    fichero1 = scan.nextLine();
                   f1 =   new File("./recursos/"+fichero1+".txt");
                   if(f1.exists()){
                       lecturaFichero(f1);
                       break;
                   }
                   else{
                       System.out.println("fichero no existe !!");
                       break;
                   }
               case 2:
                   //Si quiere copiar un fichero en otro si exeste si no vuelve un mensage de error.
                   listaFicheros();
                   System.out.println("Elige el nombre (sin extencion) de dos fichero para primero es el copiar y el segundo para pegar:");
                    fichero1 = scan.nextLine();
                    fichero2 = scan.nextLine();
                   f1 =   new File("./recursos/"+fichero1+".txt");
                   f2 =   new File("./recursos/"+fichero2+".txt");
                   if(f1.exists() && f2.exists()){
                       copiaFichero(f1,f2);
                       lecturaFichero(f2);
                       System.out.println();
                       break;
                   }
                   else{
                       System.out.println("fichero no existe !!");
                       break;
                   }
               case 3:
                   //Si quiere añadir el contenido de un fichero a otro si exeste si no vuelve un mensage de error.
                   listaFicheros();
                   System.out.println("Elige el nombre (sin extencion) de dos fichero para añadir el contenido del primero al segundo:");
                    fichero1 = scan.nextLine();
                    fichero2 = scan.nextLine();
                   f1 =   new File("./recursos/"+fichero1+".txt");
                   f2 =   new File("./recursos/"+fichero2+".txt");
                   if(f1.exists() && f2.exists()){
                       añadirEnFichero(f1,f2);
                       lecturaFichero(f2);
                       System.out.println();
                       break;
                   }
                   else{
                       System.out.println("fichero no existe !!");
                       break;
                   }
           }

        }while (eleccion!=0);
        System.out.println("Programa terminado!");
    }


//Funcion void de lectura de un fichero.
    public static void lecturaFichero(File f) throws IOException{
        FileInputStream fichero = new FileInputStream(f);
        int lectura = fichero.read();
        while (lectura != -1){
            System.out.print((char)lectura);
            lectura = fichero.read();
        }
        fichero.close();
    }

    //Funcion void de copia de un fichero en otro.
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

    //Funcion void de añadir el contenido de un fichero a otro.
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
    //Funcion del nenu.
    public static void menu(){
        System.out.println("Elige una opción (1,2,3) para salir del menu elige 0:");
        System.out.println("Opción 1: Lectura de un fichero:\nOpción 2: Copia del contenido de fichero a otro:\nOpción 3: Añadir el contenido de un fichero al primer fichero:");
    }
    //Esta funcion vuelva la lista de ficheros que estan en la carpetq recursos.
    public static void listaFicheros(){
        File f = new File("./recursos");
        for (String e : f.list()){
            System.out.println(e);
        }
    }
}


