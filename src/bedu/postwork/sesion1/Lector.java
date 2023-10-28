package bedu.postwork.sesion1;

import java.util.Scanner;

public class Lector {
    private static Scanner scanner = new Scanner(System.in);

    public static void muestraMensaje(String mensaje){
        System.out.println(mensaje);
    }
    
    public static String leeEntrada(){
        scanner.nextLine();
        return scanner.nextLine();
    }
    public static int leeEntradaEntero(){
        return scanner.nextInt();
    }
    public static short leeEntradaShort(){
        return scanner.nextShort();
    }
    public static short leeEntradaByte(){
        return scanner.nextByte();
    }
} // class
