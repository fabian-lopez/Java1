package bedu.postwork.sesion1;

import java.util.List;

public class clsAlertasLista<T> {
    private String mensaje;
    private byte tipoMensaje;
    private boolean existeError;

    private List<T> listaObjetos;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public byte getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(byte tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public List<T> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(List<T> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public boolean existeError() {
        return existeError;
    }

    public void setExisteError(boolean existeError) {
        this.existeError = existeError;
    }

    public clsAlertasLista(String mensaje, boolean existeError, byte tipoMensaje, List<T> miLista) {
        this.mensaje = mensaje;
        this.existeError = existeError;
        this.tipoMensaje = tipoMensaje;
        this.listaObjetos = miLista;
    }


}
