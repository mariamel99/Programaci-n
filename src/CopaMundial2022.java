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





        boolean menu= true;
        System.out.println("Las selecciones del copa mundial 2022:");
        do {
            menuJugadores();
            int opcion1 = scan.nextInt();
            switch (opcion1){
                case 1:
                    do{
                        leerListaJugadores("./recursos/SeleccionHolandesa.dat");
                        menuOpcion1();
                        int opcion2 = scan.nextInt();
                        switch (opcion2){
                            case 1:
                                insertarJugador(jugadores);
                                break;
                            case 2:
                                eliminarJugador(jugadores);
                                break;
                            case 3:
                                guardarLista(jugadores,"./recursos/SeleccionHolandesa.dat");//Update del archivo de la mi selección
                                guardarLista(jugadores,"recursos/Selecciones2022.dat");//guarda la lista de la selección en el archivo de todas las selecciones
                                break;
                            case 4:
                                menu = false;
                                break;
                            default:
                                System.out.println("opción no válida !!");
                        }
                    }while (menu);
                    break;
                case 2:
                    System.out.println("Introduce el nombre del archivo");
                    String nombreArch = scan.nextLine();
                    leerListaJugadores(nombreArch);
                    System.out.println("Guardar en la lista de las selecciones si | no:");
                    String opcion3= scan.nextLine();
                    if(opcion3 =="si"){
                        guardarLista(jugadores,"recursos/Selecciones2022.dat");
                    }
                    else {

                    }
                    break;
                case 3:
                    System.out.println("Fin del Programa");
                    return;
                default:
                    System.out.println("opción no válida !!");
            }
        }while (true);

    }
    public static void insertarJugador(ArrayList<Jugador> jugadores){
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
    public static void eliminarJugador(ArrayList<Jugador> jugadores ){
        scan.nextLine();
        System.out.println("introduce en nombre del jugador: ");
        String nombre = scan.nextLine();
        for (int i = 0; i<jugadores.size(); i++){
            if (nombre == jugadores.get(i).getNombreJugador()){
                jugadores.remove(i);
            }
            else{
                System.out.println("nombre no existe.");
            }
        }
    }

    public static void guardarLista(ArrayList<Jugador> jugadores, String archivo){
       try {
           DataOutputStream flujoSalida = new DataOutputStream(new FileOutputStream(archivo));
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
    public static void leerListaJugadores(String archivo){
        ArrayList<Jugador> array = new ArrayList<>();
        try{
            DataInputStream flujoEntrada = new DataInputStream( new FileInputStream(archivo));
            Jugador jogador ;
            while (flujoEntrada.available()>0) {
                jogador = new Jugador(flujoEntrada.readInt(), flujoEntrada.readUTF(),flujoEntrada.readUTF(), flujoEntrada.readInt(), flujoEntrada.readFloat(), flujoEntrada.readUTF());
               array.add(jogador);
            }
            flujoEntrada.close();
            array= ordenarArray(array);
            for(int i =0 ; i <array.size(); i++){

                System.out.printf("código de país: %d\t País: %s\t nombre: %-16s \t Año de nacimiento %d \t Altura %.2f\t Club de procedencia: %s", array.get(i).getCodPais(), array.get(i).getNombrePais(),  array.get(i).getNombreJugador(),  array.get(i).getAnoNacimiento(),  array.get(i).getAltura(), array.get(i).getClubProcedencia());
                System.out.println();
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public static  ArrayList<Jugador> ordenarArray(ArrayList<Jugador> jugadores) {
        for(int i=0; i < jugadores.size()-1; i++){
            for(int j=0; j < (jugadores.size()-1-i); j++){
                if(jugadores.get(j).getAnoNacimiento() > jugadores.get(j+1).getAnoNacimiento()){
                    Jugador jugador = jugadores.get(j);
                    jugadores.set(j,jugadores.get(j+1));
                    jugadores.set(j+1,jugador);
                }
            }
        }
        return jugadores;
    }


    public static void menuJugadores(){
        System.out.println("1. Abrir la lista de la selección Holandesa");
        System.out.println("2. leer la selección de compañero");
        System.out.println("3. Salir del Programa.");
        System.out.println("Elige una opción:");
    }
    public static void menuOpcion1(){
        System.out.println("1. Insertar un jugador");
        System.out.println("2. Eliminar un jugador");
        System.out.println("3. Guardar los cambios en el archivo");
        System.out.println("Volver a la entrada");
        System.out.println("Elige una opción:");
    }




}
