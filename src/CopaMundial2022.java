import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CopaMundial2022 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
         ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugador1= new Jugador(3,"Holland","Remko Pasveer",1983,1.88f,"Ajax (HOL)");
        Jugador jugador2= new Jugador(3,"Holland","Justin Bijlow",1998,1.88f,"Feyenoord (HOL)");
        Jugador jugador3= new Jugador(3,"Holland","Andries Noppert",1994,2.03f,"SC Heerenveen (HOL)");
        Jugador jugador4= new Jugador(3,"Holland","Jirrïen Timber",2001,1.79f,"Ajax (HOL)");
        Jugador jugador5= new Jugador(3,"Holland","Matthijs De Ligt",1999,1.87f,"Bayern Munich (GER)");
        Jugador jugador6= new Jugador(3,"Holland","Virgil Van Dijk",1991,1.95f,"Liverpool (ENG)");
        Jugador jugador7= new Jugador(3,"Holland","Nathan Aké",1995,1.80f,"Manchester City (ENG)");
        Jugador jugador8= new Jugador(3,"Holland","Stefan de Vrij",1992,1.90f,"Inter (ITA)");
        Jugador jugador9= new Jugador(3,"Holland","Tyrell Blind",1999,1.70f,"Manchester United (ENG)");
        Jugador jugador10= new Jugador(3,"Holland","Denzel Dumfries",1990,1.80f,"Ajax (HOL)");
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);
        jugadores.add(jugador4);
        jugadores.add(jugador5);
        jugadores.add(jugador6);
        jugadores.add(jugador7);
        jugadores.add(jugador8);
        jugadores.add(jugador9);
        jugadores.add(jugador10);

        //listaJugadores(jugadores);
       guardarLista(jugadores);
        System.out.println("Introduce el nombre del archivo");
        String nombreArch = scan.nextLine();
        leerListaJugadores(nombreArch);

       /* boolean menu= true;
        System.out.println("Las selecciones del copa mundial 2022:");
        do {
            menuJugadores();
            int opcion1 = scan.nextInt();
            switch (opcion1){
                case 1:
                    do{
                        menuCambios();
                        int opcion2 = scan.nextInt();
                        switch (opcion2){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                menu = false;
                                break;
                            default:
                                System.out.println("opción no válida !!");
                        }


                    }while (menu);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Fin del Programa");
                    return;
                default:
                    System.out.println("opción no válida !!");
            }
        }while (true);*/

    }
    public static void listaJugadores(ArrayList<Jugador> jugadores){
        for (int i = 0; i < 3; i++){
            System.out.println("Informaciones del jugador " + (i + 1) + ":");
            System.out.println("Introduce su nombre:");
            String nombre = scan.nextLine();
            System.out.println("introduce su año de nacimiento:");
            int año = scan.nextInt();
            System.out.println("Introduce su Altura:");
            float altura = scan.nextFloat();
            scan.nextLine();
            System.out.println("Introduce su club de procedencia ");
            String club = scan.nextLine();
            Jugador jugador = new Jugador(3, "Holland", nombre, año, altura, club);
            jugadores.add(jugador);
        }
    }

    public static void guardarLista(ArrayList<Jugador> jugadores){
       try {
           DataOutputStream flujoSalida = new DataOutputStream(new FileOutputStream("./recursos/Seleccion2022.dat"));
          for(int i=0;i<jugadores.size();i++){
              flujoSalida.writeInt(jugadores.get(i).getCodPais());
              flujoSalida.writeUTF(jugadores.get(i).getNombrePais());
              flujoSalida.writeUTF(jugadores.get(i).getNombreJugador());
              flujoSalida.writeInt(jugadores.get(i).getAnoNacimiento());
              flujoSalida.writeFloat(jugadores.get(i).getAltura());
              flujoSalida.writeUTF(jugadores.get(i).getClubProcedencia());
          }
       }catch (IOException e){
           System.out.println(e.getMessage());
       }
    }
    public static void leerListaJugadores(String nombreArchivo){

        try{
            DataInputStream flujoEntrada = new DataInputStream( new FileInputStream(nombreArchivo));
            ArrayList<Jugador> array = new ArrayList<>();
            while (flujoEntrada.available()>0) {

               System.out.printf("código de país: %d\tPaís: %s\tnombre: %s\t\t\tAño de nacimiento %d\tAltuta %.2f\tClub de procedencia: %s", flujoEntrada.readInt(),
                       flujoEntrada.readUTF(),flujoEntrada.readUTF(), flujoEntrada.readInt(), flujoEntrada.readFloat(), flujoEntrada.readUTF());
              System.out.println();
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void menuJugadores(){
        System.out.println("1. Abrir la lista de la selección Holandesa");
        System.out.println("2. leer la selección de compañero");
        System.out.println("3. Salir del Programa.");
        System.out.println("Elige una opción:");
    }
    public static void menuCambios(){
        System.out.println("1. Insertar un jugador");
        System.out.println("2. Eliminar un jugador");
        System.out.println("3. Guardar los cambios en el archivo");
        System.out.println("Volver a la entrada");
        System.out.println("Elige una opción:");
    }




}
