import bedu.postwork.sesion1.Lector;
import bedu.postwork.sesion1.Menu;

public class Main {
    
    private static boolean mostrarMenu;
    private static Menu menu;
    
    static {
        mostrarMenu = true;
        menu = new Menu();
    }

    public static void main(String[] args) {
        
        do {
        	menu.muestraMenuPrincipal();
        	try {
        		mostrarMenu = menu.validaSeleccion(Lector.leeEntradaShort());
        	} catch (Exception ex) {
	            Lector.muestraMensaje("Favor de ingresar una opción numerica. Presiona una tecla para continuar ...");
	            Lector.leeEntrada();
	        }
        } while (mostrarMenu);
        
    } // main method   

} // main class