import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class EditorTexto {
   static boolean cambio = false;
   static Scanner scan = new Scanner(System.in);
   static File f;
   static ArrayList<String> lineas =  new ArrayList<>();
    public static void main(String[] args) {


        System.out.println("------Editor de texto-----");
        do {
            int opcionMenuEntrada =0;
            menuEntrada();
         try {
             System.out.print("Elige una opción: ");
              opcionMenuEntrada = scan.nextInt();
         }catch (Exception e){
             System.out.println("Entrada no válida, Introduce un número.");
         }
         switch (opcionMenuEntrada){
             case 1:
                 scan.nextLine();
                 abrirArchivo();
                 mostrarContenido();
                 boolean menu= true;
                 do {
                     menuEditor();
                     int opcionMenu=0;
                    try {
                        opcionMenu = scan.nextInt();
                    } catch (Exception e){
                         System.out.println("Entrada no válida, Introduce un número.");
                     }

                     switch (opcionMenu){
                         case 1:
                             scan.nextLine();
                             eliminarLinea();
                             mostrarContenido();
                             break;
                         case 2:
                             insertarLinea();
                             mostrarContenido();
                             break;
                         case 3:
                             guardarArchivo();
                             break;
                         case 4:
                             cerrarArchivo();
                             menu= false;
                         default:
                             System.out.println("Opción no válida !!");
                     }

                 }while (menu);
             case 2:
                 System.out.println("Fin del Programa.");
                 return;
             default:
                 System.out.println("Opción no válida !!");
         }




        }while (true);





    }
    public  static void menuEntrada(){
        System.out.println("\nMenú del Programa :");
        System.out.println("1. Abrir archivo.");
        System.out.println("2. Salir del programa.");

    }
    public static void menuEditor(){
        System.out.println("\nMenú de la Edición :");
        System.out.println("1. Eliminar línea");
        System.out.println("2. Insertar línea");
        System.out.println("3. Guardar archivo");
        System.out.println("4. Cerrar");
        System.out.print("Elige una opción: ");

    }
    //abrir un archivo atendiendo al nombre indicado por el usuario.
    public static void abrirArchivo(){
        try {
        System.out.print("Introduce el nombre del archivo a abrir:\t");
            String nombreArchivo = scan.nextLine();
            f = new File(nombreArchivo);
            if(f.isFile()&& f.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
                String linea;
                while ((linea = br.readLine()) != null && lineas.size() < 22) {// para cargar solo 22 líneas como máximo.
                    lineas.add(linea);
                }
            }
        }catch (IOException e){
            //en caso de si el programa no encontrara el archivo
            System.out.println("Error al abrir el archivo, Ententa introducir el nombre correcto.");
        }
    }
    //mostrar el contenido del archivo subrecargado en un ArrayList.
    private static void mostrarContenido() {
        System.out.println("el contenido del archivo:");
        for (int i = 0; i < lineas.size(); i++) {
            System.out.println((i + 1) + ":\t" + lineas.get(i));
        }
    }
    public   static void eliminarLinea(){
        System.out.print("Introduce el número de línea para eliminar:\t");
        try {
            int numeroLinea = scan.nextInt();
            scan.nextLine();
            if(numeroLinea>=1 && numeroLinea<= lineas.size()){

                lineas.remove(numeroLinea-1);
                System.out.println("Línea eliminada.");
                cambio= true;
            }
            else {
                System.out.println("número de la línea no válido");
            }

        }catch(Exception e){
            //en caso de numero nigativo o mayor que el size del array.
            System.out.println("Por favor, introduce un número de línea válido.");
        }

    }

    public static void insertarLinea(){

        System.out.print("Introduce el número de línea para insertar:\t");
        try {
            int numeroLinea = scan.nextInt();
            scan.nextLine();
            if(numeroLinea>=1 && numeroLinea<= lineas.size()){
                System.out.print("Introduce el contenido de la línea:\t")
                ;
                String linea = scan.nextLine();
                lineas.add(numeroLinea-1,linea);
                System.out.println("Línea insertada correctamente.");
                cambio= true;
            }
            else {
                System.out.println("número de la línea no válido");
            }

        }catch(Exception e){
                //en caso de numero nigativo o mayor que el size del array.
            System.out.println("Por favor, introduce un número de línea válido.");
    }
    }
    public static void guardarArchivo(){
        try {

            System.out.print("Introduce el nombre del archivo para guardar:\t");
            String nombreArchivo = scan.nextLine();
            scan.nextLine();
            BufferedWriter bw = null;
                if(nombreArchivo!= f.getName()) {
                     bw = new BufferedWriter(new FileWriter(nombreArchivo));
                    for (int i = 0; i < lineas.size(); i++) {
                        bw.write(lineas.get(i) + "\n");
                    }
                    System.out.println("archivo guardado con éxito.");
                    cambio = false;
                }
                bw.close();// carrar el buffer.

        }catch (IOException e){
            System.out.println("Error al guardar del archivo, Introduce el nombre correcto.");
        }
    }
    public static void cerrarArchivo(){
        if(cambio){
            System.out.println("Hay cambios en el archivo ¿Deseas guardarlos cambios antes de cerrar?");
            System.out.print("1. Sí | 2. No: ");
            int opcion = scan.nextInt();
            switch (opcion){
                case 1:

                    guardarArchivo();
                    System.out.println("Cerrar el archivo sin guardar.");
                    break;
                case 2:
                    System.out.println("guardar y cerrar el archivo.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        else{
            System.out.println("Archivo Cerrado.");

        }

    }

}
