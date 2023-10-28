package bedu.postwork.sesion1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bedu.postwork.modelo.ListaTareas;
import bedu.postwork.modelo.ListasTareas;

public class Menu {
    private String[] _opcionesMenuPrincial;
    private ListasTareas listasTareas;
    private List<String> opcionesMenu4Tareas;

    public Menu(){
        this._opcionesMenuPrincial = new String[]{
                "1. Crear nueva lista de tareas",
                "2. Ver listas de tareas",
                "3. Ver tareas de lista",
                "4. Actualizar lista de tareas",
                "5. Eliminar lista de tareas",
                "6. Guardar y Salir"
        };
        opcionesMenu4Tareas.add("1. Agregar nueva tarea");
        opcionesMenu4Tareas.add("2. Eliminar tarea");
        opcionesMenu4Tareas.add("3. Actualizar estado");
        opcionesMenu4Tareas.add("4. Regresar");
    }

    public String[] getOpciones() {
        return _opcionesMenuPrincial;
    }

    public String getOpcionSeleccionada(short opcionSeleccionada){
        return "Opción seleccionada: " + _opcionesMenuPrincial[opcionSeleccionada-1];
    }

    public void setOpciones(String[] _opciones) {
        this._opcionesMenuPrincial = _opciones;
    }
    
    {
    	listasTareas = new ListasTareas();
		listasTareas = ListasTareas.cargarInstancia();
    	opcionesMenu4Tareas = new ArrayList<>();
    }
    
    public void muestraMenuPrincipal() {
    	Lector.muestraMensaje("\nMenú:");
        for (String opcion : this.getOpciones()) {
            Lector.muestraMensaje("\t" + opcion);
        }
        Lector.muestraMensaje("Selecciona una Opción del Menú de Tareas:");
    }
    
    public short seleccionaIndiceListaAEditar() {
    	short seleccion = -1;
    	try {    	
	    	ImpresionDeListas.printListConIndice(listasTareas.getListasTareas());
	    	Lector.muestraMensaje("~~~ Selecciona la lista que deseas editar: ");
	    	seleccion = Lector.leeEntradaShort();
    	} catch (Exception ex) {
            Lector.muestraMensaje("Favor de ingresar una opción numerica. Presiona una tecla para continuar ...");
            Lector.leeEntrada();
            return 0;
        }
    	
    	return seleccion;
    }
    
    public short mostrarMenu4Tareas() {    	
    	Lector.muestraMensaje("\nMenú Tareas:");
        for (String opcion : opcionesMenu4Tareas) {
            Lector.muestraMensaje("\t" + opcion);
        }
        Lector.muestraMensaje("Selecciona una Opción del Menú:");
        return Lector.leeEntradaShort();
    }
    
    public boolean validaSeleccion(short opcionSeleccionada){
    	clsAlertas clsAlertas;
    	ListaTareas lt = null;
    	boolean mostrarMenu = true;
    	boolean submenu = true;
    	short listaSeleccionada = 0;
    	
        switch (opcionSeleccionada){
            case 1:
                Lector.muestraMensaje(this.getOpcionSeleccionada((short)1));
                clsAlertas = listasTareas.agregaListaTarea();
                Lector.muestraMensaje(clsAlertas.getMensaje());
                break;
            case 2:
                Lector.muestraMensaje(this.getOpcionSeleccionada((short)2));
                ImpresionDeListas.printList(listasTareas.getListasTareas());
                break;
            case 3:
                Lector.muestraMensaje(this.getOpcionSeleccionada((short)3));
                Lector.muestraMensaje("\nIngresa el indice de la lista a consultar: ");
                lt = listasTareas.getListasTareas().get((short)(Lector.leeEntradaShort()-1));
                ImpresionDeListas.printListConIndice(lt.getlTareas());
                break;
            case 4:
                Lector.muestraMensaje(this.getOpcionSeleccionada((short)4));
                do {
                	listaSeleccionada = (short)(this.seleccionaIndiceListaAEditar() - 1);
                	if(listaSeleccionada > -1) {                		
	                	lt = listasTareas.obtieneListaEspecifica(listaSeleccionada);
	                	if(lt != null) {
	                		Lector.muestraMensaje("\nEditando lista de tareas: " + lt.getNombre());
	                		ImpresionDeListas.printListConIndice(listasTareas.getListasTareas().get(listaSeleccionada).getlTareas());
	                	}
	                	submenu = listasTareas.validaOpcionMenu4Tareas(this.mostrarMenu4Tareas(), listaSeleccionada);
                	}
                } while(submenu);
                break;
            case 5:
                Lector.muestraMensaje(this.getOpcionSeleccionada((short)5));
                Lector.muestraMensaje("\nIngresa el indice de la lista a eliminar: ");
                clsAlertas = listasTareas.eliminaListaTarea((short)(Lector.leeEntradaShort()-1));
                Lector.muestraMensaje(clsAlertas.getMensaje());
                break;
            case 6:
            	Lector.muestraMensaje(this.getOpcionSeleccionada((short)6));
            	listasTareas.guardaInstancia();
                mostrarMenu = false;
                break;
            default:
                Lector.muestraMensaje("Favor de seleccionar una opción mostrada en el menú. Opciones validas: 1-6.");                
                break;
        }
        return mostrarMenu;
    } // validaSeleccion

    @Override
    public int hashCode(){
        int hash = 0;
        hash = Arrays.hashCode(_opcionesMenuPrincial);
        return hash;
    }


    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Menu)) return false;

        Menu aTest= (Menu) obj;
        return Arrays.equals(_opcionesMenuPrincial, aTest.getOpciones());
    }

} // class
